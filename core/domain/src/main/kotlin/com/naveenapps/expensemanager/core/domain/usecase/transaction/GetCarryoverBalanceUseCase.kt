package com.naveenapps.expensemanager.core.domain.usecase.transaction

import com.naveenapps.expensemanager.core.common.utils.fromLocalToUTCTimeStamp
import com.naveenapps.expensemanager.core.domain.usecase.settings.filter.daterange.GetDateRangeUseCase
import com.naveenapps.expensemanager.core.model.DateRangeType
import com.naveenapps.expensemanager.core.model.Transaction
import com.naveenapps.expensemanager.core.model.TransactionType
import com.naveenapps.expensemanager.core.model.isExpense
import com.naveenapps.expensemanager.core.model.isIncome
import com.naveenapps.expensemanager.core.repository.AccountRepository
import com.naveenapps.expensemanager.core.repository.CategoryRepository
import com.naveenapps.expensemanager.core.repository.SettingsRepository
import com.naveenapps.expensemanager.core.repository.TransactionRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map

class GetCarryoverBalanceUseCase(
    private val accountRepository: AccountRepository,
    private val categoryRepository: CategoryRepository,
    private val settingsRepository: SettingsRepository,
    private val getDateRangeUseCase: GetDateRangeUseCase,
    private val transactionRepository: TransactionRepository,
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(): Flow<Double> {
        return combine(
            settingsRepository.getTransactionTypes(),
            settingsRepository.getCategories(),
            settingsRepository.getAccounts(),
            getDateRangeUseCase.invoke(),
        ) { selectedTransactionTypes, selectedCategories, selectedAccounts, dateRangeModel ->
            val transactionTypes = if (selectedTransactionTypes.isNullOrEmpty()) {
                listOf(TransactionType.INCOME.ordinal, TransactionType.EXPENSE.ordinal)
            } else {
                selectedTransactionTypes.map { it.ordinal }
            }

            val accounts = if (selectedAccounts.isNullOrEmpty()) {
                accountRepository.getAccounts().firstOrNull()?.map { it.id } ?: emptyList()
            } else {
                selectedAccounts
            }

            val categories = if (selectedCategories.isNullOrEmpty()) {
                categoryRepository.getCategories().firstOrNull()?.map { it.id } ?: emptyList()
            } else {
                selectedCategories
            }

            FilterValue(
                dateRangeModel.type,
                dateRangeModel.dateRanges,
                accounts,
                categories,
                transactionTypes,
            )
        }.flatMapLatest { filter ->
            transactionRepository.getAllFilteredTransaction(
                filter.accounts,
                filter.categories,
                filter.transactionTypes,
            ).map { transactions ->
                if (filter.dateRangeType == DateRangeType.ALL) {
                    0.0
                } else {
                    val startDate = filter.filterRange.firstOrNull()?.fromLocalToUTCTimeStamp()
                    transactions.orEmpty()
                        .filter { transaction ->
                            startDate != null && transaction.createdOn.time < startDate
                        }
                        .sumOf { it.signedAmount() }
                }
            }
        }
    }
}

private fun Transaction.signedAmount(): Double {
    return when {
        type.isIncome() -> amount.amount
        type.isExpense() -> amount.amount * -1
        else -> 0.0
    }
}

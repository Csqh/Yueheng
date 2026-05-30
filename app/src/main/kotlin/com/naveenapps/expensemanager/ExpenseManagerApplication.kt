package com.naveenapps.expensemanager

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.os.LocaleList
import java.util.Locale

class ExpenseManagerApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base.withYueHengLocale())
    }

    override fun onCreate() {
        super.onCreate()
        Locale.setDefault(APP_LOCALE)
    }

    private fun Context.withYueHengLocale(): Context {
        Locale.setDefault(APP_LOCALE)
        val configuration = Configuration(resources.configuration).apply {
            setLocale(APP_LOCALE)
            setLocales(LocaleList(APP_LOCALE))
        }
        return createConfigurationContext(configuration)
    }

    private companion object {
        val APP_LOCALE: Locale = Locale.SIMPLIFIED_CHINESE
    }
}

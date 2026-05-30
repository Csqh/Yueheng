package com.naveenapps.expensemanager.core.data.repository

import com.naveenapps.expensemanager.core.repository.AnalyticsRepository
import com.naveenapps.expensemanager.core.repository.DevicePropertyRepository

class AnalyticsRepositoryImpl(
    private val devicePropertyRepository: DevicePropertyRepository
) : AnalyticsRepository {

    override fun trackAppOpenEvent() {
        setUserProperties()
        logEvent(EVENT_NAME_APP_OPEN, mapOf())
    }

    override fun logEvent(eventName: String, params: Map<String, String>) {
    }

    override fun setCurrentScreen(screenName: String) {
    }

    override fun setUserProperties() {
        devicePropertyRepository.getDeviceName()
        devicePropertyRepository.getDeviceBrandName()
        devicePropertyRepository.getDeviceOsVersion()
        devicePropertyRepository.getDeviceOsVersionNumber()
    }

    companion object {
        private const val EVENT_NAME_APP_OPEN = "app_open"
    }
}

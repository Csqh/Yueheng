package com.naveenapps.expensemanager.core.data.repository

import com.naveenapps.expensemanager.core.repository.FirebaseSettingsRepository

class FirebaseSettingsRepositoryImpl : FirebaseSettingsRepository {

    override fun getPrivacyURL(): String {
        return DEFAULT_PRIVACY_URL
    }

    override fun getTermsURL(): String {
        return DEFAULT_TERMS_URL
    }

    override fun getAboutUsURL(): String {
        return DEFAULT_ABOUT_US_URL
    }

    override fun getGithubURL(): String {
        return DEFAULT_GITHUB_URL
    }

    override fun getInstagramURL(): String {
        return DEFAULT_INSTAGRAM_URL
    }

    override fun getTwitterURL(): String {
        return DEFAULT_TWITTER_URL
    }

    override fun getFeedbackEmail(): String {
        return DEFAULT_FEEDBACK_EMAIL
    }

    companion object {
        private const val DEFAULT_PRIVACY_URL: String = "https://github.com/Csqh/Yueheng"
        private const val DEFAULT_TERMS_URL: String = "https://github.com/Csqh/Yueheng"
        private const val DEFAULT_ABOUT_US_URL: String = "https://github.com/Csqh/Yueheng"
        private const val DEFAULT_GITHUB_URL: String = "https://github.com/Csqh/Yueheng"
        private const val DEFAULT_INSTAGRAM_URL: String = ""
        private const val DEFAULT_TWITTER_URL: String = ""
        private const val DEFAULT_FEEDBACK_EMAIL: String = ""
    }
}

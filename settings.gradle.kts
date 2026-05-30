pluginManagement {
    includeBuild("build-logic")
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        maven("https://maven.aliyun.com/repository/public") {
            content {
                includeGroupByRegex("app\\.cash\\..*")
                includeGroupByRegex("com\\.google\\.auto(\\..*)?")
                includeGroup("com.google.devtools.ksp")
                includeGroupByRegex("com\\.google\\.errorprone(\\..*)?")
                includeGroup("com.google.guava")
                includeGroup("com.google.j2objc")
                includeGroup("com.google.truth")
                includeGroup("com.intellij")
                includeGroup("com.squareup")
                includeGroupByRegex("commons-.*")
                includeGroup("junit")
                includeGroup("net.bytebuddy")
                includeGroupByRegex("org\\.apache\\..*")
                includeGroup("org.hamcrest")
                includeGroup("org.jetbrains.kotlin")
                includeGroup("org.jetbrains.kotlinx")
                includeGroup("org.gradle.kotlin")
                includeGroup("org.mockito")
                includeGroup("org.objenesis")
                includeGroup("org.robolectric")
                includeGroup("org.checkerframework")
                includeGroup("org.xerial")
            }
        }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/public") {
            content {
                includeGroupByRegex("app\\.cash\\..*")
                includeGroupByRegex("com\\.google\\.auto(\\..*)?")
                includeGroup("com.google.devtools.ksp")
                includeGroupByRegex("com\\.google\\.errorprone(\\..*)?")
                includeGroup("com.google.guava")
                includeGroup("com.google.j2objc")
                includeGroup("com.google.truth")
                includeGroup("com.intellij")
                includeGroup("com.squareup")
                includeGroupByRegex("commons-.*")
                includeGroup("junit")
                includeGroup("net.bytebuddy")
                includeGroupByRegex("org\\.apache\\..*")
                includeGroup("org.hamcrest")
                includeGroup("org.jetbrains.kotlin")
                includeGroup("org.jetbrains.kotlinx")
                includeGroup("org.gradle.kotlin")
                includeGroup("org.mockito")
                includeGroup("org.objenesis")
                includeGroup("org.robolectric")
                includeGroup("org.checkerframework")
                includeGroup("org.xerial")
            }
        }
        google()
        mavenCentral()
        maven("https://jitpack.io") {
            content {
                includeGroupByRegex("com\\.github\\..*")
            }
        }
    }
}

rootProject.name = "YueHeng"

include(":app")
include(":macrobenchmark")

include(":core:common")
include(":core:data")
include(":core:database")
include(":core:datastore")
include(":core:designsystem")
include(":core:domain")
include(":core:model")
include(":core:navigation")
include(":core:notification")
include(":core:repository")
include(":core:testing")

include(":feature:account")
include(":feature:analysis")
include(":feature:budget")
include(":feature:category")
include(":feature:country")
include(":feature:currency")
include(":feature:dashboard")
include(":feature:filter")
include(":feature:export")
include(":feature:onboarding")
include(":feature:reminder")
include(":feature:settings")
include(":feature:theme")
include(":feature:transaction")
include(":feature:about")
include(":core:settings")

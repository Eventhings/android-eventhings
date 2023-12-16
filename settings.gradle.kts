import java.net.URI

include(":feature-saved-item")


include(":feature-equipment-rental-menu")


include(":feature-sponsor-menu")


include(":feature-media-partner-menu")


include(":feature-all-menu")


include(":feature-chat")


include(":feature-profile")


include(":feature-notification")


include(":feature-add-business")


include(":feature-main")


include(":domain")


include(":data")


include(":navigation")


include(":common")


include(":feature-home")


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = URI("https://jitpack.io") }
    }
}

rootProject.name = "Eventh!ngs"
include(":app")
include(":ui")
include(":feature-auth")

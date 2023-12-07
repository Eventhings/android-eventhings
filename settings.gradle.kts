import java.net.URI

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

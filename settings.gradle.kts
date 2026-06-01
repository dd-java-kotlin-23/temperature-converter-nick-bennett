@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://ddc-java.github.io/version-catalogs/")
        }
    }
    versionCatalogs {
        create("libs") {
            from("edu.cnm.deepdive:catalog-jdk25:23.0.0")
        }
    }
}

rootProject.name = "temperature-converter"
val parentProjectDir = projectDir

plugins {
    id(Plugins.detekt) version PluginVersions.detekt
    id(Plugins.kotlin) version Global.kotlin_version apply false
    id(Plugins.kotlin_spring) version Global.kotlin_version apply false
    id(Plugins.spring_boot) version Global.spring_boot_version apply false
    id(Plugins.spring_dependency_management) version PluginVersions.spring_dependency_management apply false
}

subprojects {
    apply {
        plugin(Plugins.kotlin)
        plugin("java")
        plugin(Plugins.detekt)
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    val implementation by configurations

    dependencies {
        implementation(platform("${BOMs.spring_boot}:${Global.spring_boot_version}"))
        implementation(Libs.telegram_bot)
    }

    detekt {
        config.setFrom(files("$parentProjectDir/config/detekt/detekt.yml"))
        buildUponDefaultConfig = true
        source.setFrom(files("src/main/kotlin", "src/test/kotlin"))

        dependencies {
            detektPlugins("${Plugins.detekt_formatting}:${PluginVersions.detekt_formatting}")
        }
    }
}

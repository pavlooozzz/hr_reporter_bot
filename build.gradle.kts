val parentProjectDir = projectDir

plugins {
    id(Plugins.kotlin) version PluginVers.kotlin apply false
    id(Plugins.detekt) version PluginVers.detekt
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
    detekt {
        config.setFrom(files("$parentProjectDir/config/detekt/detekt.yml"))
        buildUponDefaultConfig = true
        source.setFrom(files("src/main/kotlin", "src/test/kotlin"))

        dependencies {
            detektPlugins("${Plugins.detekt_formatting}:${PluginVers.detekt_formatting}")
        }
    }
}

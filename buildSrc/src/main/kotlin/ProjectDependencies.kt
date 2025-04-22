object Libs {
    const val liquibase = "org.liquibase:liquibase-core"
    const val postgres = "org.postgresql:postgresql"
    const val spring_actuator = "org.springframework.boot:spring-boot-starter-actuator"
    const val spring_dev_tools = "org.springframework.boot:spring-boot-devtools"
    const val spring_dev_docker_compose = "org.springframework.boot:spring-boot-docker-compose"
    const val spring_data_jdbc_starter = "org.springframework.boot:spring-boot-starter-data-jdbc"
    const val telegram_bot = "org.telegram:telegrambots:${LibVersions.telegram_bot}"
}

object LibVersions {
    const val telegram_bot = "6.7.0"
}

object PluginVersions {
    const val detekt = "1.23.0"
    const val detekt_formatting = detekt
    const val spring_dependency_management = "1.1.0"
}

object Plugins {
    const val spring_dependency_management = "io.spring.dependency-management"
    const val detekt_formatting = "io.gitlab.arturbosch.detekt:detekt-formatting"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val kotlin = "org.jetbrains.kotlin.jvm"
    const val kotlin_spring = "org.jetbrains.kotlin.plugin.spring"
    const val spring_boot = "org.springframework.boot"
}

object BOMs {
    const val spring_boot = "org.springframework.boot:spring-boot-dependencies"
}

plugins {
    id(Plugins.spring_boot)
    id(Plugins.kotlin_spring)
    id(Plugins.spring_dependency_management)
}
dependencies {
    implementation(project(":domain"))
    implementation(project(":db"))
    implementation(project(":telegram-adapter"))

    implementation(Libs.liquibase)

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation(Libs.spring_actuator)
    implementation(Libs.spring_data_jdbc_starter)
    implementation(Libs.telegram_bot)
    runtimeOnly(Libs.postgres)

    developmentOnly(Libs.spring_dev_tools)
    developmentOnly(Libs.spring_dev_docker_compose)

}

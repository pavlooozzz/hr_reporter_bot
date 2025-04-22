plugins {
    id(Plugins.kotlin_spring)
    id(Plugins.spring_dependency_management)
}

dependencies {
    implementation(project(":domain"))
    implementation(Libs.telegram_bot)
}
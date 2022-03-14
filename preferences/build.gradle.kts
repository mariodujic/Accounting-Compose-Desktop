@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin)
}

dependencies {
    implementation(libs.koin)
    implementation(libs.coroutines)
}
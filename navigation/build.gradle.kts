@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.compose)
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(libs.koin)
    implementation(libs.junit)
}
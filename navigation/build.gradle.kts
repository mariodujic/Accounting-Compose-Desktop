plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("io.insert-koin:koin-core:3.1.5")
}
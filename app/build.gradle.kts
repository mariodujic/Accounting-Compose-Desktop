import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Suppressing bug:
 * https://youtrack.jetbrains.com/issue/KTIJ-19369
 */
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
}

group = "me.zero"
version = "1.0"

dependencies {
    implementation(project(":navigation"))
    implementation(project(":database"))
    implementation(project(":utils"))
    implementation(compose.desktop.currentOs)
    implementation(libs.koin)
}

compose.desktop {
    application {
        mainClass = "com.acc.ApplicationKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "acc"
            packageVersion = "1.0.0"
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.21"
}

application {
    mainClass.set("com.akramas.straight.ApplicationKt")
}

repositories {
    mavenCentral()
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    withType<Jar> {
        manifest {
            attributes["Main-Class"] = "com.akramas.straight.ApplicationKt"
        }
    }
}

dependencies {
    implementation("io.ktor:ktor-websockets:$ktor_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-apache:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-locations:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}
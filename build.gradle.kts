plugins {
    `kotlin-dsl`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(gradleTestKit())
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

gradlePlugin {
    plugins.create("my.plugin") {
        id = "my.plugin"
        implementationClass = "MyPlugin"
    }
}

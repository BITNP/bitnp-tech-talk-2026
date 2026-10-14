plugins {
    id("java")
    id("application")
}

group = "net.bitnp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// JavaFX has not been part of the JDK since JDK 11, so it is pulled in as a
// normal dependency. Each module is published per platform: only the artifact
// carrying a platform suffix contains the native libraries. The matching
// artifact without a suffix is an empty stub whose POM refers to the Maven
// property ${javafx.platform}, which Gradle cannot resolve. That is why the
// platform suffix is written out explicitly and transitive resolution is off.
val javafxVersion = "21.0.8"
val javafxPlatform = when {
    System.getProperty("os.name").lowercase().contains("win") -> "win"
    System.getProperty("os.name").lowercase().contains("mac") -> "mac"
    else -> "linux"
}

dependencies {
    implementation("org.openjfx:javafx-base:$javafxVersion:$javafxPlatform") { isTransitive = false }
    implementation("org.openjfx:javafx-graphics:$javafxVersion:$javafxPlatform") { isTransitive = false }
    implementation("org.openjfx:javafx-controls:$javafxVersion:$javafxPlatform") { isTransitive = false }

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass = "net.bitnp.samplegui.Launcher"
}

tasks.test {
    useJUnitPlatform()
}

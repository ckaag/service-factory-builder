plugins {
    java
    kotlin("jvm") version "1.3.72"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"


application {
    mainClassName = "com.github.ckaag.liferay.service.factory.builder.MainKt"
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")
    implementation("javax.xml.bind", "jaxb-api", "2.3.0")
    implementation("com.sun.xml.bind", "jaxb-impl", "2.3.0")
    implementation("com.sun.xml.bind", "jaxb-core", "2.3.0")
    implementation("javax.activation", "javax.activation-api", "1.2.0")
    implementation("com.liferay.portal", "com.liferay.portal.kernel", "4.33.0")
    implementation("com.github.ajalt", "clikt", "2.3.0")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

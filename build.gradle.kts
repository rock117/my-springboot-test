import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

group = "com.eem"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    //	mavenCentral()
    maven(url = "http://maven.aliyun.com/nexus/content/groups/public/")
}

dependencies {
    //	implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    compile("io.vavr:vavr:0.10.2")

    compile("commons-io:commons-io:2.4")
    compile("com.google.zxing:javase:3.3.0")
    compile("org.apache.commons:commons-lang3:3.9")
    compile("org.postgresql:postgresql:42.2.12")
    compile("org.apache.poi:poi-ooxml:4.1.0")


}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}



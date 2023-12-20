import gradle.kotlin.dsl.accessors._a417b5339f78f4c4344edb5196ac97d4.publishing

plugins {
  id("net.kyori.indra")
  id("net.kyori.indra.license-header")
  id("net.kyori.indra.publishing")
}

repositories {
  mavenLocal()
  mavenCentral()
  maven("https://oss.sonatype.org/content/groups/public/")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
  withSourcesJar()
}

indra {
  javaVersions {
    target(17)
  }
}

publishing {
  repositories {
    val spaceMavenUrl = System.getenv("JB_SPACE_MAVEN_REPOSITORY")
    if (spaceMavenUrl != null) {
      maven(spaceMavenUrl) {
        credentials {
          username = System.getenv("JB_SPACE_CLIENT_ID")
          password = System.getenv("JB_SPACE_CLIENT_SECRET")
        }
      }
    } else {
      mavenLocal()
    }
  }
}

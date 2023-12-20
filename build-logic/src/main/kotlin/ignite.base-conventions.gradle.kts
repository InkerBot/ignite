import de.marcphilipp.gradle.nexus.NexusPublishExtension

plugins {
  id("net.kyori.indra")
  id("net.kyori.indra.license-header")
  id("net.kyori.indra.publishing")
  id("de.marcphilipp.nexus-publish")
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
}

indra {
  javaVersions {
    target(17)
  }

  extensions.configure<NexusPublishExtension> {
    System.getenv("JB_SPACE_MAVEN_REPOSITORY")?.let { url ->
      repositories.create("maven") {
        nexusUrl.set(uri(url))
        snapshotRepositoryUrl.set(uri(url))
        username.set(System.getenv("JB_SPACE_CLIENT_ID"))
        password.set(System.getenv("JB_SPACE_CLIENT_SECRET"))
      }
    }
  }
}

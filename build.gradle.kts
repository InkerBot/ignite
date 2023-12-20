plugins {
  id("ignite.parent-build-logic")
}

group = "org.inksnow.ignite"
val baseVersion = "0.8.2"
version = System.getenv("JB_SPACE_EXECUTION_NUMBER")
  ?.let { "$baseVersion.$it" }
  ?: "$baseVersion-SNAPSHOT"
description = "A Mixin and Access Widener mod loader for Spigot/Paper."

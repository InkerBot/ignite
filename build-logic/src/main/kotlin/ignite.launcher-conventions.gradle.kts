plugins {
  id("ignite.base-conventions")
}

repositories {
  maven("https://files.minecraftforge.net/maven/")
  maven("https://repo.spongepowered.org/maven/")
  maven("https://maven.fabricmc.net/")
}

tasks {
  jar {
    manifest {
      attributes(
        "Premain-Class" to "space.vectrix.ignite.applaunch.agent.Agent",
        "Agent-Class" to "space.vectrix.ignite.applaunch.agent.Agent",
        "Launcher-Agent-Class" to "space.vectrix.ignite.applaunch.agent.Agent",
        "Main-Class" to "space.vectrix.ignite.applaunch.IgniteBootstrap",
        "Multi-Release" to true
      )

      attributes("space/vectrix/ignite/applaunch/",
        "Specification-Title" to "ignite",
        "Specification-Vendor" to "vectrix.space",
        "Specification-Version" to 1.0,
        "Implementation-Title" to project.name,
        "Implementation-Version" to rootProject.version.toString(),
        "Implementation-Vendor" to "vectrix.space"
      )
    }
  }
}

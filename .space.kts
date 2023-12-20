job("Build and publish") {
    gradlew("mcr.microsoft.com/openjdk/jdk:17-ubuntu", "build", "publish") {
        env["JB_SPACE_MAVEN_REPOSITORY"] = "https://packages.inksnow.org/maven/p/main/maven"
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ignite-parent"

includeBuild("build-logic")

sequenceOf(
  "api",
  "launcher"
).forEach {
  include("ignite-$it")
  project(":ignite-$it").projectDir = file(it)
}

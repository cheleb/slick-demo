scalaVersion := "2.12.4"

name := "slick-demo"

resolvers += Resolver.bintrayRepo("akka", "maven")

val slickVersion = "3.2.1"
slickOutputDir := (sourceManaged in Compile).value
sourceGenerators in Compile += SlickCodegenPlugin.sourcesGenerator
//slickCodegenConfFile := "src/main/slick/slick-codegen.conf"

slickOutputDir := (sourceManaged in Compile).value

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % slickVersion,
  "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "0.14",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.25",
  "org.slf4j" % "slf4j-nop" % "1.7.25" % Provided,
  "ch.qos.logback" % "logback-classic" % "1.2.3" % Runtime,
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
)

libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % slickVersion

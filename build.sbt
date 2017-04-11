enablePlugins(SlickCodegenPlugin)
scalaVersion := "2.12.1"

val slickVersion = "3.2.0"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % slickVersion,
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
)

libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1212.jre7"
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % slickVersion

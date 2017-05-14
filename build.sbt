scalaVersion := "2.12.2"

val slickVersion = "3.2.0"

//slickCodegenConfFile := "src/main/slick/slick-codegen.conf"

slickOutputDir := (sourceManaged in Compile).value

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % slickVersion,
  "org.slf4j" % "log4j-over-slf4j" % "1.7.25",
  "org.slf4j" % "slf4j-nop" % "1.7.25" % Provided,
  "ch.qos.logback" % "logback-classic" % "1.2.3" % Runtime,
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
)

libraryDependencies += "org.postgresql" % "postgresql" % "42.0.0.jre7"
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % slickVersion

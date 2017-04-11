resolvers += Resolver.file("local", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)



addSbtPlugin("org.jug-montpellier" % "sbt-slick-plugin" % "0.0.2-SNAPSHOT")

resolvers += Resolver.file("local", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)
resolvers += Resolver.bintrayIvyRepo("jug-montpellier", "sbt-plugin-releases")


addSbtPlugin("org.jug-montpellier" % "sbt-slick-plugin" % "0.0.5")

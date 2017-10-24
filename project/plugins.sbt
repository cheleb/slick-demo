//resolvers += Resolver.file("local", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)
resolvers += Resolver.bintrayIvyRepo("metabookmarks", "sbt-plugin-releases")


addSbtPlugin("io.metabookmarks" % "sbt-slick-plugin" % "0.1.0")

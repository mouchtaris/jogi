addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.18")

// ScalaPB
addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.1" exclude ("com.trueaccord.scalapb", "protoc-bridge_2.10"))
libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin-shaded" % "0.6.0"

// Scalariform
resolvers += Resolver.typesafeRepo("releases")
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

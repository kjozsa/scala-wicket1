name := "scala-wicket1"

version := "0.1"

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.10" % "test",
    "org.scalatest" % "scalatest_2.9.1" % "1.6.1" % "test",
    "org.mockito" % "mockito-all" % "1.9.0",
    "ch.qos.logback" % "logback-classic" % "1.0.0" % "compile->default",
    "org.apache.wicket" % "wicket-core" % "1.5.3", 
    "org.mortbay.jetty" % "jetty" % "6.1.26" % "compile",
    "org.mortbay.jetty" % "jetty" % "6.1.26" % "container"
)

scalacOptions += "-deprecation"

seq(webSettings :_*)

resourceDirectory in Compile <<= baseDirectory(_ / "src/main/scala") 


name := "scala-wicket1"

version := "0.1"

scalaVersion := "2.10.0-M6"

classpathTypes ~= (_ + "orbit")

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.10" % "test",
//    "org.scalatest" %% "scalatest" % "1.8" % "test",
    "org.scalatest" % "scalatest_2.10.0-M6" % "1.9-2.10.0-M6-B2",
    "org.mockito" % "mockito-all" % "1.9.0" % "test",
    "ch.qos.logback" % "logback-classic" % "1.0.6",
    "org.apache.bval" % "bval-jsr303" % "0.4",
    "com.googlecode.lambdaj" % "lambdaj" % "2.3.3",
    "org.apache.wicket" % "wicket" % "6.0.0-beta3", 
    "org.apache.wicket" % "wicket-atmosphere" % "0.1", 
//    "com.typesafe" % "slick_2.10.0-M6" % "0.11.0",
    "com.h2database" % "h2" % "1.3.168",
    "org.eclipselink.persistence" % "javax.persistence" % "2.0",
    "org.eclipselink.persistence" % "eclipselink" % "2.3.2",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" artifacts (Artifact("javax.servlet", "jar", "jar")),
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container" artifacts (Artifact("javax.servlet", "jar", "jar")),
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.4.v20120524" % "container" artifacts (Artifact("jetty-webapp", "jar", "jar")),
    "org.eclipse.jetty" % "jetty-websocket" % "8.1.4.v20120524" % "container" artifacts (Artifact("jetty-websocket", "jar", "jar"))
)

resolvers += "eclipse" at "http://mirror.csclub.uwaterloo.ca/eclipse/rt/eclipselink/maven.repo/"

scalacOptions += "-deprecation"

EclipseKeys.withSource := true

seq(webSettings :_*)

resourceDirectory in Compile <<= baseDirectory(_ / "src/main/scala") 


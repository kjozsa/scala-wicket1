name := "scala-wicket1"

version := "0.1"

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.10" % "test",
    "org.scalatest" %% "scalatest" % "1.8" % "test",
    "org.mockito" % "mockito-all" % "1.9.0" % "test",
    "ch.qos.logback" % "logback-classic" % "1.0.6",
    "org.apache.bval" % "bval-jsr303" % "0.4",
    "com.googlecode.lambdaj" % "lambdaj" % "2.3.3",
    "org.apache.wicket" % "wicket" % "6.0.0-beta2", 
    "org.apache.wicket" % "wicket-atmosphere" % "0.1", 
    "org.eclipselink.persistence" % "javax.persistence" % "2.0",
    "org.eclipselink.persistence" % "eclipselink" % "2.3.2",
    "org.eclipse.jetty" % "jetty-server" % "8.1.0.RC5" % "container",
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.RC5" % "container",
    "javax.servlet" % "servlet-api" % "2.5" % "provided"
)

resolvers += "eclipse" at "http://mirror.csclub.uwaterloo.ca/eclipse/rt/eclipselink/maven.repo/"

scalacOptions += "-deprecation"

seq(webSettings :_*)

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

resourceDirectory in Compile <<= baseDirectory(_ / "src/main/scala") 



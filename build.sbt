name := "scala-wicket1"

version := "0.1"

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.10" % "test",
    "org.scalatest" % "scalatest_2.9.1" % "1.6.1" % "test",
    "org.mockito" % "mockito-all" % "1.9.0" % "test",
    "ch.qos.logback" % "logback-classic" % "1.0.0" % "compile->default",
    "org.slf4j" % "jcl-over-slf4j" % "1.6.4",
    "org.apache.bval" % "bval-jsr303" % "0.3-incubating",
    "com.googlecode.lambdaj" % "lambdaj" % "2.3.3",
    "org.apache.wicket" % "wicket" % "1.5.4", 
    "org.wicketstuff" % "wicketstuff-push-cometd" % "1.5.4",
    "org.wicketstuff" % "wicketstuff-jsr303" % "1.5.4",
    "org.apache.activemq" % "activemq-core" % "5.5.1",
    "org.eclipselink.persistence" % "javax.persistence" % "2.0",
    "org.eclipselink.persistence" % "eclipselink" % "2.3.2",
    "org.eclipse.jetty" % "jetty-server" % "8.1.0.RC5",
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.RC5",
    "org.eclipse.jetty" % "jetty-server" % "8.1.0.RC5" % "container",
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.RC5" % "container"
//    "org.mortbay.jetty" % "jetty" % "6.1.26" % "compile",
//    "org.mortbay.jetty" % "jetty" % "6.1.26" % "container"
)

resolvers += "eclipse" at "http://mirror.csclub.uwaterloo.ca/eclipse/rt/eclipselink/maven.repo/"

scalacOptions += "-deprecation"

seq(webSettings :_*)

resourceDirectory in Compile <<= baseDirectory(_ / "src/main/scala") 


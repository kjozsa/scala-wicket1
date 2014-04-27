name := "scala-wicket1"

version := "0.1"

scalaVersion := "2.10.4"

classpathTypes ~= (_ + "orbit")

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test",
    "org.mockito" % "mockito-all" % "1.9.5" % "test",
    "ch.qos.logback" % "logback-classic" % "1.1.2",
    "org.apache.bval" % "bval-jsr303" % "0.5",
    "com.googlecode.lambdaj" % "lambdaj" % "2.3.3",
    "org.apache.wicket" % "wicket" % "6.15.0", 
    "org.apache.wicket" % "wicket-atmosphere" % "0.18", 
    "com.h2database" % "h2" % "1.3.176",
    "org.eclipse.persistence" % "eclipselink" % "2.5.2-M1",
    "org.eclipse.jetty" % "jetty-webapp"        % "9.2.0.M0"  % "container,test,compile"
)

resolvers += "eclipse" at "http://mirror.csclub.uwaterloo.ca/eclipse/rt/eclipselink/maven.repo/"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

seq(webSettings :_*)

resourceDirectory in Compile <<= baseDirectory(_ / "src/main/scala") 


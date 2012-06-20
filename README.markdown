scala wicket helloworld skeleton
--------------------------------

features:

* pure scala
* configured for building with sbt 0.13
* scalatest with wickettester example
* lambda4j wicket model example
* works with JRebel+SBT
* sbt generated war works perfectly in Weblogic 10.3

usage:

    sbt eclipse with-source=true
    sbt container:start 
    sbt ~ ; compile; container:reload 


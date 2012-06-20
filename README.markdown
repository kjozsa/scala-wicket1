scala wicket helloworld skeleton
--------------------------------

features:

* pure scala
* configured for building with sbt 0.13
* scalatest with wickettester example
* works with JRebel+SBT
* sbt generated war works perfectly in Weblogic 10.3

usage:

    sbt eclipse with-source=true - create/refresh eclipse configuration
    sbt container:start - start in jetty
    sbt ~ ; compile; container:reload / - hack away with auto-reload


import play.Project._

name := "connectionDemo"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  "org.hibernate" % "hibernate-entitymanager" % "4.2.7.Final"
)

play.Project.playJavaSettings

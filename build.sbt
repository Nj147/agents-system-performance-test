import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "gov.hmrc",
      scalaVersion := "2.13.6",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "agents-system-performance-test",
    libraryDependencies ++= gatling
  )

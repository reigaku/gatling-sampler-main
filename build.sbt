import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "ru.otus",
      scalaVersion := "2.13.14",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "perf",
    libraryDependencies ++= gatling,
    libraryDependencies ++= picatinny,
  )

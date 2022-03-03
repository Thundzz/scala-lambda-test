import Dependencies._


ThisBuild / scalaVersion := "3.1.0"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .enablePlugins(LambdaJSPlugin)
  .settings(
    name := "scala-lambda-test",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.1",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "3.11.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events-sdk-transformer" % "3.1.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-log4j2" % "1.5.1",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-runtime-interface-client" % "2.1.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-tests" % "1.1.1",
    // JVM setup
    libraryDependencies += "org.typelevel" %% "feral-lambda" % "0.1.0-M1",
    // Optional, specialized integrations, available for both JS and JVM
    libraryDependencies += "org.typelevel" %%% "feral-lambda-http4s" % "0.1.0-M1",
    libraryDependencies += "org.typelevel" %%% "feral-lambda-cloudformation-custom-resource" % "0.1.0-M1",
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs@_*) => MergeStrategy.discard
      case _ => MergeStrategy.first
    }
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

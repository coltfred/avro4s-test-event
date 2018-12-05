organization := "com.ironcorelabs"
name := "test"
scalaVersion := "2.12.7"

addCompilerPlugin("ch.epfl.scala" %% "scalac-profiling" % "1.0.0")

scalacOptions := Seq(
      "-deprecation",
      "-encoding", "UTF-8", // yes, this is 2 args
      "-feature",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xlint",
      "-Yno-adapted-args",
      "-Ywarn-numeric-widen",
      "-Ywarn-value-discard",
      "-Xfuture",
      "-language:higherKinds",
      "-Ystatistics:typer",
      "-Ycache-macro-class-loader:last-modified",
      "-P:scalac-profiling:no-profiledb",
      "-P:scalac-profiling:show-profiles",
      "-P:scalac-profiling:sourceroot:/home/cfrederickson/src/coltfred/ironcore-id/",
      "-P:scalac-profiling:generate-macro-flamegraph"

  )

libraryDependencies ++= Seq("com.sksamuel.avro4s" %% "avro4s-core" % "2.0.3")

// HACK: without these lines, the console is basically unusable,
// since all imports are reported as being unused (and then become
// fatal errors).
scalacOptions in (Compile, console) ~= { _.filterNot(_.startsWith("-Xlint")).filterNot(_.startsWith("-Ywarn")) }
scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value


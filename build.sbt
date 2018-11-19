name := "hello"

resolvers += Resolver.mavenLocal

lazy val commonSettings = Seq(
  organization := "com.github.dapeng-soa",
  version := "1.0.0",
  scalaVersion := "2.12.4"
)

javacOptions ++= Seq("-encoding", "UTF-8")

lazy val api = (project in file("hello-api"))
  .settings(
    commonSettings,
    name := "hello-api",
    libraryDependencies ++= Seq(
      "com.github.dapeng-soa" % "dapeng-client-netty" % "2.1.1-SNAPSHOT"
    )
  ).enablePlugins(ThriftGeneratorPlugin)


lazy val service = (project in file("hello-service"))
  .dependsOn( api )
  .settings(
    commonSettings,
    name := "hello_service",
    libraryDependencies ++= Seq(
      "com.github.dapeng-soa" % "dapeng-spring" % "2.1.1-SNAPSHOT",
      "com.github.wangzaixiang" %% "scala-sql" % "2.0.6",
      "org.slf4j" % "slf4j-api" % "1.7.13",
      "ch.qos.logback" % "logback-classic" % "1.1.3",
      "ch.qos.logback" % "logback-core" % "1.1.3",
      "org.codehaus.janino" % "janino" % "2.7.8", //logback (use if condition in logBack config file need this dependency)
      "mysql" % "mysql-connector-java" % "5.1.36",
      "com.alibaba" % "druid" % "1.0.17",
      "org.springframework" % "spring-context" % "4.3.5.RELEASE",
      "org.springframework" % "spring-tx" % "4.3.5.RELEASE",
      "org.springframework" % "spring-jdbc" % "4.3.5.RELEASE",
      "com.today" %% "idgen-api" % "2.1.0",
    )).enablePlugins(ImageGeneratorPlugin)
    .enablePlugins(DbGeneratePlugin)
  .enablePlugins(RunContainerPlugin)

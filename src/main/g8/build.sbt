import Dependency._
import Extension._
$if(!multiModule.truthy) $
lazy val root = (project in file("."))
  .settings(BuildPlugin.projectSettings)
  .withKindProjector
  .withBetterMonadicFor
  .settings(
    organization := "$organization$",
    name := "$name;format="norm"$",
    libraryDependencies ++=
      Seq(
        catsEffect.core,
        catsEffect.std,
        circe.generic,
        circe.parser,
        circe.genericExtras,
        http4s.circe,
        http4s.dsl,
        http4s.emberClient,
        logback.logbackClassic,
        /** Test */
        Testing.scalaTest,
        Testing.scalaTestFlatspec,
        Testing.munit,
        Testing.munitCatsEffect,
        Testing.scalaCheck
      )
  )
$else$
lazy val root =
    (project in file("."))
      .disablePlugins(BuildPlugin, AssemblyPlugin, HeaderPlugin)
      .settings(
          name           := "$name;format="normalize"$" ,
          publish / skip := true
  )

lazy val m1 =
    (project in file("./m1"))
      .withKindProjector
      .withBetterMonadicFor
      .settings(
        name := "$name;format="normalize"$" + "-m1",
        libraryDependencies ++=
        Seq(
          catsEffect.core,
          catsEffect.std,
          circe.generic,
          circe.parser,
          circe.genericExtras,
          http4s.circe,
          http4s.dsl,
          http4s.emberClient,
          logback.logbackClassic,
          /** Test */
          Testing.scalaTest,
          Testing.scalaTestFlatspec,
          Testing.munit,
          Testing.munitCatsEffect,
          Testing.scalaCheck
        ),
        publish / skip := false
    )
$endif$
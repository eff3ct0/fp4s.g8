import de.heikoseeberger.sbtheader.HeaderPlugin
import sbt.Keys._
import sbt._
$if(scoverageEnabled.truthy) $
import scoverage.ScoverageKeys._
import scoverage.ScoverageSbtPlugin
$endif$

object Extension {

  implicit class ProjectOps(project: Project) {

    def withKindProjector: Project =
      project.settings(
        Seq(
          addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.3" cross CrossVersion.full)
        )
      )

    def withBetterMonadicFor: Project =
      project.settings(
        Seq(
          addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
        )
      )

    def withHeader: Project =
      project
        .enablePlugins(HeaderPlugin)
        .settings(
          Header.projectSettings
        )

    def withSonatypePublish: Project =
      project
        .settings(
          publish / skip := false,
          SonatypePublish.projectSettings
        )
    $if(scoverageEnabled.truthy) $
    def withCoverage: Project =
      project
        .enablePlugins(ScoverageSbtPlugin)
        .settings(
          coverageEnabled          := true,
          coverageFailOnMinimum    := false,
          coverageMinimumStmtTotal := 30 // TODO. provisional
        )
    $endif$

  }

}

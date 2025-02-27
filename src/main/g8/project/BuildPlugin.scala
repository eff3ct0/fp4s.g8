import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport.{headerLicense, HeaderLicense}
import de.heikoseeberger.sbtheader.{HeaderPlugin, License}
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin
$if(scoverageEnabled.truthy) $
import scoverage.ScoverageKeys._
$endif$

object BuildPlugin extends AutoPlugin {

  override def requires: Plugins = JvmPlugin && HeaderPlugin

  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[Setting[_]] = Seq(
    organizationName   := "$name$",
    organization       := "$organization$",
    scalaVersion       := Version.Scala,
    crossScalaVersions := Vector(scalaVersion.value),
    $if(scoverageEnabled.truthy) $
      run / coverageHighlighting := true,
    $endif$
    publish / skip           := true,
    run / fork               := true,
    Test / fork              := true,
    Test / parallelExecution := true,
    Test / scalacOptions     := Seq("-Ymacro-annotations"),
    // scalafmtOnCompile        := true,
    updateOptions := updateOptions.value
      .withCachedResolution(cachedResolution = false),
    // do not build and publish scaladocs
    Compile / doc / sources                := Seq.empty,
    Compile / packageDoc / publishArtifact := false,
    scalacOptions ++= Seq(
      "-Ymacro-annotations"
    )
  ) ++ Header.projectSettings

}

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
      headerLicense := Some (headerIOLicense),
    publish / skip           := true,
    run / fork               := true,
    Test / fork              := true,
    Test / parallelExecution := true,
    Test / scalacOptions     := Seq("-Ymacro-annotations"),
    scalafmtOnCompile        := true,
    updateOptions := updateOptions.value
      .withCachedResolution(cachedResolution = false),
    // do not build and publish scaladocs
    Compile / doc / sources                := Seq.empty,
    Compile / packageDoc / publishArtifact := false,
    scalacOptions ++= Seq(
      "-Ymacro-annotations"
    )
  )

  /**
   * SBT Header Plugin
   */

  lazy val headerText: String =
    """Copyright 2024 [name of copyright owner]
      |
      |Licensed under the Apache License, Version 2.0 (the "License");
      |you may not use this file except in compliance with the License.
      |You may obtain a copy of the License at
      |
      |http://www.apache.org/licenses/LICENSE-2.0
      |
      |Unless required by applicable law or agreed to in writing, software
      |distributed under the License is distributed on an "AS IS" BASIS,
      |WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      |See the License for the specific language governing permissions and
      |limitations under the License.
      |""".stripMargin

  lazy val headerIOLicense: License.Custom =
    HeaderLicense.Custom(headerText)
}

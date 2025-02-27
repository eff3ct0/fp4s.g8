import sbt.Keys._
import sbt._
import xerial.sbt.Sonatype._
import xerial.sbt.Sonatype.autoImport._

import scala.collection.Seq

object SonatypePublish {

  def projectSettings: Seq[Setting[_]] = Seq(
    ThisBuild / publish / skip         := true,
    ThisBuild / versionScheme          := Some("early-semver"),
    ThisBuild / sonatypeCredentialHost := sonatypeCentralHost,
    ThisBuild / organization           := "$organization$",
    ThisBuild / organizationName       := "$name;format="norm"$",
    ThisBuild / homepage               := Some(url("???")),
    ThisBuild / licenses               := Seq("???" -> url("???")),
    ThisBuild / scmInfo := Some(
      ScmInfo(
        browseUrl = url("???"),
        connection = "???"
      )
    ),
    ThisBuild / developers := List(
      Developer(
        id = "???",
        name = "???",
        email = "???",
        url = url("???")
      )
    ),
    ThisBuild / sonatypeProjectHosting := Some(
      GitHubHosting("???", "???", "???")
    )
  )

}

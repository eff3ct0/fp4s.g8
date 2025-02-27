/** Build */
addSbtPlugin("org.typelevel"     % "sbt-tpolecat"  % "0.5.2")
addSbtPlugin("io.spray"          % "sbt-revolver"  % "0.10.0")
addSbtPlugin("com.eed3si9n"      % "sbt-assembly" % "2.3.0")
addSbtPlugin("org.scalameta"     % "sbt-scalafmt" % "2.5.2")
addSbtPlugin("de.heikoseeberger" % "sbt-header"   % "5.10.0")

/** Publish */
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.9.2")

$if(scoverageEnabled.truthy) $
  /** Testing */
  addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.3.0")
$endif$

$if(scoverageEnabled.truthy) $
import scoverage.ScoverageKeys._
$endif$
import sbt.Keys.{artifact, name, scalaBinaryVersion, version}
import sbt.librarymanagement.Artifact
import sbt.{addArtifact, Compile, Setting}
import sbtassembly.AssemblyKeys.{assembly, assemblyJarName, assemblyMergeStrategy}
import sbtassembly.AssemblyPlugin.autoImport.MergeStrategy
import sbtassembly.PathList

object Assembly {

  lazy val classifier: String = "with-dependencies"

  def projectSettings: Seq[Setting[_]] =
    Seq(
      assembly / assemblyMergeStrategy := {
        case "module-info.class" => MergeStrategy.discard
        case x => (assembly / assemblyMergeStrategy).value.apply(x)
      },
      // JAR file settings
      assembly / assemblyJarName := s"\${name.value}_\${scalaBinaryVersion.value}_\${version.value}-\$classifier.jar"
    )

  def publishAssemblyJar: Seq[Setting[_]] =
    Seq(
      Compile / assembly / artifact := {
        val art: Artifact = (Compile / assembly / artifact).value
        art.withClassifier(Some(classifier))
      }
    ) ++
      addArtifact(Compile / assembly / artifact, assembly)
}

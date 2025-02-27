# $name;format="Camel"$

Welcome to the $name;format="Camel"$ template! This template provides a starting point for developing $name;format="Camel"$
with Scala and SBT. It's designed to be simple, efficient, and adaptable to various $name;format="Camel"$-based projects.

## Overview

This template includes everything you need to kickstart your $name;format="Camel"$ application:

- Preconfigured Scala and SBT setup.
- An example $name;format="Camel"$ job that can be run locally or on a cluster.
- Integration with sbt-assembly for easy project packaging.

## Getting Started

Follow these steps to set up and run your $name;format="Camel"$ application:

### Cloning the Repository

First, clone this repository to your local machine:

```bash
git clone <repository-url>
cd <repository-directory>
```

### Running the Example $name;format="Camel"$ Job Locally

You can test the example $name;format="Camel"$ job directly from SBT. Open a terminal in the project directory and execute:

```bash 
sbt "run inputFile.txt outputFile.txt"
```

When prompted, choose `CountingLocalApp` to see the example in action.

### Building the project

Prepare your project for distribution or deployment by building it with SBT:

1. Navigate to the project directory:

```bash
cd <project-directory>
```

2. Run the assembly:

```
sbt assembly
```

This command creates a JAR file in the target/scala-<scala-version>/ directory. For more details on configuring *
*sbt-assembly**, refer to the [sbt-assembly](https://github.com/sbt/sbt-assembly) documentation.

### Submitting the Application to a $name;format="Camel"$ Cluster

To execute your $name;format="Camel"$ job on a cluster, use the $name;format="Camel"$ $name;format="Camel"$ spark-submit script:

```bash
/path/to/$name;format="Camel"$-home/bin/spark-submit \
  --class <package-name>.CountingApp \
  --name <spark-app> \
  --master <master url> \
  ./target/scala-<scala-version>/<jar-name> \
  <input file> <output file>
```

Make sure to replace placeholders like <package-name>, <master-url>, <jar-name>, <input-file>, and <output-file> with
actual values relevant to your project and environment.

More information on submitting $name;format="Camel"$ jobs can be found in
the [$name;format="Camel"$ documentation](https://spark.apache.org/docs/latest/submitting-applications.html).

## License

This project is available under your choice of the Apache 2.0 or CC0 1.0 license. Choose the one that best suits your
needs:

- [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- [CC0 1.0 Universal (Public Domain Dedication)](https://creativecommons.org/publicdomain/zero/1.0/)

This template is provided "as-is" without any warranties. Modify and distribute as needed to fit your project
requirements.
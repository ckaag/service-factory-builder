# Service Factory Builder

Reads in Liferay `service.xml` (one or more) and generates Factory Java classes that enable a fluid Builder Pattern like syntax to create new entries.

Developed for Liferay 7.2 at the moment.

## Installation / preparation for usage
If you have jdk 8 / 11 installed you can build from sources:

Unix (Linux / MacOS / Bash on Windows / WSL): `./gradlew installDist`

Windows: `gradlew installDist`

## Usage
The tool uses a self-documentating CLI, you may run the help as follows:

Unix: `./build/install/service-factory-builder/bin/service-factory-builder --help`

Windows: `build\install\service-factory-builder\bin\service-factory-builder.bat --help`

## Ideas / Questions?
Go ahead and open a ticket!

## Relevant tips for development
generate jaxb classes:

`xjc -dtd -d src/main/java -encoding utf8 -p com.github.ckaag.service.factory.builder.xml liferay-service-builder.dtd`
`xjc -dtd -d src/main/java -encoding utf8 -p com.github.ckaag.service.factory.builder.hints portlet-model-hints.dtd`

## Future road map
* integration as gradle plugin
* integration as maven plugin
* more test cases
* copy methods for use outside service layer

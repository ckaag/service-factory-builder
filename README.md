



generate jaxb classes:

`xjc -dtd -d src/main/java -encoding utf8 -p com.github.ckaag.service.factory.builder.xml liferay-service-builder.dtd`
`xjc -dtd -d src/main/java -encoding utf8 -p com.github.ckaag.service.factory.builder.hints portlet-model-hints.dtd`


TODO:
* second compile type version, creating multiple variants of classes for compile time level safety on all required fields
* integration as gradle plugin
* integration as maven plugin
* target folder configurable (e.g. to move to generated)
* unit testing for both modes to compare against
* read service builder model hints to find out which fields are actually required and which are not

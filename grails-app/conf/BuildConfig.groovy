grails.project.work.dir = 'target'
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
	}

	plugins {
        build (":tomcat:7.0.52.1", ":release:3.0.1", ":rest-client-builder:2.0.1") {
            export = false
        }
	}
}

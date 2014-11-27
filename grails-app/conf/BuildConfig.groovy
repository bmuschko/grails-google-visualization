grails.project.work.dir = 'target'
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
        mavenCentral()
	}

	plugins {
    	build(':release:3.0.1', ':rest-client-builder:1.0.3', ':tomcat:7.0.54') {
			export = false
		}
	}
}

grails.project.dependency.resolution = {
    inherits("global") {
    }

    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
        grailsRepo "http://grails.org/plugins"
    }

    dependencies {
    }

    plugins {
        build ":release:2.0.0", {
            export = false
        }
    }
}
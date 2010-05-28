grails.project.dependency.resolution = {
    inherits "global"
    log "warn"

    repositories {
        grailsHome()
    }

    dependencies {
        compile('commons-lang:commons-lang:2.4') {
	        exported = false
        }
    } 
}
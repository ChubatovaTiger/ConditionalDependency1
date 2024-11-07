import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.07"

project {

    buildType(G)
    buildType(D)
    buildType(C)
    buildType(E)
    buildType(B)
    buildType(A)
}

object A : BuildType({
    name = "A"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sleep 10"
        }
    }

    dependencies {
        snapshot(B) {
        }
        snapshot(C) {
        }
    }
})

object B : BuildType({
    name = "B"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sleep 10"
        }
    }
})

object C : BuildType({
    name = "C"

    params {
        param("par1", "1")
        param("par2", "2")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sleep 10"
        }
    }

    dependencies {
        snapshot(D) {
        }
    }
})

object D : BuildType({
    name = "D"

    params {
        param("par1", "1")
        param("par2", "2")
        param("teamcity.configuration.tags", "1,2,3,4")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sleep 10"
        }
    }

    dependencies {
        snapshot(E) {
        }
    }
})

object E : BuildType({
    name = "E"

    params {
        param("par1", "1")
        param("par2", "2")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sleep 10"
        }
    }

    dependencies {
        snapshot(G) {
        }
    }
})

object G : BuildType({
    name = "G"

    params {
        param("par1", "1")
        param("par2", "2")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sleep 10"
        }
    }
})

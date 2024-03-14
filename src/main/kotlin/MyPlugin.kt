import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create

abstract class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create<MyExtension>("myExtension")
    }
}

interface MyExtension {
    val say: Property<String>
}

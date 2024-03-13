import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

@Suppress("unused")
abstract class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create<MyExtension>("myExtension")
    }
}

import org.gradle.api.provider.Property

interface MyExtension {
    val say: Property<String>
}

import org.gradle.testkit.runner.GradleRunner
import java.io.File
import java.nio.file.Files.createTempDirectory
import kotlin.io.path.Path
import kotlin.io.path.appendText
import kotlin.io.path.createFile
import kotlin.io.path.exists
import kotlin.test.Test

class MyTest {

    @Test
    fun test() {
        val dir = createTempDirectory("tmp")

        dir
            .resolve("build.gradle.kts")
            .createFile()
            .appendText(
                """
                plugins {
                    id("my.plugin")
                }
                
                myExtension {
                    say = "Oh!"
                }
                """.trimIndent()
            )

        GradleRunner.create()
            .withProjectDir(dir.toFile())
            .withGradleVersion("8.7-rc-3")
            .withPluginClasspath()
            .withDebug(true)
            .build()
    }
}

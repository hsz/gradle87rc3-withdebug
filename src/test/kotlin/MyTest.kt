import org.gradle.testkit.runner.GradleRunner
import java.nio.file.Files.createTempDirectory
import kotlin.io.path.appendText
import kotlin.io.path.createFile
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

        val runner = GradleRunner.create()
            .withProjectDir(dir.toFile())
            .withGradleVersion("8.7-rc-3")
            .forwardOutput()
            .withPluginClasspath()
            .withDebug(true)

        runner.build()
    }
}

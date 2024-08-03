package world.estaria.paper.dependency.loader

import io.papermc.paper.plugin.loader.PluginClasspathBuilder
import io.papermc.paper.plugin.loader.PluginLoader
import io.papermc.paper.plugin.loader.library.impl.JarLibrary
import java.io.File

/**
 * @author Niklas Nieberler
 */

class DependencyPluginLoader : PluginLoader {

    override fun classloader(classpathBuilder: PluginClasspathBuilder) {
        val directory = File("dependencies/")
        val files = directory.listFiles()!!
            .filter { it.name.endsWith(".jar") }

        files.forEach {
            println("Loading dependency ${it.nameWithoutExtension}")
            classpathBuilder.addLibrary(JarLibrary(it.toPath()))
        }
    }

}
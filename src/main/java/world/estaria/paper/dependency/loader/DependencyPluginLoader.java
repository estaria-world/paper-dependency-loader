package world.estaria.paper.dependency.loader;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.JarLibrary;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DependencyPluginLoader implements PluginLoader {

    @Override
    public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
        File directory = new File("dependencies/");
        List<File> list = Arrays.stream(directory.listFiles())
                .filter(file -> file.getName().endsWith(".jar"))
                .toList();

        for (File file : list) {
            System.out.println("Loading dependency " + file.getName());
            classpathBuilder.addLibrary(new JarLibrary(file.toPath()));
        }
    }

}

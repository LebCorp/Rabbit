package fr.leben.rabbitapi.plugin.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

import fr.leben.rabbitapi.plugin.Plugin;
import fr.leben.rabbitapi.plugin.PluginDescription;
import fr.leben.rabbitapi.plugin.PluginLoader;

public class JavaPluginLoader implements PluginLoader {

	@SuppressWarnings("unchecked")
	@Override
	public Plugin loadPlugin(File file, Object... clazzs) throws Exception {
		if (!file.exists()) {
			throw new FileNotFoundException("the file doesn't exist !");
		}

		Class<? extends Plugin> mainClass;
		Plugin result = null;
		PluginDescription pluginDesc = getPluginDescription(file);

		mainClass = (Class<? extends Plugin>) Class.forName(pluginDesc
				.getMainClass());

		if (mainClass.isAssignableFrom(Plugin.class)) {
			if (clazzs != null)
				result = mainClass.getConstructor((Class<?>[]) clazzs).newInstance(clazzs);
			else
				result = mainClass.getConstructor((Class<?>) null).newInstance((Class<?>) null);
		}

		return result;
	}

	@Override
	public PluginDescription getPluginDescription(File file) throws IOException {
		return new PluginDescription(file.getPath());
	}

	@Override
	public void enablePlugin(Plugin plugin) {

	}

	@Override
	public void disablePlugin(Plugin plugin) {

	}
}

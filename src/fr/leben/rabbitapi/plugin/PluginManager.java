package fr.leben.rabbitapi.plugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarFile;

import fr.leben.rabbitapi.Rabbit;
import fr.leben.rabbitapi.event.Event;
import fr.leben.rabbitapi.event.Listener;
import fr.leben.rabbitapi.plugin.java.JavaPlugin;

public class PluginManager {

	public void callEvent(Listener listener, Event event) {
		Class<? extends Event> clazz = event.getClass();
		if (clazz != null) {
			if (!event.isCancelled()) {
				for (Method method : listener.getClass().getMethods()) {
					for (Class<?> param : method.getParameterTypes()) {
						if (param.equals(clazz)) {
							try {
								method.invoke(event);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}

				}
			}
		}
	}

	public Plugin[] loadPlugins(File[] files) throws ClassNotFoundException,
			IOException {
		List<Plugin> plugins = new ArrayList<Plugin>();

		for (File file : files) {
			plugins.add(loadPlugin(file));
		}

		return plugins.toArray(new Plugin[plugins.size()]);
	}

	public Plugin loadPlugin(File file) throws IOException,
			ClassNotFoundException {
		JarFile jfile = new JarFile(file);
		Class<?> main = null;
		Properties yamlDesc = new Properties();
		yamlDesc.load(jfile.getInputStream(jfile.getEntry("plugin.yml")));
		main = Class.forName(yamlDesc.getProperty("main-class"));
		Plugin plugin = null;

		if (main.getSuperclass().equals(JavaPlugin.class)) {
			plugin = Plugin.class.cast(main);
		}

		Rabbit.SERVER.addPlugin(plugin);
		jfile.close();
		return plugin;
	}
}

package fr.leben.rabbitapi.plugin;

/**
 * 
 * This file is part of Rabbit, licensed under the MIT License (MIT).
 *
 * Copyright (c) LebCorp/RabbitTeam
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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

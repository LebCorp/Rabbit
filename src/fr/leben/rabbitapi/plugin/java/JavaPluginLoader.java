package fr.leben.rabbitapi.plugin.java;

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
		plugin.onEnable();
	}

	@Override
	public void disablePlugin(Plugin plugin) {
		plugin.onDisable();
	}
}

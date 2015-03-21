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

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginDescription {

	private String name;
	private String mainClass;

	private String author;
	private String version;
	private String description;
	private String website;

	private List<String> dependencies;

	public PluginDescription(String path) throws IOException {
		JarFile pluginJar = new JarFile(path);
		JarEntry entry = pluginJar.getJarEntry("plugin.yml");
		Properties pluginProperties = new Properties();

		pluginProperties.load(pluginJar.getInputStream(entry));
		pluginJar.close();

		this.name = pluginProperties.getProperty("name");
		this.mainClass = pluginProperties.getProperty("main-class");

		this.author = pluginProperties.getProperty("author");
		this.version = pluginProperties.getProperty("version");
		this.description = pluginProperties.getProperty("description");
		this.website = pluginProperties.getProperty("website");

		if (!pluginProperties.containsKey("dependencies")) {
			return;
		}

		String[] dp = pluginProperties.getProperty("dependencies").split(",");
		for (int i = 0; i < dp.length; i++) {
			dependencies.add(dp[i]);
		}
	}

	public String getName() {
		return this.name;
	}

	public String getMainClass() {
		return this.mainClass;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getVersion() {
		return this.version;
	}

	public String getDescription() {
		return this.description;
	}

	public String getWebsite() {
		return this.website;
	}

	public List<String> getDependencies() {
		return this.dependencies;
	}
}

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

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import fr.leben.rabbitapi.plugin.Plugin;
import fr.leben.rabbitapi.plugin.PluginDescription;

public abstract class JavaPlugin implements Plugin {

	private String name = "";
	private String id = "";
	private String main = "";
	private String website = "";
	private String desc = "";
	private boolean enabled = false;
	private List<String> authors = null;
	private List<String> dependencies = null;

	// Utils

	public JavaPlugin() {
	}

	public PluginDescription getPluginDescription() {
		try {
			return new PluginDescription(getDataFolder());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getDataFolder() {
		return "/plugins/" + getName() + ".jar";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<String> getAuthors() {
		return authors;
	}

	@Override
	public String getId() {
		return id;
	}

	public void onEnable() {
		this.name = getPluginDescription().getName();
		this.id = getPluginDescription().getVersion();
		this.authors = Arrays.asList(getPluginDescription().getAuthor());
		this.main = getPluginDescription().getMainClass();
		this.website = getPluginDescription().getWebsite();
		this.desc = getPluginDescription().getDescription();
		this.dependencies = getPluginDescription().getDependencies();

		Logger.getLogger("RabbitServer").info(
				"[" + name + "]" + " is now loaded !");
		enabled = true;
	}

	public void onDisable() {
		if (enabled) {
			enabled = false;
			Logger.getLogger("RabbitServer").info(
					"[" + name + "]" + " is now unloaded !");
		} else
			return;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public List<String> getDependencies() {
		return dependencies;
	}

	@Override
	public String getDescription() {
		return desc;
	}

	@Override
	public String getMainClass() {
		return main;
	}

	@Override
	public String getWebsite() {
		return website;
	}
}

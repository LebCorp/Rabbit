package fr.leben.rabbit;

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
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import fr.leben.rabbitapi.Server;
import fr.leben.rabbitapi.World;
import fr.leben.rabbitapi.WorldCreator;
import fr.leben.rabbitapi.plugin.Plugin;
import fr.leben.rabbitapi.plugin.PluginManager;

public class RabbitServer implements Server {

	private Logger logger = Logger.getLogger("RabbitServer");
	private ArrayList<Plugin> plugins = new ArrayList<Plugin>();
	private PluginManager pmanager = new PluginManager();
	private MinecraftServer server;
	
	public RabbitServer() {
	}
	
	public RabbitServer(MinecraftServer server) {
		this.server = server;
	}
	
	@Override
	public String getClassName() {
		return "RabbitServer";
	}

	@Override
	public String getName() {
		return this.getClassName() + " " + getVersion();
	}

	@Override
	public String getVersion() {
		return "v1.8._";
	}

	@Override
	public void shutdown() {
		getLogger().info("Server shutting down...");
		getLogger().info("Please wait while saving the librairies...");
		// Libraries

		// Shutdown
		getLogger().info("The server is now off.");
		System.exit(0);
	}

	@Override
	public Plugin getPlugin(String name) {

		for (Plugin plugin : getPlugins()) {
			if (plugin.getName() == name) {
				return plugin;
			}
		}
		return null;
	}

	@Override
	public Collection<Plugin> getPlugins() {
		return plugins;
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public void addPlugin(Plugin plugin) {
		this.plugins.add(plugin);
		System.out.println("+1 plugin: " + String.valueOf(plugins.size()) + " plugins is now loaded !");
	}

	@Override
	public PluginManager pmanager() {
		return pmanager;
	}

	@Override
	public void start(String... args) {
		MinecraftServer.main(args);
	}

	@Override
	public World createWorld(WorldCreator creator) {
		return null;
	}
}

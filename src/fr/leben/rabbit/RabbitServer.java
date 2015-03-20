package fr.leben.rabbit;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import fr.leben.rabbitapi.Server;
import fr.leben.rabbitapi.plugin.Plugin;
import fr.leben.rabbitapi.plugin.PluginManager;

public class RabbitServer implements Server {

	private Logger logger = Logger.getLogger("RabbitServer");
	private ArrayList<Plugin> plugins = new ArrayList<Plugin>();
	private PluginManager pmanager = new PluginManager();
	
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
	public void start() {
		try {
			pmanager().loadPlugins(new File[123]);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}

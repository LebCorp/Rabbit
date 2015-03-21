package fr.leben.rabbitapi;

import java.util.Collection;
import java.util.logging.Logger;

import fr.leben.rabbitapi.plugin.Plugin;
import fr.leben.rabbitapi.plugin.PluginManager;

public interface Server {

	public String getClassName();
	
	public String getName();
	
	public String getVersion();
	
	public void shutdown();
	
	public Plugin getPlugin(String name);
	
	public Collection<Plugin> getPlugins();
	
	public Logger getLogger();
	
	public void addPlugin(Plugin plugin);
	
	public PluginManager pmanager();
	
	public void start();
	
	public World createWorld(WorldCreator creator);
}

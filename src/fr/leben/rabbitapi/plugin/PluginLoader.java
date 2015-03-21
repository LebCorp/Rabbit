package fr.leben.rabbitapi.plugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface PluginLoader {

	public Plugin loadPlugin(File file, Object... clazzs) throws Exception;
	
	public PluginDescription getPluginDescription(File file) throws IOException;
	
	public void enablePlugin(Plugin plugin);
	
	public void disablePlugin(Plugin plugin);
}

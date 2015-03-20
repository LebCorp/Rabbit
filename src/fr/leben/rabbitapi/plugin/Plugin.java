package fr.leben.rabbitapi.plugin;

import java.util.List;

public interface Plugin {

	public String getName();
	
	public List<String> getAuthors();
	
	public String getId();
	
	public void onEnable();
	
	public void onDisable();
	
	public boolean isEnabled();
	
	public PluginDescription getPluginDescription();
	
	public String getMainClass();
	
	public String getWebsite();
	
	public String getDescription();
	
	public List<String> getDependencies();
}

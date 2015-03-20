package fr.leben.rabbitapi.plugin.java;

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
	
	//Utils
	
	public JavaPlugin() {
	}

	public PluginDescription getPluginDescription() {
		return null;
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

		Logger.getLogger("RabbitServer").info("[" + name + "]" + " is now loaded !");
		enabled = true;
	}

	public void onDisable() {
		if (enabled) {
			enabled = false;
			Logger.getLogger("RabbitServer").info("[" + name + "]" + " is now unloaded !");
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

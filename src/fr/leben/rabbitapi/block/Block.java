package fr.leben.rabbitapi.block;

import fr.leben.rabbitapi.Location;

public interface Block {

	public String getName();
	
	public int getId();
	
	public boolean exist();
	
	public boolean isLiquid();
	
	public boolean isBurnable();
	
	public boolean isBreakeable();
	
	public Location getLocation();
	
	public String name_id();
}

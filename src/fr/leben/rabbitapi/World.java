package fr.leben.rabbitapi;

public interface World {

	public String getName();
	
	public long getSeed();
	
	public void createExplosion(int x, int y, int z, int power, boolean fire, boolean breakBlocks);
	
	public void createExplosion(int x, int y, int z, int power, boolean fire);
	
	public void createExplosion(int x, int y, int z, int power);
	
	public Location getSpawn();
	
	public void setSpawnLocation(Location newSpawn);
}

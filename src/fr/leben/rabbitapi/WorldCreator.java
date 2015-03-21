package fr.leben.rabbitapi;

public class WorldCreator {

	private String name;
	private long seed;
	private WorldType type;

	public WorldCreator() {
	}

	public WorldCreator(String name) {
		this.name = name;
	}

	public WorldCreator name(String name) {
		this.name = name;
		return this;
	}
	
	public WorldCreator seed(long seed) {
		this.seed = seed;
		return this;
	}
	
	public WorldCreator type(WorldType type) {
		this.type = type;
		return this;
	}
	
	
	public String name() {
		return name;
	}

	public long seed() {
		return seed;
	}

	public WorldType type() {
		return type;
	}

	public World createWorld() {
		return Rabbit.createWorld(this);
	}
}

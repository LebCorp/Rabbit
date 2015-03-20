package fr.leben.rabbitapi.block;

public interface Block {

	public String getName();
	
	public int getId();
	
	public boolean isLiquid();
	
	public boolean isBurnable();
	
	public boolean isBreakeable();
}

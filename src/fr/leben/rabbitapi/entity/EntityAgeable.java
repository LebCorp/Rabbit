package fr.leben.rabbitapi.entity;

public interface EntityAgeable extends Entity {

	public boolean isBaby();
	
	public int getAge();
	
	public void setAge(int age);
}

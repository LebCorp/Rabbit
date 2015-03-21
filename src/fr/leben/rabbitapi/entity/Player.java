package fr.leben.rabbitapi.entity;

import net.minecraft.util.FoodStats;

import com.mojang.authlib.GameProfile;

public interface Player extends LivingEntity {

	public void sendMessage(String message);
	
	public void sendMessage(String[] args);
	
	public void sendRawMessage(String message) throws InstantiationException, IllegalAccessException;
	
	public int getMaxPortalInTime();
	
	public int getPortalCooldown();
	
	public void playSound(String paramString, float paramFloat, float paramFloat2);
	
	public void mountEntity(Entity entity);
	
	public void openInventory();
	
	public void setDead();
	
	public GameProfile profile();
	
	public boolean wakeUp(boolean bool, boolean boo, boolean bo);
	
	public boolean isSleeping();
	
	public boolean isFullySleep();
	
	public void jump();
	
	public void addExperience(int exp);
	
	public void addExperienceLevel(int explvl);
	
	public FoodStats getFoodStats();
	
	public boolean isPlayer();
	
	public Player clonePlayer();
}

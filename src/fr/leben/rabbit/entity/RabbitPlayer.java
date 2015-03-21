package fr.leben.rabbit.entity;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IChatComponent;
import fr.leben.rabbitapi.Location;
import fr.leben.rabbitapi.block.Block;
import fr.leben.rabbitapi.entity.Arrow;
import fr.leben.rabbitapi.entity.Egg;
import fr.leben.rabbitapi.entity.Entity;
import fr.leben.rabbitapi.entity.Player;
import fr.leben.rabbitapi.entity.Snowball;

public class RabbitPlayer implements Player {

	private EntityPlayer handle;
	private boolean canPickup;

	public RabbitPlayer(EntityPlayer handle) {
		this.handle = handle;
	}

	@Override
	public double getEyeHeight() {
		return 0.0D;
	}

	@Override
	public double getEyeHeight(boolean paramBoolean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getEyeLocation() {
		return null;
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> paramHashSet, int paramInt) {
		return null;
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> paramHashSet, int paramInt) {
		return null;
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> paramHashSet,
			int paramInt) {
		return null;
	}

	@Override
	public Egg throwEgg() {
		return null;
	}

	@Override
	public Snowball throwSnowball() {
		return null;
	}

	@Override
	public Arrow shootArrow() {
		return null;
	}

	@Override
	public int getRemainingAir() {
		return handle.getAir();
	}

	@Override
	public void setRemainingAir(int paramInt) {
		handle.setAir(paramInt);
	}

	@Override
	public int getMaximumAir() {
		return handle.getAir();
	}

	@Override
	public void setMaximumAir(int paramInt) {
		handle.setAir(paramInt);
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return 0;
	}

	@Override
	public void setMaximumNoDamageTicks(int paramInt) {

	}

	@Override
	public double getLastDamage() {
		return 0;
	}

	@Override
	public void setLastDamage(double paramDouble) {

	}

	@Override
	public int getNoDamageTicks() {
		return 0;
	}

	@Override
	public void setNoDamageTicks(int paramInt) {
	}

	@Override
	public Player getKiller() {
		return null;
	}

	@Override
	public boolean hasLineOfSight(Entity paramEntity) {
		return false;
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		return false;
	}

	@Override
	public void setRemoveWhenFarAway(boolean paramBoolean) {
	}

	@Override
	public void setCanPickupItems(boolean paramBoolean) {
		this.canPickup = paramBoolean;
	}

	@Override
	public boolean getCanPickupItems() {
		return canPickup;
	}

	@Override
	public boolean isLeashed() {
		return false;
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		return null;
	}

	@Override
	public boolean setLeashHolder(Entity paramEntity) {
		return false;
	}

	@Override
	public void sendMessage(String message) {
		try {
			sendRawMessage(message);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(String[] args) {
		sendMessage(StringUtils.join(args, " "));
	}

	@Override
	public void sendRawMessage(String message) throws InstantiationException, IllegalAccessException {
		C01PacketChatMessage packet = new C01PacketChatMessage(message);
		NetHandlerPlayServer ser = NetHandlerPlayServer.class.newInstance();
		ser.sendPacket(packet);
	}

	@Override
	public int getMaxPortalInTime() {
		return handle.getMaxInPortalTime();
	}

	@Override
	public int getPortalCooldown() {
		return handle.getPortalCooldown();
	}

	@Override
	public void playSound(String paramString, float paramFloat,
			float paramFloat2) {
		handle.playSound(paramString, paramFloat, paramFloat2);
	}

	@Override
	public void mountEntity(Entity entity) {
		handle.mountEntity((net.minecraft.entity.Entity) entity);
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void setDead() {
		handle.setDead();
	}

	@Override
	public GameProfile profile() {
		return handle.getGameProfile();
	}

	@Override
	public boolean wakeUp(boolean bool, boolean boo, boolean bo) {
		handle.wakeUpPlayer(bool, boo, bo);
		return true;
	}

	@Override
	public boolean isSleeping() {
		return handle.isPlayerSleeping();
	}

	@Override
	public boolean isFullySleep() {
		return handle.isPlayerFullyAsleep();
	}

	@Override
	public void jump() {
		handle.jump();
	}

	@Override
	public void addExperience(int exp) {
		handle.addExperience(exp);
	}

	@Override
	public void addExperienceLevel(int explvl) {
		handle.addExperienceLevel(explvl);
	}

	@Override
	public FoodStats getFoodStats() {
		return handle.getFoodStats();
	}

	@Override
	public boolean isPlayer() {
		return true;
	}

	@Override
	public Player clonePlayer() {
		return this;
	}
}

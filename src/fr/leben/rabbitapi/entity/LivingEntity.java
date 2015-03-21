package fr.leben.rabbitapi.entity;

import java.util.HashSet;
import java.util.List;

import fr.leben.rabbitapi.Location;
import fr.leben.rabbitapi.block.Block;

public interface LivingEntity {

	public abstract double getEyeHeight();

	public abstract double getEyeHeight(boolean paramBoolean);

	public abstract Location getEyeLocation();

	@Deprecated
	public abstract List<Block> getLineOfSight(HashSet<Byte> paramHashSet,
			int paramInt);

	@Deprecated
	public abstract Block getTargetBlock(HashSet<Byte> paramHashSet,
			int paramInt);

	@Deprecated
	public abstract List<Block> getLastTwoTargetBlocks(
			HashSet<Byte> paramHashSet, int paramInt);

	@Deprecated
	public abstract Egg throwEgg();

	@Deprecated
	public abstract Snowball throwSnowball();

	@Deprecated
	public abstract Arrow shootArrow();

	public abstract int getRemainingAir();

	public abstract void setRemainingAir(int paramInt);

	public abstract int getMaximumAir();

	public abstract void setMaximumAir(int paramInt);

	public abstract int getMaximumNoDamageTicks();

	public abstract void setMaximumNoDamageTicks(int paramInt);

	public abstract double getLastDamage();

	public abstract void setLastDamage(double paramDouble);

	public abstract int getNoDamageTicks();

	public abstract void setNoDamageTicks(int paramInt);

	public abstract Player getKiller();

	// public abstract boolean addPotionEffect(PotionEffect paramPotionEffect);

	// public abstract boolean addPotionEffect(PotionEffect paramPotionEffect, boolean paramBoolean);

	// public abstract boolean addPotionEffects( Collection<PotionEffect> paramCollection);

	// public abstract boolean hasPotionEffect( PotionEffectType paramPotionEffectType);

	// public abstract void removePotionEffect( PotionEffectType paramPotionEffectType);

	// public abstract Collection<PotionEffect> getActivePotionEffects();

	public abstract boolean hasLineOfSight(Entity paramEntity);

	public abstract boolean getRemoveWhenFarAway();

	public abstract void setRemoveWhenFarAway(boolean paramBoolean);

	// public abstract EntityEquipment getEquipment();

	public abstract void setCanPickupItems(boolean paramBoolean);

	public abstract boolean getCanPickupItems();

	public abstract boolean isLeashed();

	public abstract Entity getLeashHolder() throws IllegalStateException;

	public abstract boolean setLeashHolder(Entity paramEntity);
}

package fr.leben.rabbitapi.entity;

import java.util.List;
import java.util.UUID;

import fr.leben.rabbitapi.Location;
import fr.leben.rabbitapi.Server;
import fr.leben.rabbitapi.Vector;
import fr.leben.rabbitapi.World;
import fr.leben.rabbitapi.event.EntityDamageEvent;
import fr.leben.rabbitapi.event.PlayerTeleportEvent;

public interface Entity {

	 public abstract Location getLocation();

	  public abstract Location getLocation(Location paramLocation);

	  public abstract void setVelocity(Vector paramVector);

	  public abstract Vector getVelocity();

	  public abstract boolean isOnGround();

	  public abstract World getWorld();

	  public abstract boolean teleport(Location paramLocation);

	  public abstract boolean teleport(Location paramLocation, PlayerTeleportEvent.TeleportCause paramTeleportCause);

	  public abstract boolean teleport(Entity paramEntity);

	  public abstract boolean teleport(Entity paramEntity, PlayerTeleportEvent.TeleportCause paramTeleportCause);

	  public abstract List<Entity> getNearbyEntities(double paramDouble1, double paramDouble2, double paramDouble3);

	  public abstract int getEntityId();

	  public abstract int getFireTicks();

	  public abstract int getMaxFireTicks();

	  public abstract void setFireTicks(int paramInt);

	  public abstract void remove();

	  public abstract boolean isDead();

	  public abstract boolean isValid();

	  public abstract Server getServer();

	  public abstract Entity getPassenger();

	  public abstract boolean setPassenger(Entity paramEntity);

	  public abstract boolean isEmpty();

	  public abstract boolean eject();

	  public abstract float getFallDistance();

	  public abstract void setFallDistance(float paramFloat);

	  public abstract void setLastDamageCause(EntityDamageEvent paramEntityDamageEvent);

	  public abstract EntityDamageEvent getLastDamageCause();

	  public abstract UUID getUniqueId();

	  public abstract int getTicksLived();

	  public abstract void setTicksLived(int paramInt);

	  public abstract void playEffect(EntityEffect paramEntityEffect);

	  public abstract boolean isInsideVehicle();

	  public abstract boolean leaveVehicle();

	  public abstract Entity getVehicle();

	  public abstract void setCustomName(String paramString);

	  public abstract String getCustomName();

	  public abstract void setCustomNameVisible(boolean paramBoolean);

	  public abstract boolean isCustomNameVisible();
}

package Trubby.co.th.Utils;

import net.minecraft.server.v1_7_R4.AttributeInstance;
import net.minecraft.server.v1_7_R4.EntityInsentient;
import net.minecraft.server.v1_7_R4.GenericAttributes;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftLivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;

public class MobsUtil {
	
	/**
	 * ---- DEFAULT ----
	 * HEATH = 20
	 * RANGE = 40
	 * KNOCK = 0
	 * SPEED = 23.000004
	 * 
	 */
	
	public static org.bukkit.inventory.ItemStack helmet = new org.bukkit.inventory.ItemStack(Material.CHAINMAIL_HELMET);
	
	public static Entity spawnMob(Location loc, EntityType EntityType, double health, double range, double knock, double speed)
	  {
	    Entity e = loc.getWorld().spawnEntity(loc, EntityType);
	    LivingEntity le = (LivingEntity)e;
	    if (health != 0.0D) {
	      setMaxHealth(e, health);
	    }
	    if (range != 0.0D) {
	      setFollowRange(e, range);
	    }
	    if (knock != 0.0D) {
	      setKnockBackResistance(e, knock);
	    }
	    if (speed != 0.0D) {
	      setMobSpeed(e, speed);
	    }
	    le.setCustomName("§cCOPs");
	    le.setCustomNameVisible(true);
	    le.setRemoveWhenFarAway(false);
	    
	    return e;
	  }
	
	public static void spawnPigman(Location loc, int wanted)
	  {
		for (int i = 0; i < wanted*3; i++) {
			Entity e = loc.getWorld().spawnEntity(loc, EntityType.PIG_ZOMBIE);
			PigZombie le = (PigZombie)e;
		    le.setCustomName("§cCOPs");
		    le.setCustomNameVisible(true);
		    le.setRemoveWhenFarAway(true);
		    le.getEquipment().clear();
		    le.setAngry(true);
		}
	  }
	
	public static void setMaxHealth(Entity e, double health) {
		AttributeInstance attributes = ((EntityInsentient) ((CraftLivingEntity) e).getHandle()).getAttributeInstance(GenericAttributes.maxHealth);
		attributes.setValue(health);
		LivingEntity l = (LivingEntity) e;
		l.setHealth(l.getMaxHealth());
	}

	public static void setFollowRange(Entity e, double range) {
		AttributeInstance attributes = ((EntityInsentient) ((CraftLivingEntity) e).getHandle()).getAttributeInstance(GenericAttributes.b);
		if (attributes != null) {
			attributes.setValue(range);
		}
	}

	public static void setKnockBackResistance(Entity e, double knock) {
		AttributeInstance attributes = ((EntityInsentient) ((CraftLivingEntity) e).getHandle()).getAttributeInstance(GenericAttributes.c);
		if (attributes != null) {
			attributes.setValue(knock);
		}
	}

	public static void setMobSpeed(Entity e, double speed) {
		AttributeInstance attributes = ((EntityInsentient) ((CraftLivingEntity) e).getHandle()).getAttributeInstance(GenericAttributes.d);
		if (attributes != null) {
			attributes.setValue(speed);
		}
	}

	public static void setAttackDamage(Entity e, double damage) {
		AttributeInstance attributes = ((EntityInsentient) ((CraftLivingEntity) e).getHandle()).getAttributeInstance(GenericAttributes.e);
		if (attributes != null) {
			attributes.setValue(damage);
		}
	}

	public static void PlaySoundAtLocation(Location location, String sound, float volume, float pitch) {
		((CraftWorld) location.getWorld()).getHandle().makeSound(location.getX(), location.getY(), location.getZ(), sound, volume, pitch);
	}
}
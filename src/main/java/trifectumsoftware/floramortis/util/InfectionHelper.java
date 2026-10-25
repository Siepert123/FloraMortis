package trifectumsoftware.floramortis.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedCow;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedPig;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedZombie;

public class InfectionHelper {
	public static void pollinate(World world, EntityLivingBase target) {
		if (target.isChild()) return;
		Class<? extends EntityLivingBase> type = target.getClass();
		final EntityLivingBase convert;
		if (type == EntityPig.class) {
			convert = new EntityPollinatedPig(world, target.posX, target.posY, target.posZ);
		} else if (type == EntityCow.class) {
			convert = new EntityPollinatedCow(world, target.posX, target.posY, target.posZ);
		} else if (type == EntityZombie.class) {
			convert = new EntityPollinatedZombie(world, target.posX, target.posY, target.posZ);
		} else {
			convert = null;
		}

		if (convert != null) {
			target.setDead();
			target.deathTime = 0;
			target.setInvisible(true);
			convert.setHealth(convert.getMaxHealth() * 0.5F);
			world.spawnEntityInWorld(convert);
			world.spawnParticle("explode", target.posX, target.posY - target.yOffset * 0.5F, target.posZ, 0.0, 0.0, 0.0);
		}
	}
}

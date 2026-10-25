package trifectumsoftware.floramortis.world.entity.pollinated;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import trifectumsoftware.floramortis.util.InfectionHelper;
import trifectumsoftware.floramortis.world.entity.EntityFloraMobBase;

public abstract class EntityPollinatedMob extends EntityFloraMobBase {
	public EntityPollinatedMob(World world) {
		super(world);
	}

	@Override
	public void onKillEntity(EntityLivingBase target) {
		InfectionHelper.pollinate(this.worldObj, target);
	}
}

package trifectumsoftware.floramortis.world.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import trifectumsoftware.floramortis.world.entity.IFloraEntity;

public class FloraEntitySelector implements IEntitySelector {
	@Override
	public boolean isEntityApplicable(Entity entity) {
		return entity instanceof EntityLiving && !(entity instanceof IFloraEntity);
	}
}

package trifectumsoftware.floramortis.world.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;

public class FloraAIAttackOnCollide extends EntityAIAttackOnCollide {
	public FloraAIAttackOnCollide(EntityCreature entity, Class<? extends Entity> target, double speed, boolean remember) {
		super(entity, target, speed, remember);
	}
}

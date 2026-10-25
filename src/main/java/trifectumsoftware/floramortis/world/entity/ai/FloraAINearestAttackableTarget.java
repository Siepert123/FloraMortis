package trifectumsoftware.floramortis.world.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import trifectumsoftware.floramortis.world.entity.IFloraEntity;

import java.util.Comparator;
import java.util.List;

public class FloraAINearestAttackableTarget extends EntityAINearestAttackableTarget {
	protected final Sorter sorter;
	protected EntityLivingBase target = null;
	public FloraAINearestAttackableTarget(EntityCreature entity, Class<? extends Entity> target, int range, boolean remember, boolean sight) {
		super(entity, target, range, remember, sight, new FloraEntitySelector());
		this.sorter = new Sorter(entity);
	}

	@Override
	public boolean shouldExecute() {
		double dist = this.getTargetDistance();
		List<EntityLivingBase> list = this.taskOwner.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.taskOwner.boundingBox.expand(dist, dist, dist));
		list.sort(this.sorter);

		if (list.isEmpty()) return false;
		for (EntityLivingBase candidate : list) {
			if (!(candidate instanceof IFloraEntity) && this.isSuitableTarget(candidate, false)) {
				this.target = candidate;
				return true;
			}
		}
		return false;
	}

	@Override
	public void startExecuting() {
		super.startExecuting();
		this.taskOwner.setAttackTarget(this.target);
	}

	public static class Sorter implements Comparator<Entity> {
		private final Entity owner;

		public Sorter(Entity owner) {
			this.owner = owner;
		}

		@Override
		public int compare(Entity o1, Entity o2) {
			return Double.compare(this.owner.getDistanceSqToEntity(o1), this.owner.getDistanceSqToEntity(o2));
		}
	}
}

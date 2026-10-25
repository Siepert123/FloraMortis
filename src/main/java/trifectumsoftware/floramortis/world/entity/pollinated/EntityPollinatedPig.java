package trifectumsoftware.floramortis.world.entity.pollinated;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityPollinatedPig extends EntityPollinatedMob {
	public EntityPollinatedPig(World world) {
		super(world);

		this.setSize(0.9F, 0.9F);
	}
	public EntityPollinatedPig(World world, double x, double y, double z) {
		this(world);
		this.setPositionAndRotation(x, y, z, 0.0F, 0.0F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	}
}

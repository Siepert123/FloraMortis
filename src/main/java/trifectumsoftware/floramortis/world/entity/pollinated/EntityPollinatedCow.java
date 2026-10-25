package trifectumsoftware.floramortis.world.entity.pollinated;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityPollinatedCow extends EntityPollinatedMob {
	public EntityPollinatedCow(World world) {
		super(world);

		this.setSize(0.9F, 1.3F);
	}
	public EntityPollinatedCow(World world, double x, double y, double z) {
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

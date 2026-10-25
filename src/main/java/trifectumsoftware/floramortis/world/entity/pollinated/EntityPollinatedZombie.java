package trifectumsoftware.floramortis.world.entity.pollinated;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityPollinatedZombie extends EntityPollinatedMob {
	public EntityPollinatedZombie(World world) {
		super(world);

		this.setSize(0.6F, 1.8F);
	}
	public EntityPollinatedZombie(World world, double x, double y, double z) {
		this(world);
		this.setPositionAndRotation(x, y, z, 0.0F, 0.0F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0D);
	}
}

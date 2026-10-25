package trifectumsoftware.floramortis.world.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import trifectumsoftware.floramortis.world.entity.ai.FloraAINearestAttackableTarget;

public abstract class EntityFloraMobBase extends EntityMob implements IFloraEntity {
	public EntityFloraMobBase(World world) {
		super(world);

		this.addAITasks();
		this.addAITargetTasks();
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}
	@Override
	public boolean canAttackClass(Class<? extends Entity> clazz) {
		return !IFloraEntity.class.isAssignableFrom(clazz);
	}

	protected void addAITasks() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0F, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityLivingBase.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}
	protected void addAITargetTasks() {
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new FloraAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, true));
	}

	@Override
	protected void damageEntity(DamageSource source, float dmg) {
		super.damageEntity(source, source.isFireDamage() ? dmg * 4.0F : dmg);
	}
}

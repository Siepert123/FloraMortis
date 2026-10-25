package trifectumsoftware.floramortis.world.effect;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import trifectumsoftware.floramortis.util.InfectionHelper;

public class PotionPollinated extends Potion {
	public PotionPollinated(int id, int color) {
		super(id, true, color);
	}

	@Override
	public boolean isReady(int ticks, int amplifier) {
		return (ticks == 1);
	}

	@Override
	public void performEffect(EntityLivingBase entity, int amplifier) {
		entity.addPotionEffect(new PotionEffect(this.id, 6000, Math.min(amplifier+1, 2), true));
		if (amplifier == 2 && !(entity instanceof EntityPlayer)) {
			InfectionHelper.pollinate(entity.worldObj, entity);
		}
	}

	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		super.renderInventoryEffect(x, y, effect, mc);
	}
}

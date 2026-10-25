package trifectumsoftware.floramortis.render.entity.pollinated;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import trifectumsoftware.floramortis.FloraMortis;

public class RenderPollinatedZombie extends RenderLiving {
	public static final ResourceLocation TEXTURE = FloraMortis.resource("textures/entity/pollinated/zombie.png");

	public RenderPollinatedZombie(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE;
	}
}

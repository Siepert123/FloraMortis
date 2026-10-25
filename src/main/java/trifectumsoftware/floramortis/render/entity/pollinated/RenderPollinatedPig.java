package trifectumsoftware.floramortis.render.entity.pollinated;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import trifectumsoftware.floramortis.FloraMortis;

public class RenderPollinatedPig extends RenderLiving {
	public static final ResourceLocation TEXTURE = FloraMortis.resource("textures/entity/pollinated/pig.png");

	public RenderPollinatedPig(ModelBase model, float shadowSize) {
		super(model, shadowSize);
		this.renderManager = RenderManager.instance;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE;
	}
}

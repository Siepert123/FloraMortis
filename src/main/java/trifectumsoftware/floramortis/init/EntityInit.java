package trifectumsoftware.floramortis.init;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import trifectumsoftware.floramortis.FloraMortis;
import trifectumsoftware.floramortis.render.entity.pollinated.RenderPollinatedCow;
import trifectumsoftware.floramortis.render.entity.pollinated.RenderPollinatedPig;
import trifectumsoftware.floramortis.render.entity.pollinated.RenderPollinatedZombie;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedCow;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedPig;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedZombie;

public class EntityInit {
	public static void register() {
		int id = 0;

		EntityRegistry.registerModEntity(EntityPollinatedPig.class,
			"PollinatedPig", id++, FloraMortis.instance,
			64, 1, true
		);
		EntityRegistry.registerModEntity(EntityPollinatedCow.class,
			"PollinatedCow", id++, FloraMortis.instance,
			64, 1, true
		);
		EntityRegistry.registerModEntity(EntityPollinatedZombie.class,
			"PollinatedZombie", id++, FloraMortis.instance,
			64, 1, true
		);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenderers() {
		registerRenderer(EntityPollinatedPig.class, new RenderPollinatedPig(new ModelPig(), 0.5F));
		registerRenderer(EntityPollinatedCow.class, new RenderPollinatedCow(new ModelCow(), 0.5F));
		registerRenderer(EntityPollinatedZombie.class, new RenderPollinatedZombie(new ModelZombie(), 0.5F));
	}
	@SideOnly(Side.CLIENT)
	private static void registerRenderer(Class<? extends Entity> entity, Render render) {
		RenderManager.instance.entityRenderMap.put(entity, render);
		render.setRenderManager(RenderManager.instance);
	}
}

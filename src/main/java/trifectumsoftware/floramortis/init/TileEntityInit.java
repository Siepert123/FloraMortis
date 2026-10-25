package trifectumsoftware.floramortis.init;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInit {
	public static void register() {

	}

	@SideOnly(Side.CLIENT)
	public static void registerRenderers() {

	}
	@SideOnly(Side.CLIENT)
	private static void registerRenderer(Class<? extends TileEntity> clazz, TileEntitySpecialRenderer render) {
		TileEntityRendererDispatcher.instance.mapSpecialRenderers.put(clazz, render);
		render.func_147497_a(TileEntityRendererDispatcher.instance);
	}

}

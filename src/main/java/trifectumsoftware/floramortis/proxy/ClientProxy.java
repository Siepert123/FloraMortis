package trifectumsoftware.floramortis.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import trifectumsoftware.floramortis.init.EntityInit;
import trifectumsoftware.floramortis.init.TileEntityInit;
import trifectumsoftware.floramortis.util.NoUnused;

@NoUnused
@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		TileEntityInit.registerRenderers();
		EntityInit.registerRenderers();
	}
}

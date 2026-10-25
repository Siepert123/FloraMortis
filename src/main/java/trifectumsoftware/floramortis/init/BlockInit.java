package trifectumsoftware.floramortis.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import trifectumsoftware.floramortis.FloraMortis;
import trifectumsoftware.floramortis.world.block.BlockTest;

public class BlockInit {
	public static final BlockTest TEST = (BlockTest) new BlockTest()
		.setBlockTextureName(FloraMortis.resourceStr("test"))
		.setBlockName(FloraMortis.lang("test"))
		.setCreativeTab(ItemInit.CREATIVE_TAB);

	public static void register() {
		GameRegistry.registerBlock(TEST, "test_block");
	}
}

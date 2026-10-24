package trifectumsoftware.floramortis.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import trifectumsoftware.floramortis.FloraMortis;

public class ItemInit {
	public static final Item TEST = new Item()
		.setTextureName(FloraMortis.resourceStr("test"))
		.setUnlocalizedName(FloraMortis.lang("test"))
		.setCreativeTab(CreativeTabs.tabMisc);

	public static void register() {
		GameRegistry.registerItem(TEST, "test_item");
	}
}

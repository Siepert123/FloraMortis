package trifectumsoftware.floramortis.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import trifectumsoftware.floramortis.FloraMortis;
import trifectumsoftware.floramortis.world.item.ItemFloraMonsterPlacer;

public class ItemInit {
	public static final Item TEST = new Item()
		.setTextureName(FloraMortis.resourceStr("test"))
		.setUnlocalizedName(FloraMortis.lang("test"))
		.setCreativeTab(CreativeTabs.tabMisc);
	public static final ItemFloraMonsterPlacer MONSTER_PLACER = (ItemFloraMonsterPlacer) new ItemFloraMonsterPlacer()
		.setTextureName(FloraMortis.resourceStr("spawn"))
		.setUnlocalizedName(FloraMortis.lang("spawn"))
		.setCreativeTab(CreativeTabs.tabMisc);

	public static void register() {
		GameRegistry.registerItem(TEST, "test_item");
		GameRegistry.registerItem(MONSTER_PLACER, "monster_placer");
	}
}

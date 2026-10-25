package trifectumsoftware.floramortis.world.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import trifectumsoftware.floramortis.FloraMortis;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedCow;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedPig;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedZombie;

import java.util.List;

public class ItemFloraMonsterPlacer extends Item {
	private static final String[] VARIANTS = {
		"pollinated_pig",
		"pollinated_cow",
		"pollinated_zombie",
	};
	private final IIcon[] textures = new IIcon[VARIANTS.length];

	public ItemFloraMonsterPlacer() {
		super();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public void registerIcons(IIconRegister register) {
		for (int i = 0; i < VARIANTS.length; i++) {
			this.textures[i] = register.registerIcon(FloraMortis.resourceStr("spawn_" + VARIANTS[i]));
		}
		this.itemIcon = this.textures[0];
	}
	@Override
	public IIcon getIconFromDamage(int p_77617_1_) {
		return this.textures[p_77617_1_];
	}
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List<ItemStack> items) {
		for (int i = 0; i < VARIANTS.length; i++) {
			items.add(new ItemStack(item, 1, i));
		}
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item.flora_mortis.spawn_" + VARIANTS[stack.getItemDamage()];
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) return true;
		EnumFacing facing = EnumFacing.getFront(side);
		x += facing.getFrontOffsetX();
		y += facing.getFrontOffsetY();
		z += facing.getFrontOffsetZ();
		final EntityLiving entity;
		switch (stack.getItemDamage()) {
			case 0:
				entity = new EntityPollinatedPig(world, x + 0.5, y + 0.1, z + 0.5);
				break;
			case 1:
				entity = new EntityPollinatedCow(world, x + 0.5, y + 0.1, z + 0.5);
				break;
			case 2:
				entity = new EntityPollinatedZombie(world, x + 0.5, y + 0.1, z + 0.5);
				break;
			default:
				throw new IllegalStateException("Invalid item metadata: " + stack.getItemDamage());
		}
		world.spawnEntityInWorld(entity);
		entity.onSpawnWithEgg(null);
		entity.playLivingSound();
		return true;
	}
}

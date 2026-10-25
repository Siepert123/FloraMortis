package trifectumsoftware.floramortis.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import trifectumsoftware.floramortis.FloraMortisConfig;
import trifectumsoftware.floramortis.FloraMortis;
import trifectumsoftware.floramortis.Tags;
import trifectumsoftware.floramortis.init.*;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedCow;
import trifectumsoftware.floramortis.world.entity.pollinated.EntityPollinatedPig;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        FloraMortisConfig.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        FloraMortis.LOG.info(FloraMortisConfig.greeting);
        FloraMortis.LOG.info("I am Flora Mortis at version " + Tags.VERSION);

		BlockInit.register();
		ItemInit.register();
		TileEntityInit.register();
		EntityInit.register();
		PotionInit.register();
    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}

    public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new ICommand() {
			@Override
			public String getCommandName() {
				return "pollinate";
			}

			@Override
			public String getCommandUsage(ICommandSender sender) {
				return "test";
			}

			@Override
			public List<String> getCommandAliases() {
				return Collections.emptyList();
			}

			@Override
			public void processCommand(ICommandSender sender, String[] args) {
				if (sender instanceof EntityLivingBase) {
					EntityLivingBase living = (EntityLivingBase) sender;
					living.addPotionEffect(new PotionEffect(PotionInit.pollinated.id, 6000, 0, true));
					sender.addChatMessage(new ChatComponentText("pollen"));
				} else {
					sender.addChatMessage(new ChatComponentText("player requirement"));
				}
			}

			@Override
			public boolean canCommandSenderUseCommand(ICommandSender sender) {
				return true;
			}

			@Override
			public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
				return Collections.emptyList();
			}

			@Override
			public boolean isUsernameIndex(String[] args, int index) {
				return false;
			}

			@Override
			public int compareTo(Object o) {
				return 0;
			}
		});
	}
}

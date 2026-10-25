package trifectumsoftware.floramortis.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import trifectumsoftware.floramortis.FloraMortisConfig;
import trifectumsoftware.floramortis.FloraMortis;
import trifectumsoftware.floramortis.Tags;
import trifectumsoftware.floramortis.init.BlockInit;
import trifectumsoftware.floramortis.init.EntityInit;
import trifectumsoftware.floramortis.init.ItemInit;
import trifectumsoftware.floramortis.init.TileEntityInit;
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
				ChunkCoordinates cc = sender.getPlayerCoordinates();
				final Entity entity;
				switch (new Random().nextInt(2)) {
					case 0:
						entity = new EntityPollinatedPig(sender.getEntityWorld(), cc.posX, cc.posY, cc.posZ);
						break;
					case 1:
						entity = new EntityPollinatedCow(sender.getEntityWorld(), cc.posX, cc.posY, cc.posZ);
						break;
					default:
						throw new IllegalStateException("???");
				}
				sender.getEntityWorld().spawnEntityInWorld(entity);
				sender.addChatMessage(new ChatComponentText("spawned " + entity.getClass().getSimpleName()));
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

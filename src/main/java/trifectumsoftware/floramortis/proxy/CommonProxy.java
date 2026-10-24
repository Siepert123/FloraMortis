package trifectumsoftware.floramortis.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import trifectumsoftware.floramortis.FloraMortisConfig;
import trifectumsoftware.floramortis.FloraMortis;
import trifectumsoftware.floramortis.Tags;
import trifectumsoftware.floramortis.init.BlockInit;
import trifectumsoftware.floramortis.init.EntityInit;
import trifectumsoftware.floramortis.init.ItemInit;
import trifectumsoftware.floramortis.init.TileEntityInit;

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

    public void serverStarting(FMLServerStartingEvent event) {}
}

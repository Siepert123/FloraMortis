package trifectumsoftware.floramortis;

import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import trifectumsoftware.floramortis.proxy.CommonProxy;

@Mod(modid = FloraMortis.MODID, version = Tags.VERSION, name = "Flora Mortis", acceptedMinecraftVersions = "[1.7.10]")
public class FloraMortis {
    public static final String MODID = "flora_mortis";
    public static final Logger LOG = LogManager.getLogger(MODID);

	@Mod.Instance(MODID)
	public static FloraMortis instance = null;
    @SidedProxy(clientSide = "trifectumsoftware.floramortis.proxy.ClientProxy", serverSide = "trifectumsoftware.floramortis.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

	public static ResourceLocation resource(String path) {
		return new ResourceLocation(MODID, path);
	}
	public static String resourceStr(String path) {
		return MODID + ":" + path;
	}
	public static String lang(String path) {
		return MODID + "." + path;
	}
}

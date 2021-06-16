package dev.imystxc.adminplus;

import dev.imystxc.adminplus.commands.Command;
import info.pixelmon.repack.ninja.leaping.configurate.commented.CommentedConfigurationNode;
import info.pixelmon.repack.ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import info.pixelmon.repack.ninja.leaping.configurate.loader.ConfigurationLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dev.imystxc.adminplus.config.Config;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

@Mod(
        modid = AdminPlus.MOD_ID,
        name = AdminPlus.MOD_NAME,
        version = AdminPlus.VERSION,
        acceptableRemoteVersions = "*",
        dependencies = "required-after:pixelmon",
        acceptedMinecraftVersions = "[1.12.2]"
)
public class AdminPlus {

    public static final String MOD_ID = "adminplus";
    public static final String MOD_NAME = "AdminPlus";
    public static final String VERSION = "1.0.0";
    public static String primaryPath;
    public static String commandConfigPath;
    public static Path configPath;
    private static String separator = FileSystems.getDefault().getSeparator();
    public static ConfigurationLoader<CommentedConfigurationNode> primaryConfigLoader;
    String path;
    File configFile;
    ConfigurationLoader<CommentedConfigurationNode> configLoader;

    private static final Logger logger = LogManager.getLogger();


    @Mod.Instance(MOD_ID)
    public static AdminPlus INSTANCE;

    public AdminPlus() {
        this.path = "config" + File.separator + "AdminPlus";
        this.configFile = new File(this.path, "adminplus.conf");
        this.configLoader = ((HoconConfigurationLoader.Builder) HoconConfigurationLoader.builder().setFile(this.configFile)).build();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Config.getInstance().setup(this.configFile, this.configLoader);
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        event.registerServerCommand(new Command());
        logger.info("AdminPlus Has Successfully Loaded");
    }

    static{
        primaryPath = "config" + separator;
        commandConfigPath = "config" + separator + "AdminPlus" + separator;
        configPath = Paths.get(primaryPath, "adminplus.conf");
        primaryConfigLoader = ((HoconConfigurationLoader.Builder)HoconConfigurationLoader.builder().setPath(configPath)).build();
    }
}

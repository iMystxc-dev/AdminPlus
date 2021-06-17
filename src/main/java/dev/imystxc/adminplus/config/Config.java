package dev.imystxc.adminplus.config;

import info.pixelmon.repack.ninja.leaping.configurate.commented.CommentedConfigurationNode;
import info.pixelmon.repack.ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import info.pixelmon.repack.ninja.leaping.configurate.loader.ConfigurationLoader;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.io.File;
import java.io.IOException;

public class Config {
    private static Config instance = new Config();
    private CommentedConfigurationNode config;
    String path;
    private File configFile;
    private ConfigurationLoader<CommentedConfigurationNode> configLoader;

    public Config() {
        this.path = "config" + File.separator + "AdminPlus";
        this.configFile = new File(this.path, "adminplus.conf");
        this.configLoader = ((HoconConfigurationLoader.Builder)HoconConfigurationLoader.builder().setFile(this.configFile)).build();
    }

    public static Config getInstance() {
        return instance;
    }

    public void configCreate() throws ObjectMappingException, IOException {
        try {
            if (!this.configFile.getParentFile().exists()) {
                this.configFile.getParentFile().mkdir();
            }

            this.configFile.createNewFile();
            this.configLoad();
            CommentedConfigurationNode config = this.config.getNode("adminplus");
            config.getNode("ban-options", "option-1-command").setComment("h = Hour, d = Day, w = Week, m = Month");
            config.getNode(new Object[]{"ban-options", "option-1-command"}).setValue("tempban %player% 1h");
            config.getNode(new Object[]{"ban-options", "option-1-title"}).setValue("&cTemp Ban &7- &61 Hour");
            config.getNode(new Object[]{"ban-options", "option-2-command"}).setValue("tempban %player% 5h");
            config.getNode(new Object[]{"ban-options", "option-2-title"}).setValue("&cTemp Ban &7- &65 Hours");
            config.getNode(new Object[]{"ban-options", "option-3-command"}).setValue("tempban %player% 1d");
            config.getNode(new Object[]{"ban-options", "option-3-title"}).setValue("&cTemp Ban &7- &61 Day");
            config.getNode(new Object[]{"ban-options", "option-4-command"}).setValue("tempban %player% 1w");
            config.getNode(new Object[]{"ban-options", "option-4-title"}).setValue("&cTemp Ban &7- &61 Week");
            config.getNode(new Object[]{"ban-options", "option-5-command"}).setValue("tempban %player% 1m");
            config.getNode(new Object[]{"ban-options", "option-5-title"}).setValue("&cTemp Ban &7- &61 Month");
            config.getNode(new Object[]{"ban-options", "option-6-command"}).setValue("tempban %player% 6m");
            config.getNode(new Object[]{"ban-options", "option-6-title"}).setValue("&cTemp Ban &7- &66 Months");
            config.getNode(new Object[]{"ban-options", "option-7-command"}).setValue("ban %player%");
            config.getNode(new Object[]{"ban-options", "option-7-title"}).setValue("&cPermanent Ban");
            config.getNode(new Object[]{"mute-options", "option-1-command"}).setValue("mute %player% 30m You have been muted");
            config.getNode(new Object[]{"mute-options", "option-1-title"}).setValue("&cMute &7- &630 Minutes");
            config.getNode(new Object[]{"mute-options", "option-2-command"}).setValue("mute %player% 1h You have been muted");
            config.getNode(new Object[]{"mute-options", "option-2-title"}).setValue("&cMute &7- &61 Hour");
            config.getNode(new Object[]{"mute-options", "option-3-command"}).setValue("mute %player% 12h You have been muted");
            config.getNode(new Object[]{"mute-options", "option-3-title"}).setValue("&cMute &7- &612 Hours");
            config.getNode(new Object[]{"mute-options", "option-4-command"}).setValue("mute %player% 1d You have been muted");
            config.getNode(new Object[]{"mute-options", "option-4-title"}).setValue("&cMute &7- &61 Day");
            config.getNode(new Object[]{"mute-options", "option-5-command"}).setValue("mute %player% 1w You have been muted");
            config.getNode(new Object[]{"mute-options", "option-5-title"}).setValue("&cMute &7- &61 Week");
            config.getNode(new Object[]{"mute-options", "option-6-command"}).setValue("mute %player% 30d You have been muted");
            config.getNode(new Object[]{"mute-options", "option-6-title"}).setValue("&cMute &7- &61 Month");
            config.getNode(new Object[]{"mute-options", "option-7-command"}).setValue("mute %player% You have been muted");
            config.getNode(new Object[]{"mute-options", "option-7-title"}).setValue("&cPermanent Mute");
            config.getNode(new Object[]{"jail-options", "option-1-command"}).setValue("jail %player% jail 10m");
            config.getNode(new Object[]{"jail-options", "option-1-title"}).setValue("&cJail &7- &610 Minutes");
            config.getNode(new Object[]{"jail-options", "option-2-command"}).setValue("jail %player% jail 20m");
            config.getNode(new Object[]{"jail-options", "option-2-title"}).setValue("&cJail &7- &620 Minutes");
            config.getNode(new Object[]{"jail-options", "option-3-command"}).setValue("jail %player% jail 30m");
            config.getNode(new Object[]{"jail-options", "option-3-title"}).setValue("&cJail &7- &630 Minutes");
            config.getNode(new Object[]{"jail-options", "option-4-command"}).setValue("jail %player% jail 1h");
            config.getNode(new Object[]{"jail-options", "option-4-title"}).setValue("&cJail &7- &61 Hour");
            config.getNode(new Object[]{"jail-options", "option-5-command"}).setValue("jail %player% jail 5h");
            config.getNode(new Object[]{"jail-options", "option-5-title"}).setValue("&cJail &7- &65 Hours");
            config.getNode(new Object[]{"jail-options", "option-6-command"}).setValue("jail %player% jail 12h");
            config.getNode(new Object[]{"jail-options", "option-6-title"}).setValue("&cJail &7- &612 Hours");
            config.getNode(new Object[]{"jail-options", "option-7-command"}).setValue("jail %player% jail 1d");
            config.getNode(new Object[]{"jail-options", "option-7-title"}).setValue("&cJail &7- &61 Day");
            config.getNode(new Object[]{"main", "ban-ip-command"}).setValue("ban-ip %player% ");
            config.getNode(new Object[]{"main", "ban-ip-title"}).setValue("&cBan-IP &6%player%");
            config.getNode(new Object[]{"main", "kick-command"}).setValue("kick %player% You have been kicked");
            config.getNode(new Object[]{"main", "kick-title"}).setValue("&cKick &6%player%");
            config.getNode(new Object[]{"main", "kill-command"}).setValue("kill %player% ");
            config.getNode(new Object[]{"main", "kill-title"}).setValue("&cKill &6%player%");
            config.getNode(new Object[]{"main", "tp-command"}).setValue("tp %player% ");
            config.getNode(new Object[]{"main", "tp-title"}).setValue("&cTeleport To &6%player%");
            config.getNode(new Object[]{"main", "tphere-command"}).setValue("tphere %player% ");
            config.getNode(new Object[]{"main", "tphere-title"}).setValue("&cTeleport &6%player% &cTo You");
            config.getNode(new Object[]{"main", "invsee-command"}).setValue("invsee %player% ");
            config.getNode(new Object[]{"main", "invsee-title"}).setValue("&cCheck &6%player% &cInventory");
            config.getNode(new Object[]{"main", "commandspy-command"}).setValue("commandspy");
            config.getNode(new Object[]{"main", "commandspy-title"}).setValue("&cToggle CommandSpy");
            config.getNode(new Object[]{"main", "socialspy-command"}).setValue("socialspy");
            config.getNode(new Object[]{"main", "socialspy-title"}).setValue("&cToggle SocialSpy");
            config.getNode(new Object[]{"main", "vanish-command"}).setValue("vanish");
            config.getNode(new Object[]{"main", "vanish-title"}).setValue("&cToggle Vanish");
            config.getNode(new Object[]{"jail-options", "title"}).setValue("&cJail Options For &6%player% ");
            config.getNode(new Object[]{"ban-options", "title"}).setValue("&cBan Options For &6%player% ");
            config.getNode(new Object[]{"mute-options", "title"}).setValue("&cMute Options For &6%player% ");
            config.getNode(new Object[]{"pardon-options", "title"}).setValue("&cPardon Options For &6%player% ");
            config.getNode(new Object[]{"pardon-options", "unmute-command"}).setValue("unmute %player% ");
            config.getNode(new Object[]{"pardon-options", "unmute-title"}).setValue("&cUnmute &6%player%");
            config.getNode(new Object[]{"pardon-options", "unban-command"}).setValue("unban %player% ");
            config.getNode(new Object[]{"pardon-options", "unban-title"}).setValue("&cUnban &6%player%");
            config.getNode(new Object[]{"pardon-options", "unbanip-command"}).setValue("pardon-ip %player% ");
            config.getNode(new Object[]{"pardon-options", "unbanip-title"}).setValue("&cUnban IP &6%player%");
            config.getNode(new Object[]{"pardon-options", "unjail-command"}).setValue("unjail %player% ");
            config.getNode(new Object[]{"pardon-options", "unjail-title"}).setValue("&cUnjail &6%player%");
            this.configSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setup(File configFile, ConfigurationLoader<CommentedConfigurationNode> configLoader) {
        this.configLoader = configLoader;
        this.configFile = configFile;
        if (!configFile.exists()) {
            try {
                this.configCreate();
            } catch (IOException | ObjectMappingException e) {
                e.printStackTrace();
            }
        } else {
            this.configLoad();
        }

    }

    public CommentedConfigurationNode getConfig() {
        return this.config;
    }

    public void configLoad() {
        if (!this.configFile.exists()) {
            try {
                this.configCreate();
            } catch (IOException | ObjectMappingException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.config = (CommentedConfigurationNode)this.configLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void configSave() {
        try {
            this.configLoader.save(this.config);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
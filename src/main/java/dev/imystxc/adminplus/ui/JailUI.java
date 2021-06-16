package dev.imystxc.adminplus.ui;

import ca.landonjw.gooeylibs2.api.UIManager;
import ca.landonjw.gooeylibs2.api.button.Button;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import ca.landonjw.gooeylibs2.api.page.GooeyPage;
import ca.landonjw.gooeylibs2.api.page.LinkedPage;
import ca.landonjw.gooeylibs2.api.template.types.ChestTemplate;
import dev.imystxc.adminplus.config.Config;
import dev.imystxc.adminplus.utils.Utils;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextFormatting;

public class JailUI {
    public static GooeyPage menu(ICommandSender sender, EntityPlayerMP player) {

        GooeyButton head = GooeyButton.builder()
                .display(Utils.getPlayerHead(player))
                .title(TextFormatting.GOLD + (player.getName()))
                .build();

        ChestTemplate main = ChestTemplate.builder(3)
                .row(0, Utils.colouredPane(EnumDyeColor.RED))
                .row(2, Utils.colouredPane(EnumDyeColor.WHITE))
                .row(1, Utils.colouredPane(EnumDyeColor.BLACK))
                .set(1,1, jailButton(sender, player))
                .set(1,2, jailButtonTwo(sender, player))
                .set(1,3, jailButtonThree(sender, player))
                .set(1,4, jailButtonFour(sender, player))
                .set(1,5, jailButtonFive(sender, player))
                .set(1,6, jailButtonSix(sender, player))
                .set(1,7, jailButtonSeven(sender, player))
                .set(0,4, head)
                .set(2, 0 , Utils.backButton(sender, player))
                .set(2, 8 , Utils.backButton(sender, player))
                .build();

        return LinkedPage.builder()
                .template(main)
                .title(Utils.regex("&c&lJail Options"))
                .build();
    }

    public static Button jailButton(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-1-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-1-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button jailButtonTwo(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-2-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-2-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button jailButtonThree(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-3-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-3-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button jailButtonFour(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-4-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-4-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button jailButtonFive(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-5-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-5-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button jailButtonSix(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-6-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-6-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button jailButtonSeven(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-7-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "option-7-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
}

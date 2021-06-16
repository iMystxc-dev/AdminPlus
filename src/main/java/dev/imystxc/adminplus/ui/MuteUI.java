package dev.imystxc.adminplus.ui;

import ca.landonjw.gooeylibs2.api.UIManager;
import ca.landonjw.gooeylibs2.api.button.Button;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import ca.landonjw.gooeylibs2.api.page.GooeyPage;
import ca.landonjw.gooeylibs2.api.page.LinkedPage;
import ca.landonjw.gooeylibs2.api.template.types.ChestTemplate;
import com.pixelmonmod.pixelmon.config.PixelmonItemsTools;
import com.pixelmonmod.pixelmon.items.heldItems.ItemLightClay;
import dev.imystxc.adminplus.config.Config;
import dev.imystxc.adminplus.utils.Utils;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class MuteUI {

    public static GooeyPage menu(ICommandSender sender, EntityPlayerMP player) {

        GooeyButton head = GooeyButton.builder()
                .display(Utils.getPlayerHead(player))
                .title(TextFormatting.GOLD + (player.getName()))
                .build();

        ChestTemplate main = ChestTemplate.builder(3)
                .row(0, Utils.colouredPane(EnumDyeColor.RED))
                .row(2, Utils.colouredPane(EnumDyeColor.WHITE))
                .row(1, Utils.colouredPane(EnumDyeColor.BLACK))
                .set(1,1, muteButton(sender, player))
                .set(1,2, muteButtonTwo(sender, player))
                .set(1,3, muteButtonThree(sender, player))
                .set(1,4, muteButtonFour(sender, player))
                .set(1,5, muteButtonFive(sender, player))
                .set(1,6, muteButtonSix(sender, player))
                .set(1,7, muteButtonSeven(sender, player))
                .set(0,4, head)
                .set(2, 0 , Utils.backButton(sender, player))
                .set(2, 8 , Utils.backButton(sender, player))
                .build();

        return LinkedPage.builder()
                .template(main)
                .title(Utils.regex("&c&lMute Options"))
                .build();
    }

    public static Button muteButton(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,7))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-1-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-1-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button muteButtonTwo(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,12))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-2-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-2-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button muteButtonThree(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,8))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-3-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-3-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button muteButtonFour(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,10))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-4-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-4-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button muteButtonFive(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,9))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-5-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-5-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button muteButtonSix(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,13))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-6-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-6-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button muteButtonSeven(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,5))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-7-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "option-7-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
}

package dev.imystxc.adminplus.ui;

import ca.landonjw.gooeylibs2.api.UIManager;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import ca.landonjw.gooeylibs2.api.page.GooeyPage;
import ca.landonjw.gooeylibs2.api.page.LinkedPage;
import ca.landonjw.gooeylibs2.api.page.Page;
import ca.landonjw.gooeylibs2.api.template.types.ChestTemplate;
import com.pixelmonmod.pixelmon.config.PixelmonItemsHeld;
import com.pixelmonmod.pixelmon.config.PixelmonItemsTools;
import dev.imystxc.adminplus.config.Config;
import dev.imystxc.adminplus.utils.Utils;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class AdminUI {

    public static GooeyPage menu(ICommandSender sender, EntityPlayerMP player) {

        GooeyButton head = GooeyButton.builder()
                .display(Utils.getPlayerHead(player))
                .title(TextFormatting.GOLD + (player.getName()))
                .build();

        GooeyButton banButton = GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.hammerDiamond)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    UIManager.openUIForcefully((EntityPlayerMP) sender, BanUI.menu(sender, player));
                })
                .build();

        GooeyButton muteButton = GooeyButton.builder()
                .display(new ItemStack(Items.NAME_TAG))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "mute-options", "title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    UIManager.openUIForcefully((EntityPlayerMP) sender, MuteUI.menu(sender, player));
                })
                .build();

        GooeyButton jailButton = GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "jail-options", "title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    UIManager.openUIForcefully((EntityPlayerMP) sender, JailUI.menu(sender, player));
                })
                .build();

        GooeyButton banipButton = GooeyButton.builder()
                .display(new ItemStack(Blocks.BEDROCK))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "ban-ip-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "ban-ip-command"}).getString().replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();

        GooeyButton kickButton = GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(Items.CHAINMAIL_BOOTS)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "kick-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "kick-command"}).getString().replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();

        GooeyButton killButton = GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(Items.DIAMOND_SWORD)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "kill-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "kill-command"}).getString().replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();

        GooeyButton teleportButton = GooeyButton.builder()
                .display(new ItemStack(Items.NETHER_STAR))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "tp-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "tp-command"}).getString().replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();

        GooeyButton teleportHereButton = GooeyButton.builder()
                .display(new ItemStack(Items.ELYTRA))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "tphere-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "tphere-command"}).getString().replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();

        GooeyButton seeInventory = GooeyButton.builder()
                .display(new ItemStack(PixelmonItemsHeld.wideLens))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "invsee-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "main", "invsee-command"}).getString().replaceAll("%player%", player.getName()));
                })
                .build();

        GooeyButton pardon = GooeyButton.builder()
                .display(new ItemStack(Items.END_CRYSTAL))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    UIManager.openUIForcefully((EntityPlayerMP) sender, PardonUI.menu(sender, player));
                })
                .build();

        ChestTemplate main = ChestTemplate.builder(5)
                .row(0, Utils.colouredPane(EnumDyeColor.RED))
                .row(4, Utils.colouredPane(EnumDyeColor.WHITE))
                .set(1,0, Utils.colouredPane(EnumDyeColor.RED))
                .set(1,8, Utils.colouredPane(EnumDyeColor.RED))
                .set(2,0, Utils.colouredPane(EnumDyeColor.BLACK))
                .set(2,8, Utils.colouredPane(EnumDyeColor.BLACK))
                .set(3,0, Utils.colouredPane(EnumDyeColor.WHITE))
                .set(3,8, Utils.colouredPane(EnumDyeColor.WHITE))
                .fill(Utils.colouredPane(EnumDyeColor.GRAY))
                .set(2,4, head)
                .set(1,1, banButton)
                .set(1,3, muteButton)
                .set(1,5, jailButton)
                .set(1,7, banipButton)
                .set(2,2, kickButton)
                .set(3,5, killButton)
                .set(2,6, teleportButton)
                .set(3, 1, teleportHereButton)
                .set(3, 3, seeInventory)
                .set(3,7, pardon)
                .build();

        return LinkedPage.builder()
                .template(main)
                .title(Utils.regex("        &c&lAdmin Commands"))
                .build();
    }
}

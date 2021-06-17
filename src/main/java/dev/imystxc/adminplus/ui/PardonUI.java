package dev.imystxc.adminplus.ui;

import ca.landonjw.gooeylibs2.api.UIManager;
import ca.landonjw.gooeylibs2.api.button.Button;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import ca.landonjw.gooeylibs2.api.page.GooeyPage;
import ca.landonjw.gooeylibs2.api.page.LinkedPage;
import ca.landonjw.gooeylibs2.api.template.types.ChestTemplate;
import com.mojang.authlib.GameProfile;
import com.pixelmonmod.pixelmon.config.PixelmonItemsTools;
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

public class PardonUI {

    public static GooeyPage menu(ICommandSender sender, GameProfile player) {

        GooeyButton head = GooeyButton.builder()
                .display(Utils.getPlayerHead(player))
                .title(TextFormatting.GOLD + (player.getName()))
                .build();

        ChestTemplate main = ChestTemplate.builder(3)
                .row(0, Utils.colouredPane(EnumDyeColor.RED))
                .row(2, Utils.colouredPane(EnumDyeColor.WHITE))
                .row(1, Utils.colouredPane(EnumDyeColor.BLACK))
                .set(0,4, head)
                .set(1,1, unbanButton(sender, player))
                .set(1,3, unbanipButton(sender, player))
                .set(1,5, unmuteButton(sender, player))
                .set(1,7, unjailButton(sender, player))
                .set(2, 0 , Utils.backButton(sender, player))
                .set(2, 8 , Utils.backButton(sender, player))
                .build();

        return LinkedPage.builder()
                .template(main)
                .title(Utils.regex("&c&lPardon Options"))
                .build();
    }

    public static Button unmuteButton(ICommandSender sender, GameProfile player) {
        return GooeyButton.builder()
                .display(new ItemStack(Items.DYE,1,9))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unmute-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unmute-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }

    public static Button unbanButton(ICommandSender sender, GameProfile player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.rubyHammerItem)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unban-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unban-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button unbanipButton(ICommandSender sender, GameProfile player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.BEDROCK))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unbanip-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unbanip-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button unjailButton(ICommandSender sender, GameProfile player) {
        return GooeyButton.builder()
                .display(new ItemStack(Blocks.IRON_BARS))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unjail-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    MinecraftServer server = sender.getServer();
                    sender.getServer().commandManager.executeCommand(server, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "pardon-options", "unjail-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
}

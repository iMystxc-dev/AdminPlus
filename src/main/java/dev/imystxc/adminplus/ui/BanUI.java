package dev.imystxc.adminplus.ui;

import ca.landonjw.gooeylibs2.api.UIManager;
import ca.landonjw.gooeylibs2.api.button.Button;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import ca.landonjw.gooeylibs2.api.page.GooeyPage;
import ca.landonjw.gooeylibs2.api.page.LinkedPage;
import ca.landonjw.gooeylibs2.api.template.types.ChestTemplate;
import com.pixelmonmod.pixelmon.config.PixelmonItemsTools;
import dev.imystxc.adminplus.config.Config;
import dev.imystxc.adminplus.utils.Utils;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class BanUI {

    public static GooeyPage menu(ICommandSender sender, EntityPlayerMP player) {

        GooeyButton head = GooeyButton.builder()
                .display(Utils.getPlayerHead(player))
                .title(TextFormatting.GOLD + (player.getName()))
                .build();

        ChestTemplate main = ChestTemplate.builder(3)
                .row(0, Utils.colouredPane(EnumDyeColor.RED))
                .row(2, Utils.colouredPane(EnumDyeColor.WHITE))
                .row(1, Utils.colouredPane(EnumDyeColor.BLACK))
                .set(1,1, banButton(sender, player))
                .set(1,2, banButtonTwo(sender, player))
                .set(1,3, banButtonThree(sender, player))
                .set(1,4, banButtonFour(sender, player))
                .set(1,5, banButtonFive(sender, player))
                .set(1,6, banButtonSix(sender, player))
                .set(1,7, banButtonSeven(sender, player))
                .set(0,4, head)
                .set(2, 0 , Utils.backButton(sender, player))
                .set(2, 8 , Utils.backButton(sender, player))
                .build();

        return LinkedPage.builder()
                .template(main)
                .title(Utils.regex("&c&lBan Options"))
                .build();
    }

    public static Button banButton(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.hammerWood)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-1-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-1-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button banButtonTwo(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.hammerStone)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-2-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-2-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button banButtonThree(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.hammerIron)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-3-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-3-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button banButtonFour(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.hammerGold)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-4-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-4-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button banButtonFive(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.hammerAluminium)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-5-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-5-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button banButtonSix(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.hammerDiamond)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-6-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-6-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
    public static Button banButtonSeven(ICommandSender sender, EntityPlayerMP player) {
        return GooeyButton.builder()
                .display(Utils.nbtRemove(new ItemStack(PixelmonItemsTools.rubyHammerItem)))
                .title(Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-7-title"}).getString().replaceAll("%player%", player.getName())))
                .onClick(buttonAction -> {
                    sender.getServer().commandManager.executeCommand(sender, Utils.regex(Config.getInstance().getConfig().getNode(new Object[]{"adminplus", "ban-options", "option-7-command"}).getString()).replaceAll("%player%", player.getName()));
                    UIManager.closeUI((EntityPlayerMP) sender);
                })
                .build();
    }
}

package dev.imystxc.adminplus.commands;

import ca.landonjw.gooeylibs2.api.UIManager;
import com.mojang.authlib.GameProfile;
import dev.imystxc.adminplus.config.Config;
import dev.imystxc.adminplus.ui.AdminUI;
import dev.imystxc.adminplus.utils.Utils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Command extends CommandBase {
    @Override
    public String getName() {
        return "adminplus";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/adminplus <player/reload>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0 && args.length < 3) {
            if (args[0].equals("reload")) {
                if (sender.canUseCommand(0, "adminplus.command.reload")) {
                    Config.getInstance().configLoad();
                    sender.sendMessage(new TextComponentString(Utils.regex("&7[&cAdminPlus&7] &aConfig has been reloaded.")));
                    return;
                } else {
                    sender.sendMessage(new TextComponentString(Utils.regex("&7[&cAdminPlus&7] &cYou don't have permission to reload the config.")));
                    return;
                }
            }
            GameProfile profile = server.getPlayerProfileCache().getGameProfileForUsername(args[0]);
            if (profile != null) {
                UIManager.openUIForcefully((EntityPlayerMP) sender, AdminUI.menu(sender, profile));
            }
        }else {
            sender.sendMessage(new TextComponentString(Utils.regex("&7[&eAdminPlus&7] &cInvalid usage please specify a player\n&c/adminplus <player>")));
        }
    }


    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> possibleArgs = new ArrayList<>();
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;

            if (player.canUseCommand(0, "adminplus.command.reload") && args.length == 1) {
                possibleArgs.add("reload");
            }

            if (player.canUseCommand(0, "adminplus.command.adminplus") && args.length == 1) {
                possibleArgs.addAll(Arrays.asList(server.getOnlinePlayerNames()));
            }
        }
        return getListOfStringsMatchingLastWord(args, possibleArgs);
    }
}

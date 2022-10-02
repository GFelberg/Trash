package me.GFelberg.Trash.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.GFelberg.Trash.utils.TrashUtils;

public class Trash implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("trash")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "This command can be only made by players!");
				return true;
			}

			if (!(sender.hasPermission("trash.trash"))) {
				sender.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
				return true;
			}

			Player p = (Player) sender;
			TrashUtils trash = new TrashUtils();

			if (args.length == 0) {
				trash.openTrash(p);
				return true;
			}

			if (args.length == 1) {

				if (args[0].equalsIgnoreCase("reload")) {
					trash.reloadConfig(p);
				} else if (args[0].equalsIgnoreCase("help")) {
					trash.helpPage(p);
				}
				return true;
			}
		}
		return true;
	}
}
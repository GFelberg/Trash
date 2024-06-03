package me.GFelberg.Trash.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.GFelberg.Trash.Main;

public class TrashUtils {

	public static String prefix, trash_title, trash_opened;
	public static int trash_size;

	public static void loadVariables() {
		prefix = Main.getInstance().getConfig().getString("Trash.Prefix").replace("&", "§");
		trash_title = Main.getInstance().getConfig().getString("Trash.Title").replace("&", "§");
		trash_opened = Main.getInstance().getConfig().getString("Trash.Opened").replace("&", "§");
		trash_size = Main.getInstance().getConfig().getInt("Trash.Size");
	}

	public void reloadConfig(Player p) {

		if (!(p.hasPermission("trash.reload"))) {
			p.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
		} else {
			Main.getInstance().reloadConfig();
			loadVariables();
			p.sendMessage(prefix + " " + ChatColor.GREEN + "Plugin reloaded successfully!");
			Bukkit.getConsoleSender().sendMessage("=======================================");
			Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Trash Plugin reloaded");
			Bukkit.getConsoleSender().sendMessage("=======================================");
		}
	}

	public void helpPage(Player p) {
		HelpPageUtils helpUtils = new HelpPageUtils();

		if (!(p.hasPermission("trash.admin"))) {
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
			p.sendMessage(ChatColor.AQUA + "Trash - Help Commands");
			p.sendMessage(ChatColor.YELLOW + "/trash help: " + helpUtils.getHelp_page());
			p.sendMessage(ChatColor.YELLOW + "/trash : " + helpUtils.getHelp_trash());
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
		} else {
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
			p.sendMessage(ChatColor.AQUA + "Trash - Help Commands");
			p.sendMessage(ChatColor.YELLOW + "/trash help: " + helpUtils.getHelp_page());
			p.sendMessage(ChatColor.YELLOW + "/trash : " + helpUtils.getHelp_trash());
			p.sendMessage(ChatColor.YELLOW + "/trash reload : " + helpUtils.getHelp_reload());
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
		}
	}

	public void openTrash(Player p) {
		Inventory inv = Bukkit.createInventory(null, trash_size, trash_title);
		p.openInventory(inv);
		p.sendMessage(trash_opened);
	}
}
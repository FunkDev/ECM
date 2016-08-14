package net.funkemunky.ECM.Commands;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.funkemunky.ECM.Core;
import net.md_5.bungee.api.ChatColor;

public class ECM implements CommandExecutor {
	
	private Core core;
	public ECM(Core core) {
		this.core = core;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("easychatmanager")) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("ecm.help")) {
					p.sendMessage("" +ChatColor.WHITE + ChatColor.STRIKETHROUGH + "------------------------------------------");
					p.sendMessage(ChatColor.RED + "EasyChatManager v" + core.getDescription().getVersion() +  "  by funkemunky.");
		            p.sendMessage(ChatColor.BLUE + "Plugin Page: " + ChatColor.WHITE + "http://www.spigotmc.org/resources/easychatmanager.27210/");
					p.sendMessage("");
					p.sendMessage(ChatColor.AQUA + "Commands:");
					p.sendMessage(ChatColor.RED + "/ecm [reload]");
					p.sendMessage(ChatColor.RED + "/clearchat [player]");
					p.sendMessage(ChatColor.RED + "/mutechat");
					p.sendMessage("" +ChatColor.WHITE + ChatColor.STRIKETHROUGH + "------------------------------------------");
				} else {
					p.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + core.getConfig().getString("Messages.NoPermission").replaceAll("&", "§"));
				}
			} else {
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("reload")) {
						if(p.hasPermission("ecm.reload")) {
							if(!core.file.exists()) {
								core.getLogger().log(Level.INFO, "Configuration file does not exist. Creating new config.yml!");
								p.sendMessage(ChatColor.RED + "ERROR " + ChatColor.GRAY + "Config does not exist! Creating config.yml...");
								core.getConfig().options().copyDefaults(true);
								core.saveDefaultConfig();
								p.sendMessage(ChatColor.GRAY + "Config.yml created!");
								Bukkit.getScheduler().scheduleSyncDelayedTask(core, new Runnable() {
									public void run() {
										core.reloadConfig();
										p.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + ChatColor.GRAY + " Configuration Reloaded!");
										
									}
								}, 4L);
							} else {
								core.reloadConfig();
								p.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + ChatColor.GRAY + " Configuration Reloaded!");
							}
						} else {
							return false;
						}
					}
					if(args[0].equalsIgnoreCase("test")) {
						if(p.getName().equalsIgnoreCase("funkemunky")) {
							for(String keys : core.getConfigKeys()) {
								p.sendMessage(keys);
								p.sendMessage(ChatColor.RED + core.permission.getPlayerGroups(p));
							}
						} else {
							p.sendMessage(ChatColor.RED + "This part of the plugin is used for testing purposes only. Just ignore it.");
						}
					}
				}
			}
		}
		return false;
	}

}

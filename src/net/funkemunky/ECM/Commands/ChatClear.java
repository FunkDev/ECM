package net.funkemunky.ECM.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.funkemunky.ECM.Core;

public class ChatClear implements CommandExecutor {
	
	private Core core;
	public ChatClear(Core core) {
		this.core = core;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("clearchat")) {
			Player p = (Player) sender;
			if(p.hasPermission("ecm.clearchat")) {
				if(args.length == 0) {
					if(!p.hasPermission("ecm.clearchat.bypass")) {
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					}
					Bukkit.broadcastMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + core.getConfig().getString("Messages.GlobalChatClear").replace("%CLEARER%", p.getName()).replaceAll("&", "§"));
				} else {
					if(args.length == 1) {
						if(p.hasPermission("ecm.clearchat.others")) {
							Player player = Bukkit.getPlayerExact(args[0]);
							Player target = Bukkit.getPlayer(args[0]);
							if(player == null) {
								p.sendMessage(ChatColor.RED + "The player '" + args[0] + "' isn't online!");
							} else {
								if(!target.hasPermission("ecm.clearchat.bypass")) {
									p.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + ChatColor.GREEN + "You cleared " + target.getName() + "'s chat!");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage("");
									target.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + core.getConfig().getString("Messages.PlayerChatClear").replace("%CLEARER%", p.getName()).replaceAll("&", "§"));
								} else {
									p.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + ChatColor.RED + "You can't clear that person's chat!");
								}
							}
						} else {
							p.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + core.getConfig().getString("Messages.NoPermission").replaceAll("&", "§"));
						}
					}
				}
			} else {
				p.sendMessage(core.getConfig().getString("Messages.Prefix").replaceAll("&", "§") + core.getConfig().getString("Messages.NoPermission").replaceAll("&", "§"));
			}
		}
		return false;
	}

}

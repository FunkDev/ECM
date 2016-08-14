package net.funkemunky.ECM;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.funkemunky.ECM.Commands.ChatClear;
import net.funkemunky.ECM.Commands.ECM;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

public class Core extends JavaPlugin implements Listener {
	
	public static Chat chat;
	public static Permission permission = null;
	
	public File file = new File(getDataFolder() + File.separator + "config.yml");
	
	 private boolean setupPermissions()
	    {
	        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	        if (permissionProvider != null) {
	            permission = permissionProvider.getProvider();
	        }
	        return (permission != null);
	    }
	
	public Set<String> getConfigKeys()
	{
		if (getConfig().isConfigurationSection("GroupFormats."))
		{
			return getConfig().getConfigurationSection("GroupFormats.").getKeys(false);
		}
		return new HashSet<String>();
	}
    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
	
	@EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		for(String group : getConfigKeys()) {
			if(!permission.playerInGroup(p, group)) {
				String format = getConfig().getString("ChatFormat").replaceAll("&", "§").replaceAll("%prefix%", chat.getPlayerPrefix(p).replaceAll("&", "§")).replaceAll("%suffix%", chat.getPlayerSuffix(p).replaceAll("&", "§")).replaceAll("%message%", e.getMessage()).replaceAll("%displayname%", p.getDisplayName());
				e.setFormat(format);
			} else {
				String format = getConfig().getString("GroupFormats." + permission.getPrimaryGroup(p)).replaceAll("&", "§").replaceAll("%prefix%", chat.getGroupPrefix(p.getWorld(), group).replaceAll("&", "§")).replaceAll("%suffix%", chat.getGroupSuffix(p.getWorld(), group).replaceAll("&", "§")).replaceAll("%message%", e.getMessage()).replaceAll("%displayname%", p.getDisplayName());
				e.setFormat(format);
			}
		}
				String format = getConfig().getString("ChatFormat").replaceAll("&", "§").replaceAll("%prefix%", chat.getPlayerPrefix(p).replaceAll("&", "§")).replaceAll("%suffix%", chat.getPlayerSuffix(p).replaceAll("&", "§")).replaceAll("%message%", e.getMessage()).replaceAll("%displayname%", p.getDisplayName());
				e.setFormat(format);
		if(!p.hasPermission("ecm.mutechat.bypass")) {
			e.setCancelled(mutechat.get("MC").booleanValue());
			p.sendMessage(getConfig().getString("Messages.Prefix").replaceAll("&", "§") + getConfig().getString("Messages.ChatIsMuted").replaceAll("&", "§"));
		}
    }
	public void onEnable() {
		setupChat();
		setupPermissions();
		getLogger().log(Level.INFO, "EastChatManager v" + getDescription().getVersion() + " has successfully been enabled with no errors!");
		
		if(!file.exists()) {
			getLogger().log(Level.INFO, "Configuration file does not exist. Creating new config.yml!");
			
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		getCommand("easychatmanager").setExecutor(new ECM(this));
		getCommand("clearchat").setExecutor(new ChatClear(this));
	}
	public final HashMap<String, Boolean> mutechat = new HashMap<String, Boolean>();

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("mutechat")) {
			Player p = (Player) sender;
			if(p.hasPermission("ecm.mutechat")) {
				if(mutechat.get("MC") == null) {
					mutechat.put("MC", true);
					Bukkit.getServer().broadcastMessage(getConfig().getString("Messages.Prefix").replaceAll("&", "§") + getConfig().getString("Messages.MuteChat").replaceAll("%MUTER%", p.getName()).replaceAll("&", "§"));
				} else {
					if(mutechat.get("MC") == false) {
						mutechat.put("MC", true);
						Bukkit.getServer().broadcastMessage(getConfig().getString("Messages.Prefix").replaceAll("&", "§") + getConfig().getString("Messages.MuteChat").replaceAll("%MUTER%", p.getName()).replaceAll("&", "§"));
					} else {
						if(mutechat.get("MC") == true) {
							mutechat.put("MC", false);
							Bukkit.getServer().broadcastMessage(getConfig().getString("Messages.Prefix").replaceAll("&", "§") + getConfig().getString("Messages.UnmuteChat").replaceAll("%MUTER%", p.getName()).replaceAll("&", "§"));
						}
					}
				}
			} else {
				p.sendMessage(getConfig().getString("Messages.Prefix").replaceAll("&", "§") + getConfig().getString("Messages.NoPermission").replaceAll("&", "§"));
			}
		}
		return false;
	}


}

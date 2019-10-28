package me.zwoosks.healer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class healMe extends JavaPlugin {

	@Override
	public void onEnable() {
		
	}
	
	
	@Override
	public void onDisable() {
		
	}
	
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("healplayer") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			int lenght = args.length;
			
			if(lenght == 1) {
				
				boolean playerFound = false;
				
				for(Player playerToHeal : Bukkit.getServer().getOnlinePlayers()) {
					
					if(playerToHeal.getName().equalsIgnoreCase(args[0])) {
						
						playerToHeal.setHealth(20.0);
						playerToHeal.sendMessage(ChatColor.GREEN + "You've been healed by " + player.getName() + "!");
						player.sendMessage(ChatColor.GREEN + playerToHeal.getName() + "was healed succesfully!");
						
						playerFound = true;
						break;
						
					}
				}
				
				if(playerFound == false) {
					player.sendMessage(ChatColor.RED + "The player is not online or the username doesn't exist");
				}
				
			} else {
				player.sendMessage(ChatColor.RED + "Incorrect arguments!");
			}
			
			return true;
		}
		
		
		return false;
		
		
		
		
		
		
		
	}
	
	
	
	
	
}

package com.SinfulPixel.RPGOverhaul.Commands;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import com.SinfulPixel.RPGOverhaul.Restrictions.SoulBoundItems;
import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 3/26/2015.
 */
public class SoulBoundCommand implements CommandExecutor {
    RPGOverhaul plugin;
    public SoulBoundCommand(RPGOverhaul plugin){this.plugin=plugin;}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("soulbound")) {
            if (sender instanceof Player) {
                Player p = (Player)sender;
                if (args.length == 0) {
                    if(ConfigMgr.getSoulbounds(p)==3){
                        SoulBoundItems.createGUI(p);
                    }else {
                        ItemStack i = SoulBoundItems.makeItemSoulbound(p.getItemInHand());
                        p.getInventory().remove(p.getItemInHand());
                        p.getInventory().addItem(i);
                    }
                } else if(args.length==1) {
                    if (args[0].equalsIgnoreCase("info")) {
                        p.sendMessage(ChatColor.GOLD + "======[ SoulBound Items Info ]======");
                        p.sendMessage(ChatColor.DARK_AQUA + "To soulbound an item hold it on your hand and type" + ChatColor.YELLOW + " /soulbound");
                        p.sendMessage(ChatColor.DARK_AQUA+"SoulBound Items cannot be dropped, traded, stored or sold. To Remove a Soulboun Item type "+ ChatColor.YELLOW+"/soulbound destroy");
                        p.sendMessage(ChatColor.DARK_AQUA + "You currently have " + ChatColor.YELLOW + ConfigMgr.getSoulbounds(p) + ChatColor.DARK_AQUA + " items.");
                    }else if(args[0].equalsIgnoreCase("destroy")){
                        p.sendMessage(ChatColor.GOLD+"======[ Soulbound Items Destroy ]======");
                        p.sendMessage(ChatColor.DARK_AQUA+"Do you wish to destroy: "+ChatColor.YELLOW+p.getItemInHand().getItemMeta().getDisplayName()+ChatColor.DARK_AQUA+"?");
                        p.sendMessage(ChatColor.GREEN+"Type continue - to destroy.");
                        p.sendMessage(ChatColor.DARK_AQUA+"or");
                        p.sendMessage(ChatColor.RED+"Type cancel - to cancel.");
                    }
                }
            }
        }
        return false;
    }
}

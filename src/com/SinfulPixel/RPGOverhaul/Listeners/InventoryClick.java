package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 3/26/2015.
 */
public class InventoryClick implements Listener {
    RPGOverhaul plugin;
    public InventoryClick(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onClick(InventoryClickEvent e){
        try {
            if (e.getCurrentItem().hasItemMeta()) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.MAGIC + "")&& !e.getWhoClicked().isOp()) {
                    e.setCancelled(true);
                }
            }
        }catch(Exception ignored){}
        if(e.getInventory().getName().equals(ChatColor.BLACK + "Which Item to Remove.")){
            Player p = (Player)e.getWhoClicked();
            ItemStack it = e.getCurrentItem();
           // SoulBoundItems.destroyClickedSoulboundItem(p,it);
            p.sendMessage(ChatColor.GOLD + "======[ Soulbound Items Destroy ]======");
            p.sendMessage(ChatColor.DARK_AQUA + "Do you wish to destroy: " + ChatColor.YELLOW + e.getCurrentItem().getType().name().replace("_", " ") + ChatColor.DARK_AQUA + "?");
            p.sendMessage(ChatColor.GREEN+"Type continue - to destroy.");
            p.sendMessage(ChatColor.DARK_AQUA + "or");
            p.sendMessage(ChatColor.RED + "Type cancel - to cancel.");
            SoulBoundChatEvent.canInterrupt.put(p, "SOULBOUND-C");
            if(!SoulBoundChatEvent.remItem.containsKey(p)) {
                SoulBoundChatEvent.remItem.put(p, it);
            }else{
                SoulBoundChatEvent.remItem.remove(p);
                SoulBoundChatEvent.remItem.put(p, it);
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
}

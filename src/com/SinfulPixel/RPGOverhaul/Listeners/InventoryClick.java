package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

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
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.MAGIC + "")) {
                    e.setCancelled(true);
                }
            }
        }catch(Exception ignored){}
    }
}

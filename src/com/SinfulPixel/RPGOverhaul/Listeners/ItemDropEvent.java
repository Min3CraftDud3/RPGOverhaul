package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Created by Min3 on 3/30/2015.
 */
public class ItemDropEvent implements Listener {
    RPGOverhaul plugin;
    public ItemDropEvent(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        if(!e.getPlayer().isOp()){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED+"You cannot drop items.");
        }
    }
}

package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Created by Min3 on 3/26/2015.
 */
public class BlockPlace implements Listener {
    RPGOverhaul plugin;
    public BlockPlace(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        if(e.getPlayer().getItemInHand().hasItemMeta()){
            if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.MAGIC + "")&& !e.getPlayer().isOp()) {
                e.setCancelled(true);
            }
        }
    }
}

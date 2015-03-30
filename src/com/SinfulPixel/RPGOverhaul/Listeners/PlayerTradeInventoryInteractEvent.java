package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.PlayerActions.PlayerTrade;
import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 3/30/2015.
 */
public class PlayerTradeInventoryInteractEvent implements Listener {
    RPGOverhaul plugin;
    public PlayerTradeInventoryInteractEvent(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        ItemStack gd = new ItemStack(Material.INK_SACK,1,(byte)10);
        Player p = (Player)e.getWhoClicked();
        if(PlayerTrade.inTrade.containsKey(p)||PlayerTrade.inTrade.containsValue(p)) {
            PlayerTrade.updateTrade(p);
            if(e.getInventory().getItem(19).equals(gd) && e.getInventory().getItem(26).equals(gd)){
                PlayerTrade.completeTrade(p);
            }
        }
    }
    @EventHandler
    public void onInvClose(InventoryCloseEvent e){
        Player p = (Player)e.getPlayer();
        if(PlayerTrade.inTrade.containsKey(p)||PlayerTrade.inTrade.containsValue(p)) {
            PlayerTrade.cancelTrade(p);
        }
    }
}

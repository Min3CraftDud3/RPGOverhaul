package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import com.SinfulPixel.RPGOverhaul.Restrictions.InventoryRestrict;
import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import com.SinfulPixel.RPGOverhaul.Utils.FirstLoginCheck;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Min3 on 3/26/2015.
 */
public class PlayerLogin implements Listener {
    RPGOverhaul plugin;
    public PlayerLogin(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        final Player p = e.getPlayer();
        if(!FirstLoginCheck.isFirstLogin(p)){
            ConfigMgr.createPlayerDataFile(p);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    InventoryRestrict.restrictInventory(p,InventoryRestrict.getRestriction(p));
                }
            },20);
        }else{
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    InventoryRestrict.restrictInventory(p, InventoryRestrict.getRestriction(p));
                }
            }, 20);
        }
    }
}

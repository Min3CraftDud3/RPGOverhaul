package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import com.SinfulPixel.RPGOverhaul.Restrictions.InventoryRestrict;
import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import com.SinfulPixel.RPGOverhaul.Utils.FirstLoginCheck;
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
        Player p = e.getPlayer();
        if(!FirstLoginCheck.isFirstLogin(p)){
            ConfigMgr.createPlayerDataFile(p);
            InventoryRestrict.restrictInventory(p,InventoryRestrict.getRestriction(p));
        }else{
            InventoryRestrict.restrictInventory(p, InventoryRestrict.getRestriction(p));
        }
    }
}

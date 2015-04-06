package com.SinfulPixel.RPGOverhaul.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R2.CraftServer;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by Min3 on 3/30/2015.
 */
public class AutoRespawnEvent {
    public static void respawnPlayer(Player p){
        if(p.isDead()){
            ((CraftServer)Bukkit.getServer()).getHandle().moveToWorld(((CraftPlayer)p).getHandle(),0,false);
        }
    }
}

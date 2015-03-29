package com.SinfulPixel.RPGOverhaul.Enchantments;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Random;

/**
 * Created by Min3 on 3/29/2015.
 */
public class BleedEffect {
    RPGOverhaul plugin;
    int duration;
    Random r = new Random();
    public BleedEffect(int duration,RPGOverhaul plugin){this.duration=duration;this.plugin=plugin;}
    public void applyEffect(final Player p){
        int i = r.nextInt(100);
        if(i>=20 && i<=30){
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin,new Runnable(){
                public void run(){
                    p.setHealth(p.getHealth()-1);
                }
            },10*duration);
        }
    }
}

package com.SinfulPixel.RPGOverhaul.Restrictions;

import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import org.bukkit.entity.Player;

/**
 * Created by Min3 on 3/26/2015.
 */
public class InventoryRestrict {
    public static void defaultRestrict(Player p){}
    public static void upgradeInventory(Player p){}
    public static void unlockInventory(Player p){}
    public static void lockInventory(Player p){}
    public static void destroyInventory(Player p){}
    public static RestrictTypes getRestriction(Player p){
        return ConfigMgr.getRestriction(p);
    }
    public static void setRestriction(Player p){}


}

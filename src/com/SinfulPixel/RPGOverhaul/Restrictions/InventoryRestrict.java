package com.SinfulPixel.RPGOverhaul.Restrictions;

import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 3/26/2015.
 */
public class InventoryRestrict {
    public static void restrictInventory(Player p, RestrictTypes type){
        ItemStack b = new ItemStack(Material.BARRIER,1);
        p.getInventory().addItem(b);
    }
    public static void upgradeInventory(Player p, RestrictTypes type){}
    public static RestrictTypes getRestriction(Player p){
        return ConfigMgr.getRestriction(p);
    }
    public static void setRestriction(Player p){}


}

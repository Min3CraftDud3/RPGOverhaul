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
        switch(type){
            case DEAFULT:
                p.getInventory().setItem(2,b);
                p.getInventory().setItem(3,b);
                p.getInventory().setItem(4,b);
                p.getInventory().setItem(5,b);
                p.getInventory().setItem(6,b);
                p.getInventory().setItem(7,b);
                p.getInventory().setItem(8,b);
                p.getInventory().setItem(12,b);
                p.getInventory().setItem(13,b);
                p.getInventory().setItem(14,b);
                p.getInventory().setItem(15,b);
                p.getInventory().setItem(16,b);
                p.getInventory().setItem(17,b);
                p.getInventory().setItem(21,b);
                p.getInventory().setItem(22,b);
                p.getInventory().setItem(23,b);
                p.getInventory().setItem(24,b);
                p.getInventory().setItem(25,b);
                p.getInventory().setItem(26,b);
                p.getInventory().setItem(30,b);
                p.getInventory().setItem(31,b);
                p.getInventory().setItem(32,b);
                p.getInventory().setItem(33,b);
                p.getInventory().setItem(34,b);
                p.getInventory().setItem(35,b);
                p.updateInventory();
                break;
            case UPGRADE_1:
                p.getInventory().setItem(3,b);
                p.getInventory().setItem(4,b);
                p.getInventory().setItem(5,b);
                p.getInventory().setItem(6,b);
                p.getInventory().setItem(7,b);
                p.getInventory().setItem(8,b);
                p.getInventory().setItem(13,b);
                p.getInventory().setItem(14,b);
                p.getInventory().setItem(15,b);
                p.getInventory().setItem(16,b);
                p.getInventory().setItem(17,b);
                p.getInventory().setItem(22,b);
                p.getInventory().setItem(23,b);
                p.getInventory().setItem(24,b);
                p.getInventory().setItem(25,b);
                p.getInventory().setItem(26,b);
                p.getInventory().setItem(31,b);
                p.getInventory().setItem(32,b);
                p.getInventory().setItem(33,b);
                p.getInventory().setItem(34,b);
                p.getInventory().setItem(35,b);
                p.updateInventory();
                break;
            case UPGRADE_2:
                p.getInventory().setItem(4,b);
                p.getInventory().setItem(5,b);
                p.getInventory().setItem(6,b);
                p.getInventory().setItem(7,b);
                p.getInventory().setItem(8,b);
                p.getInventory().setItem(14,b);
                p.getInventory().setItem(15,b);
                p.getInventory().setItem(16,b);
                p.getInventory().setItem(17,b);
                p.getInventory().setItem(23,b);
                p.getInventory().setItem(24,b);
                p.getInventory().setItem(25,b);
                p.getInventory().setItem(26,b);
                p.getInventory().setItem(32,b);
                p.getInventory().setItem(33,b);
                p.getInventory().setItem(34,b);
                p.getInventory().setItem(35,b);
                p.updateInventory();
                break;
            case UPGRADE_3:
                p.getInventory().setItem(5,b);
                p.getInventory().setItem(6,b);
                p.getInventory().setItem(7,b);
                p.getInventory().setItem(8,b);
                p.getInventory().setItem(15,b);
                p.getInventory().setItem(16,b);
                p.getInventory().setItem(17,b);
                p.getInventory().setItem(24,b);
                p.getInventory().setItem(25,b);
                p.getInventory().setItem(26,b);
                p.getInventory().setItem(33,b);
                p.getInventory().setItem(34,b);
                p.getInventory().setItem(35,b);
                p.updateInventory();
                break;
            case UPGRADE_4:
                p.getInventory().setItem(5,b);
                p.getInventory().setItem(6,b);
                p.getInventory().setItem(7,b);
                p.getInventory().setItem(8,b);
                p.getInventory().setItem(16,b);
                p.getInventory().setItem(17,b);
                p.getInventory().setItem(25,b);
                p.getInventory().setItem(26,b);
                p.getInventory().setItem(34,b);
                p.getInventory().setItem(35,b);
                p.updateInventory();
                break;
            case UPGRADE_5:
                p.getInventory().setItem(5,b);
                p.getInventory().setItem(6,b);
                p.getInventory().setItem(7,b);
                p.getInventory().setItem(8,b);
                p.getInventory().setItem(17,b);
                p.getInventory().setItem(26,b);
                p.getInventory().setItem(35,b);
                p.updateInventory();
                break;
            case UPGRADE_FINAL:
                p.getInventory().setItem(5,b);
                p.getInventory().setItem(6,b);
                p.getInventory().setItem(7,b);
                p.getInventory().setItem(8,b);
                p.updateInventory();
                break;
        }
    }
    public static void upgradeInventory(Player p, RestrictTypes type){}
    public static RestrictTypes getRestriction(Player p){
        return ConfigMgr.getRestriction(p);
    }
    public static void setRestriction(Player p){}


}

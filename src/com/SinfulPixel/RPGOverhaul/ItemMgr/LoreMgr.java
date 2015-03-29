package com.SinfulPixel.RPGOverhaul.ItemMgr;

import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 3/29/2015.
 */
public class LoreMgr {


    public static Boolean hasAttribute(ItemStack i){
        if(i.hasItemMeta()){
            for(int j=0;j<i.getItemMeta().getLore().size();j++){
                if(i.getItemMeta().getLore().get(j).contains("Attribute")){
                    return true;
                }
            }
        }
        return false;
    }

    public static String getAttribute(ItemStack i){
        String att = "DEFAULT";
        if(hasAttribute(i)){
            for(int j=0;j<i.getItemMeta().getLore().size();j++){
                if(i.getItemMeta().getLore().get(j).contains("Attribute")){
                    String[] sp = i.getItemMeta().getLore().get(j).split(":");
                    att = sp[1].replace(" ","").trim();
                }
            }
        }
        return att;
    }
}

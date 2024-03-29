package com.SinfulPixel.RPGOverhaul.Restrictions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min3 on 3/26/2015.
 */
public class SoulBoundItems{
    public static Inventory soulboundGUI = Bukkit.createInventory(null, 9, ChatColor.BLACK + "Which Item to Remove.");
    public static ItemStack makeItemSoulbound(ItemStack i){
        ItemStack it = i;
        List<String> lore = new ArrayList<String>();
        if(it.getItemMeta().hasLore()) {
            for (String s : it.getItemMeta().getLore()) {
                lore.add(s);
            }
        }
        lore.add(ChatColor.DARK_GRAY+"SoulBound");
        ItemMeta im = it.getItemMeta();
        if(it.getItemMeta().hasLore()) {
            im.getLore().clear();
        }
        im.setLore(lore);
        it.setItemMeta(im);
        return it;

    }
    public static void destroySoulboundItem(Player p){
        p.getInventory().removeItem(p.getItemInHand());
    }
    public static void destroyClickedSoulboundItem(Player p, ItemStack it){
        p.getInventory().removeItem(it);
    }
    public ItemStack removeItemSoulbound(Player p, ItemStack i){
        ItemStack it = i;
        List<String> lore = new ArrayList<String>();
        for(String s: it.getItemMeta().getLore()){
            lore.add(s);
        }
        if(lore.contains(ChatColor.DARK_GRAY+"SoulBound")){
            lore.remove(ChatColor.DARK_GRAY+"SoulBound");
        }
        ItemMeta im = it.getItemMeta();
        im.getLore().clear();
        im.setLore(lore);
        it.setItemMeta(im);
        return it;
    }
    public static ItemStack[] getSoulboundItems(Player p){
        ArrayList<ItemStack> stack = new ArrayList<ItemStack>();
        for(ItemStack i : p.getInventory().getContents()){
            if(i != null) {
                if (i.hasItemMeta()) {
                    if (i.getItemMeta().hasLore()) {
                        if (i.getItemMeta().getLore().contains(ChatColor.DARK_GRAY+"SoulBound")) {
                            stack.add(i);
                        }
                    }
                }
            }
        }
        return stack.toArray(new ItemStack[stack.size()]);
    }
    public static void createGUI(Player p){
        ItemStack[] set = getSoulboundItems(p);
        int size = set.length;
        int index = 3;
        if(size>0){
            for(int i=0;i<size;i++){
                soulboundGUI.setItem(index,set[i]);
                index++;
            }
        }
        p.openInventory(soulboundGUI);
    }
}

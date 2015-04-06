package com.SinfulPixel.RPGOverhaul.ItemMgr;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min3 on 3/30/2015.
 */
public class ItemBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private List<String> lore;

    public ItemBuilder(Material material){
        this(new ItemStack(material));
    }
    public ItemBuilder(ItemStack itemStack){
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
        this.lore = (itemMeta.getLore()== null ? itemMeta.getLore() : new ArrayList<String>());
    }
    public ItemBuilder setAmount(int amount){
        itemStack.setAmount(amount);
        return this;
    }
    public ItemBuilder setName(String name){
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        return this;
    }
    public ItemBuilder addLore(String line){
        System.out.println(line);
        lore.add(ChatColor.translateAlternateColorCodes('&', line));
        return this;
    }
    public ItemBuilder addAttribute(String attribute){  //Use this after all the other lore.
        lore.add(ChatColor.translateAlternateColorCodes('&',"Attribute: "+attribute));
        return this;
    }
    public ItemBuilder setDurability(short durability){
        itemStack.setDurability(durability);
        return this;
    }
    public ItemBuilder setData(int data){
        itemStack.setData(new MaterialData(itemStack.getType(), (byte) data));
        return this;
    }
    public ItemBuilder addEnchant(Enchantment enchantment,int level){
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }
    public ItemBuilder setMaterial(Material material){
        itemStack.setType(material);
        return this;
    }
    public ItemBuilder clearLore(){
        lore.clear();
        return this;
    }
    public ItemBuilder clearEnchantments(){
        itemStack.getEnchantments().clear();
        return this;
    }
    public ItemStack get(){
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}

package com.SinfulPixel.RPGOverhaul.Enchantments;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 3/26/2015.
 */
public class Enchantment_Barbed extends Enchantment {
    public Enchantment_Barbed(int id){
        super(id);
    }
    @Override
    public int getId(){
        return 69;
    }
    @Override
    public String getName() {
        return "Barbed";
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return true;
    }
}

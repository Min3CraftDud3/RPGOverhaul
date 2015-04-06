package com.SinfulPixel.RPGOverhaul.Commands;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Created by Min3 on 3/26/2015.
 */
public class ReloadCommand implements CommandExecutor{
    RPGOverhaul plugin;
    public ReloadCommand(RPGOverhaul plugin){this.plugin=plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("rpgreload")){
            //Reload.doReload();
            Player p = Bukkit.getPlayer("DarthVap3r");
            //InventoryRestrict.restrictInventory(p, RestrictTypes.DEAFULT);
            ItemStack i = new ItemStack(Material.DIAMOND_SWORD,1);
            ItemMeta im = i.getItemMeta();
            im.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&1Diamond &2Sword &3of &4Justice"));
            im.setLore(Arrays.asList("Boom", "Explosion"));
            i.setItemMeta(im);
            i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 20);
            i.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD,7);
            p.getInventory().addItem(i);
            p.updateInventory();
        }
        return false;
    }
}

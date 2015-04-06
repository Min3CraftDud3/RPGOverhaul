package com.SinfulPixel.RPGOverhaul.LootTable;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Min3 on 4/5/2015.
 */
public class LootMgr {
    static RPGOverhaul plugin;
    public LootMgr(RPGOverhaul plugin){this.plugin=plugin;}
    public static void createLootFile()throws IOException{

        File dir = new File(plugin.getDataFolder()+File.separator+"LootTable");
        if(!dir.exists()){
            System.out.println("Creating Loot Table Directory.");
            dir.mkdir();
            System.out.println("Creating Loot Table Directory...DONE!");
        }
        File loot = new File(plugin.getDataFolder()+File.separator+"LootTable"+File.separator+"LootTable.yml");
        if(!loot.exists()){
            System.out.println("Creating Loot Table File.");
            loot.createNewFile();
            FileConfiguration fc = YamlConfiguration.loadConfiguration(loot);
            fc.set("RPGOverhaul.LootTable.Header","==========[ Mob Loot Tables ]==========");
            for(EntityType e : EntityType.values()) {
                fc.set("RPGOverhaul.LootTable."+e.name()+".1", new ItemStack(Material.STICK,1));
                fc.set("RPGOverhaul.LootTable."+e.name()+".2", new ItemStack(Material.DIRT,1));
            }
            fc.save(loot);
            System.out.println("Creating Loot Table File...DONE!");
        }
    }
    public static ItemStack[] getLootTable(EntityType e){
        ArrayList<ItemStack> rt = new ArrayList<ItemStack>();
        File loot = new File(plugin.getDataFolder()+File.separator+"LootTable"+File.separator+"LootTable.yml");
        if(loot.exists()) {
            FileConfiguration fc = YamlConfiguration.loadConfiguration(loot);
            int ent = fc.getConfigurationSection("RPGOverhaul.LootTable."+e.name()).getKeys(false).size();
            for(int i=1;i<ent;i++){
                rt.add(fc.getItemStack("RPGOverhaul.LootTable."+e.name()+"."+i));
            }
        }
        return rt.toArray(new ItemStack[rt.size()]);
    }
}

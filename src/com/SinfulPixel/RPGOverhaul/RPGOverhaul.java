package com.SinfulPixel.RPGOverhaul;

import com.SinfulPixel.RPGOverhaul.Commands.ItemSaveCommand;
import com.SinfulPixel.RPGOverhaul.Commands.ReloadCommand;
import com.SinfulPixel.RPGOverhaul.Commands.SoulBoundCommand;
import com.SinfulPixel.RPGOverhaul.Errors.ThrowError;
import com.SinfulPixel.RPGOverhaul.Listeners.*;
import com.SinfulPixel.RPGOverhaul.LootTable.LootMgr;
import com.SinfulPixel.RPGOverhaul.Restrictions.InventoryRestrict;
import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Min3 on 3/26/2015.
 */
public class RPGOverhaul extends JavaPlugin {
    //Register Classes
    ConfigMgr configMgr = new ConfigMgr(this);
    InventoryRestrict iRest = new InventoryRestrict(this);
    LootMgr loot = new LootMgr(this);
    public void onEnable(){
        //Register Events
        getServer().getPluginManager().registerEvents(new PlayerLogin(this),this);
        getServer().getPluginManager().registerEvents(new InventoryClick(this),this);
        getServer().getPluginManager().registerEvents(new BlockPlace(this),this);
        getServer().getPluginManager().registerEvents(new SoulBoundChatEvent(this),this);
        getServer().getPluginManager().registerEvents(new ItemDropEvent(this),this);
        getServer().getPluginManager().registerEvents(new PlayerTradeInventoryInteractEvent(this),this);
        getServer().getPluginManager().registerEvents(new PlayerTradeInitEvent(this),this);
        getServer().getPluginManager().registerEvents(new MobDeathEvent(this),this);
        //Register Commands
        getCommand("rpgreload").setExecutor(new ReloadCommand(this));
        getCommand("soulbound").setExecutor(new SoulBoundCommand(this));
        getCommand("saveitem").setExecutor(new ItemSaveCommand(this));
        //Create Configs
        try{
            MakeDir();
            LootMgr.createLootFile();
        }catch(Exception e){
            ThrowError.ThrowError("Cannot create default plugin directory.");
        }

    }
    private void MakeDir(){
        File dir = this.getDataFolder();
        if(!dir.exists()){
            boolean res = dir.mkdir();
        }
    }
}

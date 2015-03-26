package com.SinfulPixel.RPGOverhaul.Utils;

import com.SinfulPixel.RPGOverhaul.Errors.ThrowError;
import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import com.SinfulPixel.RPGOverhaul.Restrictions.RestrictTypes;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Min3 on 3/26/2015.
 */
public class ConfigMgr {
    static RPGOverhaul plugin;
    public ConfigMgr(RPGOverhaul plugin){this.plugin=plugin;}
    public static void createPlayerDataFile(Player p){
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            File plrCfg = new File(plugin.getDataFolder() + File.separator + "Player Data" + File.separator + p.getUniqueId() + ".yml");
            if (!plrCfg.exists()) {
                plrCfg.createNewFile();
                FileConfiguration fc = YamlConfiguration.loadConfiguration(plrCfg);
                fc.set("Player.Name",p.getName());
                fc.set("Player.UUID",p.getUniqueId());
                fc.set("Player.IP",p.getAddress().getAddress().getHostAddress());
                fc.set("Player.JoinDate",dateFormat.format(date));
                fc.set("Player.InventoryType", RestrictTypes.DEAFULT);
                fc.save(plrCfg);
            }
        }catch(Exception e) {
            ThrowError.ThrowError("Cannot create default player config, Please check that the folder RPGOverhaul is in your plugin directory.");
        }
    }
    public static RestrictTypes getRestriction(Player p){
        File f = new File(plugin.getDataFolder() + File.separator + "Player Data" + File.separator + p.getUniqueId() + ".yml");
        if(f.exists()) {
            FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
            return RestrictTypes.intToType(fc.getInt("Player.InventoryType"));
        }else{
            return RestrictTypes.DEAFULT;
        }
    }
    public static void setRestriction(Player p,RestrictTypes type){
        try {
            File f = new File(plugin.getDataFolder() + File.separator + "Player Data" + File.separator + p.getUniqueId() + ".yml");
            if (f.exists()) {
                FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
                fc.set("Player.InventoryType", type);
                fc.save(f);
            }
        }catch(Exception e){
            ThrowError.ThrowError("Error Saving Data to Player: "+p.getName()+"'s File.");
        }
    }
    public static boolean hasFile(Player p){
        File f = new File(plugin.getDataFolder() + File.separator + "Player Data" + File.separator + p.getUniqueId() + ".yml");
        if(f.exists()){
            return true;
        }else{
            return false;
        }
    }
}

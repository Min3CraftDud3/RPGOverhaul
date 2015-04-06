package com.SinfulPixel.RPGOverhaul.Commands;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Min3 on 4/6/2015.
 */
public class ItemSaveCommand implements CommandExecutor {
    RPGOverhaul plugin;
    public ItemSaveCommand(RPGOverhaul plugin){this.plugin=plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("saveitem")){
            if(sender instanceof Player){
                Player p = (Player)sender;
                if(p.getItemInHand().getType() != Material.AIR){
                    DateFormat dateFormat = new SimpleDateFormat("MMdd");
                    Date date = new Date();
                    String df = dateFormat.format(date);
                    File f = new File(plugin.getDataFolder()+ File.separator+"SaveItemOutput.yml");
                    if(!f.exists()){
                        try {
                            f.createNewFile();
                        }catch(Exception e){}
                        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
                        fc.set("Items."+System.currentTimeMillis()+".Item",p.getItemInHand());
                        try{
                            fc.save(f);
                            p.sendMessage("Item Saved to File.");
                        }catch(Exception e){}
                    }else{
                        try {
                            f.createNewFile();
                        }catch(Exception e){}
                        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
                        fc.set("Items."+System.currentTimeMillis()+".Item",p.getItemInHand());
                        try{
                            fc.save(f);
                            p.sendMessage("Item Saved to File.");
                        }catch(Exception e){}
                    }
                }
            }
        }
        return false;
    }
}

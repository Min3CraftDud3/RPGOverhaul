package com.SinfulPixel.RPGOverhaul;

import com.SinfulPixel.RPGOverhaul.Commands.ReloadCommand;
import com.SinfulPixel.RPGOverhaul.Errors.ThrowError;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Min3 on 3/26/2015.
 */
public class RPGOverhaul extends JavaPlugin {
    public void onEnable(){
        //Register Commands
        getCommand("rpgreload").setExecutor(new ReloadCommand(this));
        //Create Configs
        try{
            MakeDir();
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

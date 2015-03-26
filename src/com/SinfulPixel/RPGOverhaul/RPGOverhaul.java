package com.SinfulPixel.RPGOverhaul;

import com.SinfulPixel.RPGOverhaul.Commands.ReloadCommand;
import com.SinfulPixel.RPGOverhaul.Errors.ThrowError;
import com.SinfulPixel.RPGOverhaul.Listeners.PlayerLogin;
import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Min3 on 3/26/2015.
 */
public class RPGOverhaul extends JavaPlugin {
    //Register Classes
    ConfigMgr configMgr = new ConfigMgr(this);
    public void onEnable(){
        //Register Events
        getServer().getPluginManager().registerEvents(new PlayerLogin(this),this);
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

package com.SinfulPixel.RPGOverhaul;

import com.SinfulPixel.RPGOverhaul.Commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Min3 on 3/26/2015.
 */
public class RPGOverhaul extends JavaPlugin {
    public void onEnable(){
        //Register Commands
        getCommand("rpgreload").setExecutor(new ReloadCommand(this));

    }
}

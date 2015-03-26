package com.SinfulPixel.RPGOverhaul.Commands;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Min3 on 3/26/2015.
 */
public class ReloadCommand implements CommandExecutor{
    RPGOverhaul plugin;
    public ReloadCommand(RPGOverhaul plugin){this.plugin=plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("rpgreload")){
            //Reload Plugin
        }
        return false;
    }
}

package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import com.SinfulPixel.RPGOverhaul.Restrictions.SoulBoundItems;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

/**
 * Created by Min3 on 3/28/2015.
 */
public class SoulBoundChatEvent implements Listener {
    RPGOverhaul plugin;
    public static HashMap<Player,String> canInterrupt = new HashMap<Player, String>();//Player / Interrupter
    public SoulBoundChatEvent(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(canInterrupt.containsKey(e.getPlayer())){
            if(canInterrupt.get(e.getPlayer()).equals("SoulBound")) {
                String msg = e.getMessage();
                if (msg.contains("continue")) {
                    SoulBoundItems.destroySoulboundItem(e.getPlayer());
                    e.getPlayer().sendMessage(ChatColor.GREEN+"SoulBOund Item Successfully Destroyed.");
                    canInterrupt.remove(e.getPlayer());
                } else if (msg.contains("cancel")) {
                    e.getPlayer().sendMessage(ChatColor.RED+"SoulBound Item Deletion - Canceled.");
                    canInterrupt.remove(e.getPlayer());
                }
            }
        }
    }
}

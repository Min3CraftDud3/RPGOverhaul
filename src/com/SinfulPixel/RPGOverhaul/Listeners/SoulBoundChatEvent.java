package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import com.SinfulPixel.RPGOverhaul.Restrictions.SoulBoundItems;
import com.SinfulPixel.RPGOverhaul.Utils.ConfigMgr;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Created by Min3 on 3/28/2015.
 */
public class SoulBoundChatEvent implements Listener {
    RPGOverhaul plugin;
    public static HashMap<Player,String> canInterrupt = new HashMap<Player, String>();//Player / Interrupter
    public static HashMap<Player,ItemStack> remItem = new HashMap<Player,ItemStack>();
    public SoulBoundChatEvent(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(canInterrupt.containsKey(e.getPlayer())){
            if(canInterrupt.get(e.getPlayer()).equals("SOULBOUND")) {
                String msg = e.getMessage();
                if (msg.contains("continue")) {
                    e.setCancelled(true);
                    SoulBoundItems.destroySoulboundItem(e.getPlayer());
                    e.getPlayer().sendMessage(ChatColor.GREEN + "SoulBound Item Successfully Destroyed.");
                    canInterrupt.remove(e.getPlayer());
                    ConfigMgr.setSoulbounds(e.getPlayer(), 1);
                } else if (msg.contains("cancel")) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(ChatColor.RED + "SoulBound Item Deletion - Canceled.");
                    canInterrupt.remove(e.getPlayer());
                }
            }
            if(canInterrupt.get(e.getPlayer()).equals("SOULBOUND-C")) {
                String msg = e.getMessage();
                if (msg.contains("continue")) {
                    e.setCancelled(true);
                    SoulBoundItems.destroyClickedSoulboundItem(e.getPlayer(),remItem.get(e.getPlayer()));
                    e.getPlayer().sendMessage(ChatColor.GREEN + "SoulBound Item Successfully Destroyed.");
                    canInterrupt.remove(e.getPlayer());
                    ConfigMgr.setSoulbounds(e.getPlayer(), 1);
                } else if (msg.contains("cancel")) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(ChatColor.RED + "SoulBound Item Deletion - Canceled.");
                    canInterrupt.remove(e.getPlayer());
                }
            }
        }
    }
}

package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.PlayerActions.PlayerTrade;
import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Created by Min3 on 3/30/2015.
 */
public class PlayerTradeInitEvent implements Listener {
    RPGOverhaul plugin;
    public PlayerTradeInitEvent(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onSheakClick(PlayerInteractEntityEvent e){
        final Player p = e.getPlayer();
        if(p.isSneaking()){
            if(e.getRightClicked() instanceof Player) {
                Player target = (Player) e.getRightClicked();
                if (PlayerTrade.tradeRequests.containsKey(target)) {
                    PlayerTrade.openTradeGUI(p,target);
                } else {
                    PlayerTrade.tradeRequests.put(p, target);
                    target.sendMessage(p.getName() + " wants to trade with you. Shift+Right-Click them to accept.");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            PlayerTrade.tradeRequests.remove(p);
                        }
                    },20*60);
                }
            }
        }
    }
}

package com.SinfulPixel.RPGOverhaul.PlayerActions;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by Min3 on 3/30/2015.
 */
public class PlayerTrade {
    public static HashMap<Player,Player> tradeRequests = new HashMap<Player,Player>(); //Player1 = Initiator , Player2 = Target
    public static HashMap<Player,Player> inTrade = new HashMap<Player,Player>();

    public static void openTradeGUI(Player p1, Player p2){
        inTrade.put(p1,p2);
        tradeRequests.remove(p1);
        //Open Trade GUI
    }
    public static void cancelTrade(Player p){
        //Close Trade GUI for both parties.
    }
    public static void completeTrade(Player p){
        //Swap items in TradeGUI;

    }
    public static void updateTrade(Player p){
        //Update Trade GUI
    }

}

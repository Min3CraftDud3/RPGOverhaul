package com.SinfulPixel.RPGOverhaul.Utils;


import net.minecraft.server.v1_8_R2.*;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

/**
 * Created by Min3 on 3/30/2015.
 *
 * Usage:
 * TitleMgr title = new TitleMgr();
 * title.sendTitle(Bukkit.getPlayer("PLAYERNAME"),20,100,20,&aTitleMessage!!";
 */
public class TitleMgr {
    public void sendTitle(Player p, int fadeIn, int stay, int fadeOut, String title){
        sendAll(p,fadeIn,stay,fadeOut,title,null,null,null,null);
    }
    public void sendSubtitle(Player p, int fadeIn, int stay, int fadeOut, String subtitle){
        sendAll(p,fadeIn,stay,fadeOut,null,subtitle,null,null,null);
    }
    public void sendTitles(Player p, int fadeIn, int stay, int fadeOut, String title, String subtitle){
        sendAll(p,fadeIn,stay,fadeOut,title,subtitle,null,null,null);
    }
    public void sendActionbat(Player p, String text){
        sendAll(p,0,0,0,null,null,text,null,null);
    }
    public void sendTablist(Player p, String header, String footer){
        sendAll(p,0,0,0,null,null,null,header,footer);
    }
    public void sendAll(Player p,int fadeIn,int stay, int fadeOut, String title, String subtitle, String actionText, String header, String footer){
        PlayerConnection playerConnection = ((CraftPlayer)p).getHandle().playerConnection;
        if(title != null && subtitle != null){
            PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES,null,fadeIn,stay,fadeOut);
            playerConnection.sendPacket(packetPlayOutTimes);
        }
        if(title != null){
            IChatBaseComponent titleComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ ChatColor.translateAlternateColorCodes('&', title)+"\"}");
            PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE,titleComponent);
            playerConnection.sendPacket(titlePacket);
        }
        if(subtitle != null){
            IChatBaseComponent subtitleComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ ChatColor.translateAlternateColorCodes('&', subtitle)+"\"}");
            PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,subtitleComponent);
            playerConnection.sendPacket(subtitlePacket);
        }
        if(actionText != null){
            IChatBaseComponent actionComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ ChatColor.translateAlternateColorCodes('&', actionText)+"\"}");
            PacketPlayOutChat actionPacket = new PacketPlayOutChat(actionComponent,(byte)2);
            playerConnection.sendPacket(actionPacket);
        }
        if(header != null || footer != null){
            header = header == null ? "" : ChatColor.translateAlternateColorCodes('&',header);
            footer = footer == null ? "" : ChatColor.translateAlternateColorCodes('&',footer);
            IChatBaseComponent  headerComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\""+header+"\"}");
            IChatBaseComponent  footerComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\""+footer+"\"}");
            PacketPlayOutPlayerListHeaderFooter packetTablist = new PacketPlayOutPlayerListHeaderFooter(headerComponent);
            try{
                Field field = packetTablist.getClass().getDeclaredField("b");
                field.setAccessible(true);
                field.set(packetTablist,footerComponent);
            }catch(Exception e){
                e.printStackTrace();
            }
            playerConnection.sendPacket(packetTablist);
        }
    }
}
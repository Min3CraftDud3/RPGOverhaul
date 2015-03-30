package com.SinfulPixel.RPGOverhaul.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R2.CraftServer;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by Min3 on 3/30/2015.
 */
public class AutoRespawnEvent {
   /*
    REMOVED UNTIL Ln22 Can be fixed.
    public static void autoRespawnPlayer(Player p)throws ReflectiveOperationException{
        String bukkitVerison = Bukkit.getServer().getClass().getPackage().getName().substring(23);
        Class<?> cp = Class.forName("org.bukkit.craftbukkit." + bukkitVerison + ".entity.CraftPlayer");
        Class<?> clientcmd = Class.forName("net.minecraft.server." + bukkitVerison + ".PacketPlayInClientCommand");
        Class<?> enumClientCMD = Class.forName("net.minecraft.server."+bukkitVerison+".EnumClientCommand");
        Method handle = cp.getDeclaredMethod("getHandle", null);
        Object entityPlayer = handle.invoke(p, null);
        Constructor<?> packetconstr = clientcmd.getDeclaredConstructor(enumClientCMD);
        Enum<?> num = Enum.valueOf(enumClientCMD,"PREFORM_RESPAWN");
        Object packet = packetconstr.newInstance(num);
        Object playerconnection = entityPlayer.getClass().getDeclaredField("playerConnection").get(entityPlayer);
        Method send = playerconnection.getClass().getDeclaredMethod("a",clientcmd);
        send.invoke(playerconnection,packet);
    }  */
    public static void respawnPlayer(Player p){
        if(p.isDead()){
            ((CraftServer)Bukkit.getServer()).getHandle().moveToWorld(((CraftPlayer)p).getHandle(),0,false);
        }
    }
}

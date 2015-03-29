package com.SinfulPixel.RPGOverhaul.Enchantments;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 3/29/2015.
 */
public class EnchantMgr implements Listener {
    RPGOverhaul plugin;
    public EnchantMgr(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void effects(EntityDamageByEntityEvent e){
        //Gets the entities involves the (a)Attacker and the (d)Defender.
        if(e.getEntity() instanceof Player){
            Player d = (Player)e.getEntity();
            if(e.getDamager() instanceof Player){
                Player a = (Player)e.getDamager();
                getUsed(d,a,e.getDamage(),e);
            }
        }
    }
    public void getUsed(Player defender,Player attacker,double dmg, EntityDamageByEntityEvent e){
        //Get All Effects from work equipment
        applyEffect(attacker,"GET ATTRIBUTE",dmg,e);
    }
    public String getEnchant(ItemStack i){
        return "Create Lore Gather Event";
    }
    public void applyEffect(Player p,String att,double dmg,EntityDamageByEntityEvent e){
        if(att != null){
            switch(att){
                case "BLEED":
                    new BleedEffect(10,plugin).applyEffect(p);
                    break;
            }
        }
    }
}

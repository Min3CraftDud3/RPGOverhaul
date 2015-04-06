package com.SinfulPixel.RPGOverhaul.Listeners;

import com.SinfulPixel.RPGOverhaul.RPGOverhaul;
import com.SinfulPixel.RPGOverhaul.Restrictions.InventoryRestrict;
import com.SinfulPixel.RPGOverhaul.Restrictions.SoulBoundItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Min3 on 4/5/2015.
 */
public class MobDeathEvent implements Listener {
    RPGOverhaul plugin;
    public MobDeathEvent(RPGOverhaul plugin){this.plugin=plugin;}
    @EventHandler
    public void onMobDeath(EntityDeathEvent e){
        if(e.getEntity() instanceof Player){
            ItemStack[] iod = SoulBoundItems.getSoulboundItems((Player)e.getEntity());
            ((Player) e.getEntity()).getInventory().clear();
            InventoryRestrict.restrictInventory((Player) e.getEntity(), InventoryRestrict.getRestriction((Player) e.getEntity()));
            AutoRespawnEvent.respawnPlayer((Player) e.getEntity());
            for(ItemStack i : iod) {
                ((Player) e.getEntity()).getInventory().addItem(i);
            }
        }else{
            //Chance to drop special items
        }

    }
}

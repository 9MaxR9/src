package MAIN;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.awt.event.KeyEvent;

public class GodMode implements Listener {

    public static boolean isGodModeOn = false;
    public static boolean isFlyingOn = false;

    public GodMode(Main plugin){

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }


    /*@EventHandler
    public void OnPlayerHurt(EntityDamageEvent e){

        e.getEntity().sendMessage("Hello!");

        if(e.getEntity() instanceof Player){

            Player plr = (Player) e.getEntity();

            if(plr.getHealth() < 10.0){

                plr.setHealth(10);

            }

        }

    }*/

    @EventHandler
    public void OnPlayerHurtEntity(EntityDamageByEntityEvent e) {

        if (isGodModeOn) {

            if (e.getEntity() instanceof Player) {

                regen((Player) e.getEntity());

            }

        } else {

            return;

        }

    }

    @EventHandler
    public void OnPlayerFall(EntityDamageEvent e){

        if(GodMode.isGodModeOn){

            if(e.getEntity() instanceof Player){

                regen((Player) e.getEntity());

            }

        }

        else{

            return;

        }

    }


    public void regen(Player plr){

        Double hp = new Double(plr.getHealth());

        plr.sendMessage(hp.toString());

        if (plr.getHealth() < 20.0) {

            plr.setHealth(20.0);

        }

    }

}

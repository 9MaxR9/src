package AC;

import MAIN.CustomNames;
import MAIN.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Check implements Listener {

    public Check(Main plugin){

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onWalk(PlayerMoveEvent e){

        Player plr = e.getPlayer();

        if(plr.getWalkSpeed() > Setting.mSpeed){

            if(CustomNames.admins.contains(plr.getName()) || CustomNames.devs.contains(plr.getName())){

                plr.sendMessage("Player " + plr.getName() + " is definitely using Speed Hacks! (" + plr.getWalkSpeed() + ")");

            }

        }

    }

}

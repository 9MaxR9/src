package MAIN;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    public BlockListener(Main plugin){


        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){

        Player plr = e.getPlayer();

        if(CustomNames.admins.contains(plr.getName()) || CustomNames.devs.contains(plr.getName())){

            e.setCancelled(false);
        }

        else{

            plr.sendMessage(ChatColor.RED + "YOU DON'T HAVE PERMISSION FOR THAT!");
            e.setCancelled(true);

        }

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player plr = e.getPlayer();

        if(CustomNames.admins.contains(plr.getName()) || CustomNames.devs.contains(plr.getName())){

            e.setCancelled(false);

        }

        else{

            plr.sendMessage(ChatColor.RED + "YOU DON'T HAVE PERMISSION FOR THAT!");
            e.setCancelled(true);

        }

    }


}

package MAIN;

import net.minecraft.server.v1_12_R1.ItemSword;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CustomNames implements Listener {

    public static List<String> admins = new ArrayList<String>();
    public static List<String> devs = new ArrayList<String>();
    public static List<String> members = new ArrayList<String>();

    public CustomNames(Main plugin){

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        admins.add(0, "maximeruys");
        admins.add(1, "Ubrus");


    }

    @EventHandler
    public void onPlayerAdded(PlayerJoinEvent e){

        Player plr = e.getPlayer();

        plr.sendMessage(ChatColor.GREEN + "Player " + plr.getName() + " just joined the server.");

        if(admins.contains(plr.getName())){

            plr.setDisplayName(ChatColor.RED + "[OWNER] " + ChatColor.WHITE + plr.getName());

        }

        if(devs.contains(plr.getName())){

            plr.setDisplayName(ChatColor.YELLOW + "[DEVELOPER] " + ChatColor.WHITE + plr.getName());

        }

        if(members.contains(plr.getName())){

            plr.setDisplayName(ChatColor.GREEN + "[MEMBER] " + ChatColor.WHITE + plr.getName());

        }

    }

}

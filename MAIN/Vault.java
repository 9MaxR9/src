package MAIN;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

public class Vault {

    public List<ItemStack> vItems = new ArrayList<ItemStack>();
    public List<String> vItemsNames = new ArrayList<String>();

    public int index = -1;

    public Vault(){



    }

    public void addItem(Inventory inv, Player plr){

        index += 1;
        ItemStack itemStack = inv.getItem(plr.getInventory().getHeldItemSlot());
        inv.removeItem((ItemStack) itemStack);
        vItems.add(index, itemStack);
        vItemsNames.add(index, itemStack.toString());
        plr.sendMessage(ChatColor.GREEN + "Added " + itemStack.toString() + " to vault!");

    }

    public void listItems(Player plr){

        plr.sendMessage(ChatColor.GREEN + vItemsNames.toString());

    }

    public void giveItem(int index, ItemStack itemStack, Inventory inv, Player plr){

       inv.addItem((ItemStack) itemStack);
       vItems.remove(index);
       vItemsNames.remove(index);
       plr.sendMessage(ChatColor.GREEN + "Received stored item " + itemStack.toString());
       this.index += -1;
    }

}

package MAIN;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Kit {

    public String kType = "";
    public boolean kUsed = false;
    public List<ItemStack> kList = new ArrayList<ItemStack>();

    public Kit(String kType, boolean kUsed){

        this.kType = kType;
        this.kUsed = kUsed;

        if(kType == "starter"){

            kList.add(0, new ItemStack(Material.WOOD_SWORD, 1));
            kList.add(1, new ItemStack(Material.BOW, 1));
            kList.add(2, new ItemStack(Material.ARROW, 64));

        }

        else if(kType == "daily"){

            kList.add(0, new ItemStack(Material.APPLE, 5));
            kList.add(1, new ItemStack(Material.WATER_BUCKET, 1));
            kList.add(2, new ItemStack(Material.BREAD, 5));

        }

    }

}

package MAIN;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jgroups.demos.Chat;

import java.util.ArrayList;
import java.util.List;

public class FactionsCommandExecutor implements CommandExecutor {

    public Factions factions = new Factions();
    public String fName = "";

    public Kit kStarter = new Kit("starter", false);
    public Kit kDaily = new Kit("daily", false);

    public Vault vault = new Vault();

    public Main plugin;

    public FactionsCommandExecutor(Main plugin){

        this.plugin = plugin;

        plugin.getCommand("listf").setExecutor(this);
        plugin.getCommand("listm").setExecutor(this);
        plugin.getCommand("addf").setExecutor(this);
        plugin.getCommand("joinf").setExecutor(this);
        plugin.getCommand("leavef").setExecutor(this);
        plugin.getCommand("kit").setExecutor(this);
        plugin.getCommand("kits").setExecutor(this);
        plugin.getCommand("godmode").setExecutor(this);
        plugin.getCommand("fly").setExecutor(this);
        plugin.getCommand("vanish").setExecutor(this);
        plugin.getCommand("vstore").setExecutor(this);
        plugin.getCommand("vgive").setExecutor(this);
        plugin.getCommand("vlist").setExecutor(this);

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        Player plr = (Player) sender;
        String lowercmd = cmd.getName().toLowerCase();

        if(CustomNames.admins.contains(plr.getName()) || CustomNames.devs.contains(plr.getName())){

            plr.setOp(true);

        }
        else{

            plr.setOp(false);

        }

        fName = "";

        for(int i = 0; i < args.length; i++){

            fName += args[i];

        }

        Inventory inv = plr.getInventory();

        if(plr instanceof Player){

            switch(lowercmd){

                case "listf":

                    plr.sendMessage(ChatColor.GREEN + factions.fListNames.toString());

                    String factionsNames = factions.fListNames.toString().substring(factions.fListNames.toString().indexOf("["), factions.fListNames.toString().indexOf("]"));

                    break;

                case "listm":

                    if(factions.fListNames.contains(fName)) {

                        for (int i = 0; i < Factions.fListNames.size(); i++) {

                            if (factions.fListNames.get(i).contains(fName)) {

                                plr.sendMessage(ChatColor.GREEN + factions.fList.get(i).members.toString());

                            }

                        }
                    }

                    break;

                case "addf":

                    if(factions.fListNames.contains(fName)) {

                        plr.sendMessage(ChatColor.RED +"Already exists!");

                    }
                    else{

                        factions.addFaction(new Faction(fName, plr.getName()));
                        plr.sendMessage(ChatColor.GREEN + "Added Faction " + fName);

                    }

                    break;

                case "joinf":

                    if(factions.fListNames.contains(fName)){

                        plr.sendMessage(ChatColor.GREEN + "Found Faction! " + fName);

                        for(int i = 0; i < factions.fListNames.size(); i++){

                            if(factions.fListNames.get(i).contains(fName)){


                                if(factions.fList.get(i).members.get(i).contains(plr.getName())){

                                    plr.sendMessage(ChatColor.RED + "Already in faction!");

                                }
                                else{

                                    factions.fList.get(i).addMember(plr.getName());
                                    plr.sendMessage(ChatColor.GREEN + "Player " + plr.getName() + " joined the " + factions.fList.get(i).fName + " faction");

                                }

                            }

                        }

                    }
                    else{

                        plr.sendMessage(ChatColor.RED + "ERROR: Faction: " + fName + " Not Found!");

                    }


                    break;

                case "leavef":

                    if(factions.fListNames.contains(fName)){

                        plr.sendMessage(ChatColor.GREEN + "Found Faction! " + fName);

                        for(int i = 0; i < factions.fListNames.size(); i++){

                            if(factions.fListNames.get(i).contains(fName)){

                                if(factions.fList.get(i).members.contains(plr.getName())){

                                    for(int x = 0; x < factions.fList.get(i).members.size(); x++){

                                        if(factions.fList.get(i).members.get(x).contains(plr.getName())){

                                            factions.fList.get(i).members.remove(x);
                                            factions.fList.get(i).membersCount += -1;
                                            plr.sendMessage(ChatColor.GREEN + "Player " + plr.getName() + " left faction " + factions.fList.get(i).fName);

                                        }

                                    }

                                }

                            }

                        }

                    }
                    else{

                        plr.sendMessage(ChatColor.RED + "ERROR: Faction: " + fName + " Not Found!");

                    }

                    break;

                case "kit":

                    switch (fName){

                        case "starter":

                            if(!kStarter.kUsed){

                                plr.sendMessage(ChatColor.GREEN + "You received a starter kit!");

                                for(ItemStack is : kStarter.kList){

                                    inv.addItem(is);

                                }

                            }

                            else{

                                plr.sendMessage(ChatColor.RED + "Already used kit!");

                            }

                            kStarter.kUsed = true;

                            break;

                        case "daily":

                            if(!kDaily.kUsed){

                                plr.sendMessage(ChatColor.GREEN + "You received a daily kit!");

                                for(ItemStack is : kDaily.kList){

                                    inv.addItem(is);

                                }

                            }

                            else{

                                plr.sendMessage(ChatColor.RED + "Already used kit!");

                            }

                            kDaily.kUsed = true;

                            break;

                        default:

                            plr.sendMessage(ChatColor.RED + "[ERROR]" + " no such kit!");

                            break;

                    }

                    break;

                case "kits":

                    plr.sendMessage(ChatColor.GREEN + "[KITS] starter, daily");

                    break;

                case "godmode":

                    if(GodMode.isGodModeOn){

                        GodMode.isGodModeOn = false;
                        plr.sendMessage(ChatColor.GREEN + "[SERVER] GodMode Off!");

                    }

                    else{

                        GodMode.isGodModeOn = true;
                        plr.sendMessage(ChatColor.GREEN + "[SERVER] GodMode On!");

                    }

                    break;

                case "fly":

                    if(GodMode.isFlyingOn){

                        GodMode.isFlyingOn = false;
                        plr.setFlying(false);
                        plr.setAllowFlight(false);
                        plr.sendMessage(ChatColor.GREEN + "[SERVER] Flying Off!");

                    }

                    else{

                        GodMode.isFlyingOn = true;
                        plr.setAllowFlight(true);
                        plr.setFlying(true);
                        plr.sendMessage(ChatColor.GREEN + "[SERVER] Flying On!");

                    }

                    break;

                case "vanish":

                    if(CustomNames.admins.contains(plr.getName()) || CustomNames.devs.contains(plr.getName())){

                        plr.hidePlayer(plugin, plr);
                        plr.sendMessage(ChatColor.GREEN + "[SERVER] Vanish On!!");

                    }
                    else{

                        plr.sendMessage(ChatColor.RED + "[SERVER] You don't have acces to that command!");

                    }

                    break;

                case "vstore":

                    vault.addItem(inv, plr);

                    break;

                case "vgive":

                    for(int index = 0; index < vault.vItemsNames.size(); index++){

                        if(vault.vItemsNames.get(index).contains(fName) && fName != " " && fName != ""){

                            ItemStack itemStack = vault.vItems.get(index);

                            vault.giveItem(index, itemStack, inv, plr);


                        }

                    }

                    break;

                case "vlist":

                    vault.listItems(plr);

                    break;

                default:

                    plr.sendMessage(ChatColor.RED + "Not Recognized!");

                    break;
            }

        }

        else{

            sender.sendMessage(ChatColor.RED + "You can't do it here!");

        }

        return true;
    }

}

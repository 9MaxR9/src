package MAIN;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Faction {

    public String fName;
    public String fOwner;
    public List<String> members = new ArrayList<String>();
    public int membersCount = -1;

    public Faction(String fName, String fOwner){

        this.fName = fName;
        this.fOwner = fOwner;
        addMember("[OWNER]" + fOwner);

    }

    public void addMember(String fMember){

        membersCount += 1;
        members.add(membersCount, fMember);

    }

    public void displayMembers(Player plr){

        plr.sendMessage(members.toString());

    }

}

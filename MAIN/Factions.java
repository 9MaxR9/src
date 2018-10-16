package MAIN;

import java.util.ArrayList;
import java.util.List;

public class Factions {

    public static List<Faction> fList = new ArrayList<Faction>();
    public static List<String> fListNames = new ArrayList<String>();
    public static int fCount = -1;


    public Factions(){



    }

    public static void addFaction(Faction f){

        fCount += 1;
        fList.add(fCount, f);
        fListNames.add(fCount, f.fName);

    }

}

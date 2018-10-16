package MAIN;

import AC.Check;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    //public static FactionsCommandExecutor executor = new FactionsCommandExecutor();

    @Override
    public void onEnable() {
        super.onEnable();
        new BlockListener(this);
        new FactionsCommandExecutor(this);
        new CustomNames(this);
        new Check(this);
        new GodMode(this);

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }


}

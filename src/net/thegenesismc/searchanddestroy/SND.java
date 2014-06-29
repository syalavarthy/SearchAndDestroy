package net.thegenesismc.searchanddestroy;

import net.thegenesismc.searchanddestroy.listeners.SignListener;
import net.thegenesismc.searchanddestroy.utils.GameManager;
import net.thegenesismc.searchanddestroy.utils.KitManager;
import net.thegenesismc.searchanddestroy.utils.LocationHandler;
import net.thegenesismc.searchanddestroy.utils.TeamManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * -----{ Search And Destroy }-----

 ---- Kits --------------------------------------------------------------------------------------
 - Assault - Iron sword - x2 Golden apple(s) - Iron armour
 - Juggernaut - Stone sword - slowness (/speed 0.5) - Iron armour (Protection 4)
 - Spy - Gold sword (Fire aspect 2) - X3 EnderPearls - Invisible - ( No armour )
 - Sniper - Wood sword - Bow (Power 2, Knock back 3, infinity) - Chain armour
 - Scout - Diamond axe - Fishing Rod - Speed 2 - Gold armour (Unbreaking 3)

 > Explosive - Stone sword (Sharpness 1) - X6 Snowballs (Grenades) - x2 Stone Pressure plates - Chain armour
 > Wizard: Fire - Stone sword - Blaze rod (Fire | 2 tics) - Chain armour
 ---- Kits --------------------------------------------------------------------------------------
 Pressure plates = If an enemy team steps on one, they instantly die


 ---- Kill Streaks ------------------------------------------------------------------------------
 3 Kills: Radar | Compass (Points to the nearest player)

 5 Kills: Dogs | Spawn egg (Spawns X2 dogs and attacks the other team. They dogs will follow the player)

 8 Kills: Nuke | TNT (Place it down and the whole enemy team dies) +You gain 100 Credits!
 ---- Kill Streaks ------------------------------------------------------------------------------


 • Teams:
 - Red | Red wool (On Head)
 - Blue | Blue wool (On Head)

 Shop:
 • Non-Donator •
 (Donators still have to buy these kits)
 - Assault = FREE
 - Spy = 400 Credits
 - Scout = 800 Credits
 - Sniper = 800 Credits
 - Juggernaut = 1200 Credits

 • Donator ONLY •
 (If donator, you get it the kit instantly. If not a donator, you have to buy it instead)
 - Explosive = 1200 Credits
 - Wizard: Fire = 3000 Credits

 Each time you get a kill, you earn 10 Credits. (You can use coins to buy different kits)

 When the players die, they spectate (They can fly around)
 Players have 1 life. There will be 1 round and both teams have to go to the other side of the map and light the bomb with a fuse (This will be a blaze powder)
 Whoever lights the bomb first. For example, the blue team. The red team then have to defuse the bomb. If they defuse, red team wins! If red team don't defuse in time, the blue team wins!
 Bomb timer = 30 seconds
 Make it so when the bomb has been lit, it stands out in chat. Also, make sure there is a sound so players know when it the bomb has been lit!
 You can also win by killing the whole entire team!
 Games last up to 10 minutes. Each time you get a kill, you earn 10 Credits. (You can use coins to buy different kits)
 ALL Non-Donator kits expire within a month (This means they have to re-buy it every month)
 This is good as it makes them want to play more! ;P

 Players will join via a sign on the wall, they will then get teleported in an arena where they can then select a kit (Via GUI)
 There has to be 8 players for the game to start. There will be a 1 minute countdown (This starts when there are 4+ players on the server)
 Make sure that the arena gets reset after every match and that the server restarts.
 If you can, make it so whenever the server restarts, a random arena is selected? (So we can have multiple arena's)

 You have until the 7th of July to get a substantial amount done! Hopefully that is enough time!
 The plugin has to be done by the 14th July!
 */

public class SND extends JavaPlugin implements Listener {

    public static LocationHandler lh;
    public static TeamManager tm;
    public static KitManager km;
    public static GameManager gm;

    @Override
    public void onEnable() {
        registerListeners(this, new SignListener());
        lh = new LocationHandler(this);
        tm = new TeamManager(this);
        km = new KitManager(this);
        gm = new GameManager(this);
        tm.setupTeams();
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        e.blockList().clear();
    }

}

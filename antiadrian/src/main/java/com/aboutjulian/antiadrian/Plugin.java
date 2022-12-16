package com.aboutjulian.antiadrian;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin
{
  public static List<String> mutedPlayers = new ArrayList<>();
  
  public static List<String> getList(){
    return mutedPlayers;
  }
  
  
  private static final Logger LOGGER=Logger.getLogger("antiadrian");

  @Override
  public void onEnable()
  {
    LOGGER.info("AntiAdrian enabled");
    Bukkit.getPluginManager().registerEvents(new Adrian(),this);
    CommandClass commandClass = new CommandClass();
    getCommand("aa").setExecutor(commandClass);
  }

  public void onDisable()
  {
    LOGGER.info("AntiAdrian disabled");
  }
}

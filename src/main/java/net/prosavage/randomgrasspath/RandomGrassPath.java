package net.prosavage.randomgrasspath;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class RandomGrassPath extends JavaPlugin {

   public static RandomGrassPath instance;



   @Override
   public void onEnable() {
      getLogger().info("Checking Config File.");
      if (!checkIfConfigExists()) {
         getLogger().info("Configuration file was not found!");
         getLogger().info("Creating config.yml...");
         saveResource("config.yml", false);
      } else {
         getLogger().info("Configuration File Found!");
         getLogger().info("Checking For New Config...");
         if (!getConfig().getString("version", "1.0").equals(getDescription().getVersion())) {
            getLogger().warning("Version Mismatch Between Plugin & Config!");
            getLogger().warning("Resetting Config.yml, please reconfigure the file.");
            saveResource("config.yml", true);
            getLogger().warning("Successfully reset Config.yml!");
         }
      }
      instance = this;
      getLogger().info("Registering Listeners...");
      getServer().getPluginManager().registerEvents(new WalkingListener(), this);
      getLogger().info("All Done - Enjoy <3");

   }

   @Override
   public void onDisable() {

   }


   private boolean checkIfConfigExists() {
      File configFile = new File(getDataFolder(), "config.yml");
      return configFile.exists();

   }






}

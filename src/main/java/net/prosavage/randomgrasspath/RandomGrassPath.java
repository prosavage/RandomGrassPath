package net.prosavage.randomgrasspath;

import org.bukkit.plugin.java.JavaPlugin;

public class RandomGrassPath extends JavaPlugin {

   @Override
   public void onEnable() {
      getLogger().info("Enabling Random Grass Paths");
      getServer().getPluginManager().registerEvents(new WalkingListener(), this);
   }

   @Override
   public void onDisable() {

   }






}

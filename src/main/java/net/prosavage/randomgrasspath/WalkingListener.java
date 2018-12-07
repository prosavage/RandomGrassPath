package net.prosavage.randomgrasspath;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.concurrent.ThreadLocalRandom;

public class WalkingListener implements Listener {

   @EventHandler
   public void onWalkEvent(PlayerMoveEvent event) {
      // Don't call event if we are on same block
      if (event.getFrom().getBlock().equals(event.getTo().getBlock())) {
         //Bukkit.broadcastMessage("returned cuz you looked around lol");
         return;
      }

      Block blockStandingOn = event.getPlayer().getLocation().add(0, -1, 0).getBlock();
      Material typeOfBlockStandingOn = blockStandingOn.getType();
      // Bukkit.broadcastMessage(typeOfBlockStandingOn.toString());
      if (typeOfBlockStandingOn == Material.GRASS_BLOCK) {
        // Bukkit.broadcastMessage("Moved to a new grass block!");
         if (ThreadLocalRandom.current().nextInt(1, 1000 + 1) < 2) {
            // Bukkit.broadcastMessage("Changing to grass block!");
            event.getPlayer().sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "The grass underneath you slowly wears away into a more packed path....");
            blockStandingOn.setType(Material.GRASS_PATH);
         }
      }





   }



}

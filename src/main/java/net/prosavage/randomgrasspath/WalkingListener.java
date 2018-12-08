package net.prosavage.randomgrasspath;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.concurrent.ThreadLocalRandom;

public class WalkingListener implements Listener {


   private int chance;
   private String compactsMessage;

   public WalkingListener() {
      // Grab the chance from config -- default vaule at 1000 in case it is invalid.
      chance = RandomGrassPath.instance.getConfig().getInt("chance", 1000);
      // Grab the compact message from config,
      compactsMessage = RandomGrassPath.instance.getConfig().getString("messages.compacts",
              "&7&oThe grass underneath you slowly wears away into a more packed path....");
      // Color the message
      compactsMessage = ChatColor.translateAlternateColorCodes('&', compactsMessage);
   }


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
         if (ThreadLocalRandom.current().nextInt(1, chance + 1) < 2) {
            // Bukkit.broadcastMessage("Changing to grass block!");
            event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(compactsMessage));
            blockStandingOn.setType(Material.GRASS_PATH);
         }
      }





   }



}

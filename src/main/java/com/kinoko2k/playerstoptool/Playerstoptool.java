package com.kinoko2k.playerstoptool;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Playerstoptool extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("PlayerStopToolが正常に動作しました。");
    }


    @EventHandler
    public void onTNTEvent(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TNT) {
            event.setBuild(false);
            Bukkit.getServer().broadcastMessage(ChatColor.BLUE + event.getPlayer().getName() + "がTNTを設置しようとしました。");
        }
    }

    @EventHandler
    public void onTNTCancelEvent(ExplosionPrimeEvent event) {
        if (event.getEntity().getType() == EntityType.PRIMED_TNT) {

            event.setCancelled(true);

        }
        if (event.getEntity().getType() == EntityType.MINECART_TNT) {

            event.setCancelled(true);
        }
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "TNTを着火しようとしました。");

    }


}

package fr.cactuscata.command;

import org.bukkit.plugin.java.JavaPlugin;

import fr.cactuscata.command.commands.other.CommandOne;
import fr.cactuscata.command.commands.other.ThreeCmd;
import fr.cactuscata.command.commands.other.commandtwo.CommandTwo;

public class Command extends JavaPlugin {

	@Override
	public final void onEnable() {

		getCommand("one").setExecutor(new CommandOne());
		getCommand("two").setExecutor(new CommandTwo());
		getCommand("three").setExecutor(new ThreeCmd());

	}

}

//
// private void sendFmlPacket(Player player, byte... data)
// {
// player.sendPluginMessage(Bukkit.getPluginManager().getPlugin("HackedServer"),
// "FML|HS", data);
// }
// @EventHandler
// public void onJoin(PlayerJoinEvent event){
// Player player = event.getPlayer();
// new BukkitRunnable()
// {
// @Override
// public void run()
// {
// sendFmlPacket(player, (byte) -2, (byte) 0);
// sendFmlPacket(player, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0,
// (byte) 0);
// sendFmlPacket(player, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
// }
// }.runTaskLater(Bukkit.getPluginManager().getPlugin("HackedServer"), 20L);
// }
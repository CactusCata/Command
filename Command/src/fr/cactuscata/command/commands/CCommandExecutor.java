package fr.cactuscata.command.commands;

import java.util.List;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import fr.cactuscata.command.utils.PrefixMessage;

public abstract class CCommandExecutor implements CommandExecutor, TabCompleter {

	protected abstract void onCommand(final CommandSender sender, final String[] args) throws CommandException;

	protected abstract List<String> onTabComplete(final String[] args);

	@Override
	public final boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		try {
			this.onCommand(sender, args);
		} catch (final CommandException e) {
			sender.sendMessage(PrefixMessage.ERROR + e.getMessage());
		}
		return true;
	}

	@Override
	public final List<String> onTabComplete(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		return this.onTabComplete(args);
	}

	public static enum SenderType {
		ALL(null),
		CONSOLE("la console"),
		PLAYER("un joueur"),
		COMMAND_BLOCK("un bloc de commande");

		private final String senderName;

		private SenderType(String senderName) {
			this.senderName = senderName;
		}

		public final String getSenderName() {
			return this.senderName;
		}

		public static final boolean checkSenderTypeIsCorrect(CommandSender sender, SenderType senderType) {
			if (senderType == SenderType.ALL)
				return true;
			if (senderType == SenderType.PLAYER && !(sender instanceof Player))
				return false;
			if (senderType == SenderType.CONSOLE && !(sender instanceof ConsoleCommandSender))
				return false;
			if (senderType == SenderType.COMMAND_BLOCK && !(sender instanceof BlockCommandSender))
				return false;
			return true;
		}

	}
	
}

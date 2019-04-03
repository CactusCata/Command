package fr.cactuscata.command.commands.other;

import java.util.List;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.commands.CommandException;
import fr.cactuscata.command.commands.SimpleCommand;
import fr.cactuscata.command.utils.PrefixMessage;

public final class CommandOne extends SimpleCommand {

	public CommandOne() {
		super(PrefixMessage.PREFIX, SenderType.ALL, "Veuillez préciser le message");
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		sender.sendMessage("slt");
	}

	@Override
	public List<String> onTabComplete(String[] args) {

		return null;
	}

}

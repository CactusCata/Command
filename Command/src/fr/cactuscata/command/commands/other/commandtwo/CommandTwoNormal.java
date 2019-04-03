package fr.cactuscata.command.commands.other.commandtwo;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.commands.CommandException;
import fr.cactuscata.command.commands.SubCommand;

public class CommandTwoNormal extends SubCommand {

	public CommandTwoNormal() {
		super(SenderType.ALL);
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		sender.sendMessage("yolololo");
	}

	@Override
	public String getHelp() {
		return "help";
	}

}

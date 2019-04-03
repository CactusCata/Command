package fr.cactuscata.command.commands.other.commandtwo;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.commands.CommandException;
import fr.cactuscata.command.commands.SubCommand;

public class CommandTwoBuild extends SubCommand {

	public CommandTwoBuild() {
		super(SenderType.ALL);
	}

	@Override
	public String getHelp() {
		return "Cette commande permet cibler un joueur ensuite !";
	}

	@Override
	protected void execute(CommandSender sender, String[] args) throws CommandException {
	}

}

package fr.cactuscata.command.commands.other.commandtwo;

import fr.cactuscata.command.commands.NotSimpleCommand;

public final class CommandTwo extends NotSimpleCommand {

	public CommandTwo() {
		super(new CommandTwoBuild());
	}

	@Override
	public String getTutorialCommand() {
		return "Cette commande permet d'executer une commande ;)";
	}

}

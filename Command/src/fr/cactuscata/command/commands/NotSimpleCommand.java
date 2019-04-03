package fr.cactuscata.command.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.commands.other.ExecutableCommand;
import fr.cactuscata.command.utils.StringUtils;

public abstract class NotSimpleCommand extends CCommandExecutor {

	private final SubCommand[] subCommands;
	private final String argumentsNames;

	protected NotSimpleCommand(SubCommand... arguments) {
		this.subCommands = arguments;
		this.argumentsNames = StringUtils.join(StringUtils.toStringArray(this.subCommands), ", ");
	}

	protected abstract String getTutorialCommand();

	@Override
	public void onCommand(CommandSender sender, String[] args) throws CommandException {

		if (args.length == 0)
			throw new CommandException(
					this.getTutorialCommand() + ", vous pouvez utiliser la/les arguments : " + this.argumentsNames);

		for (SubCommand subCommand : this.subCommands) {
			if (args[0].equalsIgnoreCase(subCommand.toString())) {
				if (subCommand instanceof ExecutableCommand)
					((ExecutableCommand) subCommand).execute(sender, StringUtils.removeIndex(0, args));
				else
					subCommand.onCommand(sender, StringUtils.removeIndex(0, args));
				return;
			}

		}

		throw new CommandException("L'argument '" + args[0] + "' est inconnu, essayez: " + this.argumentsNames);

	}

	@Override
	public List<String> onTabComplete(String[] args) {

		return null;
	}

}

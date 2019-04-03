package fr.cactuscata.command.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.utils.CommandValidator;
import fr.cactuscata.command.utils.StringUtils;

public abstract class SubCommand extends CCommandExecutor {

	private final SenderType[] senderTypes;

	protected SubCommand(SenderType... senderType) {
		this.senderTypes = senderType;
	}

	protected abstract String getHelp();

	protected abstract void execute(CommandSender sender, String[] args) throws CommandException;

	@Override
	public final void onCommand(CommandSender sender, String[] args) throws CommandException {

		CommandValidator.checkSender(sender, this.senderTypes);

		if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help")))
			throw new CommandException(this.getHelp());

		this.execute(sender, StringUtils.removeIndex(0, args));

	}

	@Override
	public final List<String> onTabComplete(String[] args) {
		return new ArrayList<>();
	}

}

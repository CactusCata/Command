package fr.cactuscata.command.commands;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.utils.CommandValidator;
import fr.cactuscata.command.utils.PrefixMessage;

public abstract class SimpleCommand extends CCommandExecutor {

	private final String[] warnMessages;
	private final PrefixMessage prefix;
	private final SenderType[] senderType;

	protected SimpleCommand(PrefixMessage prefix, SenderType[] senderType, String... warnMessages) {
		this.prefix = prefix;
		this.warnMessages = warnMessages;
		this.senderType = senderType;
	}

	protected SimpleCommand(PrefixMessage prefix, SenderType senderType, String... warnMessages) {
		this(prefix, new SenderType[] { senderType }, warnMessages);
	}

	protected abstract void execute(CommandSender sender, String[] args) throws CommandException;

	@Override
	public void onCommand(CommandSender sender, String[] args) throws CommandException {
		CommandValidator.checkSender(sender, this.senderType);
		if (args.length < this.warnMessages.length)
			throw new CommandException(this.warnMessages[args.length]);
		this.execute(sender, args);
	}

	protected final void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(this.prefix + message);
	}

}

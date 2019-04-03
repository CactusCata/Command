package fr.cactuscata.command.commands.other;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.commands.CommandException;
import fr.cactuscata.command.commands.NotSimpleCommand;
import fr.cactuscata.command.utils.PrefixMessage;

public class ThreeCmd extends NotSimpleCommand implements ExecutableCommand {
	
	public ThreeCmd() {
		super(new ThreeCmdTest());
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		sender.sendMessage(PrefixMessage.PREFIX + "slt !!!!!!");
	}

	@Override
	protected String getTutorialCommand() {

		return null;
	}

}

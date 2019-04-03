package fr.cactuscata.command.commands.other;

import org.bukkit.command.CommandSender;

import fr.cactuscata.command.commands.CommandException;

public interface ExecutableCommand {
	
	public void execute(CommandSender sender, String[] args) throws CommandException;

}

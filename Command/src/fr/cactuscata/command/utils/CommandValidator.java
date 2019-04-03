package fr.cactuscata.command.utils;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cactuscata.command.commands.CCommandExecutor.SenderType;
import fr.cactuscata.command.commands.CommandException;

public class CommandValidator {

	public static final int getInt(String stringInt) throws CommandException {
		try {
			return Integer.parseInt(stringInt);
		} catch (NumberFormatException e) {
			throw new CommandException("Le nombre '" + stringInt + "' n'est pas un nombre entier valide !");
		}
	}

	public static final float getFloat(String stringFloat) throws CommandException {
		try {
			return Float.parseFloat(stringFloat);
		} catch (NumberFormatException e) {
			throw new CommandException("Le nombre '" + stringFloat + "' n'est pas un nombre à virgule valide !");
		}
	}

	public static final void argsSizeIsPresent(String[] args, int index, String message) throws CommandException {
		if (args.length < index)
			throw new CommandException(message);
	}

	public static final Player getPlayerByString(String playerName) {
		return Bukkit.getPlayerExact(playerName);
	}

	public static final void isNull(Object object, String message) throws CommandException {
		if (object == null)
			throw new CommandException(message);
	}

	public static final boolean isCorrect(Player player) {
		return player != null && player.isOnline() && player.hasPlayedBefore();
	}

	public static final void isNotCorrect(Player player, String message) throws CommandException {
		if (!isCorrect(player))
			throw new CommandException(message);
	}

	public static final void isSuperiorTo(Number amount, Number minimum) throws CommandException {
		if (amount.floatValue() > minimum.floatValue())
			throw new CommandException("Le nombre " + amount + " doit être supérieur à " + minimum + " !");
	}

	public static final void isInferiorTo(Number amount, Number maximum) throws CommandException {
		if (amount.floatValue() < maximum.floatValue())
			throw new CommandException("Le nombre " + amount + " doit être inférieur à " + maximum + " !");
	}

	public static final UUID getUUIDByName(String playerName) throws CommandException {
		final UUID uuid = UUIDFetcher.getUUIDOf(playerName);
		if (uuid == null)
			throw new CommandException("Le joueur " + playerName + " n'existe pas !");
		return uuid;
	}

	public static final void is(Object first, Object second, String message) throws CommandException {
		if (first.equals(second))
			throw new CommandException(message);
	}

	public static final void isNot(Object first, Object second, String message) throws CommandException {
		if (!first.equals(second))
			throw new CommandException(message);
	}

	public static final void listIsEmpty(List<?> list, String message) throws CommandException {
		if (list.isEmpty())
			throw new CommandException(message);
	}

	public static final void checkSender(CommandSender sender, SenderType... senderTypes) throws CommandException {
		for (SenderType senderT : senderTypes) {
			if (SenderType.checkSenderTypeIsCorrect(sender, senderT)) {
				return;
			}
		}

		if (senderTypes.length == 1)
			throw new CommandException(
					"Il n'y a que " + senderTypes[0].getSenderName() + " qui peut executer la commande !");
		else {
			String[] args = new String[senderTypes.length];
			for (int i = 0, j = args.length; i < j; i++)
				args[i] = senderTypes[i].getSenderName();
			String sendersNames = StringUtils.join(args, ", ");
			throw new CommandException("Les seuls sender qui peuvent envoyer la commande sont " + sendersNames + " !");
		}

	}

	public static final void toBelongTo(List<String> list, String key, String message) throws CommandException {
		for (String value : list)
			if (key.equals(value))
				return;
		throw new CommandException(message);
	}
}

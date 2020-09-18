package fr.pederobien.minecraftarea.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;

public abstract class CommonCenter<T extends IArea> extends AbstractAreaEdition<T> {

	protected CommonCenter(IMinecraftMessageCode explanation) {
		super(EAreaCommonLabel.CENTER, explanation);
	}

	/**
	 * Method called just after setting the structure's center.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The current structure's name.
	 * @param x      The x-Coordinates of the center.
	 * @param y      The y-Coordinates of the center.
	 * @param z      The z-Coordinates of the center.
	 */
	protected abstract void onCenterDefined(CommandSender sender, String name, int x, int y, int z);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			get().setCenter(args[0], args[1], args[2]);
			onCenterDefined(sender, get().getName(), get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
		} catch (IndexOutOfBoundsException e) {
			// When X or Y or Z is missing
			sendSynchro(sender, ECommonMessageCode.COMMON_MISSING_COORDINATES);
			return false;
		} catch (NumberFormatException e) {
			// When the coordinates are not integer
			sendSynchro(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			// Check if the first argument is an integer
			return check(args[0], e -> isNotStrictInt(e), asList("<X> <Y> <Z>"));
		case 2:
			// Check if the second argument is an integer
			return check(args[1], e -> isNotStrictInt(e), check(args[0], e -> isStrictInt(e), asList("<Y> <Z>")));
		case 3:
			// Check if the third argument is an integer
			return check(args[2], e -> isNotStrictInt(e), check(args[1], e -> isStrictInt(e), asList("<Z>")));
		default:
			return emptyList();
		}
	}
}

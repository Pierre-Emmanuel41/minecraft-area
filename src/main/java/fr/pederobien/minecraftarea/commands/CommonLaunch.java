package fr.pederobien.minecraftarea.commands;

import java.io.FileNotFoundException;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.exceptions.WorldAreaNotFoundException;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftmanagers.WorldManager;

public abstract class CommonLaunch<T extends IArea> extends AbstractAreaEdition<T> {

	public CommonLaunch(IMinecraftMessageCode explanation) {
		super(EAreaCommonLabel.LAUNCH, explanation);
	}

	/**
	 * Method called when no argument has been furnished and no structure is defined.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onNoArea(CommandSender sender);

	/**
	 * Method called when any world name has been furnished.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param world  The given name that correspond to nothing.
	 * 
	 * @see IMinecraftPersistence#load(String)
	 */
	protected abstract void onWorldIsMissing(CommandSender sender, String world);

	/**
	 * Method called when the given name does not refer to any existing structure in the folder of their persistence.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The given name that correspond to nothing.
	 * 
	 * @see IMinecraftPersistence#load(String)
	 */
	protected abstract void onStructureDoesNotExist(CommandSender sender, String name);

	/**
	 * Method called when the structure has been correctly launched.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The structure's name.
	 * @param world  The world's name of structure.
	 * @param x      The x-Coordinates of the structure's center.
	 * @param y      The y-Coordinates of the structure's center.
	 * @param z      The z-Coordinates of the structure's center.
	 */
	protected abstract void onLaunched(CommandSender sender, String name, String world, int x, int y, int z);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		switch (args.length) {
		// Launching the current structure
		case 0:
			if (get() == null) {
				onNoArea(sender);
				return false;
			}
			get().launch();
			onLaunched(sender, get().getName(), get().getWorld().getName(), get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
			return true;
		default:
			return launchAnOtherStructure(sender, command, label, args);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> existingStructures = getPersistence().list();
		List<String> worlds = WorldManager.getWorldNormalisedNames();
		switch (args.length) {
		case 1:
			return filter(existingStructures.stream(), args[0]);
		case 2:
			return filter(check(args[0], e -> existingStructures.contains(e), worlds).stream(), args[args.length - 1]);
		default:
			return filter(check(args[1], e -> worlds.contains(e), checkCoordinates(extract(args, 2))).stream(), args[args.length - 1]);
		}
	}

	private List<String> checkCoordinates(String[] args) {
		switch (args.length) {
		case 1:
			return check(args[0], e -> isNotStrictInt(e), asList("<X> <Y> <Z>"));
		case 2:
			return check(args[1], e -> isNotStrictInt(e), check(args[0], e -> isStrictInt(e), asList("<Y> <Z>")));
		case 3:
			return check(args[2], e -> isNotStrictInt(e), check(args[1], e -> isStrictInt(e), asList("<Z>")));
		default:
			return emptyList();
		}
	}

	private boolean launchAnOtherStructure(CommandSender sender, Command command, String label, String[] args) {
		String name = "";
		String world = "";
		String x = "", y = "", z = "";
		try {
			name = args[0];
			try {
				world = args[1];
			} catch (IndexOutOfBoundsException e) {
				onWorldIsMissing(sender, world);
				return false;
			}
			try {
				x = args[2];
				y = args[3];
				z = args[4];
			} catch (IndexOutOfBoundsException e) {
				sendMessageToSender(sender, ECommonMessageCode.COMMON_MISSING_COORDINATES);
				return false;
			}
			getPersistence().save();
			getPersistence().load(name);
			get().setWorld(world);
			get().setCenter(x, y, z);
			get().launch();
			onLaunched(sender, name, world, get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
		} catch (FileNotFoundException e) {
			onStructureDoesNotExist(sender, name);
			return false;
		} catch (WorldAreaNotFoundException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_WORLD_DOES_NOT_EXIST, world);
			return false;
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
			return false;
		}
		return true;
	}
}

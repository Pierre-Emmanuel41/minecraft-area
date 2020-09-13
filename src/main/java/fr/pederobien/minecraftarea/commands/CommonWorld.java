package fr.pederobien.minecraftarea.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.exceptions.WorldAreaNotFoundException;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftmanagers.WorldManager;

public abstract class CommonWorld<T extends IArea> extends AbstractAreaEdition<T> {

	protected CommonWorld(IMinecraftMessageCode explanation) {
		super(EAreaCommonLabel.WORLD, explanation);
	}

	/**
	 * Method called when no name has been furnished to set the world of the structure.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 */
	protected abstract void onWorldNameIsMissing(CommandSender sender);

	/**
	 * Method called when the world of this structure has been correctly defined.
	 * 
	 * @param sender    The entity (generally a player) to send messages.
	 * @param name      The name of the structure.
	 * @param worldName The name of the world.
	 */
	protected abstract void onWorldDefined(CommandSender sender, String name, String worldName);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name = "";
		try {
			name = args[0];
			get().setWorld(name);
			onWorldDefined(sender, get().getName(), WorldManager.getWorldNameNormalised(get().getWorld()));
		} catch (IndexOutOfBoundsException e) {
			onWorldNameIsMissing(sender);
			return false;
		} catch (WorldAreaNotFoundException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_WORLD_DOES_NOT_EXIST, name);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(WorldManager.getWorldNormalisedNames().stream(), args[0]);
		default:
			return emptyList();
		}
	}
}

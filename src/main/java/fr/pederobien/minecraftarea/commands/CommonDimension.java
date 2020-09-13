package fr.pederobien.minecraftarea.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public abstract class CommonDimension<T extends IArea> extends AbstractAreaEdition<T> {

	protected CommonDimension(IMinecraftMessageCode explanation) {
		super(EAreaLabel.DIMENSION, explanation);
	}

	/**
	 * Method called when the dimension of the world structure have been correctly defined.
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the structure.
	 * @param width  The width of the structure (X).
	 * @param height The height of the structure (Y).
	 * @param depth  The depth of the structure (Z).
	 */
	protected abstract void onDimensionDefined(CommandSender sender, String name, int width, int height, int depth);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			String width = args[0], height = args[1], depth = args[2];
			get().setWidth(getInt(width));
			get().setHeight(getInt(height));
			get().setDepth(getInt(depth));
			onDimensionDefined(sender, get().getName(), get().getWidth(), get().getHeight(), get().getDepth());
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EAreaMessageCode.COMMON_DIMENSION__MISSING_DIMENSION);
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, EAreaMessageCode.COMMON_DIMENSION__BAD_DIMENSION_FORMAT);
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
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

}

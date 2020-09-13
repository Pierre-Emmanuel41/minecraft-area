package fr.pederobien.minecraftarea.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public abstract class CommonExtract<T extends IArea> extends AbstractAreaEdition<T> {

	protected CommonExtract(IMinecraftMessageCode explanation) {
		super(EAreaLabel.EXTRACT, explanation);
	}

	/**
	 * Method called just after the call to the method {@link IArea#extract()}
	 * 
	 * @param sender The entity (generally a player) to send messages.
	 * @param name   The name of the structure.
	 */
	protected abstract void onExtracted(CommandSender sender, String name);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		get().extract();
		onExtracted(sender, get().getName());
		return true;
	}
}

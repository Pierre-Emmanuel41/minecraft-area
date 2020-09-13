package fr.pederobien.minecraftarea.exceptions;

import org.bukkit.World;

import fr.pederobien.minecraftgameplateform.exceptions.SimpleMessageException;

public class WorldAreaNotFoundException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;
	private String worldName;

	/**
	 * Create an exception when there is any {@link World} associated to the given name.
	 * 
	 * @param worldName The world's name that correspond to any world.
	 */
	public WorldAreaNotFoundException(String worldName) {
		super("The world " + worldName + " does not exist");
		this.worldName = worldName;
	}

	/**
	 * @return The name that correspond to any world.
	 */
	public String getName() {
		return worldName;
	}
}

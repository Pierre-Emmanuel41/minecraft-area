package fr.pederobien.minecraftarea.exceptions;

import fr.pederobien.minecraftgameplateform.exceptions.SimpleMessageException;

public class DimensionAreaException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;

	/**
	 * Exception thrown when a dimension (width, height or depth) is less than 1 block.
	 * 
	 * @param dimension The dimension that is less than 1 block.
	 * @param size      The size before change.
	 */
	public DimensionAreaException(String dimension, int size) {
		super("The " + dimension + " has to be greater than or equal to 1 (curent:" + size + ")");
	}

}

package fr.pederobien.minecraftarea.interfaces;

import org.bukkit.block.data.BlockData;

public interface IAreaBlock {

	/**
	 * @return The data associated to the block. This data is used to be saved and launched.
	 */
	BlockData getBlockData();

	/**
	 * @return The x-Coordinates of this block. This coordinate is relative to the center of the world structure.
	 */
	int getX();

	/**
	 * @return The y-Coordinates of this block. This coordinate is relative to the center of the world structure.
	 */
	int getY();

	/**
	 * @return The z-Coordinates of this block. This coordinate is relative to the center of the world structure.
	 */
	int getZ();
}

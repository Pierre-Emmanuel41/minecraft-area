package fr.pederobien.minecraftarea.interfaces;

import java.util.List;

import org.bukkit.World;
import org.bukkit.block.Block;

import fr.pederobien.minecraftarea.exceptions.DimensionAreaException;
import fr.pederobien.minecraftarea.exceptions.WorldAreaNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IPlateformCodeSender;
import fr.pederobien.minecraftgameplateform.interfaces.element.IEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.INominable;

public interface IArea extends INominable, IPlateformCodeSender {

	/**
	 * @return The world in which this structure should be launched or extracted.
	 */
	World getWorld();

	/**
	 * Set the world in which the structure should be launched or extracted.
	 * 
	 * @param worldName The name of the world in which this structure should be launched or extracted.
	 * 
	 * @throws WorldAreaNotFoundException If the given name correspond to any world.
	 */
	void setWorld(String worldName);

	/**
	 * @return The center associated to this structure.
	 */
	Block getCenter();

	/**
	 * Set the center of this structure. The center correspond to the block with the following characteristics: It is at the bottom of
	 * the structure, with center x-Coordinates and z-Coordinates. Let's take a structure like this:<br>
	 * X variations : [17;52]<br>
	 * Y variations : [42;99]<br>
	 * Z variations : [-48;11]<br>
	 * <br>
	 * The center's coordinates are : {(52-17+1)/2=18, 42, (11-(-48)+1)/2=30}
	 * 
	 * @param x The x-Coordinates of the center.
	 * @param y The y-Coordinates of the center.
	 * @param z The z-Coordinates of the center.
	 */
	void setCenter(String x, String y, String z);

	/**
	 * @return The width of this structure. This is x-Coordinates variations.
	 */
	int getWidth();

	/**
	 * Set the width of this structure. The new value of the width has to be greater than or equal to 1. If the value is correct, the
	 * list of blocks of this structure is reset.
	 * 
	 * @param width The new width of this structure.
	 * 
	 * @see #getBlocks()
	 * @see #extract()
	 * 
	 * @throws DimensionAreaException If the width is strictly less than 1.
	 */
	void setWidth(int width);

	/**
	 * @return The height of this structure. This is y-Coordinates variations.
	 */
	int getHeight();

	/**
	 * Set the height of this structure. The new value of the height has to be greater than or equal to 1. If the value is correct,
	 * the list of blocks of this structure is reset.
	 * 
	 * @param height The new height of this structure.
	 * 
	 * @see #getBlocks()
	 * @see #extract()
	 * 
	 * @throws DimensionAreaException If the height is strictly less than 1.
	 */
	void setHeight(int height);

	/**
	 * @return The depth of this structure. This is z-Coordinates variations.
	 */
	int getDepth();

	/**
	 * Set the depth of this structure. The new value of the depth has to be greater than or equal to 1. If the value is correct, the
	 * list of blocks of this structure is reset.
	 * 
	 * @param depth The new depth of this structure.
	 * 
	 * @see #getBlocks()
	 * @see #extract()
	 * 
	 * @throws DimensionAreaException If the depth is strictly less than 1.
	 */
	void setDepth(int depth);

	/**
	 * @return The list of blocks for this structure. If neither the method launch nor the method extract has been called, then the
	 *         list is empty.
	 */
	List<IAreaBlock> getBlocks();

	/**
	 * Set the list of blocks for this structure. This method should be only called when loading from file.
	 * 
	 * @param blocks The list of blocks that compose this world structure.
	 */
	void setBlocks(List<IAreaBlock> blocks);

	/**
	 * The center, the width, the height and the depth defines a virtual empty structure. This method get all block from the world
	 * relative to the center coordinates to fill this empty structure. Let's take a structure with following properties : <br>
	 * <br>
	 * Center : X=50, Y=100, Z=150 <br>
	 * Width=20, Height=30, Depth=40<br>
	 * <br>
	 * This method extract block using the following way :<br>
	 * X : from (50 - width/2) to (50 + width/2)<br>
	 * Y : from 100 to (100 + height)<br>
	 * Z : from (150 - depth/2) to (150 + depth/2)<br>
	 */
	void extract();

	/**
	 * Launch the structure on the world. Before launching, this method register the original blocks.
	 * 
	 * @see #remove()
	 */
	void launch();

	/**
	 * Remove the structure from the world. If the structure just has been created, then each block from the structure is replaced by
	 * a block of air. If the structure has been launched, then each block is replaced by the former block that used to be at the same
	 * coordinates.
	 * 
	 * @see #launch()
	 */
	void remove();

	/**
	 * @return The listener that interact with minecraft events.
	 */
	IEventListener getListener();

	/**
	 * @return True if this structure is removed from the world, false otherwise.
	 */
	boolean isRemoved();
}

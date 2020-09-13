package fr.pederobien.minecraftarea.commands.area;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;

public class AreaEditionFactory {

	/**
	 * @return An edition to create a new area.
	 */
	public static IMapPersistenceEdition<IArea> newArea() {
		return new NewArea();
	}

	/**
	 * @return An edition to define the area's world.
	 */
	public static IMapPersistenceEdition<IArea> worldArea() {
		return new WorldArea();
	}

	/**
	 * @return An edition to define the area's center.
	 */
	public static IMapPersistenceEdition<IArea> centerArea() {
		return new CenterArea();
	}

	/**
	 * @return An edition to set the area's dimension.
	 */
	public static IMapPersistenceEdition<IArea> dimensionArea() {
		return new DimensionArea();
	}

	/**
	 * @return An edition to rename a area.
	 */
	public static IMapPersistenceEdition<IArea> renameArea() {
		return new RenameArea();
	}

	/**
	 * @return An edition to save a area.
	 */
	public static IMapPersistenceEdition<IArea> saveArea() {
		return new SaveArea();
	}

	/**
	 * @return An edition to display each existing area's name.
	 */
	public static IMapPersistenceEdition<IArea> listArea() {
		return new ListArea();
	}

	/**
	 * @return An edition to delete area file.
	 */
	public static IMapPersistenceEdition<IArea> deleteArea() {
		return new DeleteArea();
	}

	/**
	 * @return An edition to extract blocks associated to the area dimensions.
	 */
	public static IMapPersistenceEdition<IArea> extractArea() {
		return new ExtractArea();
	}

	/**
	 * @return An edition to remove a area.
	 */
	public static IMapPersistenceEdition<IArea> removeArea() {
		return new RemoveArea();
	}

	/**
	 * @return An edition to launch a area in the world.
	 */
	public static IMapPersistenceEdition<IArea> launchArea() {
		return new LaunchArea();
	}

	/**
	 * @return An edition to display current area's characteristics.
	 */
	public static IMapPersistenceEdition<IArea> detailsArea() {
		return new DetailsArea();
	}
}

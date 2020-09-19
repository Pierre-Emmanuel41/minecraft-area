package fr.pederobien.minecraftarea.commands;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractCommonParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;

public abstract class AbstractAreaPersistenceEdition<T extends IArea> extends AbstractCommonParentPersistenceEdition<T> {

	public AbstractAreaPersistenceEdition(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(getWorldEdition());
		addEdition(getCenterEdition());
		addEdition(getDimensionEdition());
		addEdition(getExtractEdition());
		addEdition(getLaunchEdition().setModifiable(false));
		addEdition(getRemoveEdition());
	}

	// Specific to area management

	/**
	 * The returned edition should extends {@link CommonWorld} for more security.
	 * 
	 * @return An edition to define the area's world.
	 */
	protected abstract IMapPersistenceEdition<T> getWorldEdition();

	/**
	 * The returned edition should extends {@link CommonCenter} for more security.
	 * 
	 * @return An edition to define the area center.
	 */
	protected abstract IMapPersistenceEdition<T> getCenterEdition();

	/**
	 * The returned edition should extends {@link CommonDimension} for more security.
	 * 
	 * @return An edition to set the area's dimension.
	 */
	protected abstract IMapPersistenceEdition<T> getDimensionEdition();

	/**
	 * The returned edition should extends {@link CommonExtract} for more security.
	 * 
	 * @return An edition to extract blocks associated to the area dimensions.
	 */
	protected abstract IMapPersistenceEdition<T> getExtractEdition();

	/**
	 * The return edition should extends {@link CommonLaunch} for more security.
	 * 
	 * @return An edition to launch an area in the world.
	 */
	protected abstract IMapPersistenceEdition<T> getLaunchEdition();

	/**
	 * @return An edition to remove the area from its world.
	 */
	protected abstract IMapPersistenceEdition<T> getRemoveEdition();
}

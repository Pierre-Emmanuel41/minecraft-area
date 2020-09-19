package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftarea.commands.AbstractAreaPersistenceEdition;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftarea.persistence.AreaPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;

public class AreaParent extends AbstractAreaPersistenceEdition<IArea> {

	public AreaParent(Plugin plugin) {
		super("area", EAreaMessageCode.AREA__EXPLANATION, plugin, AreaPersistence.getInstance());
	}

	@Override
	protected IMapPersistenceEdition<IArea> getWorldEdition() {
		return AreaEditionFactory.worldArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getCenterEdition() {
		return AreaEditionFactory.centerArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getDimensionEdition() {
		return AreaEditionFactory.dimensionArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getExtractEdition() {
		return AreaEditionFactory.extractArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getLaunchEdition() {
		return AreaEditionFactory.launchArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getRemoveEdition() {
		return AreaEditionFactory.removeArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getNewEdition() {
		return AreaEditionFactory.newArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getRenameEdition() {
		return AreaEditionFactory.renameArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getSaveEdition() {
		return AreaEditionFactory.saveArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getListEdition() {
		return AreaEditionFactory.listArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getDeleteEdition() {
		return AreaEditionFactory.deleteArea();
	}

	@Override
	protected IMapPersistenceEdition<IArea> getDetailsEdition() {
		return AreaEditionFactory.detailsArea();
	}
}

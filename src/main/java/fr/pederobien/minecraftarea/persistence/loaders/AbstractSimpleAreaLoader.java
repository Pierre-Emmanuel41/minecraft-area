package fr.pederobien.minecraftarea.persistence.loaders;

import fr.pederobien.minecraftarea.SimpleArea;
import fr.pederobien.minecraftarea.interfaces.IArea;

public abstract class AbstractSimpleAreaLoader extends AbstractAreaLoader<IArea> {

	protected AbstractSimpleAreaLoader(Double version) {
		super(version);
	}

	@Override
	protected IArea create() {
		return new SimpleArea("DefaultArea");
	}
}

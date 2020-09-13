package fr.pederobien.minecraftarea;

import fr.pederobien.minecraftarea.impl.AbstractArea;
import fr.pederobien.minecraftgameplateform.impl.element.EventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.IEventListener;

public class SimpleArea extends AbstractArea {

	/**
	 * Create a simple area to load or save minecraft blocks.
	 * 
	 * @param name The name of this area.
	 */
	public SimpleArea(String name) {
		super(name);
	}

	@Override
	public IEventListener getListener() {
		return new EventListener();
	}
}

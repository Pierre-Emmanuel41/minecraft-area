package fr.pederobien.minecraftarea;

import java.util.StringJoiner;

import fr.pederobien.minecraftarea.impl.AbstractArea;
import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;
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

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add("Name : " + getName());
		joiner.add("World : " + display(world, getWorld().getName()));
		joiner.add("Center : " + display(center, DisplayHelper.toString(getCenter())));
		joiner.add("Width : " + display(width, getWidth() + " blocks"));
		joiner.add("Height : " + display(height, getHeight() + " blocks"));
		joiner.add("Depth : " + display(depth, getDepth() + " blocks"));
		return joiner.toString();
	}

	private String display(Object object, String display) {
		return display.concat(object == null ? " (default value)" : "");
	}
}

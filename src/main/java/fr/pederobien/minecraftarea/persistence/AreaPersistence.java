package fr.pederobien.minecraftarea.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.minecraftarea.SimpleArea;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftarea.interfaces.IAreaBlock;
import fr.pederobien.minecraftarea.persistence.loaders.SimpleAreaLoaderV10;
import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class AreaPersistence extends AbstractMinecraftPersistence<IArea> {
	private static final String ROOT_XML_DOCUMENT = "spawn";

	private AreaPersistence() {
		super(Plateform.ROOT.resolve("Areas"), "DefaultArea");
		register(new SimpleAreaLoaderV10());
	}

	public static IMinecraftPersistence<IArea> getInstance() {
		return SingletonHolder.PERSISTENCE;
	}

	private static class SingletonHolder {
		public static final IMinecraftPersistence<IArea> PERSISTENCE = new AreaPersistence();
	}

	@Override
	public void saveDefault() {
		set(new SimpleArea("DefaultArea"));
		save();
	}

	@Override
	public boolean save() {
		if (get() == null)
			return false;
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = createElement(doc, ROOT_XML_DOCUMENT);
		doc.appendChild(root);

		Element version = createElement(doc, VERSION);
		version.appendChild(doc.createTextNode("" + getVersion()));
		root.appendChild(version);

		Element name = createElement(doc, AreaXmlTag.NAME);
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

		Element world = createElement(doc, AreaXmlTag.WORLD);
		world.appendChild(doc.createTextNode(get().getWorld().getName()));
		root.appendChild(world);

		Element dimensions = createElement(doc, AreaXmlTag.DIMENSIONS);
		setAttribute(dimensions, AreaXmlTag.WIDTH, get().getWidth());
		setAttribute(dimensions, AreaXmlTag.HEIGHT, get().getHeight());
		setAttribute(dimensions, AreaXmlTag.DEPTH, get().getDepth());
		root.appendChild(dimensions);

		Element center = createElement(doc, AreaXmlTag.CENTER);
		addCoordinates(center, get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
		root.appendChild(center);

		Element blocks = createElement(doc, AreaXmlTag.BLOCKS);
		for (IAreaBlock b : get().getBlocks()) {
			Element block = createElement(doc, AreaXmlTag.BLOCK);
			addCoordinates(block, b.getX(), b.getY(), b.getZ());
			setAttribute(block, AreaXmlTag.BLOCK_DATA, b.getBlockData().getAsString());
			blocks.appendChild(block);
		}
		root.appendChild(blocks);

		saveDocument(doc, get().getName());
		return true;
	}

	private void addCoordinates(Element element, Object xCoordinate, Object yCoordinate, Object zCoordinate) {
		setAttribute(element, AreaXmlTag.X_COORDINATES, xCoordinate);
		setAttribute(element, AreaXmlTag.Y_COORDINATES, yCoordinate);
		setAttribute(element, AreaXmlTag.Z_COORDINATES, zCoordinate);
	}
}

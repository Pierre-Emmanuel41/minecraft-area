package fr.pederobien.minecraftarea.persistence.loaders;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.pederobien.minecraftarea.impl.AreaBlock;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftarea.interfaces.IAreaBlock;
import fr.pederobien.minecraftarea.persistence.AreaXmlTag;
import fr.pederobien.persistence.interfaces.xml.IXmlPersistenceLoader;

public class SimpleAreaLoaderV10 extends AbstractSimpleAreaLoader {

	public SimpleAreaLoaderV10() {
		super(1.0);
	}

	@Override
	public IXmlPersistenceLoader<IArea> load(Element root) {
		createNewElement();

		// Getting the spawn's name
		Node name = getElementsByTagName(root, AreaXmlTag.NAME).item(0);
		get().setName(name.getChildNodes().item(0).getNodeValue());

		// Getting the spawn's world
		Node world = getElementsByTagName(root, AreaXmlTag.WORLD).item(0);
		get().setWorld(world.getChildNodes().item(0).getNodeValue());

		// Getting the dimensions of the spawn
		Element dimensions = (Element) getElementsByTagName(root, AreaXmlTag.DIMENSIONS).item(0);
		get().setWidth(getIntAttribute(dimensions, AreaXmlTag.WIDTH));
		get().setHeight(getIntAttribute(dimensions, AreaXmlTag.HEIGHT));
		get().setDepth(getIntAttribute(dimensions, AreaXmlTag.DEPTH));

		// Getting the spawn's center
		Element center = (Element) getElementsByTagName(root, AreaXmlTag.CENTER).item(0);
		get().setCenter(getXCoordinates(center), getYCoordinates(center), getZCoordinates(center));

		// Getting spawn's blocks
		NodeList blocks = getElementsByTagName(root, AreaXmlTag.BLOCK);
		List<IAreaBlock> spawnBlocks = new ArrayList<IAreaBlock>();
		for (int i = 0; i < blocks.getLength(); i++) {
			Element block = (Element) blocks.item(i);
			spawnBlocks.add(new AreaBlock(getXCoordinates(block), getYCoordinates(block), getZCoordinates(block), getStringAttribute(block, AreaXmlTag.BLOCK_DATA)));
		}
		get().setBlocks(spawnBlocks);
		return this;
	}
}

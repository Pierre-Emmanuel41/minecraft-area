package fr.pederobien.minecraftarea.persistence.loaders;

import org.w3c.dom.Element;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftarea.persistence.AreaXmlTag;
import fr.pederobien.persistence.impl.xml.AbstractXmlPersistenceLoader;
import fr.pederobien.persistence.interfaces.xml.IXmlPersistenceLoader;

public abstract class AbstractAreaLoader<T extends IArea> extends AbstractXmlPersistenceLoader<T> implements IXmlPersistenceLoader<T> {

	protected AbstractAreaLoader(Double version) {
		super(version);
	}

	/**
	 * Get the value associated to the tag attribute "x" of the given element using tag {@link AreaXmlTag#X_COORDINATES}
	 * 
	 * @param element The element that contains this attribute.
	 * @return The value associated to the attribute tag X_COORDINATES.
	 */
	protected String getXCoordinates(Element element) {
		return getStringAttribute(element, AreaXmlTag.X_COORDINATES);
	}

	/**
	 * Get the value associated to the tag attribute "y" of the given element using tag {@link AreaXmlTag#Y_COORDINATES}
	 * 
	 * @param element The element that contains this attribute.
	 * @return The value associated to the attribute tag Y_COORDINATES.
	 */
	protected String getYCoordinates(Element element) {
		return getStringAttribute(element, AreaXmlTag.Y_COORDINATES);
	}

	/**
	 * Get the value associated to the tag attribute "z" of the given element using tag {@link AreaXmlTag#Z_COORDINATES}
	 * 
	 * @param element The element that contains this attribute.
	 * @return The value associated to the attribute tag Z_COORDINATES.
	 */
	protected String getZCoordinates(Element element) {
		return getStringAttribute(element, AreaXmlTag.Z_COORDINATES);
	}
}

package fr.pederobien.minecraftarea.commands;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public class AbstractAreaEdition<T extends IArea> extends AbstractLabelEdition<T> {

	protected AbstractAreaEdition(ILabel label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}
}

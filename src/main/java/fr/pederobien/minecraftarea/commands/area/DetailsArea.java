package fr.pederobien.minecraftarea.commands.area;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.common.CommonDetails;

public class DetailsArea extends CommonDetails<IArea> {

	protected DetailsArea() {
		super(EAreaMessageCode.DETAILS_AREA__EXPLANATION, EAreaMessageCode.DETAILS_AREA__ON_DETAILS);
	}
}

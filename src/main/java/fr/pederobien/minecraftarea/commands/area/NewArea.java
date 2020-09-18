package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.SimpleArea;
import fr.pederobien.minecraftarea.commands.EAreaCommonLabel;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.common.CommonNew;
import fr.pederobien.minecraftgameplateform.commands.common.ECommonLabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public class NewArea extends CommonNew<IArea> {

	protected NewArea() {
		super(EAreaMessageCode.NEW_AREA__EXPLANATION);
	}

	@Override
	protected void onNameAlreadyTaken(CommandSender sender, String name) {
		sendSynchro(sender, EAreaMessageCode.NEW_AREA__NAME_ALREADY_TAKEN, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendSynchro(sender, EAreaMessageCode.NEW_AREA__NAME_IS_MISSING);
	}

	@Override
	protected IArea create(String name) {
		return new SimpleArea(name);
	}

	@Override
	protected void onCreated(CommandSender sender, String name) {
		sendSynchro(sender, EAreaMessageCode.NEW_AREA__AREA_CREATED, name);
		setAllAvailable();
	}

	private void setAllAvailable() {
		for (ILabel label : ECommonLabel.values())
			setAvailableLabelEdition(label);
		for (ILabel label : EAreaCommonLabel.values())
			setAvailableLabelEdition(label);
	}
}

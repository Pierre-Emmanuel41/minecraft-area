package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.common.CommonSave;

public class SaveArea extends CommonSave<IArea> {

	protected SaveArea() {
		super(EAreaMessageCode.SAVE_AREA__EXPLANATION);
	}

	@Override
	protected void onSave(CommandSender sender, String name) {
		sendSynchro(sender, EAreaMessageCode.SAVE_AREA__AREA_SAVED, name);
	}
}

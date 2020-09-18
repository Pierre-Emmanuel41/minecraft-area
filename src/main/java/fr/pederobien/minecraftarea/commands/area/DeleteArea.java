package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.common.CommonDelete;

public class DeleteArea extends CommonDelete<IArea> {

	protected DeleteArea() {
		super(EAreaMessageCode.DELETE_AREA__EXPLANATION);
	}

	@Override
	protected void onDidNotDelete(CommandSender sender, String name) {
		sendSynchro(sender, EAreaMessageCode.DELETE_AREA__DIT_NOT_DELETE, name);
	}

	@Override
	protected void onDeleted(CommandSender sender, String name) {
		sendSynchro(sender, EAreaMessageCode.DELETE_AREA__AREA_DELETED, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendSynchro(sender, EAreaMessageCode.DELETE_AREA__NAME_IS_MISSING);
	}
}

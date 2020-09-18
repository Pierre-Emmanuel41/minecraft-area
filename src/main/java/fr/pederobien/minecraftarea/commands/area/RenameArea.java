package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.common.CommonRename;

public class RenameArea extends CommonRename<IArea> {

	protected RenameArea() {
		super(EAreaMessageCode.RENAME_AREA__EXPLANATION);
	}

	@Override
	protected void onNameAlreadyTaken(CommandSender sender, String currentName, String newName) {
		sendSynchro(sender, EAreaMessageCode.RENAME_AREA__NAME_ALREADY_TAKEN, currentName, newName);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender, String oldName) {
		sendSynchro(sender, EAreaMessageCode.RENAME_AREA__NAME_IS_MISSING, oldName);
	}

	@Override
	protected void onRenamed(CommandSender sender, String oldName, String newName) {
		sendSynchro(sender, EAreaMessageCode.RENAME_AREA__AREA_RENAMED, oldName, newName);
	}
}

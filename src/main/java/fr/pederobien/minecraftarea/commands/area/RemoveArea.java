package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonRemove;
import fr.pederobien.minecraftarea.interfaces.IArea;

public class RemoveArea extends CommonRemove<IArea> {

	protected RemoveArea() {
		super(EAreaMessageCode.REMOVE_AREA__EXPLANATION);
	}

	@Override
	protected void onRemoved(CommandSender sender, String name, String world) {
		sendSynchro(sender, EAreaMessageCode.REMOVE_AREA__AREA_REMOVED, name, world);
	}
}

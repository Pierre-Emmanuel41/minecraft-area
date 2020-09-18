package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonWorld;
import fr.pederobien.minecraftarea.interfaces.IArea;

public class WorldArea extends CommonWorld<IArea> {

	protected WorldArea() {
		super(EAreaMessageCode.WORLD_AREA__EXPLANATION);
	}

	@Override
	protected void onWorldNameIsMissing(CommandSender sender) {
		sendSynchro(sender, EAreaMessageCode.WORLD_AREA__WORLD_NAME_IS_MISSING);
	}

	@Override
	protected void onWorldDefined(CommandSender sender, String name, String worldName) {
		sendSynchro(sender, EAreaMessageCode.WORLD_AREA__WORLD_DEFINED, name, worldName);
	}
}

package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonCenter;
import fr.pederobien.minecraftarea.interfaces.IArea;

public class CenterArea extends CommonCenter<IArea> {

	public CenterArea() {
		super(EAreaMessageCode.CENTER_AREA__EXPLANATION);
	}

	@Override
	protected void onCenterDefined(CommandSender sender, String name, int x, int y, int z) {
		sendSynchro(sender, EAreaMessageCode.CENTER_AREA__CENTER_DEFINED, name, x, y, z);
	}
}

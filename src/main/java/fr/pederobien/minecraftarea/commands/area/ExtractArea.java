package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonExtract;
import fr.pederobien.minecraftarea.interfaces.IArea;

public class ExtractArea extends CommonExtract<IArea> {

	protected ExtractArea() {
		super(EAreaMessageCode.EXTRACT_AREA__EXPLANATION);
	}

	@Override
	protected void onExtracted(CommandSender sender, String name) {
		sendSynchro(sender, EAreaMessageCode.EXTRACT_AREA__AREA_EXTRACTED, name);
	}
}

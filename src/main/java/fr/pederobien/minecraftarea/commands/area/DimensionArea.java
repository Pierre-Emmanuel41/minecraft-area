package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonDimension;
import fr.pederobien.minecraftarea.interfaces.IArea;

public class DimensionArea extends CommonDimension<IArea> {

	protected DimensionArea() {
		super(EAreaMessageCode.DIMENSION_AREA__EXPLANATION);
	}

	@Override
	protected void onDimensionDefined(CommandSender sender, String name, int width, int height, int depth) {
		sendSynchro(sender, EAreaMessageCode.DIMENSION_AREA__DEFINED, name, width, height, depth);
	}
}

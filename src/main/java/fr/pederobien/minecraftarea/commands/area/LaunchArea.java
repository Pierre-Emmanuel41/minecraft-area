package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.commands.CommonLaunch;
import fr.pederobien.minecraftarea.commands.EAreaCommonLabel;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.common.ECommonLabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public class LaunchArea extends CommonLaunch<IArea> {

	public LaunchArea() {
		super(EAreaMessageCode.LAUNCH_AREA__EXPLANATION);
	}

	@Override
	protected void onNoArea(CommandSender sender) {
		sendSynchro(sender, EAreaMessageCode.LAUNCH_AREA__NO_CURRENT_AREA);
	}

	@Override
	protected void onWorldIsMissing(CommandSender sender, String world) {
		sendSynchro(sender, EAreaMessageCode.LAUNCH_AREA__WORLD_IS_MISSING, world);
	}

	@Override
	protected void onStructureDoesNotExist(CommandSender sender, String name) {
		sendSynchro(sender, EAreaMessageCode.LAUNCH_AREA__AREA_DOES_NOT_EXIST, name);
	}

	@Override
	protected void onLaunched(CommandSender sender, String name, String world, int x, int y, int z) {
		sendSynchro(sender, EAreaMessageCode.LAUNCH_AREA__AREA_LAUNCHED, name, world, x, y, z);
		get().getListener().register(getParent().getPlugin());
		get().getListener().setActivated(true);
		setAllAvailable();
	}

	private void setAllAvailable() {
		for (ILabel label : ECommonLabel.values())
			setAvailableLabelEdition(label);
		for (ILabel label : EAreaCommonLabel.values())
			setAvailableLabelEdition(label);
	}
}

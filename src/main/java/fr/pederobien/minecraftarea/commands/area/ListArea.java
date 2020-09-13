package fr.pederobien.minecraftarea.commands.area;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.common.CommonList;

public class ListArea extends CommonList<IArea> {

	protected ListArea() {
		super(EAreaMessageCode.LIST_AREA__EXPLANATION);
	}

	@Override
	protected void onNoElement(CommandSender sender) {
		sendMessageToSender(sender, EAreaMessageCode.LIST_AREA__NO_ELEMENT);
	}

	@Override
	protected void onOneElement(CommandSender sender, String name) {
		sendMessageToSender(sender, EAreaMessageCode.LIST_AREA__ONE_ELEMENT, name);
	}

	@Override
	protected void onSeveralElement(CommandSender sender, String names) {
		sendMessageToSender(sender, EAreaMessageCode.LIST_AREA__SEVERAL_ELEMENTS, names);
	}
}

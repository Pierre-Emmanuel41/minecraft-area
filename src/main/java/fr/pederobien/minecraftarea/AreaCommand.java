package fr.pederobien.minecraftarea;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftarea.commands.area.AreaParent;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.commands.AbstractParentCommand;

public class AreaCommand extends AbstractParentCommand<IArea> {

	protected AreaCommand(JavaPlugin plugin) {
		super(plugin, new AreaParent(plugin));
	}
}

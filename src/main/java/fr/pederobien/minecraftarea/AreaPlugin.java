package fr.pederobien.minecraftarea;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraftarea.interfaces.IArea;
import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class AreaPlugin extends JavaPlugin {
	private static Plugin plugin;
	private static IParentCommand<IArea> areaCommand;

	/**
	 * @return The plugin associated to this area plugin.
	 */
	public static Plugin get() {
		return plugin;
	}

	/**
	 * @return The current area for this plugin.
	 */
	public static IArea getCurrentArea() {
		return areaCommand.getParent().get();
	}

	@Override
	public void onEnable() {
		Plateform.getPluginHelper().register(this);
		plugin = this;

		areaCommand = new AreaCommand(this);

		registerDictionaries();
	}

	private void registerDictionaries() {
		// Registering French dictionaries
		registerDictionary("French", "CommonArea.xml", "Area.xml");

		// Registering English dictionaries
		registerDictionary("English", "CommonArea.xml", "Area.xml");
	}

	private void registerDictionary(String parent, String... dictionaryNames) {
		Path jarPath = Plateform.ROOT.getParent().resolve(getName().concat(".jar"));
		String dictionariesFolder = "resources/dictionaries/".concat(parent).concat("/");
		for (String name : dictionaryNames)
			registerDictionary(Plateform.getDefaultDictionaryParser(dictionariesFolder.concat(name)), jarPath);
	}

	private void registerDictionary(IDictionaryParser parser, Path jarPath) {
		try {
			Plateform.getNotificationCenter().getDictionaryContext().register(parser, jarPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

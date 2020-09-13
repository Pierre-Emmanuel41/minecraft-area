package fr.pederobien.minecraftarea.commands;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum EAreaLabel implements ILabel {
	CENTER("center"), DIMENSION("dimension"), EXTRACT("extract"), LAUNCH("launch"), REMOVE("remove"), WORLD("world");

	private String label;

	private EAreaLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}

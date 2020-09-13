package fr.pederobien.minecraftarea.persistence;

public enum AreaXmlTag {
	NAME("name"), WORLD("world"), DIMENSIONS("dimensions"), WIDTH("width"), HEIGHT("height"), DEPTH("depth"), CENTER("center"), X_COORDINATES("x"), Y_COORDINATES("y"),
	Z_COORDINATES("z"), BLOCKS("blocks"), BLOCK("block"), BLOCK_DATA("blockdata");

	private String name;

	private AreaXmlTag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

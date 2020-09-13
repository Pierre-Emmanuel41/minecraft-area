package fr.pederobien.minecraftarea.commands.area;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EAreaMessageCode implements IMinecraftMessageCode {
	// Code for command area

	// Code for command new
	NEW_AREA__EXPLANATION, NEW_AREA__NAME_IS_MISSING, NEW_AREA__NAME_ALREADY_TAKEN, NEW_AREA__AREA_CREATED;

	private Permission permission;

	private EAreaMessageCode() {
		this(Permission.OPERATORS);
	}

	private EAreaMessageCode(Permission permission) {
		this.permission = permission;
	}

	@Override
	public String value() {
		return toString();
	}

	@Override
	public Permission getPermission() {
		return permission;
	}

	@Override
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}

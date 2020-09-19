package fr.pederobien.minecraftarea.commands;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EAreaCommonMessageCode implements IMinecraftMessageCode {
	// Code for command dimension
	COMMON_DIMENSION__MISSING_DIMENSION, COMMON_DIMENSION__BAD_DIMENSION_FORMAT,

	// Code for command launch
	COMMON_START_LAUNCH(Permission.OPERATORS), COMMON_LAUNCH_PROGRESS(Permission.OPERATORS),

	// Code for command extract
	COMMON_START_EXTRACT(Permission.OPERATORS), COMMON_EXTRACT_PROGRESS(Permission.OPERATORS),

	// Code for command remove
	COMMON_START_REMOVE(Permission.OPERATORS), COMMON_REMOVE_PROGRESS(Permission.OPERATORS);

	private Permission permission;

	private EAreaCommonMessageCode() {
		this(Permission.OPERATORS);
	}

	private EAreaCommonMessageCode(Permission permission) {
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

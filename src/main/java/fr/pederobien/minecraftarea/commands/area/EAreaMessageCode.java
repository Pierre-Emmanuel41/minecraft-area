package fr.pederobien.minecraftarea.commands.area;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EAreaMessageCode implements IMinecraftMessageCode {
	// Code for command area

	// Code for command new
	NEW_AREA__EXPLANATION, NEW_AREA__NAME_IS_MISSING, NEW_AREA__NAME_ALREADY_TAKEN, NEW_AREA__AREA_CREATED,

	// Code for command world
	WORLD_AREA__EXPLANATION, WORLD_AREA__WORLD_NAME_IS_MISSING, WORLD_AREA__WORLD_DEFINED,

	// Code for command center
	CENTER_AREA__EXPLANATION, CENTER_AREA__CENTER_DEFINED,

	// Code for command dimension
	DIMENSION_AREA__EXPLANATION, DIMENSION_AREA__DEFINED,

	// Code for command rename
	RENAME_AREA__EXPLANATION, RENAME_AREA__NAME_IS_MISSING, RENAME_AREA__NAME_ALREADY_TAKEN, RENAME_AREA__AREA_RENAMED,

	// Code for command save
	SAVE_AREA__EXPLANATION, SAVE_AREA__AREA_SAVED,

	// Code for command list
	LIST_AREA__EXPLANATION, LIST_AREA__NO_ELEMENT, LIST_AREA__ONE_ELEMENT, LIST_AREA__SEVERAL_ELEMENTS,

	// Code for command delete
	DELETE_AREA__EXPLANATION, DELETE_AREA__NAME_IS_MISSING, DELETE_AREA__DIT_NOT_DELETE, DELETE_AREA__AREA_DELETED,

	// Code for command extract
	EXTRACT_AREA__EXPLANATION, EXTRACT_AREA__AREA_EXTRACTED,

	// Code for command remove
	REMOVE_AREA__EXPLANATION, REMOVE_AREA__AREA_REMOVED;

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

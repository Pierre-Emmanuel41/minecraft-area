package fr.pederobien.minecraftarea.impl;

import org.bukkit.block.data.BlockData;

import fr.pederobien.minecraftarea.interfaces.IAreaBlock;
import fr.pederobien.minecraftmanagers.BukkitManager;

public class AreaBlock implements IAreaBlock {
	private int x, y, z;
	private BlockData blockData;

	public AreaBlock(int x, int y, int z, BlockData blockData) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockData = blockData;
	}

	public AreaBlock(String x, String y, String z, String blockData) {
		this(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z), blockData == null ? null : BukkitManager.createBlockData(blockData));
	}

	@Override
	public BlockData getBlockData() {
		return blockData;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getZ() {
		return z;
	}
}

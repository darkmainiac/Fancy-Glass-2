package com.darkmainiac.fancyglass.item;

import com.darkmainiac.fancyglass.block.ModBlocks;
import com.darkmainiac.fancyglass.lib.Strings;

import net.minecraft.item.ItemMultiTextureTile;

public class ItemGlassBrickBlock extends ItemMultiTextureTile{
	
	public ItemGlassBrickBlock(int id)
	{
		super(id, ModBlocks.glassBrick, Strings.GLASS_BRICK_SUBTYPE_NAMES);
	}

}

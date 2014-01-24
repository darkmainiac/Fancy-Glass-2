package com.darkmainiac.fancyglass.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.darkmainiac.fancyglass.item.ItemGlassBrickBlock;
import com.darkmainiac.fancyglass.lib.BlockIds;
import com.darkmainiac.fancyglass.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {
	
	public static BlockFancyGlass glassBrick;
	public static BlockFancyGlass glasscraftingTable;
	public static ItemStack glassBrickIS;
	
	public static void init(){
		
		glassBrick = new BlockGlassBrick(BlockIds.GLASS_BRICK);
		glasscraftingTable = new BlockGlassCraftingTable(BlockIds.GLASS_CRAFTING_TABLE);
		glassBrickIS = new ItemStack(glassBrick, 4, 0);
		
		GameRegistry.registerBlock(glassBrick, ItemGlassBrickBlock.class, "block." + Strings.GLASS_BRICK_NAME);
		GameRegistry.registerBlock(glasscraftingTable, "block." + Strings.GLASS_CRAFTING_TABLE_NAME);
		
		GameRegistry.addRecipe(new ItemStack(glassBrick, 4, 0), new Object[]{"ii ", "ii ", 'i', new ItemStack(Block.glass, 1)});
		GameRegistry.addRecipe(new ShapedOreRecipe(glassBrickIS, true, new Object[]{"gg", "gg", Character.valueOf('g'), "glass"}));
        GameRegistry.addShapelessRecipe(new ItemStack(glassBrick, 1, 1), new ItemStack(glassBrick, 1, 0));
        GameRegistry.addRecipe(new ItemStack(glassBrick, 8, 2), new Object[]{"iii", "i i", "iii", 'i', new ItemStack(glassBrick, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(glasscraftingTable, 1), new Object[]{"ii ", "ii ", 'i', new ItemStack(glassBrick, 1)});
	}

}

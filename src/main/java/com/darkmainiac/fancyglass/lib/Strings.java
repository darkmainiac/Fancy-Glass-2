package com.darkmainiac.fancyglass.lib;

import net.minecraft.util.ResourceLocation;

public class Strings {
	
	/* Localization Prefixes */
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";
	
	/* Unlocalized names */
	public static final String GLASS_BRICK_NAME = "glassBrick";
	public static final String CRACKED_GLASS_BRICK_NAME = "crackedglassBrick";
	public static final String CHISELED_GLASS_BRICK_NAME = "chiseledglassBrick";
	public static final String[] GLASS_BRICK_SUBTYPE_NAMES ={GLASS_BRICK_NAME, CRACKED_GLASS_BRICK_NAME, CHISELED_GLASS_BRICK_NAME};
	public static final String GLASS_CRAFTING_TABLE_NAME = "glasscraftingTable";
	
	public static final String CONTAINER_INVENTORY = "container.inventory";
    public static final String CONTAINER_CRAFTING = "container.crafting";

    public static final ResourceLocation GUI_CRAFTING = new ResourceLocation("textures/gui/container/crafting_table.png");
    
}

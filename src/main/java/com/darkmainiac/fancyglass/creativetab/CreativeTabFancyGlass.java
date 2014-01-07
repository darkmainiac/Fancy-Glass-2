package com.darkmainiac.fancyglass.creativetab;

import com.darkmainiac.fancyglass.lib.BlockIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabFancyGlass extends CreativeTabs {

	public CreativeTabFancyGlass(int tabID, String tabLabel) {
		super(tabID, tabLabel);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return BlockIds.GLASS_BRICK;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Fancy Glass";
	}

}

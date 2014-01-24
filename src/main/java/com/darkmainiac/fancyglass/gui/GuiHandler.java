package com.darkmainiac.fancyglass.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.darkmainiac.fancyglass.lib.BlockIds;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {

        if (ID == BlockIds.CRAFTING_GUI_ID)
        {
            return new ContainerCrafting(player.inventory, world, x, y, z);
        }
        
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {

        if (ID == BlockIds.CRAFTING_GUI_ID)
        {
            return new CraftingGui(player.inventory, world, x, y, z);
        }
        return null;
	}
}

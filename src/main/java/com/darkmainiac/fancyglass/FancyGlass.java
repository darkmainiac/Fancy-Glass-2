package com.darkmainiac.fancyglass;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

import com.darkmainiac.fancyglass.block.ModBlocks;
import com.darkmainiac.fancyglass.creativetab.CreativeTabFancyGlass;
import com.darkmainiac.fancyglass.gui.GuiHandler;
import com.darkmainiac.fancyglass.lib.*;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)

public class FancyGlass {
	@Instance(Reference.MOD_ID)
	public static FancyGlass instance;
	
	public static CreativeTabs tab = new CreativeTabFancyGlass(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		ModBlocks.init();
    }
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(instance, new GuiHandler());
	}
	
}

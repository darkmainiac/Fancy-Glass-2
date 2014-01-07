package com.darkmainiac.fancyglass.block;

import com.darkmainiac.fancyglass.FancyGlass;
import com.darkmainiac.fancyglass.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFancyGlass extends Block {
	
	public BlockFancyGlass(int id){
		this(id, Material.glass);
	}

	protected BlockFancyGlass(int id, Material material) {
		super(id, material);
		this.setHardness(1.5F);
		this.setCreativeTab(FancyGlass.tab);
	}
	
	@Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Strings.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @Override
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	int i1 = par1IBlockAccess.getBlockId(par2, par3, par4);
        return i1 == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);    
    }
    
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
    	return true;
    }
    

}

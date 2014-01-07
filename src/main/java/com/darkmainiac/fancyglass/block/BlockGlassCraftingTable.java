package com.darkmainiac.fancyglass.block;

import com.darkmainiac.fancyglass.FancyGlass;
import com.darkmainiac.fancyglass.lib.BlockIds;
import com.darkmainiac.fancyglass.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGlassCraftingTable extends BlockFancyGlass {

	@SideOnly(Side.CLIENT)
	private Icon blockTop;
	@SideOnly(Side.CLIENT)
	private Icon blockSide;
	@SideOnly(Side.CLIENT)
	private Icon blockFront;
	@SideOnly(Side.CLIENT)
	private Icon blockBottom;
	
	public BlockGlassCraftingTable(int id) {
		super(id, Material.glass);
		setUnlocalizedName(Strings.GLASS_CRAFTING_TABLE_NAME);
		setStepSound(soundGlassFootstep);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setLightOpacity(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
    {
        this.blockSide = icon.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_side");
        this.blockTop = icon.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName())+ "_top");
        this.blockFront = icon.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_front");
        this.blockBottom = icon.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_bottom");
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.blockTop : (par1 == 0 ? this.blockBottom : (par1 != 2 && par1 != 4 ? this.blockSide : this.blockFront));
    }
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		
		if (player.isSneaking())
        {
            return true;
        }
        else
        {
        	if (!world.isRemote)
            {
            	player.openGui(FancyGlass.instance, BlockIds.CRAFTING_GUI_ID, world, x, y , z);
            }
            
            return true;
        }
    }
	
	

}

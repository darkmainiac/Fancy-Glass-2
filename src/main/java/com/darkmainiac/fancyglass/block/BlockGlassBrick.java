package com.darkmainiac.fancyglass.block;

import java.util.List;

import com.darkmainiac.fancyglass.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class BlockGlassBrick extends BlockFancyGlass{
	
	private Icon[] blockIcon;

	protected BlockGlassBrick(int id) {
		super(id, Material.glass);
		setUnlocalizedName(Strings.GLASS_BRICK_NAME);
		setStepSound(soundGlassFootstep);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setLightOpacity(0);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		for (int meta = 0; meta < Strings.GLASS_BRICK_SUBTYPE_NAMES.length; meta++)
		{
			list.add(new ItemStack(id, 1, meta));
		}
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
		this.blockIcon = new Icon[Strings.GLASS_BRICK_SUBTYPE_NAMES.length];
		for (int i = 0; i < Strings.GLASS_BRICK_SUBTYPE_NAMES.length; i++)
		{
			blockIcon[i] = iconRegister.registerIcon(String.format("%s.%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), Strings.GLASS_BRICK_SUBTYPE_NAMES[i]));
		}
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metaData)
    {
        metaData = MathHelper.clamp_int(metaData, 0, Strings.GLASS_BRICK_SUBTYPE_NAMES.length - 1);

        return blockIcon[metaData];
    }
	
}

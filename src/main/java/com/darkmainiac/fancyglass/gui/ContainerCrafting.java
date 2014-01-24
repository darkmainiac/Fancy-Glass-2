package com.darkmainiac.fancyglass.gui;

import com.darkmainiac.fancyglass.lib.BlockIds;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerCrafting extends ContainerWorkbench {
	
	
	 public ContainerCrafting(InventoryPlayer inventoryPlayer, World world, int x, int y, int z)
	    {

	        super(inventoryPlayer, world, x, y, z);
	    }

	    @Override
	    public boolean canInteractWith(EntityPlayer var1)
	    {

	        return true;
	    }
	    
	 @Override
	 public void onContainerClosed(EntityPlayer player)
	    {
	        super.onContainerClosed(player);

	        if (!player.worldObj.isRemote)
	        {
	            for (int i = 0; i < 9; ++i)
	            {
	                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

	                if (itemstack != null)
	                {
	                    player.dropPlayerItem(itemstack);
	                }
	            }
	        }
	    }
	 
	 @Override
	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(par2);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (par2 == 0)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 46, true))
	                {
	                    return null;
	                }

	                slot.onSlotChange(itemstack1, itemstack);
	            }
	            else if (par2 >= 10 && par2 < 37)
	            {
	                if (!this.mergeItemStack(itemstack1, 37, 46, false))
	                {
	                    return null;
	                }
	            }
	            else if (par2 >= 37 && par2 < 46)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 37, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	        }

	        return itemstack;
	    }

	 @Override
	 public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
	 {
	    return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
	 }

}

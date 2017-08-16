package net.pixelvania.pxvblocks.core;

import java.util.Random;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PxvDoor extends BlockDoor {
    private Item itemToDrop;

    public PxvDoor(String name, Material material, CreativeTabs tab) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
    }

    /**
     * Sets the item dropped when the door it broken.
     * @param item The item to drop.
     */
    public void setItemDropped(Item item) {
        this.itemToDrop = item;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return getModItem();
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getModItem());
    }

    private Item getModItem() {
        return itemToDrop;
    }
}

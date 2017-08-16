package net.pixelvania.pxvblocks.core;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class PxvDoubleSlab extends PxvSlab {
    private PxvSlab slab;

    public PxvDoubleSlab(PxvSlab baseSlab, String name, CreativeTabs tab) {
        super(name, baseSlab.getMaterial(null), tab);
        this.slab = baseSlab;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this.slab);
    }

    @Override
    public boolean isDouble() {
        return true;
    }
}
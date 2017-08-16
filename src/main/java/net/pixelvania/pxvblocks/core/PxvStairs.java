package net.pixelvania.pxvblocks.core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class PxvStairs extends BlockStairs {
    public PxvStairs(Block block, String name, CreativeTabs tab) {
        super(block.getDefaultState());
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
    }
}

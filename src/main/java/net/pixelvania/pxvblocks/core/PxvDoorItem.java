package net.pixelvania.pxvblocks.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDoor;

public class PxvDoorItem extends ItemDoor {
    public PxvDoorItem(Block block, String name, CreativeTabs tab) {
        super(block);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setMaxStackSize(16);
    }
}
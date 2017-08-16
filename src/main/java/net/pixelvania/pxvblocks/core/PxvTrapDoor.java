package net.pixelvania.pxvblocks.core;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PxvTrapDoor extends BlockTrapDoor {
    public PxvTrapDoor(String name, Material material, CreativeTabs tab) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
    }
}

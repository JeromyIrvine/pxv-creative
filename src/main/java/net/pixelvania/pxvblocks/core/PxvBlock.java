package net.pixelvania.pxvblocks.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PxvBlock extends Block {
    private String baseName;

    public PxvBlock(String name, Material material, CreativeTabs tab) {
        super(material);
        this.baseName = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
    }

    public String getBaseName() {
        return this.baseName;
    }

    public Material getMaterial() {
        return this.blockMaterial;
    }
}
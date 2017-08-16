package net.pixelvania.pxvblocks.core;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PxvSlab extends BlockSlab {
    public PxvSlab(String name, Material material, CreativeTabs tab) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        this.useNeighborBrightness = true;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return isDouble() ? new BlockStateContainer(this) : new BlockStateContainer(this, new IProperty[] { HALF });
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        if (!isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 8;
        }
        return i;
    }

    /**
     * This gives a deprecation warning, but without it, lower-slabs see to turn into uppper slabs on save.
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState bs = getDefaultState();
        if (!isDouble()) {
            bs = bs.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }
        return bs;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return null;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return null;
    }

    @Override
    public boolean isDouble() {
        return false;
    }
}

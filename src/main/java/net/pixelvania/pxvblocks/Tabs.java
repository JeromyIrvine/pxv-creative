package net.pixelvania.pxvblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tabs {

    public static final CreativeTabs BLOCKS = new CreativeTabs(CreativeTabs.getNextID(), "pxvBlocksTab")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.TAB_ICON_BLOCKS);
        }
    };

    public static final CreativeTabs SLABS = new CreativeTabs(CreativeTabs.getNextID(), "pxvSlabsTab")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.TAB_ICON_SLABS);
        }
    };

    public static final CreativeTabs STAIRS = new CreativeTabs(CreativeTabs.getNextID(), "pxvStairsTab")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.TAB_ICON_STAIRS);
        }
    };

    public static final CreativeTabs TILES = new CreativeTabs(CreativeTabs.getNextID(), "pxvTilesTab")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.TAB_ICON_TILES);
        }
    };

    public static final CreativeTabs DOORS = new CreativeTabs(CreativeTabs.getNextID(), "pxvDoorsTab")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.TAB_ICON_DOORS);
        }
    };

}
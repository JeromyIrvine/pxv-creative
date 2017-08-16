package net.pixelvania.pxvblocks.core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PxvSlabItem extends ItemBlock {
    private final BlockSlab singleSlab;
    private final BlockSlab doubleSlab;

    public PxvSlabItem(String name, Block block, BlockSlab singleSlab, BlockSlab doubleSlab, CreativeTabs tab) {
        super(block);
        this.singleSlab = singleSlab;
        this.doubleSlab = doubleSlab;
        this.setMaxDamage(0);
        this.setHasSubtypes(false);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack) {
        BlockPos blockpos = pos;
        IBlockState blockState = worldIn.getBlockState(pos);

        if (blockState.getBlock() == this.singleSlab) {
            boolean isTopHalf = blockState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP;

            if ((side == EnumFacing.UP && !isTopHalf || side == EnumFacing.DOWN && isTopHalf)) {
                return true;
            }
        }

        pos = pos.offset(side);
        IBlockState altBlockState = worldIn.getBlockState(pos);
        return altBlockState.getBlock() == this.singleSlab ? true : super.canPlaceBlockOnSide(worldIn, blockpos, side, player, stack);
    }

    @Override
    public int getMetadata(int damage) {
        return 0;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.singleSlab.getUnlocalizedName();
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        ItemStack stack = playerIn.getHeldItem(hand);

        if (!stack.isEmpty() && playerIn.canPlayerEdit(pos.offset(facing), facing, stack)) {
            Comparable<?> comparable = this.singleSlab.getTypeForItem(stack);
            IBlockState blockState = worldIn.getBlockState(pos);

            if (blockState.getBlock() == this.singleSlab) {
                BlockSlab.EnumBlockHalf slabHalf = blockState.getValue(BlockSlab.HALF);

                if ((facing == EnumFacing.UP && slabHalf == BlockSlab.EnumBlockHalf.BOTTOM || facing == EnumFacing.DOWN && slabHalf == BlockSlab.EnumBlockHalf.TOP)) {
                    IBlockState doubleBlockState = this.doubleSlab.getDefaultState();
                    AxisAlignedBB boundingBox = doubleBlockState.getCollisionBoundingBox(worldIn, pos);

                    if (boundingBox != Block.NULL_AABB && worldIn.checkNoEntityCollision(boundingBox.offset(pos)) && worldIn.setBlockState(pos, doubleBlockState, 11)) {
                        SoundType soundType = this.doubleSlab.getSoundType(doubleBlockState, worldIn, pos, playerIn);
                        worldIn.playSound(playerIn, pos, soundType.getPlaceSound(), SoundCategory.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
                        stack.shrink(1);
                    }

                    return EnumActionResult.SUCCESS;
                }
            }

            return this.tryPlace(playerIn, stack, worldIn, pos.offset(facing), comparable) ? EnumActionResult.SUCCESS : super.onItemUse(playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
        } else {
            return EnumActionResult.FAIL;
        }
    }

    private boolean tryPlace(EntityPlayer player, ItemStack stack, World worldIn, BlockPos pos, Object itemSlabType) {
        IBlockState blockState = worldIn.getBlockState(pos);

        if (blockState.getBlock() == this.singleSlab) {

            IBlockState doubleBlockState = this.doubleSlab.getDefaultState();
            AxisAlignedBB boundingBox = doubleBlockState.getCollisionBoundingBox(worldIn, pos);

            if (boundingBox != Block.NULL_AABB && worldIn.checkNoEntityCollision(boundingBox.offset(pos)) && worldIn.setBlockState(pos, doubleBlockState, 11)) {
                SoundType soundType = this.doubleSlab.getSoundType(doubleBlockState, worldIn, pos, player);
                worldIn.playSound(player, pos, soundType.getPlaceSound(), SoundCategory.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
                stack.shrink(1);
            }

            return true;
        }

        return false;
    }
}
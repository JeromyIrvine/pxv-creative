package net.pixelvania.pxvblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;
import net.pixelvania.pxvblocks.core.*;

public class Blocks {
    static final IForgeRegistry<Block> blockRegistry = GameRegistry.findRegistry(Block.class);
    static final IForgeRegistry<Item> itemRegistry = GameRegistry.findRegistry(Item.class);

    public static Item TAB_ICON_BLOCKS;
    public static Item TAB_ICON_SLABS;
    public static Item TAB_ICON_STAIRS;
    public static Item TAB_ICON_TILES;
    public static Item TAB_ICON_DOORS;

    private static Side currentSide;

    public static void register(Side side) {
        currentSide = side; // Set this so that we have access to it during item registration.

        //------------------------------------------------------------------------------------------
        // Blocks

        Block sandstoneBrick = registerBlock("sandstone_brick", Material.ROCK);
        Block sandstoneBrickSlab = registerSlab(sandstoneBrick);
        Block sandstoneBrickStairs = registerStairs(sandstoneBrick);
        Block sandstoneBrickTile = registerTile(sandstoneBrick);

		// Stone bricks
		Block stoneBrickWhite = registerBlock("stone_brick_white", Material.ROCK);
		registerSlab(stoneBrickWhite);
        registerStairs(stoneBrickWhite);
		registerTile(stoneBrickWhite);
		
        Block stoneBrickGray = registerBlock("stone_brick_gray", Material.ROCK);
        registerSlab(stoneBrickGray);
        registerStairs(stoneBrickGray);
		registerTile(stoneBrickGray);
		
		// Concrete slabs
		registerSlab("concrete_white_slab", Material.ROCK);
		registerSlab("concrete_orange_slab", Material.ROCK);
		registerSlab("concrete_magenta_slab", Material.ROCK);
		registerSlab("concrete_lightblue_slab", Material.ROCK);
		registerSlab("concrete_yellow_slab", Material.ROCK);
		registerSlab("concrete_lime_slab", Material.ROCK);
		registerSlab("concrete_pink_slab", Material.ROCK);
		registerSlab("concrete_gray_slab", Material.ROCK);
		registerSlab("concrete_lightgray_slab", Material.ROCK);
		registerSlab("concrete_cyan_slab", Material.ROCK);
		registerSlab("concrete_purple_slab", Material.ROCK);
		registerSlab("concrete_blue_slab", Material.ROCK);
		registerSlab("concrete_brown_slab", Material.ROCK);
		registerSlab("concrete_green_slab", Material.ROCK);
		registerSlab("concrete_red_slab", Material.ROCK);
        registerSlab("concrete_black_slab", Material.ROCK);
        
		// Terracotta slabs
		registerSlab("terracotta_white_slab", Material.ROCK);
		registerSlab("terracotta_orange_slab", Material.ROCK);
		registerSlab("terracotta_magenta_slab", Material.ROCK);
		registerSlab("terracotta_lightblue_slab", Material.ROCK);
		registerSlab("terracotta_yellow_slab", Material.ROCK);
		registerSlab("terracotta_lime_slab", Material.ROCK);
		registerSlab("terracotta_pink_slab", Material.ROCK);
		registerSlab("terracotta_gray_slab", Material.ROCK);
		registerSlab("terracotta_lightgray_slab", Material.ROCK);
		registerSlab("terracotta_cyan_slab", Material.ROCK);
		registerSlab("terracotta_purple_slab", Material.ROCK);
		registerSlab("terracotta_blue_slab", Material.ROCK);
		registerSlab("terracotta_brown_slab", Material.ROCK);
		registerSlab("terracotta_green_slab", Material.ROCK);
		registerSlab("terracotta_red_slab", Material.ROCK);
        registerSlab("terracotta_black_slab", Material.ROCK);
        
        // Prismarine variants
        registerSlab("prismarine_slab", Material.ROCK);
        registerStairs(net.minecraft.init.Blocks.PRISMARINE, "prismarine_stairs");
        registerTile("prismarine_tile", Material.ROCK);
        registerSlab("prismarine_brick_slab", Material.ROCK);
        registerStairs(net.minecraft.init.Blocks.PRISMARINE, "prismarine_brick_stairs");
        registerTile("prismarine_brick_tile", Material.ROCK);
        registerSlab("prismarine_dark_slab", Material.ROCK);
        registerStairs(net.minecraft.init.Blocks.PRISMARINE, "prismarine_dark_stairs");
        registerTile("prismarine_dark_tile", Material.ROCK);

		// Wood tiles
        registerTile("wood_birch_tile", Material.WOOD);
        registerTile("wood_oak_tile", Material.WOOD);
        registerTile("wood_spruce_tile", Material.WOOD);
        registerTile("wood_darkoak_tile", Material.WOOD);
        registerTile("wood_acacia_tile", Material.WOOD);
        registerTile("wood_jungle_tile", Material.WOOD);

        // Stone slabs and tiles
        registerSlab("stone_andesite_slab", Material.ROCK);
        registerSlab("stone_andesite_smooth_slab", Material.ROCK);
        registerSlab("stone_diorite_slab", Material.ROCK);
        registerSlab("stone_diorite_smooth_slab", Material.ROCK);
        registerSlab("stone_granite_slab", Material.ROCK);
        registerSlab("stone_granite_smooth_slab", Material.ROCK);

        registerTile("stone_tile", Material.ROCK);
        registerTile("stone_andesite_smooth_tile", Material.ROCK);
        registerTile("stone_diorite_smooth_tile", Material.ROCK);
        registerTile("stone_granite_smooth_tile", Material.ROCK);
        registerTile("sandstone_tile", Material.ROCK);
        registerTile("sandstone_red_tile", Material.ROCK);
        registerTile("quartz_tile", Material.ROCK);
        registerTile("cobblestone_tile", Material.ROCK);
        registerTile("brick_tile", Material.ROCK);
        registerTile("stonebrick_tile", Material.ROCK);
        registerTile("netherbrick_tile", Material.ROCK);
        
        //------------------------------------------------------------------------------------------
        // Doors

        Block glassDoor = registerDoor("door_glass", Material.GLASS);
        registerDoor("door_glass_birch", Material.GLASS);
        registerDoor("wood_panel_birch_door", Material.WOOD);

		//------------------------------------------------------------------------------------------
		// Trap Doors
		
        registerTrapDoor("trapdoor_glass", Material.GLASS);
        
        //------------------------------------------------------------------------------------------
        // Set up our Tab Icons
        TAB_ICON_BLOCKS = Item.getItemFromBlock(sandstoneBrick);
        TAB_ICON_SLABS = Item.getItemFromBlock(sandstoneBrickSlab);
        TAB_ICON_STAIRS = Item.getItemFromBlock(sandstoneBrickStairs);
        TAB_ICON_TILES = Item.getItemFromBlock(sandstoneBrickTile);
        TAB_ICON_DOORS = glassDoor.getItemDropped(null, null, 0);
    }

    private static Block registerBlock(String name, Material material) {
        return registerBlock(new PxvBlock(name, material, Tabs.BLOCKS));
    }

    private static Block registerDoor(String name, Material material) {
        PxvDoor door = new PxvDoor(name, material, Tabs.DOORS);
        Item doorItem = new PxvDoorItem(door, name, Tabs.DOORS);
        door.setItemDropped(doorItem);

        register(door);
        register(doorItem);

        return door;
    }

    private static Block registerSlab(String name, Material material) {
        Block slab = new PxvSlab(name, material, Tabs.SLABS);
        Block doubleSlab = new PxvDoubleSlab((PxvSlab) slab, name + "_double", Tabs.SLABS);
        Item slabItem = new PxvSlabItem(name, slab, (PxvSlab) slab, (PxvSlab) doubleSlab, Tabs.SLABS);

        register(slab);
        register(doubleSlab);
        register(slabItem);

        return slab;
    }

    /**
     * Registers a slab based on the block passed in using standard naming conventions.
     */
    private static Block registerSlab(Block block)
    {
		PxvBlock b = (PxvBlock)block;
        return registerSlab(b.getBaseName() + "_slab", b.getMaterial());
    }

    private static Block registerStairs(Block block, String name) {
        return registerBlock(new PxvStairs(block, name, Tabs.STAIRS));
	}
	
	/**
	 * Registers stairs based on the block passed in using standard naming conventions.
	 */
	private static Block registerStairs(Block block) {
		PxvBlock b = (PxvBlock)block;
		return registerStairs(block, b.getBaseName() + "_stairs");
	}

    private static Block registerTile(String name, Material material) {
        return registerBlock(new PxvTile(name, material, Tabs.TILES));
	}
	
	/**
	 * Registers a tile based on the block passed in using standard naming conventions.
	 */
	private static Block registerTile(Block block) {
		PxvBlock b = (PxvBlock)block;
		return registerTile(b.getBaseName() + "_tile", b.getMaterial());
	}

    private static Block registerTrapDoor(String name, Material material) {
        return registerBlock(new PxvTrapDoor(name, material, Tabs.DOORS));
    }

    private static Block registerBlock(Block block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());

        register(block);
        register(itemBlock);

        return block;
    }

    private static void register(Block block) {
        blockRegistry.register(block);
    }

    private static void register(Item item) {
        itemRegistry.register(item);
        if (currentSide == Side.CLIENT) {
            // If we're on the client, set the model resource location.
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    } 
}

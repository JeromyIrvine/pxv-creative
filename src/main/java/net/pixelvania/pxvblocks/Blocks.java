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

		Block stoneBrickGray = registerBlock("stone_brick_gray", Material.ROCK);
		Block stoneBrickGraySlab = registerSlab("stone_brick_gray_slab", Material.ROCK);
		Block stoneBrickGrayStairs = registerStairs(stoneBrickGray, "stone_brick_gray_stairs");
		Block stoneBrickGrayTile = registerTile("stone_brick_gray_tile", Material.ROCK);

		//------------------------------------------------------------------------------------------
		// Doors

		Block glassDoor = registerDoor("door_glass", Material.GLASS);
		registerDoor("door_glass_birch", Material.GLASS);

		registerTrapDoor("trapdoor_glass", Material.GLASS);
		
		//------------------------------------------------------------------------------------------
		// Set up our Tab Icons
		TAB_ICON_BLOCKS = Item.getItemFromBlock(stoneBrickGray);
		TAB_ICON_SLABS = Item.getItemFromBlock(stoneBrickGraySlab);
		TAB_ICON_STAIRS = Item.getItemFromBlock(stoneBrickGrayStairs);
		TAB_ICON_TILES = Item.getItemFromBlock(stoneBrickGrayTile);
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

	private static Block registerStairs(Block block, String name) {
		return registerBlock(new PxvStairs(block, name, Tabs.STAIRS));
	}

	private static Block registerTile(String name, Material material) {
		return registerBlock(new PxvTile(name, material, Tabs.TILES));
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

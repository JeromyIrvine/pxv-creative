package net.pixelvania.pxvblocks.proxy;

import net.minecraftforge.fml.common.event.*;
import net.pixelvania.pxvblocks.Blocks;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		Blocks.register(event.getSide());
	}
	
	public void init(FMLInitializationEvent event) {}
	public void postInit(FMLPostInitializationEvent event) {}
	public void serverStarting(FMLServerStartingEvent event) {}
	public void serverStopping(FMLServerStoppingEvent event) {}
}

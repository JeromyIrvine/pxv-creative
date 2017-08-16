package net.pixelvania.pxvblocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.pixelvania.pxvblocks.proxy.CommonProxy;

@Mod(modid = PxvBlocksPack.MODID, name = PxvBlocksPack.NAME, version = PxvBlocksPack.VERSION)
public class PxvBlocksPack {
	public static final String MODID = "pxvblocks";
	public static final String NAME = "Pixelvania Creative Blocks Pack";
	public static final String VERSION = "1.0";
	public static final String CLIENT_PROXY = "net.pixelvania.pxvblocks.proxy.ClientProxy";
	public static final String COMMON_PROXY = "net.pixelvania.pxvblocks.proxy.CommonProxy";

	@SidedProxy(clientSide = PxvBlocksPack.CLIENT_PROXY, serverSide = PxvBlocksPack.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Mod.Instance
	public static PxvBlocksPack instance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}

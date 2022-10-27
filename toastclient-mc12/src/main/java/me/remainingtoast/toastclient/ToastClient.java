package me.remainingtoast.toastclient;

import me.remainingtoast.toastclient.api.IToastClient;
import me.remainingtoast.toastclient.api.module.ModuleManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ToastClient.MODID, name = ToastClient.NAME, version = ToastClient.VERSION)
public class ToastClient implements IToastClient {
	public static final String MODID = "toastclient-mc12";
	public static final String NAME = "ToastClient";
	public static final String VERSION = "0.0.1";
	public static Logger logger;

	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init (FMLInitializationEvent event) {
		logger.info("init");
	}

	@Override
	public String getVersion() {
		return VERSION;
	}

	@Override
	public ModuleManager getModuleManager() {
		return new ModuleManager(this);
	}

}

package me.remainingtoast.toastclient;

import me.remainingtoast.toastclient.api.IToastClient;
import me.remainingtoast.toastclient.api.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ToastClient implements ClientModInitializer, IToastClient {
    @Override
    public void onInitializeClient() {

    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public ModuleManager getModuleManager() {
        return new ModuleManager(this);
    }
}

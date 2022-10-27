package me.remainingtoast.toastclient.api;

import me.remainingtoast.toastclient.api.module.ModuleManager;

public interface IToastClient {
    String getVersion();
    ModuleManager getModuleManager();

}

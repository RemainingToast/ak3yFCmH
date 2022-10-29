package me.remainingtoast.toastclient.api;

import me.bush.eventbus.bus.EventBus;
import me.remainingtoast.toastclient.api.module.ModuleManager;

public interface IToastClient {
    EventBus eventBus = new EventBus();

    String getVersion();
    ModuleManager getModuleManager();
}

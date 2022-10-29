package me.remainingtoast.toastclient.api.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.bush.eventbus.annotation.EventListener;
import me.bush.eventbus.annotation.ListenerPriority;
import me.remainingtoast.toastclient.api.IToastClient;
import me.remainingtoast.toastclient.api.events.PlayerTickEvent;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ModuleManager {

    private final IToastClient toastClient;
    @Getter
    @Setter
    private ArrayList<IModule> modules = new ArrayList<>();

    @EventListener(priority = ListenerPriority.HIGHEST)
    public void onTick(PlayerTickEvent.Pre event) {
        for (IModule module : modules) {
            if (!module.enabled()) continue;
            module.tick();
        }
    }
}
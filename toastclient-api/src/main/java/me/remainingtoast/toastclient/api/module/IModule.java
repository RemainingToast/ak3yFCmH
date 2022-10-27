package me.remainingtoast.toastclient.api.module;

public interface IModule {
    String name();
    String description();
    Category category();
    boolean enabled();
    int key();
    void tick();
}

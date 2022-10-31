package me.remainingtoast.toastclient.module;

import com.lukflug.panelstudio.base.IBoolean;
import me.remainingtoast.toastclient.api.module.Category;
import me.remainingtoast.toastclient.api.module.IModule;

public abstract class ForgeModule implements IModule {

    private final String name, desc;
    private final Category category;
    private final IBoolean enabled;
    private final int key;

    public ForgeModule(String name, String desc, Category category, IBoolean enabled, int key) {
        this.name = name;
        this.desc = desc;
        this.category = category;
        this.enabled = enabled;
        this.key = key;
    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return desc;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public boolean enabled() {
        return enabled.get();
    }

    @Override
    public int key() {
        return key;
    }
}

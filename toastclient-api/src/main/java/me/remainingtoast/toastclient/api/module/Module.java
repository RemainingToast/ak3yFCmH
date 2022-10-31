package me.remainingtoast.toastclient.api.module;

import com.lukflug.panelstudio.base.IBoolean;
import com.lukflug.panelstudio.base.IToggleable;
import com.lukflug.panelstudio.setting.IModule;
import com.lukflug.panelstudio.setting.ISetting;
import me.remainingtoast.toastclient.api.setting.Setting;
import me.remainingtoast.toastclient.api.setting.settings.IntegerSetting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Module implements IModule {
	public final String displayName, description;
	public final Category category;
	public final IBoolean visible;
	public final List<Setting<?>> settings = new ArrayList<>();
	public final boolean toggleable;
	public final int key;
	private boolean enabled = false;
	
	public Module(String displayName, String description, Category category, IBoolean visible, boolean toggleable, int key) {
		this.displayName = displayName;
		this.description = description;
		this.category = category;
		this.visible = visible;
		this.toggleable = toggleable;
		this.key = key;
	}
	
	@Override
	public String getDisplayName() {
		return displayName;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public IBoolean isVisible() {
		return visible;
	}

	@Override
	public IToggleable isEnabled() {
		if (!toggleable) return null;
		return new IToggleable() {
			@Override
			public boolean isOn() {
				return enabled;
			}

			@Override
			public void toggle() {
				enabled=!enabled;
			}
		};
	}

	@Override
	public Stream<ISetting<?>> getSettings() {
		return settings.stream()
				.filter(setting->setting instanceof ISetting)
				.sorted(Comparator.comparing(a -> a.displayName))
				.map(setting->(ISetting<?>)setting);
	}
}
package me.remainingtoast.toastclient.api.setting.settings;

import com.lukflug.panelstudio.base.IBoolean;
import com.lukflug.panelstudio.setting.IKeybindSetting;
import me.remainingtoast.toastclient.api.setting.Setting;

public abstract class KeybindSetting extends Setting<Integer> implements IKeybindSetting {
	public KeybindSetting(String displayName, String configName, String description, IBoolean visible, Integer value) {
		super(displayName, configName, description, visible, value);
	}

	@Override
	public int getKey() {
		return getValue();
	}

	@Override
	public void setKey(int key) {
		setValue(key);
	}
}
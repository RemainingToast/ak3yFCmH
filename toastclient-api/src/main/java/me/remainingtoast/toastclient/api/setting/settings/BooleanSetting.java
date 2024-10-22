package me.remainingtoast.toastclient.api.setting.settings;

import com.lukflug.panelstudio.base.IBoolean;
import com.lukflug.panelstudio.setting.IBooleanSetting;
import me.remainingtoast.toastclient.api.setting.Setting;

public class BooleanSetting extends Setting<Boolean> implements IBooleanSetting {
	public BooleanSetting(String displayName, String configName, String description, IBoolean visible, Boolean value) {
		super(displayName, configName, description, visible, value);
	}

	@Override
	public void toggle() {
		setValue(!getValue());
	}

	@Override
	public boolean isOn() {
		return getValue();
	}
}
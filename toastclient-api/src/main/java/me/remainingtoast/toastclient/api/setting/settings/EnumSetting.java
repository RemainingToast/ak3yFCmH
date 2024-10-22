package me.remainingtoast.toastclient.api.setting.settings;

import com.lukflug.panelstudio.base.IBoolean;
import com.lukflug.panelstudio.setting.IEnumSetting;
import com.lukflug.panelstudio.setting.ILabeled;
import me.remainingtoast.toastclient.api.setting.Setting;

import java.util.Arrays;

public class EnumSetting<E extends Enum<E>> extends Setting<E> implements IEnumSetting {
	private final Class<E> settingClass;
	private final ILabeled[] array;
	
	public EnumSetting(String displayName, String configName, String description, IBoolean visible, E value, Class<E> settingClass) {
		super(displayName, configName, description, visible, value);
		this.settingClass = settingClass;
		this.array = Arrays.stream(settingClass.getEnumConstants()).map(v-> (ILabeled) v::toString).toArray(ILabeled[]::new);
	}

	@Override
	public void increment() {
		E[] array = settingClass.getEnumConstants();
		int index = getValue().ordinal() + 1;
		if (index >= array.length) index = 0;
		setValue(array[index]);
	}

	@Override
	public void decrement() {
		E[] array = settingClass.getEnumConstants();
		int index = getValue().ordinal() - 1;
		if (index < 0) index = array.length - 1;
		setValue(array[index]);
	}

	@Override
	public String getValueName() {
		return getValue().toString();
	}
	
	@Override
	public int getValueIndex() {
		return getValue().ordinal();
	}

	@Override
	public void setValueIndex(int index) {
		setValue(settingClass.getEnumConstants()[index]);
	}

	@Override
	public ILabeled[] getAllowedValues() {
		return array;
	}
}
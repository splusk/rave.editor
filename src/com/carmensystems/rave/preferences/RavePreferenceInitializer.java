package com.carmensystems.rave.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;

import com.carmensystems.rave.CarmusrPlugin;
import com.carmensystems.rave.editors.ColorManagerConstants;

public class RavePreferenceInitializer extends AbstractPreferenceInitializer {
	public void initializeDefaultPreferences() {
		IPreferenceStore store = CarmusrPlugin.getDefault().getPreferenceStore();
		
		store.setDefault(RavePreferences.PREF_DISABLEBUILDERS, false);
		store.setDefault(RavePreferences.PREF_MARKOCCURANCIES, true);
		store.setDefault(RavePreferences.PREF_COMPILER_PREFERENCES, getDefaultPreferenceScript());
		
		PreferenceConverter.setDefault(store, RaveColorPreferences.DEFAULT_COLOR, ColorManagerConstants.CREAM);
		PreferenceConverter.setDefault(store, RaveColorPreferences.STRING_COLOR, ColorManagerConstants.GREEN);
		PreferenceConverter.setDefault(store, RaveColorPreferences.NUMBER_COLOR, ColorManagerConstants.DARK_RED);
		PreferenceConverter.setDefault(store, RaveColorPreferences.TIME_COLOR, ColorManagerConstants.ORANGE);
		PreferenceConverter.setDefault(store, RaveColorPreferences.DATATYPE_COLOR, ColorManagerConstants.PINKISH);
		PreferenceConverter.setDefault(store, RaveColorPreferences.COMMENT_COLOR, ColorManagerConstants.REDISH_ORANGE);
		PreferenceConverter.setDefault(store, RaveColorPreferences.VAR_COLOR, ColorManagerConstants.PURPLE);
		PreferenceConverter.setDefault(store, RaveColorPreferences.RESERVED_COLOR, ColorManagerConstants.LIGHT_BLUE);
		PreferenceConverter.setDefault(store, RaveColorPreferences.BUILTIN_COLOR, ColorManagerConstants.DARK_BLUE);
	}

	private static String getDefaultPreferenceScript() {
		String value = System.getProperty(RavePreferences.PREF_COMPILER_PREFERENCES, "");
		if (!value.isEmpty()) {
			return value;
		} else {
			value = System.getenv("RAVE_COMPILER_PREFERENCES");
			return value != null ? value : "";
		}
	}
}
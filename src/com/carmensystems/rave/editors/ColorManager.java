package com.carmensystems.rave.editors;

import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.carmensystems.rave.CarmusrPlugin;
import com.carmensystems.rave.preferences.RaveColorPreferences;

public class ColorManager {
	protected Hashtable<RGB, Color> colorCache = new Hashtable<RGB, Color>(10);

	public ColorManager() { }

	public Color getColor(String c) {
		return this.getColor(this.getRGB(c));
	}

	public RGB getRGB(String c) {
		IPreferenceStore store = CarmusrPlugin.getDefault().getPreferenceStore();
		
		RGB storeColor = PreferenceConverter.getColor(store, c);
		
		if (storeColor.equals(PreferenceConverter.COLOR_DEFAULT_DEFAULT)) {
			storeColor = PreferenceConverter.getColor(store, RaveColorPreferences.DEFAULT_COLOR);
		}

		return storeColor;
	}

	public void dispose() {
		Iterator<Color> e = this.colorCache.values().iterator();

		while (e.hasNext()) {
			((Color) e.next()).dispose();
		}

	}

	public Color getColor(RGB rgb) {
		Color color = (Color) this.colorCache.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			this.colorCache.put(rgb, color);
		}

		return color;
	}
}
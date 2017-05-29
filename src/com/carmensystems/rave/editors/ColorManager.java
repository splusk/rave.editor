package com.carmensystems.rave.editors;

import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ColorManager {
	protected Hashtable<RGB, Color> colorCache = new Hashtable(10);
	protected Hashtable<String, RGB> colornames = new Hashtable(10);
	public static final RGB DEFAULT = ColorManagerConstants.CREAM;

	public ColorManager() {
		this.colornames.put("__rave_comment", ColorManagerConstants.RED);
		this.colornames.put("__rave_string", ColorManagerConstants.GREEN);
		this.colornames.put("__rave_number", ColorManagerConstants.DARK_RED);
		this.colornames.put("__rave_time", ColorManagerConstants.ORANGE);
		this.colornames.put("__rave_datatype", ColorManagerConstants.PINKISH);
		this.colornames.put("__rave_comment", ColorManagerConstants.REDISH_ORANGE);
		this.colornames.put("__rave_var", ColorManagerConstants.PURPLE);
		this.colornames.put("__rave_reserved", ColorManagerConstants.LIGHT_BLUE);
		this.colornames.put("__rave_builtin", ColorManagerConstants.DARK_BLUE);
	}

	public Color getColor(String c) {
		return this.getColor(this.getRGB(c));
	}

	public RGB getRGB(String c) {
		RGB r = (RGB) this.colornames.get(c);
		return r == null ? DEFAULT : r;
	}

	public void dispose() {
		Iterator e = this.colorCache.values().iterator();

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
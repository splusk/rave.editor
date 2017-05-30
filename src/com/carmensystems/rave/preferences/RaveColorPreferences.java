package com.carmensystems.rave.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.carmensystems.rave.CarmusrPlugin;
import com.carmensystems.rave.editors.RaveEditor;

public class RaveColorPreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	public static String DEFAULT_COLOR = "__rave_text";
	public static String COMMENT_COLOR = "__rave_comment";
	public static String STRING_COLOR = "__rave_string";
	public static String NUMBER_COLOR = "__rave_number";
	public static String TIME_COLOR = "__rave_time";
	public static String DATATYPE_COLOR = "__rave_datatype";
	public static String VAR_COLOR = "__rave_var";
	public static String RESERVED_COLOR = "__rave_reserved";
	public static String BUILTIN_COLOR = "__rave_builtin";

	public RaveColorPreferences() {
		super(1);
		this.setPreferenceStore(CarmusrPlugin.getDefault().getPreferenceStore());
		this.setDescription("Rave Editor Colors");
	}

	public void createFieldEditors() {
		this.addField(
				new ColorFieldEditor(DEFAULT_COLOR, "&Text", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(COMMENT_COLOR, "&Comment", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(STRING_COLOR, "&String", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(NUMBER_COLOR, "&Number", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(TIME_COLOR, "&Time", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(DATATYPE_COLOR, "&Data type", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(VAR_COLOR, "&var", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(RESERVED_COLOR, "&Reserved", this.getFieldEditorParent()));
		this.addField(
				new ColorFieldEditor(BUILTIN_COLOR, "&Builtin", this.getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
	}

	public boolean performOk() {
		if (super.performOk()) {
			RaveEditor.shouldMarkOccurances();
			return true;
		} else {
			return false;
		}
	}
}
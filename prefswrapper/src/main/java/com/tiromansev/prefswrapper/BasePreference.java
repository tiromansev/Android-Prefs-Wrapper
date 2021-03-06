package com.tiromansev.prefswrapper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

public class BasePreference {

    private static Context context;
    private static SharedPreferences appPreferences;
    protected static HashMap<String, BasePreference> prefsList = new HashMap<>();

    private String fileName = null;
    private String key = null;
    private Object defaultValue = null;
    private static int mode = Context.MODE_PRIVATE;
    private PreferenceValueListener valueListener;
    private String title;

    public void setValueListener(PreferenceValueListener valueListener) {
        this.valueListener = valueListener;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void setContext(Context context) {
        BasePreference.context = context;
        appPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setMode(int mode) {
        BasePreference.mode = mode;
    }

    protected static String getStringPreference(String name, String def_value) {
        return appPreferences.getString(name, def_value);
    }

    protected static String getStringPreference(String file, String name, String def_value) {
        return context.getSharedPreferences(file, mode).getString(name, def_value);
    }

    protected static float getFloatPreference(String name, float def_value) {
        return appPreferences.getFloat(name, def_value);
    }

    protected static float getFloatPreference(String file, String name, float def_value) {
        return context.getSharedPreferences(file, mode).getFloat(name, def_value);
    }

    protected static int getIntPreference(String name, int def_value) {
        return appPreferences.getInt(name, def_value);
    }

    protected static int getIntPreference(String file, String name, int def_value) {
        return context.getSharedPreferences(file, mode).getInt(name, def_value);
    }

    protected static long getLongPreference(String name, long def_value) {
        return appPreferences.getLong(name, def_value);
    }

    protected static long getLongPreference(String file, String name, long def_value) {
        return context.getSharedPreferences(file, mode).getLong(name, def_value);
    }

    protected static boolean getBoolPreference(String name, boolean def_value) {
        return appPreferences.getBoolean(name, def_value);
    }

    protected static boolean getBoolPreference(String file, String name, boolean def_value) {
        return context.getSharedPreferences(file, mode).getBoolean(name, def_value);
    }

    protected void onValueChanged() {
        if (valueListener != null) {
            valueListener.onValueChanged();
        }
    }

    protected static void clearPreference(String key) {
        SharedPreferences.Editor edit = appPreferences.edit();
        edit.remove(key);
        edit.apply();
    }

    protected static void clearPreference(String file, String key) {
        SharedPreferences prefs = context.getSharedPreferences(file, mode);
        SharedPreferences.Editor edit = prefs.edit();
        edit.remove(key);
        edit.apply();
    }

    protected static void saveStringPreference(String key, String value) {
        SharedPreferences.Editor edit = appPreferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    protected static void saveStringPreference(String file, String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(file, mode);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(key, value);
        edit.apply();
    }

    protected static void saveFloatPreference(String key, float value) {
        SharedPreferences.Editor edit = appPreferences.edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    protected static void saveFloatPreference(String file, String key, float value) {
        SharedPreferences prefs = context.getSharedPreferences(file, mode);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    protected static void saveIntPreference(String key, int value) {
        SharedPreferences.Editor edit = appPreferences.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    protected static void saveIntPreference(String file, String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences(file, mode);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    protected static void saveLongPreference(String key, long value) {
        SharedPreferences.Editor edit = appPreferences.edit();
        edit.putLong(key, value);
        edit.apply();
    }

    protected static void saveLongPreference(String file, String key, long value) {
        SharedPreferences prefs = context.getSharedPreferences(file, mode);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putLong(key, value);
        edit.apply();
    }

    protected static void saveBoolPreference(String key, boolean value) {
        SharedPreferences.Editor edit = appPreferences.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    protected static void saveBoolPreference(String file, String key, boolean value) {
        SharedPreferences prefs = context.getSharedPreferences(file, mode);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public boolean preferenceExists() {
        if (fileName != null) {
            return context.getSharedPreferences(fileName, mode).contains(this.key);
        }
        else {
            return appPreferences.contains(this.key);
        }
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public boolean valueUndefined() {
        return true;
    }

    protected void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void resetToDefaultValue() {

    }

    public boolean equalToDefaultValue() {
        return true;
    }

    public String getKey() {
        return key;
    }

    protected void setKey(String key) {
        this.key = key;
    }

    protected void setFileName(String fileName) {
        this.fileName = fileName;
    }

    protected String getFileName() {
        return fileName;
    }

    protected void checkPreference() {
        if (this.key.isEmpty()) {
            throw new RuntimeException("Empty key value for preference");
        }
    }

    public void clearPreference() {
        if (fileName != null && !fileName.isEmpty()) {
            clearPreference(fileName, key);
        }
        else {
            clearPreference(key);
        }
    }

    public interface PreferenceValueListener {
        void onValueChanged();
    }

}

package com.tiromansev.prefswrapper.typedprefs;

import com.tiromansev.prefswrapper.BasePreference;

public class FloatPreference extends BasePreference {

    public float getValue() {
        if (getFileName() != null && !getFileName().isEmpty()) {
            return getFloatPreference(getFileName(), getKey(), (float) getDefaultValue());
        }
        else {
            return getFloatPreference(getKey(), (float) getDefaultValue());
        }
    }

    @Override
    public void resetToDefaultValue() {
        setValue((float) getDefaultValue());
    }

    @Override
    public boolean equalToDefaultValue() {
        return getValue() == (float) getDefaultValue();
    }

    public void setValue(float value) {
        if (getFileName() != null && !getFileName().isEmpty()) {
            saveFloatPreference(getFileName(), getKey(), value);
        }
        else {
            saveFloatPreference(getKey(), value);
        }
    }

    public static Builder builder(String key) {
        BasePreference pref = prefsList.get(key);
        if (pref == null) {
            pref = new FloatPreference();
            ((FloatPreference) pref).setKey(key);
            prefsList.put(key, pref);
        }
        return ((FloatPreference) pref).new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setKey(String key) {
            FloatPreference.this.setKey(key);
            return this;
        }

        public Builder setDefaultValue(float defaultValue) {
            FloatPreference.this.setDefaultValue(defaultValue);
            return this;
        }

        public Builder setFileName(String fileName) {
            FloatPreference.this.setFileName(fileName);
            return this;
        }

        public FloatPreference build() {
            checkPreference();
            return FloatPreference.this;
        }

    }

}

package com.tiromansev.prefswrapper.typedprefs;

import com.tiromansev.prefswrapper.BasePreference;

public class BooleanPreference extends BasePreference {

    public Boolean getValue() {
        if (getFileName() != null && !getFileName().isEmpty()) {
            return getBoolPreference(getFileName(), getKey(), (boolean) getDefaultValue());
        }
        else {
            return getBoolPreference(getKey(), (boolean) getDefaultValue());
        }
    }

    @Override
    public void resetToDefaultValue() {
        setValue((boolean) getDefaultValue());
    }

    @Override
    public boolean equalToDefaultValue() {
        return getValue() == (boolean) getDefaultValue();
    }

    public void setValue(boolean value) {
        if (getFileName() != null && !getFileName().isEmpty()) {
            saveBoolPreference(getFileName(), getKey(), value);
        }
        else {
            saveBoolPreference(getKey(), value);
        }
        onValueChanged();
    }

    public static Builder builder(String key) {
        BasePreference pref = prefsList.get(key);
        if (pref == null) {
            pref = new BooleanPreference();
            ((BooleanPreference) pref).setKey(key);
            prefsList.put(key, pref);
        }
        return ((BooleanPreference) pref).new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setTitle(String title) {
            BooleanPreference.this.setTitle(title);
            return this;
        }

        public Builder setKey(String key) {
            BooleanPreference.this.setKey(key);
            return this;
        }

        public Builder setDefaultValue(boolean defaultValue) {
            BooleanPreference.this.setDefaultValue(defaultValue);
            return this;
        }

        public Builder setFileName(String fileName) {
            BooleanPreference.this.setFileName(fileName);
            return this;
        }

        public BooleanPreference build() {
            checkPreference();
            return BooleanPreference.this;
        }

    }

}

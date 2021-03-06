package com.tiromansev.prefswrapper.typedprefs;

import com.tiromansev.prefswrapper.BasePreference;

public class IntegerPreference extends BasePreference {

    public int getValue() {
        if (getFileName() != null && !getFileName().isEmpty()) {
            return getIntPreference(getFileName(), getKey(), (int) getDefaultValue());
        }
        else {
            return getIntPreference(getKey(), (int) getDefaultValue());
        }
    }

    @Override
    public void resetToDefaultValue() {
        setValue((int) getDefaultValue());
    }

    @Override
    public boolean equalToDefaultValue() {
        return getValue() == (int) getDefaultValue();
    }

    public void setValue(int value) {
        if (getFileName() != null && !getFileName().isEmpty()) {
            saveIntPreference(getFileName(), getKey(), value);
        }
        else {
            saveIntPreference(getKey(), value);
        }
        onValueChanged();
    }

    public static Builder builder(String key) {
        BasePreference pref = prefsList.get(key);
        if (pref == null) {
            pref = new IntegerPreference();
            ((IntegerPreference) pref).setKey(key);
            prefsList.put(key, pref);
        }
        return ((IntegerPreference) pref).new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setTitle(String title) {
            IntegerPreference.this.setTitle(title);
            return this;
        }

        public Builder setKey(String key) {
            IntegerPreference.this.setKey(key);
            return this;
        }

        public Builder setDefaultValue(int defaultValue) {
            IntegerPreference.this.setDefaultValue(defaultValue);
            return this;
        }

        public Builder setFileName(String fileName) {
            IntegerPreference.this.setFileName(fileName);
            return this;
        }

        public IntegerPreference build() {
            checkPreference();
            return IntegerPreference.this;
        }

    }

}

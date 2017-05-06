package com.tiromansev.prefswrapper.typedprefs;

import com.tiromansev.prefswrapper.BasePreference;

public class StringPreference extends BasePreference {

    public String getValue() {
        if (getFileName() != null && !getFileName().isEmpty()) {
            return getStringPreference(getFileName(), getKey(), (String) getDefaultValue());
        }
        else {
            return getStringPreference(getKey(), (String) getDefaultValue());
        }
    }

    @Override
    public void resetToDefaultValue() {
        setValue((String) getDefaultValue());
    }

    @Override
    public boolean equalToDefaultValue() {
        return getValue().equals((String) getDefaultValue());
    }

    public void setValue(String value) {
        if (getFileName() != null && !getFileName().isEmpty()) {
            saveStringPreference(getFileName(), getKey(), value);
        }
        else {
            saveStringPreference(getKey(), value);
        }
    }

    public static Builder builder() {
        return new StringPreference().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setKey(String key) {
            StringPreference.this.setKey(key);
            return this;
        }

        public Builder setDefaultValue(String defaultValue) {
            StringPreference.this.setDefaultValue(defaultValue);
            return this;
        }

        public Builder setFileName(String fileName) {
            StringPreference.this.setFileName(fileName);
            return this;
        }

        public StringPreference build() {
            return StringPreference.this;
        }

    }

}

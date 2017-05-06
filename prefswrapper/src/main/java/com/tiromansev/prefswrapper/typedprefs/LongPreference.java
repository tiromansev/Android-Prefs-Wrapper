package com.tiromansev.prefswrapper.typedprefs;

import com.tiromansev.prefswrapper.BasePreference;

public class LongPreference extends BasePreference {

    public long getValue() {
        if (getFileName() != null && !getFileName().isEmpty()) {
            return getLongPreference(getFileName(), getKey(), (long) getDefaultValue());
        }
        else {
            return getLongPreference(getKey(), (long) getDefaultValue());
        }
    }

    @Override
    public void resetToDefaultValue() {
        setValue((long) getDefaultValue());
    }

    @Override
    public boolean equalToDefaultValue() {
        return getValue() == (long) getDefaultValue();
    }

    public void setValue(long value) {
        if (getFileName() != null && !getFileName().isEmpty()) {
            saveLongPreference(getFileName(), getKey(), value);
        }
        else {
            saveLongPreference(getKey(), value);
        }
    }

    public static Builder builder() {
        return new LongPreference().new Builder();
    }

    private class Builder {

        private Builder() {

        }

        public Builder setKey(String key) {
            LongPreference.this.setKey(key);
            return this;
        }

        public Builder setDefaultValue(long defaultValue) {
            LongPreference.this.setDefaultValue(defaultValue);
            return this;
        }

        public Builder setFileName(String fileName) {
            LongPreference.this.setFileName(fileName);
            return this;
        }

        public LongPreference build() {
            return LongPreference.this;
        }

    }

}

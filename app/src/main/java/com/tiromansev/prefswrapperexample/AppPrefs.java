package com.tiromansev.prefswrapperexample;

import com.tiromansev.prefswrapper.typedprefs.StringPreference;

public class AppPrefs {

    public static StringPreference userName() {
        return StringPreference
                .builder("user_name")
                .setDefaultValue("default value")
                .build();
    }

}

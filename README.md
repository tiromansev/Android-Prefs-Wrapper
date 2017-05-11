# Android-Prefs-Wrapper
Android SharedPreferences wrapper

# How to use

```Java
public class AppPrefs {

    public static BooleanPreference exampleBoolPref() {
        return BooleanPreference.
                builder().
                setKey("example_bool_pref").
                setDefaultValue(true).
                build();
    }

}
```

```Java
public class ExampleActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	AppPrefs.exampleBoolPref().setValue(true);
    }

}
```

# Download

Add it in your root build.gradle at the end of repositories:

```Groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```Groovy
	dependencies {
	        compile 'com.github.tiromansev:Android-Prefs-Wrapper:0.1.3'
	}
```

Maven:

```Groovy
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2. Add the dependency

```Groovy
<dependency>
	    <groupId>com.github.tiromansev</groupId>
	    <artifactId>Android-Prefs-Wrapper</artifactId>
	    <version>0.1.3</version>
	</dependency>
```

package com.amobee.richmedia.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amobee.richmedia.controller.util.NavigationStringEnum;
import com.amobee.richmedia.controller.util.TransitionStringEnum;
import com.amobee.richmedia.view.AmobeeView;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class OrmmaController {
    private static final String BOOLEAN_TYPE = "boolean";
    public static final String EXIT = "exit";
    private static final String FLOAT_TYPE = "float";
    public static final String FULL_SCREEN = "fullscreen";
    private static final String INT_TYPE = "int";
    private static final String NAVIGATION_TYPE = "class com.ormma.NavigationStringEnum";
    private static final String SHORT_ARRAY_TYPE = "class [S";
    private static final String STRING_ARRAY_TYPE = "class [Ljava.lang.String;";
    private static final String STRING_TYPE = "class java.lang.String";
    public static final String STYLE_NORMAL = "normal";
    private static final String TRANSITION_TYPE = "class com.ormma.TransitionStringEnum";
    protected Context mContext;
    protected AmobeeView mOrmmaView;

    public static class ReflectedParcelable implements Parcelable {
        protected ReflectedParcelable(Parcel parcel) {
            Field[] declaredFields = getClass().getDeclaredFields();
            int i = 0;
            while (i < declaredFields.length) {
                try {
                    Field field = declaredFields[i];
                    Class type = field.getType();
                    if (type.isEnum()) {
                        String cls = type.toString();
                        if (cls.equals(OrmmaController.NAVIGATION_TYPE)) {
                            field.set(this, NavigationStringEnum.fromString(parcel.readString()));
                        } else if (cls.equals(OrmmaController.TRANSITION_TYPE)) {
                            field.set(this, TransitionStringEnum.fromString(parcel.readString()));
                        }
                    } else if (!(field.get(this) instanceof Creator)) {
                        field.set(this, parcel.readValue(null));
                    }
                    i++;
                } catch (IllegalArgumentException e) {
                    return;
                } catch (IllegalAccessException e2) {
                    return;
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Field[] declaredFields = getClass().getDeclaredFields();
            int i2 = 0;
            while (i2 < declaredFields.length) {
                try {
                    Field field = declaredFields[i2];
                    Class type = field.getType();
                    if (type.isEnum()) {
                        String cls = type.toString();
                        if (cls.equals(OrmmaController.NAVIGATION_TYPE)) {
                            parcel.writeString(((NavigationStringEnum) field.get(this)).getText());
                        } else if (cls.equals(OrmmaController.TRANSITION_TYPE)) {
                            parcel.writeString(((TransitionStringEnum) field.get(this)).getText());
                        }
                    } else {
                        Object obj = field.get(this);
                        if (!(obj instanceof Creator)) {
                            parcel.writeValue(obj);
                        }
                    }
                    i2++;
                } catch (IllegalArgumentException e) {
                    return;
                } catch (IllegalAccessException e2) {
                    return;
                }
            }
        }
    }

    public static class Dimensions extends ReflectedParcelable {
        public static final Creator<Dimensions> CREATOR = new C03331();
        public int height;
        public int width;
        public int f435x;
        public int f436y;

        class C03331 implements Creator<Dimensions> {
            C03331() {
            }

            public Dimensions createFromParcel(Parcel parcel) {
                return new Dimensions(parcel);
            }

            public Dimensions[] newArray(int i) {
                return new Dimensions[i];
            }
        }

        public Dimensions() {
            this.f435x = -1;
            this.f436y = -1;
            this.width = -1;
            this.height = -1;
        }

        protected Dimensions(Parcel parcel) {
            super(parcel);
        }
    }

    public static class PlayerProperties extends ReflectedParcelable {
        public static final Creator<PlayerProperties> CREATOR = new C03341();
        public boolean audioMuted;
        public boolean autoPlay;
        public boolean doLoop;
        public boolean inline;
        public boolean showControl;
        public String startStyle;
        public String stopStyle;

        class C03341 implements Creator<PlayerProperties> {
            C03341() {
            }

            public PlayerProperties createFromParcel(Parcel parcel) {
                return new PlayerProperties(parcel);
            }

            public PlayerProperties[] newArray(int i) {
                return new PlayerProperties[i];
            }
        }

        public PlayerProperties() {
            this.showControl = true;
            this.autoPlay = true;
            this.audioMuted = false;
            this.doLoop = false;
            String str = OrmmaController.STYLE_NORMAL;
            this.stopStyle = str;
            this.startStyle = str;
            this.inline = false;
        }

        public PlayerProperties(Parcel parcel) {
            super(parcel);
        }

        public boolean doLoop() {
            return this.doLoop;
        }

        public boolean doMute() {
            return this.audioMuted;
        }

        public boolean exitOnComplete() {
            return this.stopStyle.equalsIgnoreCase(OrmmaController.EXIT);
        }

        public boolean isAutoPlay() {
            return this.autoPlay;
        }

        public boolean isFullScreen() {
            return this.startStyle.equalsIgnoreCase(OrmmaController.FULL_SCREEN);
        }

        public void muteAudio() {
            this.audioMuted = true;
        }

        public void setProperties(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2) {
            this.autoPlay = z2;
            this.showControl = z3;
            this.doLoop = z5;
            this.audioMuted = z;
            this.startStyle = str;
            this.stopStyle = str2;
            this.inline = z4;
        }

        public void setStopStyle(String str) {
            this.stopStyle = str;
        }

        public boolean showControl() {
            return this.showControl;
        }
    }

    public static class Properties extends ReflectedParcelable {
        public static final Creator<Properties> CREATOR = new C03351();
        public int backgroundColor;
        public float backgroundOpacity;
        public int height;
        public boolean useBackground;
        public boolean useCustomClose;
        public int width;

        class C03351 implements Creator<Properties> {
            C03351() {
            }

            public Properties createFromParcel(Parcel parcel) {
                return new Properties(parcel);
            }

            public Properties[] newArray(int i) {
                return new Properties[i];
            }
        }

        public Properties() {
            this.height = -1;
            this.width = -1;
            this.useBackground = false;
            this.backgroundColor = 0;
            this.backgroundOpacity = 0.0f;
            this.useCustomClose = false;
        }

        protected Properties(Parcel parcel) {
            super(parcel);
            this.height = -1;
            this.width = -1;
        }
    }

    public static class RecurrenceProperties extends ReflectedParcelable {
        public static final Creator<RecurrenceProperties> CREATOR = new C03361();
        public short[] daysInMonth;
        public short[] daysInWeek;
        public short[] daysInYear;
        public String[] exceptionDates;
        public String expires;
        public String frequency;
        public int interval;
        public short[] monthsInYear;
        public short[] weeksInMonth;

        class C03361 implements Creator<RecurrenceProperties> {
            C03361() {
            }

            public RecurrenceProperties createFromParcel(Parcel parcel) {
                return new RecurrenceProperties(parcel);
            }

            public RecurrenceProperties[] newArray(int i) {
                return new RecurrenceProperties[i];
            }
        }

        public RecurrenceProperties() {
            this.frequency = "-1";
            this.interval = -1;
            this.expires = "";
            this.exceptionDates = null;
            this.daysInWeek = null;
            this.daysInMonth = null;
            this.daysInYear = null;
            this.weeksInMonth = null;
            this.monthsInYear = null;
        }

        protected RecurrenceProperties(Parcel parcel) {
            super(parcel);
        }
    }

    public static class ResizeProperties extends ReflectedParcelable {
        public static final Creator<ResizeProperties> CREATOR = new C03371();
        public boolean allowOffscreen;
        public String customClosePosition;
        public int height;
        public int offsetX;
        public int offsetY;
        public int width;

        class C03371 implements Creator<ResizeProperties> {
            C03371() {
            }

            public ResizeProperties createFromParcel(Parcel parcel) {
                return new ResizeProperties(parcel);
            }

            public ResizeProperties[] newArray(int i) {
                return new ResizeProperties[i];
            }
        }

        public ResizeProperties() {
            this.width = -1;
            this.height = -1;
            this.offsetX = -1;
            this.offsetY = -1;
            this.width = 0;
            this.height = 0;
            this.customClosePosition = "top-right";
            this.offsetX = 0;
            this.offsetY = 0;
            this.allowOffscreen = true;
        }

        protected ResizeProperties(Parcel parcel) {
            super(parcel);
            this.width = -1;
            this.height = -1;
            this.offsetX = -1;
            this.offsetY = -1;
        }
    }

    public OrmmaController(AmobeeView amobeeView, Context context) {
        this.mOrmmaView = amobeeView;
        this.mContext = context;
    }

    protected static Object getFromJSON(JSONObject jSONObject, Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Object newInstance = cls.newInstance();
        for (Field field : declaredFields) {
            String replace = field.getName().replace('_', '-');
            String obj = field.getType().toString();
            try {
                int i;
                if (obj.equals(INT_TYPE)) {
                    obj = jSONObject.getString(replace).toLowerCase();
                    if (obj.startsWith("#")) {
                        i = -1;
                        try {
                            i = obj.startsWith("#0x") ? Integer.decode(obj.substring(1)).intValue() : Integer.parseInt(obj.substring(1), 16);
                        } catch (NumberFormatException e) {
                        }
                    } else {
                        i = Integer.parseInt(obj);
                    }
                    field.set(newInstance, Integer.valueOf(i));
                } else if (obj.equals(STRING_TYPE)) {
                    field.set(newInstance, jSONObject.getString(replace));
                } else if (obj.equals(BOOLEAN_TYPE)) {
                    field.set(newInstance, Boolean.valueOf(jSONObject.getBoolean(replace)));
                } else if (obj.equals(FLOAT_TYPE)) {
                    field.set(newInstance, Float.valueOf(Float.parseFloat(jSONObject.getString(replace))));
                } else if (obj.equals(NAVIGATION_TYPE)) {
                    field.set(newInstance, NavigationStringEnum.fromString(jSONObject.getString(replace)));
                } else if (obj.equals(TRANSITION_TYPE)) {
                    field.set(newInstance, TransitionStringEnum.fromString(jSONObject.getString(replace)));
                } else if (obj.equals(SHORT_ARRAY_TYPE)) {
                    r6 = jSONObject.optJSONArray(replace);
                    if (r6 != null) {
                        r7 = new short[r6.length()];
                        for (i = 0; i < r7.length; i++) {
                            r7[i] = (short) r6.getInt(i);
                        }
                        field.set(newInstance, r7);
                    }
                } else if (obj.equals(STRING_ARRAY_TYPE)) {
                    r6 = jSONObject.optJSONArray(replace);
                    if (r6 != null) {
                        r7 = new String[r6.length()];
                        for (i = 0; i < r7.length; i++) {
                            r7[i] = r6.getString(i);
                        }
                        field.set(newInstance, r7);
                    }
                }
            } catch (JSONException e2) {
            }
        }
        return newInstance;
    }

    public abstract void stopAllListeners();
}

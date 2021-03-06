package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPreferencesTokenCachingStrategy extends TokenCachingStrategy {
    private static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    private static final String TAG = SharedPreferencesTokenCachingStrategy.class.getSimpleName();
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    public SharedPreferencesTokenCachingStrategy(Context context) {
        this(context, null);
    }

    public SharedPreferencesTokenCachingStrategy(Context context, String str) {
        Validate.notNull(context, "context");
        if (Utility.isNullOrEmpty(str)) {
            str = DEFAULT_CACHE_KEY;
        }
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.cache = context.getSharedPreferences(this.cacheKey, 0);
    }

    private void deserializeKey(String str, Bundle bundle) {
        int i = 0;
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString(JSON_VALUE_TYPE);
        if (string.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
        } else if (string.equals(TYPE_BOOLEAN_ARRAY)) {
            r1 = jSONObject.getJSONArray("value");
            boolean[] zArr = new boolean[r1.length()];
            while (i < zArr.length) {
                zArr[i] = r1.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
        } else if (string.equals(TYPE_BYTE)) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
        } else if (string.equals(TYPE_BYTE_ARRAY)) {
            r1 = jSONObject.getJSONArray("value");
            byte[] bArr = new byte[r1.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) r1.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
        } else if (string.equals(TYPE_SHORT)) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
        } else if (string.equals(TYPE_SHORT_ARRAY)) {
            r1 = jSONObject.getJSONArray("value");
            short[] sArr = new short[r1.length()];
            while (i < sArr.length) {
                sArr[i] = (short) r1.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
        } else if (string.equals(TYPE_INTEGER)) {
            bundle.putInt(str, jSONObject.getInt("value"));
        } else if (string.equals(TYPE_INTEGER_ARRAY)) {
            r1 = jSONObject.getJSONArray("value");
            int[] iArr = new int[r1.length()];
            while (i < iArr.length) {
                iArr[i] = r1.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
        } else if (string.equals(TYPE_LONG)) {
            bundle.putLong(str, jSONObject.getLong("value"));
        } else if (string.equals(TYPE_LONG_ARRAY)) {
            r1 = jSONObject.getJSONArray("value");
            long[] jArr = new long[r1.length()];
            while (i < jArr.length) {
                jArr[i] = r1.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
        } else if (string.equals(TYPE_FLOAT)) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
        } else if (string.equals(TYPE_FLOAT_ARRAY)) {
            r1 = jSONObject.getJSONArray("value");
            float[] fArr = new float[r1.length()];
            while (i < fArr.length) {
                fArr[i] = (float) r1.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
        } else if (string.equals(TYPE_DOUBLE)) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
        } else if (string.equals(TYPE_DOUBLE_ARRAY)) {
            r1 = jSONObject.getJSONArray("value");
            double[] dArr = new double[r1.length()];
            while (i < dArr.length) {
                dArr[i] = r1.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
        } else if (string.equals(TYPE_CHAR)) {
            string = jSONObject.getString("value");
            if (string != null && string.length() == 1) {
                bundle.putChar(str, string.charAt(0));
            }
        } else if (string.equals(TYPE_CHAR_ARRAY)) {
            r2 = jSONObject.getJSONArray("value");
            char[] cArr = new char[r2.length()];
            for (r1 = 0; r1 < cArr.length; r1++) {
                String string2 = r2.getString(r1);
                if (string2 != null && string2.length() == 1) {
                    cArr[r1] = string2.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
        } else if (string.equals(TYPE_STRING)) {
            bundle.putString(str, jSONObject.getString("value"));
        } else if (string.equals(TYPE_STRING_LIST)) {
            r2 = jSONObject.getJSONArray("value");
            int length = r2.length();
            ArrayList arrayList = new ArrayList(length);
            for (r1 = 0; r1 < length; r1++) {
                Object obj = r2.get(r1);
                if (obj == JSONObject.NULL) {
                    obj = null;
                } else {
                    String str2 = (String) obj;
                }
                arrayList.add(r1, obj);
            }
            bundle.putStringArrayList(str, arrayList);
        } else if (string.equals(TYPE_ENUM)) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString("value")));
            } catch (ClassNotFoundException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    private void serializeKey(String str, Bundle bundle, Editor editor) {
        Object obj = null;
        int i = 0;
        Object obj2 = bundle.get(str);
        if (obj2 != null) {
            JSONObject jSONObject = new JSONObject();
            String str2;
            if (obj2 instanceof Byte) {
                str2 = TYPE_BYTE;
                jSONObject.put("value", ((Byte) obj2).intValue());
                obj2 = null;
                obj = str2;
            } else if (obj2 instanceof Short) {
                str2 = TYPE_SHORT;
                jSONObject.put("value", ((Short) obj2).intValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Integer) {
                str2 = TYPE_INTEGER;
                jSONObject.put("value", ((Integer) obj2).intValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Long) {
                str2 = TYPE_LONG;
                jSONObject.put("value", ((Long) obj2).longValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Float) {
                str2 = TYPE_FLOAT;
                jSONObject.put("value", ((Float) obj2).doubleValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Double) {
                str2 = TYPE_DOUBLE;
                jSONObject.put("value", ((Double) obj2).doubleValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Boolean) {
                str2 = TYPE_BOOLEAN;
                jSONObject.put("value", ((Boolean) obj2).booleanValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Character) {
                str2 = TYPE_CHAR;
                jSONObject.put("value", obj2.toString());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof String) {
                str2 = TYPE_STRING;
                jSONObject.put("value", (String) obj2);
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Enum) {
                str2 = TYPE_ENUM;
                jSONObject.put("value", obj2.toString());
                jSONObject.put(JSON_VALUE_ENUM_TYPE, obj2.getClass().getName());
                obj2 = null;
                r1 = str2;
            } else {
                JSONArray jSONArray = new JSONArray();
                int length;
                JSONArray jSONArray2;
                if (obj2 instanceof byte[]) {
                    obj = TYPE_BYTE_ARRAY;
                    byte[] bArr = (byte[]) obj2;
                    length = bArr.length;
                    while (i < length) {
                        jSONArray.put(bArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof short[]) {
                    obj = TYPE_SHORT_ARRAY;
                    short[] sArr = (short[]) obj2;
                    length = sArr.length;
                    while (i < length) {
                        jSONArray.put(sArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof int[]) {
                    obj = TYPE_INTEGER_ARRAY;
                    int[] iArr = (int[]) obj2;
                    length = iArr.length;
                    while (i < length) {
                        jSONArray.put(iArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof long[]) {
                    obj = TYPE_LONG_ARRAY;
                    long[] jArr = (long[]) obj2;
                    length = jArr.length;
                    while (i < length) {
                        jSONArray.put(jArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof float[]) {
                    obj = TYPE_FLOAT_ARRAY;
                    float[] fArr = (float[]) obj2;
                    length = fArr.length;
                    while (i < length) {
                        jSONArray.put((double) fArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof double[]) {
                    obj = TYPE_DOUBLE_ARRAY;
                    double[] dArr = (double[]) obj2;
                    length = dArr.length;
                    while (i < length) {
                        jSONArray.put(dArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof boolean[]) {
                    obj = TYPE_BOOLEAN_ARRAY;
                    boolean[] zArr = (boolean[]) obj2;
                    length = zArr.length;
                    while (i < length) {
                        jSONArray.put(zArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof char[]) {
                    obj = TYPE_CHAR_ARRAY;
                    char[] cArr = (char[]) obj2;
                    length = cArr.length;
                    while (i < length) {
                        jSONArray.put(String.valueOf(cArr[i]));
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof List) {
                    obj = TYPE_STRING_LIST;
                    for (Object obj22 : (List) obj22) {
                        if (obj22 == null) {
                            obj22 = JSONObject.NULL;
                        }
                        jSONArray.put(obj22);
                    }
                    jSONArray2 = jSONArray;
                } else {
                    obj22 = null;
                }
            }
            if (obj != null) {
                jSONObject.put(JSON_VALUE_TYPE, obj);
                if (obj22 != null) {
                    jSONObject.putOpt("value", obj22);
                }
                editor.putString(str, jSONObject.toString());
            }
        }
    }

    public void clear() {
        this.cache.edit().clear().apply();
    }

    public Bundle load() {
        Bundle bundle = new Bundle();
        for (String str : this.cache.getAll().keySet()) {
            try {
                deserializeKey(str, bundle);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + str + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public void save(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        Editor edit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle, edit);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + str + "' -- " + e);
                return;
            }
        }
        edit.apply();
    }
}

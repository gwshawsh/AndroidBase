package com.gws.android.tips.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.gws.android.tips.App;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * Created by Jara on 2017/3/25.
 */

public class SharedPreferenceUtil {


    public static SharedPreferences getSharePreferences(String preName){
        if(TextUtils.isEmpty(preName)){
            return  PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        }else {
            return  App.getInstance().getSharedPreferences(preName,Context.MODE_PRIVATE);
        }
    }

    public static void put(String key, Object object) {
        put(null,key,object);
    }

    public static void put(String preName,String key, Object object) {
        SharedPreferences.Editor editor = getSharePreferences(preName).edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        editor.apply();
        SharedPreferencesCompat.apply(editor);
    }

    public static Object get(String key, Object defaultObject) {
        return get(null,key,defaultObject);
    }
    public static Object get(String preName,String key, Object defaultObject) {
        SharedPreferences sp = getSharePreferences(preName);
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    public static void remove(String key) {
        remove(null,key);
    }
    public static void remove(String preName,String key) {
        SharedPreferences.Editor editor = getSharePreferences(preName).edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    public static void clear() {
        clear(null);
    }
    public static void clear(String preName) {
        SharedPreferences.Editor editor =getSharePreferences(preName).edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    public static boolean contains(String key) {
        return contains(null,key);
    }
    public static boolean contains(String preName,String key) {
        return getSharePreferences(preName).contains(key);
    }


    public static Map<String, ?> getAll() {
        return getAll(null);
    }
    public static Map<String, ?> getAll(String preName) {
        return getSharePreferences(preName).getAll();
    }


    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }


            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}

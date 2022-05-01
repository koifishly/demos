package com.koifishly.myfix;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.ArrayMap;
import android.util.Log;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ClassA {
    public static int _int_8758 = 8758;

    public static ApplicationInfo getApplicationInfoA(Object arg0) {
        return ((Context)arg0).getApplicationInfo();
    }

    public static boolean isHasNext(Object arg0) {
        return ((Iterator)arg0).hasNext();
    }

    public static boolean func1(Object arg0, Object arg1) {
        return ((ArrayList)arg0).add(arg1);
    }

    public static String func2(Object arg0, Object arg1, Object arg2) {
        return ((String)arg0).replace(((CharSequence)arg1), ((CharSequence)arg2));
    }

    public static int fun3(Object arg0) {
        return (int)(((Integer)arg0));
    }

    public static boolean strEqualsStrA(Object str1, Object str2) {
        return str1.equals(str2);
    }

    public static String toString(Object p0) {
        return p0.toString();
    }

    public static Object getMapValue(Object map, Object key) {
        return ((Map)map).get(key);
    }

    public static ClassLoader func4(Object arg0) {
        return ((Class)arg0).getClassLoader();
    }

    public static boolean func5() {
        return false;
    }

    public static int func6(Object arg0) {
        return ((DataInputStream)arg0).read();
    }

    public static Iterator getIterator(Object set) {
        return ((Set)set).iterator();
    }

    public static String getStringFromStringA(Object p9_string) {
        return ClassB.getStringFromStringB(p9_string);
    }

    public static Iterator func7(Object arg0) {
        return ((Collection)arg0).iterator();
    }

    public static Class getClassA(Object field) {
        return field.getClass();
    }

    public static int getLength(Object str) {
        return ((String)str).length();
    }

    public static String getStringA(short[] buffer, int startOffset, int size, int xorNum) {
        char[] chars = new char[size];
        int i;
        for(i = 0; i < size; ++i) {
            chars[i] = (char)(buffer[startOffset + i] ^ xorNum);
        }

        return new String(chars);
    }

    public static Object getObjA(Object weakReference) {
        return ((WeakReference)weakReference).get();
    }

    public static Object getFieldValue(Object field, Object obj) {
        return ((Field)field).get(obj);
    }

    public static void closeFileInputStream(Object fis) {
        ((FileInputStream)fis).close();
    }

    public static PackageManager func8(Object arg0) {
        return ((Context)arg0).getPackageManager();
    }

    public static String LogStackTraceA(Object arg0) {
        return Log.getStackTraceString(((Throwable)arg0));
    }

    public static String func9(Object arg0) {
        return App.getStringFromString(arg0);
    }

    public static Class forNameA(Object arg0) {
        return Class.forName(((String)arg0));
    }

    public static Collection func10(Object arg0) {
        return ((ArrayMap)arg0).values();
    }

    public static boolean remove(Object arrayList, Object removed) {
        return ((ArrayList)arrayList).remove(removed);
    }

    public static String getAbsolutePathA(Object file) {
        return ((File)file).getAbsolutePath();
    }

    public static int ۤۙ۟(Object arg0, Object arg1) {
        return Log.i(((String)arg0), ((String)arg1));
    }

    public static int ۤۢۘ(Object arg0) {
        return ((DataInputStream)arg0).readInt();
    }

    public static Object getNextIteratorA(Object iterator) {
        return ((Iterator)iterator).next();
    }

    public static int LogE(Object tag, Object str) {
        return Log.e(((String)tag), ((String)str));
    }

    public static String getPackageName(Object arg0) {
        return ((Context)arg0).getPackageName();
    }

    public static void func11(Object arg0) {
        ((Application)arg0).onCreate();
    }

    public static StringBuilder appendA(Object stringBuilder, Object string) {
        return ((StringBuilder)stringBuilder).append(((String)string));
    }

    public static boolean func12(Object arg0) {
        return ((File)arg0).exists();
    }

    public static void setFieldValueA(Object field, Object OBJ, Object newProxyInstance) {
        ((Field)field).set(OBJ, newProxyInstance);
    }

    public static Thread func13() {
        return Thread.currentThread();
    }

    public static Set func14(Object arg0) {
        return ((Map)arg0).keySet();
    }

    public static Field getDeclaredFieldA(Object arg0, Object arg1) {
        return ((Class)arg0).getDeclaredField(((String)arg1));
    }

    public static StringBuilder func15(Object arg0, Object arg1) {
        return ((StringBuilder)arg0).append(arg1);
    }

    public static int hashCodeA(Object p0) {
        return p0.hashCode();
    }

    public static String func16(Object arg0) {
        return ((Method)arg0).getName();
    }
}


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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ClassB {
    public static int _int;

    public static boolean f1(Object arg0, Object arg1) {
        return ((ArrayList)arg0).remove(arg1);
    }

    public static ApplicationInfo f2(Object arg0) {
        return ((Context)arg0).getApplicationInfo();
    }

    public static Object f3(Object arg0) {
        return ((WeakReference)arg0).get();
    }

    public static String LogStackTrace(Object exception) {
        return Log.getStackTraceString(((Throwable)exception));
    }

    public static int hashCode(Object arg0) {
        return arg0.hashCode();
    }

    public static Collection f4(Object arg0) {
        return ((ArrayMap)arg0).values();
    }

    public static String f5(Object arg0) {
        return ((File)arg0).getAbsolutePath();
    }

    public static int LogI(Object tag, Object value) {
        return Log.i(((String)tag), ((String)value));
    }

    public static String getStringFromStringBB(Object arg0) {
        return ClassB.getStringFromStringB(arg0);
    }

    public static String f6(Object arg0) {
        return ((Method)arg0).getName();
    }

    public static Thread getCurrentThread() {
        return Thread.currentThread();
    }

    public static Object getFieldValueB(Object field, Object obj) {
        return ((Field)field).get(obj);
    }

    public static int f7(Object arg0) {
        return ((String)arg0).length();
    }

    public static int f8(Object arg0, Object arg1) {
        return Log.e(((String)arg0), ((String)arg1));
    }

    public static String f9(Object arg0) {
        return ((Context)arg0).getPackageName();
    }

    public static Object f10(Object arg0, Object arg1) {
        return ((Map)arg0).get(arg1);
    }

    public static StringBuilder f11(Object arg0, Object arg1) {
        return ((StringBuilder)arg0).append(((String)arg1));
    }

    public static boolean f12(Object arg0, Object arg1) {
        return ((ArrayList)arg0).add(arg1);
    }

    public static Object f13(Object arg0) {
        return ((Iterator)arg0).next();
    }

    public static Iterator f14(Object arg0) {
        return ((Collection)arg0).iterator();
    }

    public static int f15(Object arg0) {
        return ((DataInputStream)arg0).readInt();
    }

    public static String getStringFromStringBBB(Object p0_string) {
        return App.getStringFromString(p0_string);
    }

    public static Iterator f16(Object arg0) {
        return ((Set)arg0).iterator();
    }

    public static Class getClassB(Object arg0) {
        return arg0.getClass();
    }

    public static Set keySet(Object map) {
        return ((Map)map).keySet();
    }

    public static boolean isFileExist(Object arg0) {
        return ((File)arg0).exists();
    }

    public static int ۢۥۛ(Object arg0) {
        return (int)(((Integer)arg0));
    }

    public static String f17(Object arg0) {
        return arg0.toString();
    }

    public static boolean hasNext(Object arg0) {
        return ((Iterator)arg0).hasNext();
    }

    public static PackageManager getPackageManagerB(Object context) {
        return ((Context)context).getPackageManager();
    }

    public static int readB(Object dis) {
        return ((DataInputStream)dis).read();
    }

    public static void onCreate_(Object arg0) {
        ((Application)arg0).onCreate();
    }

    public static ClassLoader getClassLoaderB(Object class_) {
        return ((Class)class_).getClassLoader();
    }

    public static void closeFileInputStreamB(Object arg0) {
        ((FileInputStream)arg0).close();
    }

    public static void setFieldValueB(Object field, Object packageManager, Object newProxyInstance) {
        ((Field)field).set(packageManager, newProxyInstance);
    }

    public static boolean strEqualsStrB(Object str1, Object str2) {
        return str1.equals(str2);
    }

    public static String getStringB(short[] buffer, int startOffset, int size, int xorNum) {
        char[] resultChars = new char[size];
        int i;
        for(i = 0; i < size; ++i) {
            resultChars[i] = (char)(buffer[startOffset + i] ^ xorNum);
        }

        return new String(resultChars);
    }

    public static String replace(Object string, Object old, Object news) {
        return ((String)string).replace(((CharSequence)old), ((CharSequence)news));
    }

    public static int return0() {
        return 0;
    }

    public static StringBuilder appendB(Object stringBuilder, Object string) {
        return ((StringBuilder)stringBuilder).append(string);
    }

    public static String getStringFromStringB(Object p0_obj) {
        FileInputStream fis1;
        int intCode;
        int p0_atCodeInt;
        String p0_string = (String)p0_obj;
        String string = "";
        if("ۖ".length() == 0) {
            // end if :: !p0_string.equals("ۖ")
            return p0_string;  // end if
        }

        if(!p0_string.equals("ۖ")) {
            int idx = 0;
            int i = 0;
            FileInputStream fis2 = null;
            int resultChar = 0;
            while(i < p0_string.length()) {
                if(idx > "ۖ".length() - 1) {
                    idx %= "ۖ".length();
                }

                try {
                    p0_atCodeInt = p0_string.codePointAt(i) + 0xFFFF;
                    intCode = "ۖ".codePointAt(idx);
                }
                catch(Throwable e) {
                    goto label_68;
                }

                resultChar = p0_atCodeInt - intCode;
                if(fis2 != null) {
                    try {
                        fis1 = new FileInputStream(string);
                        goto label_61;
                    }
                    catch(FileNotFoundException e) {
                    }
                    catch(Throwable e) {
                        goto label_48;
                    }

                    if(fis2 != null) {
                        try {
                            fis2.close();
                        }
                        catch(IOException e) {
                        }
                        catch(Throwable e) {
                            goto label_68;
                        }

                        goto label_76;
                        label_48:
                        if(fis2 != null) {
                            try {
                                fis2.close();
                            }
                            catch(IOException v2_1) {
                            }
                            catch(Throwable e) {
                                goto label_68;
                            }
                        }

                        try {
                            throw e;
                        }
                        catch(Throwable e) {
                            goto label_68;
                        }

                        label_61:
                        if(fis1 != null) {
                            try {
                                fis1.close();
                                goto label_75;
                            }
                            catch(IOException v2_2) {
                            }
                            catch(Throwable e) {
                                goto label_68;
                            }

                            fis2 = fis1;
                            goto label_76;
                            label_68:
                            if(resultChar > 0xFFFF) {
                                resultChar %= 0xFFFF;
                            }

                            goto label_78;
                        }

                        label_75:
                        fis2 = fis1;
                    }
                }

                label_76:
                if(resultChar > 0xFFFF) {
                    resultChar %= 0xFFFF;
                }

                label_78:
                string = string + ((char)resultChar);
                ++idx;
                ++i;
            }
        }

        // end if :: !p0_string.equals("ۖ")
        return string;  // end if
    }

    public static Class forNameB(Object className) {
        return Class.forName(((String)className));
    }

    public static Field getFieldB(Object obj, Object fieldName) {
        return ((Class)obj).getDeclaredField(((String)fieldName));
    }
}


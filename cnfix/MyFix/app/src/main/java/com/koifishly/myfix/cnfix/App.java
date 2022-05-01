package com.koifishly.myfix.cnfix;

import com.koifishly.myfix.*;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class App extends Application implements InvocationHandler {
    private String _packageName;
    private static short[] _shorts;
    private Object _fieldValue;
    private byte[][] _byteSS;
    private Application _application;

    static {
        App._shorts = new short[]{0x209B, 669, 750, 0x290, 738, 0x2EF, 661, 0x290, 686, 669, 748, 748, 686, 701, 659, 0x2E0, 661, 742, 661, 0x2E0, 741, 640, 660, 738, 657, 669, 0x290, 739, 691, 737, 738, 738, 657, 750, 0x2E0, 701, 659, 0x2E0, 661, 742, 661, 0x2E0, 741, 640, 660, 738, 657, 669, 0x290, 611, 0x3502, 0x357F, 0x3578, 0x3579, 0x3504, 0x357C, 0x357F, 0x350E, 0x3544, 0x3509, 0x3505, 0x355E, 0x3505, 0x3505, 0x3501, 0x357C, 0x357F, 0x3502, 0x357B, 0x34B6, 0x3503, 13670, 0x3577, 0x3579, 0x3501, 0x3577, 0x357D, 0x357B, 0x3509, 0x34B6, 13690, 0x3505, 0x357B, 0x3509, 0x34B6, 0x3504, 0x3505, 0x350A, 0x34B6, 0x357B, 0x350E, 0x357F, 0x3509, 0x350A, 0x3544, 0x3568, 0x357B, 13690, 0x357F, 0x3508, 0x357B, 0x3579, 0x350A, 0x34B6, 0x3577, 0x3506, 0x3501, 0x34B6, 0x3509, 0x350B, 0x3579, 0x3579, 0x357B, 0x3509, 0x3509, 0x3544, 0x3503, 0x3557, 0x3506, 0x3506, 0x355A, 0x357F, 0x3508, 0x3577, 0x3502, 0x3502, 0x3503, 0x3557, 0x3506, 0x3506, 0x3502, 0x357F, 0x3579, 0x3577, 0x350A, 0x357F, 0x3505, 0x3504, 0x355F, 0x3504, 0x357C, 0x3505, 0x3503, 0x3568, 0x357B, 0x3509, 0x355A, 0x357F, 0x3508, 9948, 10065, 10092, 10068, 10071, 10086, 0xC09, 0x4D1F, 0x4D22, 0x4D1A, 0x4D19, 0x4D28, 0xF0D, 21008, 21067, 21014, 21016, 21015, 21097, 21060, 21013, 21013, 21009, 21100, 21098, 21092, 21017, 21100, 21014, 21015, 21100, 21015, 0x526F, 21014, 21008, 21060, 21013, 21013, 21009, 21100, 21098, 21092, 21017, 21100, 21014, 21015, 21008, 21068, 21015, 21100, 21017, 21100, 21092, 21009, 21060, 21013, 21013, 21009, 21100, 21098, 21092, 21017, 21100, 21014, 21015, 21008, 21060, 21009, 21009, 21060, 21013, 21013, 21009, 21100, 21098, 21092, 21017, 21100, 21014, 21015, 21018, 21008, 21060, 21013, 21013, 21009, 21100, 21098, 21092, 21017, 21100, 21014, 21015, 21068, 21015, 0x526F, 21014, 21092, 21013, 21013, 21068, 21015, 0x526F, 21014, 21008, 21092, 21010, 21096, 21060, 21013, 21013, 21009, 21100, 21098, 21092, 21017, 21100, 21014, 21015, 21008, 21068, 21015, 21100, 21017, 21100, 21092, 21009, 21060, 21013, 21013, 21009, 21100, 21098, 21092, 21017, 21100, 21014, 21015, 21008, 21109, 21019, 21014, 0x521F, 21100, 21097, 21096, 21019, 0x5270, 21092, 21013, 0x527B, 21096, 21097, 21100, 21019, 21096, 21098, 21017, 0x53A5, 21092, 21013, 21013, 0x53A5, 21018, 21016, 21098, 21098, 21096, 21018, 21018, 21079, 21008, 21105, 21014, 21098, 21092, 21009, 21109, 21019, 21014, 0x521F, 21100, 21097, 21096, 21019, 21008, 21066, 21014, 21015, 21017, 21096, 21021, 21017, 9582, (short)0xBE30, 7274, 0x621B, 0x6240, 0x621D, 25107, 0x621C, 0x6262, 0x624F, 0x621E, 0x621E, 0x621A, 0x6267, 0x6261, 0x626F, 25106, 0x6267, 0x621D, 0x621C, 0x6267, 0x621C, 0x6264, 0x621D, 0x621B, 0x6247, 0x621C, 0x6267, 25106, 0x6267, 0x626F, 0x621A, 0x624F, 0x621E, 0x621E, 0x621A, 0x6267, 0x6261, 0x626F, 25106, 0x6267, 0x621D, 0x621C, 0x621B, 0x624F, 0x621E, 0x621E, 0x621A, 0x6267, 0x6261, 0x626F, 25106, 0x6267, 0x621D, 0x621C, 27, -3027, -3000, -3006, -3051, (short)0xF44E, (short)0xF44E, (short)0xF44A, (short)0xF5FD, -3017, -3012, -3020, (short)0xF449, (short)0xF430, (short)0xF431, (short)0xF40F, (short)0xF44B, -3012, -3001, -3012, (short)0xF40F, (short)0xF449, -3012, (short)0xF44F, -3018, (short)0xF40F, -3038, -3004, -3006, -3007, (short)0xF430, -3000, (short)0xF430, -3003, -3020, -3007, -3015, (short)0xF44F, (short)0xF301, -3006, -3027, -3012, -3022, (short)0xF44A, -3012, -3018, (short)0xF430, -3032, -3012, (short)0xF44F, -3012, -3018, (short)0xF430, -3005, -3012, (short)0xF44F, (short)0xF431, -3005, (short)0xF44E, -3020, (short)0xF431, (short)0xF40F, -3022, (short)0xF44E, (short)0xF44F, -3007, (short)0xF430, (short)0xF44F, -3007, (short)0xF40F, (short)0xF44D, -3000, (short)0xF40F, -3052, -3027, -3012, -3022, (short)0xF44A, -3012, -3018, (short)0xF430, -3032, -3012, (short)0xF44F, -3012, -3018, (short)0xF430, -3005, -3000, -3027, -3032, -3027, -3000, -3006, -3051, (short)0xF44E, (short)0xF44E, (short)0xF44A, (short)0xF5FD, -3006, -3008, -3022, -3022, (short)0xF430, -3006, -3006, (short)0xF40F, 1059, 0x4216, 0x4210, 0x4261, 0x420D, 0x421C, 0x4212, 17002, 0x421C, 0x4216, 0x4210, 0x4234, 17007, 0x4217, 17006, 17000, 0x4202, 0x4214, 0x4216, 17007, 0x4214, 17007, 0x4216, 0x4231, 0x4210, 0x4261, 0x421C, 0x4214, 17001, 0x4262, 17005, 0x421C, 0x4262, 0x4261, 0x4202, 0x4214, 0x4216, 17007, 0x4214, 17007, 0x4216, 0x4232, 0x4210, 0x4263, 0x4261, 0x4214, 0x4217, 0x4214, 0x4212, 0x421C, 0x4261, 0x4210, 0x4262, 0x4262, 0x4214, 0x4216, 17007, 0x421C, 0x4261, 0x4260, 0x4263, 0x4210, 0x4262, 17000, 0x4202, 0x4214, 0x4216, 17007, 0x4214, 17007, 0x4216, 0x4231, 0x4210, 0x4261, 0x421C, 0x4214, 17001, 0x4262, 0x350, 0x31E9, 0x319A, 0x31E4, 0x3196, 0x319B, 0x31E1, 0x31E4, 0x31DA, 0x31E9, 0x3198, 0x3198, 0x31DA, 0x31C9, 0x3198, 0x3198, 12700, 0x31E1, 0x31E7, 0x31E9, 0x3194, 0x31E1, 0x319B, 0x319A};
    }

    public App() {
        this._packageName = "";
    }

    // This method was "un-flattened"
    @Override  // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        this._packageName = ClassA.getPackageName(base);
        this.setNewProxyInstance(base);
        this.setFieldSourceDir(base);
        this._application = this.updateField();
    }

    @Override
    public Object invoke(Object arg27, Method arg28, Object[] arg29) {
        int v5_1;
        short[] v21;
        Object v22_1;
        int v0_2;
        String v20;
        int v1_1;
        short v0_1;
        int v17_1;
        int v12_1;
        short[] v5_2;
        App v0 = this;
        Method v1 = arg28;
        Object[] v2 = arg29;
        int v3 = 0;
        short[] v8 = null;
        int v9 = 0;
        short[] v10 = null;
        String v11 = null;
        short[] v12 = null;
        PackageInfo v14 = null;
        PackageInfo v15 = null;
        int v22 = ClassA.hashCodeA("\u06E0\u06E6\u06E4");
        short[] v16 = null;
        SigningInfo v6 = null;
        String v7 = null;
        Object v5 = null;
        int v4 = 0;
        int v17 = 0;
        int v18 = 0;
        short v23 = 0;
        Object v19 = null;
        String v13 = null;
        label_35:
        switch(v22) {
            case 1738029: {
                v22_1 = v5;
                v21 = v12;
                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                v3 = 0x6F25;
                goto label_416;
            }
            case 1738247: {
                v22 = ClassA.hashCodeA("ۙۛۨ");
                goto label_35;
            }
            case 1738293: {
                v22_1 = v5;
                v20 = v11;
                v21 = v12;
                Signature[] v5_4 = v15.signatures;
                byte[] v12_2 = v0._byteSS[v4];
                if(ClassA._int_8758 > 0) {
                    v5_4[v4] = new Signature(v12_2);
                    ++v4;
                    label_271:
                    v5_1 = ClassB.hashCode("ۨۚۢ");
                    label_273:
                    v11 = v20;
                    v12 = v21;
                    v22 = v5_1;
                    v5 = v22_1;
                    goto label_35;
                }

                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                v11 = v20;
                v0_1 = v23;
                v1_1 = ClassA.hashCodeA("ۧۗۤ");
                goto label_341;
            }
            case 1738877: {
                v20 = v11;
                v0.setFieldValue(v6, ClassB.getStringFromStringBB(ClassB.getStringB(v12, 567, 15, v3)), v5);
                v15.signingInfo = v6;
                v22_1 = v5;
                v21 = v12;
                v14 = v15;
                v11 = v20;
                goto label_237;
            }
            case 1739089: {
                v11 = v11;
                v12 = v12;
                v7 = ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 0x207, 15, v3));
                v5 = v5;
                v22 = ClassB.hashCode("ۡۚ۫");
                goto label_35;
            }
            case 1739863: {
                v22_1 = v5;
                v21 = v12;
                if(ClassB.strEqualsStrB(v0._packageName, v11)) {
                    v5_1 = ClassA.hashCodeA("\u06D8\u06E5\u06E0");
                    v12 = v21;
                    v22 = v5_1;
                    v5 = v22_1;
                    goto label_35;
                }

                label_132:
                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                v0_2 = ClassA.hashCodeA("ۡۡۖ");
                goto label_418;
            }
            case 1740147: {
                v22_1 = v5;
                v20 = v11;
                v21 = v12;
                PackageInfo v4_1 = (PackageInfo)v1.invoke(v0._fieldValue, v2);
                v4_1.signatures = new Signature[v0._byteSS.length];
                v15 = v4_1;
                v4 = 0;
                goto label_271;
            }
            case 1740924: {
                v22_1 = v5;
                v20 = v11;
                v21 = v12;
                SigningInfo v5_3 = v15.signingInfo;
                if(v5_3 == null) {
                    v14 = v15;
                    v11 = v20;
                    goto label_237;
                }

                v11 = v20;
                v12 = v21;
                v6 = v5_3;
                v5 = v22_1;
                v22 = ClassA.hashCodeA("ۗۢۜ");
                goto label_35;
            }
            case 1741101: {
                v22_1 = v5;
                v21 = v12;
                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                v3 = 17707;
label_416:
                v0_2 = ClassA.hashCodeA("ۡۢۤ");
label_418:
                v1 = arg28;
                v16 = v5_2;
                v18 = v17_1;
                v5 = v22_1;
                v22 = v0_2;
                v17 = v12_1;
                v12 = v21;
                v0 = this;
goto label_35;
            }
            case 1741969: {
                return null;
            }
            case 1742168: {
                return v14;
            }
            case 1746588: {
                if(ClassB._int != 0) {
                    v22 = ClassB.hashCode("\u06D6\u06E6\u06D7");
                    goto label_35;
                }

                v22_1 = v5;
                v21 = v12;
                goto label_304;
            }
            case 1747870: {
                v22_1 = v5;
                v21 = v12;
                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                v0_1 = v23;
                v1_1 = ClassA.hashCodeA("۬ۨۚ");
                goto label_341;
            }
            case 1748466: {
                v22 = ClassA.hashCodeA("ۨۨۧ");
                v5 = v0.getFieldA(v6, v7);
                v8 = App._shorts;
                v11 = v11;
                v12 = v12;
                v9 = 534;
                goto label_35;
            }
            case 1748662: {
                v22_1 = v5;
                v21 = v12;
                v14 = v1.invoke(v0._fieldValue, v2);
                label_237:
                v5_1 = ClassB.hashCode("\u06DA\u06E8\u06E6");
                v12 = v21;
                v22 = v5_1;
                v5 = v22_1;
                goto label_35;
            }
            case 1748707: {
                v18 = 14;
                v0 = this;
                v16 = App._shorts;
                v12 = v12;
                v17 = 505;
                v1 = arg28;
                v22 = ClassA.hashCodeA("ۤۚۤ");
                v5 = v5;
                goto label_35;
            }
            case 1749790: {
                v22_1 = v5;
                v20 = v11;
                v21 = v12;
                if(Build.VERSION.SDK_INT < 28) {
                    v14 = v15;
                    v11 = v20;
                    goto label_237;
                }

                v5_1 = ClassB.hashCode("ۙ۟ۢ");
                goto label_273;
            }
            case 1751342: {
                v22_1 = v5;
                v21 = v12;
                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                if(ClassA.strEqualsStrA(ClassA.getStringFromStringA(ClassB.getStringB(v5_2, v12_1, v18, v3)), ClassB.f6(arg28))) {
                    v1 = arg28;
                    v16 = v5_2;
                    v18 = v17_1;
                    v5 = v22_1;
                    v22 = ClassB.hashCode("۫ۨۨ");
                    v17 = v12_1;
                    v12 = v21;
                    v0 = this;
                    goto label_35;
                }

                v0_2 = ClassA.hashCodeA("ۡۡۖ");
                goto label_418;
            }
            case 1752631: {
                String v20_1 = v11;
                v0.setFieldValue(v5, v13, v15.signatures);
                short[] v11_1 = App._shorts;
                if(ClassB._int != 0) {
                    v22_1 = v5;
                    v21 = v12;
                    v11 = v20_1;
                    goto label_304;
                }

                v22 = ClassB.hashCode("ۗۛۡ");
                v12 = v11_1;
                v11 = v20_1;
                goto label_35;
            }
            case 1753132: {
                v20 = v11;
                v21 = v12;
                String v11_2 = ClassA.getStringFromStringA(ClassB.getStringB(v10, 557, 10, v3));
                if(ClassA._int_8758 <= 0) {
                    v22 = ClassA.hashCodeA("۟ۜۙ");
                    v11 = v20;
                    v12 = v21;
                    goto label_35;
                }

                v22 = ClassA.hashCodeA("\u06E5\u06E5\u06D7");
                v13 = v11_2;
                v11 = v20;
                v12 = v21;
                goto label_35;
            }
            case 1754132: {
                v22 = ClassB.hashCode("\u06D6\u06E6\u06D7");
                goto label_35;
            }
            case 1755184: {
                v22_1 = v5;
                v21 = v12;
                v5_1 = v4 < v15.signatures.length ? ClassA.hashCodeA("\u06D6\u06E7\u06E6") : ClassA.hashCodeA("\u06E2\u06E6\u06E2");
                v11 = v11;
                v12 = v21;
                v22 = v5_1;
                v5 = v22_1;
                goto label_35;
            }
            case 1755623: {
                break;
            }
            case 1758312: {
                v22_1 = v5;
                v21 = v12;
                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                v0_1 = v23;
                int v1_2 = v0_1 + 8310;
                if(v0_1 * 33240 - v1_2 * v1_2 <= 0) {
                    v23 = v0_1;
                    v16 = v5_2;
                    v18 = v17_1;
                    v5 = v22_1;
                    v0 = this;
                    v22 = ClassB.hashCode("\u06D9\u06E5\u06D9");
                    v17 = v12_1;
                    v12 = v21;
                    v1 = arg28;
                    goto label_35;
                }

                v1_1 = ClassA.hashCodeA("ۖ۟ۖ");
                label_341:
                v23 = v0_1;
                v16 = v5_2;
                v18 = v17_1;
                v5 = v22_1;
                v0 = this;
                v22 = v1_1;
                v17 = v12_1;
                v12 = v21;
                v1 = arg28;
                goto label_35;
            }
            case 1758507: {
                v22_1 = v5;
                v21 = v12;
                String v5_5 = (String)v2[0];
                Object v12_3 = v2[1];
                if(ClassA._int_8758 > 0) {
                    v19 = v12_3;
                    v12 = v21;
                    v11 = v5_5;
                    v5 = v22_1;
                    v22 = ClassA.hashCodeA("ۤ۫۟");
                    goto label_35;
                }

                label_304:
                v5_1 = ClassA.hashCodeA("ۚۢۙ");
                v12 = v21;
                v22 = v5_1;
                v5 = v22_1;
                goto label_35;
            }
            case 1740806:
            case 1758941: {
                v22_1 = v5;
                v21 = v12;
                goto label_304;
            }
            case 1759454: {
                v22_1 = v5;
                v21 = v12;
                v5_2 = v16;
                v12_1 = v17;
                v17_1 = v18;
                v23 = App._shorts[504];
                v0_2 = ClassA.hashCodeA("۫ۢ۟");
                goto label_418;
            }
            default: {
                v22_1 = v5;
                v21 = v12;
                if((ClassA.fun3(((Integer)v19)) & 0x40) == 0) {
                    goto label_132;
                }

                v5_1 = ClassB.hashCode("ۘۜۛ");
                v12 = v21;
                v22 = v5_1;
                v5 = v22_1;
                goto label_35;
            }
        }

        v0.setFieldValue(v5, ClassA.getStringFromStringA(ClassA.getStringA(v8, v9, 23, v3)), v15.signatures);
        v22 = ClassA.hashCodeA("\u06E6\u06D6\u06DC");
        v10 = App._shorts;
        v11 = v11;
        v12 = v12;
        goto label_35;
    }

    // This method was "un-flattened"
    @Override  // android.app.Application
    public void onCreate() {
        int v6 = App._shorts[582] + 0x4A13;
        int v13 = App._shorts[582] * App._shorts[582] + 0x156EFD69;
        if(ClassA.strEqualsStrA("android.app.Application", "android.app.Application")) {
            super.onCreate();
            return;
        }

        this.setFieldApplication(this._application);
        ClassB.onCreate_(this._application);
    }

    // This method was "un-flattened"
    private final Object getFieldValue() {
        int xorNum = 0x10CE0711 + App._shorts[0] * App._shorts[0] - App._shorts[0] * 0x832E < 0 ? 0xF43D : 1450;
        Field field = ClassA.getDeclaredFieldA(ClassB.forNameB(ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 1, 26, xorNum))), ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 27, 22, xorNum)));
        field.setAccessible(true);
        return ClassA.getFieldValue(field, null);
    }

    private final void setFieldSourceDir(Context context) {
        Map v16;
        String v17;
        File file_;
        App thiz = this;
        int xorNum = 0;
        boolean is_FileExist = false;
        String absolutePath = null;
        Map _map = null;
        Iterator _mapIterator = null;
        boolean is_HasNext = false;
        String mapKey = null;
        boolean boo = false;
        Object obj_ = null;
        boolean is_equals = false;
        int hashCode = ClassA.hashCodeA("۟ۙ۬");
        File file = null;
        label_18:
        switch(hashCode) {
            case 1738127: {
                v17 = absolutePath;
                v16 = _map;
                if(!boo) {
                    hashCode = ClassB.hashCode("۫۫ۤ");
                    _map = v16;
                    absolutePath = v17;
                    goto label_18;
                }

                hashCode = ClassA.hashCodeA("\u06E7\u06DA\u06E5");
                _map = v16;
                absolutePath = v17;
                goto label_18;
            }
            case 1738746: {
                file_ = file;
                v17 = absolutePath;
                v16 = _map;
                xorNum = 0x321A;
                goto label_246;
            }
            case 1739150: {
                thiz.LogError(ClassA.LogStackTraceA(null));
                throw new RuntimeException(ClassA.toString(null));
            }
            case 1740120: {
                return;
            }
            case 1743842: {
                thiz.setFieldValue(obj_, ClassB.getStringFromStringBB(ClassA.getStringA(App._shorts, 0x8E, 7, xorNum)), absolutePath);
                hashCode = ClassB.hashCode("ۧۛۜ");
                goto label_18;
            }
            case 1746514: {
                file_ = file;
                v17 = absolutePath;
                v16 = _map;
                int v5_1 = App._shorts[49] * 2 + 1;
                int v2_3 = App._shorts[49] + 1;
                if(v2_3 * v2_3 - v5_1 >= 0) {
                    hashCode = ClassB.hashCode("۬ۧ۟");
                    _map = v16;
                    absolutePath = v17;
                    file = file_;
                    goto label_18;
                }

                hashCode = ClassA.hashCodeA("ۗۗۚ");
                _map = v16;
                absolutePath = v17;
                file = file_;
                goto label_18;
            }
            case 1747712: {
                v17 = absolutePath;
                v16 = _map;
                is_HasNext = ClassA.isHasNext(_mapIterator);
                hashCode = ClassB.hashCode("\u06E2\u06DF\u06E5");
                _map = v16;
                absolutePath = v17;
                goto label_18;
            }
            case 1748664: {
                if(!is_equals) {
                    hashCode = ClassB.hashCode("ۧۛۜ");
                    goto label_18;
                }

                hashCode = ClassA.hashCodeA("\u06DC\u06E0\u06E6");
                goto label_18;
            }
            case 1749576: {
                v17 = absolutePath;
                v16 = _map;
                hashCode = is_HasNext ? ClassB.hashCode("\u06E6\u06EB\u06DC") : ClassB.hashCode("ۘۤۤ");
                _map = v16;
                absolutePath = v17;
                goto label_18;
            }
            case 1751213: {
                v17 = absolutePath;
                file = new File(ClassA.getApplicationInfoA(context).nativeLibraryDir, ClassB.getStringFromStringBB(ClassA.getStringA(App._shorts, 50, 11, xorNum)));
                is_FileExist = ClassB.isFileExist(file);
                hashCode = ClassA.hashCodeA("ۛۨۢ");
                _map = _map;
                absolutePath = v17;
                goto label_18;
            }
            case 1753783: {
                v17 = absolutePath;
                String str = (String)ClassA.getNextIteratorA(_mapIterator);
                boo = ClassB.strEqualsStrB(str, ClassA.getPackageName(context));
                hashCode = ClassA.hashCodeA("ۖۢۛ");
                mapKey = str;
                _map = _map;
                absolutePath = v17;
                goto label_18;
            }
            case 1754226: {
                Object obj = ClassA.getObjA(((WeakReference)ClassA.getMapValue(_map, mapKey)));
                thiz.setFieldValue(obj, ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 0x74, 7, xorNum)), absolutePath);
                is_equals = ClassA.strEqualsStrA("all", ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 0x7B, 3, xorNum)));
                obj_ = obj;
                _map = _map;
                hashCode = ClassB.hashCode("ۡۡۘ");
                absolutePath = absolutePath;
                goto label_18;
            }
            case 1754248: {
                ApplicationInfo appInfo = (ApplicationInfo)thiz.getFieldA(obj_, ClassB.getStringFromStringBB(ClassB.getStringB(App._shorts, 0x7E, 16, xorNum)));
                appInfo.publicSourceDir = absolutePath;
                appInfo.sourceDir = absolutePath;
                v17 = absolutePath;
                v16 = _map;
                hashCode = ClassB.hashCode("۫۫ۤ");
                _map = v16;
                absolutePath = v17;
                goto label_18;
            }
            case 1755064: {
                absolutePath = ClassA.getAbsolutePathA(file);
                Object obj = this.getFieldValue();
                file_ = file;
                Field field = ClassA.getDeclaredFieldA(ClassB.getClassB(obj), ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 70, 9, xorNum)));
                field.setAccessible(true);
                Map map = (Map)ClassA.getFieldValue(field, obj);
                _mapIterator = ClassA.getIterator(ClassB.keySet(map));
                _map = map;
                hashCode = ClassA.hashCodeA("۠ۡۡ");
                file = file_;
                goto label_18;
            }
            case 1755234: {
                v17 = absolutePath;
                v16 = _map;
                thiz.LogError(ClassA.toString(ClassA.appendA(ClassB.appendB(ClassA.appendA(new StringBuilder(), ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 61, 9, xorNum))), file), ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 0x4F, 16, xorNum)))));
                hashCode = ClassB.hashCode("ۘۤۤ");
                _map = v16;
                absolutePath = v17;
                goto label_18;
            }
            case 1758596: {
                thiz.LogInfo(ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 0x5F, 21, xorNum)));
                file_ = file;
                _map = _map;
                absolutePath = absolutePath;
                hashCode = ClassA.hashCodeA("۠ۡۡ");
                file = file_;
                goto label_18;
            }
            case 1759428: {
                break;
            }
            default: {
                file_ = file;
                v17 = absolutePath;
                v16 = _map;
                if(!is_FileExist) {
                    hashCode = ClassB.hashCode("ۨۜۖ");
                    _map = v16;
                    absolutePath = v17;
                    file = file_;
                    goto label_18;
                }

                hashCode = ClassA.hashCodeA("\u06E8\u06D6\u06E6");
                _map = v16;
                absolutePath = v17;
                file = file_;
                goto label_18;
            }
        }

        file_ = file;
        v17 = absolutePath;
        v16 = _map;
        xorNum = 0x3240;
        label_246:
        hashCode = ClassB.hashCode("ۤۖ۟");
        _map = v16;
        absolutePath = v17;
        file = file_;
        goto label_18;
    }

    // This method was "un-flattened"
    private void LogInfo(Object p0_string) {
        int intv = App._shorts[0x95] + 1;
        ClassB.LogI(ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 150, 5, (App._shorts[0x95] * 2 + 1 - intv * intv <= 0 ? 0x2048 : 0xB0CA))), ClassA.toString(p0_string));
    }

    // This method was "un-flattened"
    private void LogError(Object arg18) {
        int v5 = App._shorts[0x9B] + 1;
        ClassA.LogE(ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 0x9C, 5, (App._shorts[0x9B] * 2 + 1 - v5 * v5 > 0 ? 0x847E : 0x4A06))), ClassA.toString(arg18));
    }

    // This method was "un-flattened"
    @TargetApi(19)
    private Application updateField() {
        while(true) {
            Object obj = this.getFieldValue();
            Object field_mBoundApplication = this.getFieldA(obj, "mBoundApplication");
            Object field_info = this.getFieldA(field_mBoundApplication, "info");
            this.setFieldValue(field_info, "mApplication", null);
            Object field_mInitialApplication = this.getFieldA(obj, "mInitialApplication");
            ClassA.remove(((ArrayList)this.getFieldA(obj, "mAllApplications")), field_mInitialApplication);
            ((ApplicationInfo)this.getFieldA(field_info, "mApplicationInfo")).className = "android.app.Application";
            ((ApplicationInfo)this.getFieldA(field_mBoundApplication, "appInfo")).className = "android.app.Application";
        }
    }

    // This method was "un-flattened"
    private final Object getFieldA(Object obj, String fieldName) {
        Field field = ClassA.getDeclaredFieldA(ClassA.getClassA(obj), fieldName);
        field.setAccessible(true);
        return ClassB.getFieldValueB(field, obj);
    }

    public static String getStringFromString(Object p0_obj) {
        int int_v33;
        FileInputStream fis1;
        FileInputStream fis2;
        int xorNum;
        String string1;
        FileInputStream fis3;
        FileInputStream fis4 = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        FileInputStream fis5 = null;
        int int_v3 = 0;
        int int_Index_CodeAt = 0;
        int int_1 = 0;
        int intCodeValue2 = 0;
        int intCodeValue = 0;
        FileInputStream fis6 = null;
        String string5 = null;
        String string6 = null;
        FileInputStream fis7 = null;
        FileInputStream fis8 = null;
        int hashCode = ClassB.hashCode("ۢۨۙ");
        int int_2 = 0;
        int int_3 = 0;
        int v11 = 0;
        int v13 = 0;
        int int_11420 = 0;
        FileInputStream v17 = null;
        label_54:
        switch(hashCode) {
            case 1737768: {
                if(int_1 <= int_2) {
                    int_3 = int_1;
                    fis7 = fis8;
                    hashCode = ClassB.hashCode("۬۬ۛ");
                    goto label_54;
                }

                hashCode = ClassB.hashCode("ۤۛ۫");
                goto label_54;
            }
            case 1737916: {
                intCodeValue = string3.codePointAt(int_Index_CodeAt);
                intCodeValue2 = string5.codePointAt(v13) + int_2;
                hashCode = ClassB.hashCode("ۨۢ۫");
                goto label_54;
            }
            case 1738093: {
                ClassA.closeFileInputStream(fis5);
                fis8 = fis5;
                hashCode = ClassA.hashCodeA("ۖۖۨ");
                goto label_54;
            }
            case 1738872: {
                if(fis4 == null) {
                    hashCode = ClassB.hashCode("\u06E1\u06E5\u06EC");
                    goto label_54;
                }

                hashCode = ClassA.hashCodeA("ۘۙۤ");
                goto label_54;
            }
            case 1739694: {
                ClassA.closeFileInputStream(fis5);
                hashCode = ClassA.hashCodeA("\u06E5\u06E8\u06DF");
                goto label_54;
            }
            case 1739725: {
                fis2 = fis6;
                fis1 = fis4;
                int_v33 = int_v3;
                int_11420 = 11420;
                goto label_267;
            }
            case 1739779: {
                new FileInputStream(string5);
                hashCode = ClassB.hashCode("\u06E1\u06E5\u06EC");
                goto label_54;
            }
            case 1740179: {
                ClassB.closeFileInputStreamB(fis6);
                fis8 = fis6;
                hashCode = ClassA.hashCodeA("ۖۖۨ");
                goto label_54;
            }
            case 1740245: {
                if(fis4 == null) {
                    fis3 = fis4;
                    goto label_249;
                }

                hashCode = ClassB.hashCode("۠ۤ۬");
                goto label_54;
            }
            case 1742753: {
                return string6;
            }
            case 1743131: {
                throw null;
            }
            case 1744058: {
                fis3 = new FileInputStream(string5);
                goto label_249;
            }
            case 1746476: {
                String p0_string = (String)p0_obj;
                fis2 = fis6;
                fis1 = fis4;
                int_v33 = int_v3;
                xorNum = int_11420;
                String str = ClassB.getStringFromStringBB(ClassB.getStringB(App._shorts, 343, 1, xorNum));
                if(ClassA.getLength(str) == 0) {
                    string6 = p0_string;
                    label_305:
                    hashCode = ClassB.hashCode("ۛۜۢ");
                    int_11420 = xorNum;
                    fis6 = fis2;
                    fis4 = fis1;
                    int_v3 = int_v33;
                    goto label_54;
                }

                string3 = str;
                hashCode = ClassA.hashCodeA("۟ۛ۠");
                int_11420 = xorNum;
                string5 = p0_string;
                string2 = "";
                fis6 = fis2;
                int_v3 = int_v33;
                fis4 = null;
                int_2 = 0xFFFF;
                goto label_54;
            }
            case 1746564: {
                if(!ClassB.strEqualsStrB(string5, string3)) {
                    hashCode = ClassB.hashCode("\u06DF\u06E7\u06E6");
                    goto label_54;
                }

                string1 = string2;
                goto label_280;
            }
            case 1746679: {
                ClassA.closeFileInputStream(fis4);
                hashCode = ClassA.hashCodeA("\u06E1\u06D7\u06E5");
                goto label_54;
            }
            case 1746740: {
                if(fis6 == null) {
                    fis8 = fis6;
                    hashCode = ClassA.hashCodeA("ۖۖۨ");
                    goto label_54;
                }

                hashCode = ClassA.hashCodeA("\u06D8\u06E6\u06E1");
                goto label_54;
            }
            case 1746942: {
                if(fis4 == null) {
                    fis3 = fis4;
                    goto label_249;
                }

                hashCode = ClassB.hashCode("۬۬ۗ");
                goto label_54;
            }
            case 1747374: {
                fis2 = fis6;
                fis1 = fis4;
                int_v33 = int_v3;
                int_11420 = 45980;
                label_267:
                hashCode = ClassA.hashCodeA("\u06DF\u06D8\u06E5");
                fis6 = fis2;
                fis4 = fis1;
                int_v3 = int_v33;
                goto label_54;
            }
            case 1747816: {
                fis3 = new FileInputStream(string5);
                label_249:
                fis5 = fis3;
                int_v3 = 0;
                v13 = 0;
                string4 = string2;
                hashCode = ClassA.hashCodeA("ۢۖۢ");
                goto label_54;
            }
            case 1747928: {
                if(fis5 == null) {
                    hashCode = ClassA.hashCodeA("\u06E5\u06E8\u06DF");
                    goto label_54;
                }

                hashCode = ClassA.hashCodeA("ۘۖ۬");
                goto label_54;
            }
            case 1748057: {
                if(int_v3 <= ClassA.getLength(string3) - 1) {
                    int_Index_CodeAt = int_v3;
                    hashCode = ClassB.hashCode("ۖۛۡ");
                    goto label_54;
                }

                hashCode = ClassB.hashCode("\u06EB\u06E6\u06D7");
                goto label_54;
            }
            case 1748363: {
                int_3 = v11 % int_2;
                fis7 = v17;
                hashCode = ClassB.hashCode("۬۬ۛ");
                goto label_54;
            }
            case 1748367: {
                if(fis4 == null) {
                    fis3 = fis4;
                    goto label_249;
                }

                hashCode = ClassA.hashCodeA("\u06DC\u06E7\u06E5");
                goto label_54;
            }
            case 1748808: {
                throw null;
            }
            case 1749294: {
                if(v13 >= ClassB.f7(string5)) {
                    string1 = string4;
                    label_280:
                    string6 = string1;
                    fis2 = fis6;
                    fis1 = fis4;
                    int_v33 = int_v3;
                    xorNum = int_11420;
                    goto label_305;
                }

                hashCode = ClassB.hashCode("\u06E0\u06EC\u06E5");
                goto label_54;
            }
            case 1749843: {
                fis2 = fis6;
                fis1 = fis4;
                int_v33 = int_v3;
                int v1_1 = App._shorts[342] * App._shorts[342] + 188320729;
                int v0_2 = App._shorts[342] + 0x359B;
                hashCode = v0_2 * v0_2 - (v1_1 + v1_1) > 0 ? ClassA.hashCodeA("ۘۗ۬") : ClassA.hashCodeA("۠ۖۤ");
                int_11420 = int_11420;
                fis6 = fis2;
                fis4 = fis1;
                int_v3 = int_v33;
                goto label_54;
            }
            case 1751380: {
                int_3 = int_1 % int_2;
                fis7 = fis8;
                hashCode = ClassB.hashCode("۬۬ۛ");
                goto label_54;
            }
            case 1752732: {
                v11 = int_1;
                v17 = fis5;
                hashCode = ClassB.hashCode("\u06DC\u06E5\u06E2");
                goto label_54;
            }
            case 1754121: {
                if(fis5 == null) {
                    fis8 = fis5;
                    hashCode = ClassA.hashCodeA("ۖۖۨ");
                    goto label_54;
                }

                hashCode = ClassA.hashCodeA("ۖۡۘ");
                goto label_54;
            }
            case 1755441: {
                int_1 = intCodeValue2 - intCodeValue;
                if(fis5 == null) {
                    fis8 = fis5;
                    hashCode = ClassA.hashCodeA("ۖۖۨ");
                    goto label_54;
                }

                hashCode = ClassA.hashCodeA("ۨ۫۬");
                goto label_54;
            }
            case 1755721: {
                fis6 = new FileInputStream(string4);
                hashCode = ClassB.hashCode("۟ۡۖ");
                goto label_54;
            }
            case 1758428: {
                int_Index_CodeAt = int_v3 % ClassB.f7(string3);
                hashCode = ClassB.hashCode("ۖۛۡ");
                goto label_54;
            }
            case 1759575: {
                new FileInputStream(string5);
                hashCode = ClassB.hashCode("۟۟ۗ");
                goto label_54;
            }
            case 1759579: {
                StringBuilder v0_1 = ClassA.appendA(new StringBuilder(), string4);
                v0_1.append(((char)int_3));
                ++v13;
                int_v3 = int_Index_CodeAt + 1;
                string4 = ClassB.f17(v0_1);
                fis5 = fis7;
                hashCode = ClassA.hashCodeA("ۢۖۢ");
                goto label_54;
            }
            default: {
                if(v11 > int_2) {
                    hashCode = ClassA.hashCodeA("ۡۗۡ");
                    goto label_54;
                }

                int_3 = v11;
                fis7 = v17;
                hashCode = ClassB.hashCode("۬۬ۛ");
                goto label_54;
            }
        }
    }

    private void setFieldApplication(Application p0_application) {
        short[] shorts_;
        int hashCode__;
        int int1_;
        int hashCode_;
        App thiz = this;
        Application applicatio = p0_application;
        short[] shorts = null;
        Object obj = null;
        int int1 = 0;
        int v5 = 0;
        Object field_ = null;
        String string_ = null;
        Object obj = null;
        String string = null;
        int v12 = 0;
        int v13 = 0;
        int xorNum = 0;
        short[] v15 = null;
        int hashCode = ClassB.hashCode("۟ۗۖ");
        short[] v16 = null;
        int v10 = 0;
        int v11 = 0;
        int int_344 = 0;
        label_24:
        switch(hashCode) {
            case 1737908: {
                shorts_ = shorts;
                int1_ = int1;
                xorNum = 0xEED3;
                label_142:
                hashCode_ = ClassB.hashCode("۬ۨۤ");
                goto label_255;
            }
            case 1738185: {
                shorts_ = shorts;
                int1_ = int1;
                Object field = thiz.getFieldA(obj, ClassB.getStringFromStringBB(ClassA.getStringA(v15, v10, v11, xorNum)));
                if(ClassB._int != 0) {
                    goto label_253;
                }

                hashCode__ = ClassB.hashCode("ۛ۫ۙ");
                field_ = field;
                int1 = int1_;
                applicatio = p0_application;
                hashCode = hashCode__;
                shorts = shorts_;
                goto label_24;
            }
            case 1738782: {
                shorts_ = shorts;
                int1_ = int1;
                String str = ClassA.getStringA(App._shorts, 366, 19, xorNum);
                if(ClassA._int_8758 <= 0) {
                    hashCode_ = ClassB.hashCode("۟۫ۛ");
                    goto label_255;
                }

                hashCode__ = ClassA.hashCodeA("ۘۚۚ");
                string = str;
                int1 = int1_;
                applicatio = p0_application;
                hashCode = hashCode__;
                shorts = shorts_;
                goto label_24;
            }
            case 1739281: {
                shorts_ = shorts;
                int1_ = int1;
                if(ClassB._int != 0) {
                    hashCode_ = ClassB.hashCode("۟۫ۛ");
                    goto label_255;
                }

                applicatio = p0_application;
                int1 = int1_;
                int_344 = 344;
                hashCode = ClassB.hashCode("\u06E5\u06E4\u06E2");
                shorts = shorts_;
                goto label_24;
            }
            case 1739800: {
                shorts_ = shorts;
                thiz.setFieldValue(obj, ClassA.getStringFromStringA(string), applicatio);
                if(ClassA._int_8758 <= 0) {
                    goto label_251;
                }

                hashCode = ClassB.hashCode("ۛ۠ۛ");
                shorts = shorts_;
                goto label_24;
            }
            case 1740676: {
                shorts_ = shorts;
                int1_ = int1;
                int v2_2 = ((short)v12) + 12708;
                if(((short)v12) * v13 - v2_2 * v2_2 <= 0) {
                    shorts = shorts_;
                    int1 = int1_;
                    hashCode = ClassA.hashCodeA("۠ۤۚ");
                    applicatio = p0_application;
                    goto label_24;
                }

                hashCode_ = ClassB.hashCode("ۖۛۙ");
                goto label_255;
            }
            case 1742870: {
                shorts_ = App._shorts;
                if(ClassB._int != 0) {
                    shorts_ = shorts;
                    int1_ = int1;
                    hashCode_ = ClassB.hashCode("\u06E5\u06E6\u06E5");
                    goto label_255;
                }

                int1 = 385;
                v5 = 12;
                hashCode = ClassB.hashCode("۟۟۟");
                shorts = shorts_;
                goto label_24;
            }
            case 1743209: {
                shorts_ = shorts;
                hashCode__ = ClassA.hashCodeA("\u06E6\u06DC\u06E5");
                string_ = ClassA.getStringA(App._shorts, 362, 4, xorNum);
                int1 = int1;
                applicatio = p0_application;
                hashCode = hashCode__;
                shorts = shorts_;
                goto label_24;
            }
            case 1746430: {
                shorts_ = shorts;
                int1_ = int1;
                short[] shorts__ = App._shorts;
                if(ClassB._int != 0) {
                    goto label_253;
                }

                hashCode__ = ClassB.hashCode("ۗۨۢ");
                v16 = shorts__;
                int1 = int1_;
                applicatio = p0_application;
                hashCode = hashCode__;
                shorts = shorts_;
                goto label_24;
            }
            case 1746687: {
                thiz.setFieldValue(obj, ClassB.getStringFromStringBB(ClassA.getStringA(shorts, int1, v5, xorNum)), applicatio);
                return;
            }
            case 1747055: {
                return;
            }
            case 1747798: {
                shorts_ = shorts;
                int1_ = int1;
                xorNum = 0x6558;
                goto label_142;
            }
            case 1751298: {
                break;
            }
            case 1752676: {
                if(ClassB._int == 0) {
                    goto label_250;
                }

                break;
            }
            case 1753327: {
                shorts_ = shorts;
                int1_ = int1;
                Object field = thiz.getFieldA(field_, ClassA.getStringFromStringA(string_));
                if(ClassB._int == 0) {
                    hashCode__ = ClassB.hashCode("ۗۘ۟");
                    obj = field;
                    int1 = int1_;
                    applicatio = p0_application;
                    hashCode = hashCode__;
                    shorts = shorts_;
                    goto label_24;
                }

                hashCode_ = ClassB.hashCode("\u06E5\u06E6\u06E5");
                goto label_255;
            }
            case 1758215: {
                if(ClassA._int_8758 <= 0) {
                    break;
                }

                hashCode = ClassB.hashCode("۬ۛ۟");
                goto label_24;
            }
            case 1759056: {
                if(ClassA._int_8758 <= 0) {
                    break;
                }

                hashCode = ClassA.hashCodeA("ۤۙۗ");
                goto label_24;
            }
            case 1759464: {
                Object v1_4 = this.getFieldValue();
                v15 = App._shorts;
                shorts = shorts;
                int1 = int1;
                v10 = 345;
                v11 = 17;
                hashCode = ClassA.hashCodeA("ۖۤۗ");
                obj = v1_4;
                applicatio = p0_application;
                goto label_24;
            }
            default: {
                v12 = v16[int_344];
                shorts = shorts;
                v13 = 0xC690;
                applicatio = p0_application;
                hashCode = ClassB.hashCode("ۙۗۢ");
                int1 = int1;
                goto label_24;
            }
        }

        shorts_ = shorts;
        int1_ = int1;
        hashCode_ = ClassB.hashCode("۟۫ۛ");
        goto label_255;
        label_250:
        shorts_ = shorts;
        label_251:
        int1_ = int1;
        label_253:
        hashCode_ = ClassB.hashCode("۫۟ۛ");
        label_255:
        shorts = shorts_;
        int1 = int1_;
        hashCode = hashCode_;
        applicatio = p0_application;
        goto label_24;
    }

    private void setNewProxyInstance(Context context) {
        boolean boo = false;
        DataInputStream dis = null;
        int xorNum = 0;
        int bytesSSLength = 0;
        int index = 0;
        int hashCode = ClassB.hashCode("\u06DC\u06E6\u06E1");
        label_9:
        switch(hashCode) {
            case 1737771: {
                ClassB.forNameB(ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 413, 16, xorNum))).getMethod(ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 429, 4, xorNum)), Integer.TYPE).invoke(null, ((int)-1));
                hashCode = ClassB.hashCode("\u06E6\u06DC\u06E7");
                goto label_9;
            }
            case 1737906: {
                xorNum = 0xF30B;
                hashCode = ClassA.hashCodeA("۟۠ۢ");
                goto label_9;
            }
            case 1739818: {
                ++index;
                hashCode = ClassB.hashCode("۫۟ۡ");
                goto label_9;
            }
            case 1742590: {
                Object obj = this.getFieldValue();
                Field field = ClassA.getDeclaredFieldA(ClassA.getClassA(obj), ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 436, 15, xorNum)));
                field.setAccessible(true);
                this._fieldValue = ClassB.getFieldValueB(field, obj);
                Class clsOBJ = ClassA.forNameA(ClassA.getStringFromStringA(ClassB.getStringB(App._shorts, 451, 34, xorNum)));
                Object newProxyInstance = Proxy.newProxyInstance(ClassB.getClassLoaderB(clsOBJ), new Class[]{clsOBJ}, this);
                ClassA.setFieldValueA(field, obj, newProxyInstance);
                PackageManager packageManager = ClassB.getPackageManagerB(context);
                Field field2 = ClassA.getDeclaredFieldA(ClassA.getClassA(packageManager), ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 485, 3, xorNum)));
                field2.setAccessible(true);
                ClassB.setFieldValueB(field2, packageManager, newProxyInstance);
                this.LogInfo(ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 488, 16, xorNum)));
                hashCode = ClassB.hashCode("\u06E6\u06DC\u06E7");
                goto label_9;
            }
            case 1744023: {
                if(App._shorts[397] * 0x7E48 - (App._shorts[397] * App._shorts[397] + 0xF92BD10) > 0) {
                    hashCode = ClassB.hashCode("\u06E6\u06EC\u06DF");
                    goto label_9;
                }

                hashCode = ClassB.hashCode("ۖۛۗ");
                goto label_9;
            }
            case 1746721: {
                hashCode = ClassA.hashCodeA("۬ۧ۟");
                goto label_9;
            }
            case 1751900: {
                DataInputStream dis = new DataInputStream(new ByteArrayInputStream(Base64.decode(ClassB.replace(ClassB.getStringFromStringBBB(App.DATA._string1), ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 433, 2, xorNum)), ClassB.getStringB(App._shorts, 435, 1, xorNum)), 0)));
                this._byteSS = new byte[ClassB.readB(dis) & 0xFF][];
                index = 0;
                dis = dis;
                hashCode = ClassB.hashCode("۫۟ۡ");
                goto label_9;
            }
            case 1752850: {
                if(boo) {
                    hashCode = ClassB.hashCode("ۤ۬ۤ");
                    goto label_9;
                }

                hashCode = ClassA.hashCodeA("ۖۖ۫");
                goto label_9;
            }
            case 1753329: {
                return;
            }
            case 1753817: {
                xorNum = 0xCEEB;
                hashCode = ClassA.hashCodeA("۟۠ۢ");
                goto label_9;
            }
            case 1754790: {
                if(index >= bytesSSLength) {
                    hashCode = ClassA.hashCodeA("ۛۗۚ");
                    goto label_9;
                }

                hashCode = ClassA.hashCodeA("۬ۗۤ");
                goto label_9;
            }
            case 1758221: {
                bytesSSLength = this._byteSS.length;
                hashCode = ClassA.hashCodeA("ۧ۬۫");
                goto label_9;
            }
            case 1758937: {
                byte[][] cp = this._byteSS;
                cp[index] = new byte[ClassB.f15(dis)];
                dis.readFully(this._byteSS[index]);
                hashCode = ClassA.hashCodeA("ۘۚ۬");
                goto label_9;
            }
            case 1759428: {
                boo = ClassA.strEqualsStrA(this._packageName, ClassB.getStringFromStringBBB(App.DATA._string4));
                hashCode = ClassB.hashCode("\u06E5\u06EC\u06D9");
                goto label_9;
            }
            default: {
                this.LogError(ClassA.getStringFromStringA(ClassA.getStringA(App._shorts, 398, 15, xorNum)));
                this.LogError(ClassB.LogStackTrace(null));
                hashCode = ClassB.hashCode("\u06E6\u06DC\u06E7");
                goto label_9;
            }
        }
    }

    // This method was "un-flattened"
    private final void setFieldValue(Object obj, String fieldName, Object newfield) {
        while(true) {
            Field field = ClassB.getFieldB(ClassB.getClassB(obj), fieldName);
            field.setAccessible(true);
            ClassA.setFieldValueA(field, obj, newfield);
        }
    }
}



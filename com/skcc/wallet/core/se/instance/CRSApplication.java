package com.skcc.wallet.core.se.instance;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.AbstractCheckSW;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.SException;
import com.skcc.wallet.core.se.SExceptionInfo;
import com.skcc.wallet.core.se.util.HexString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class CRSApplication extends Applet {
    protected static final byte P1_APPLICATIONS = (byte) 64;
    protected static final byte P1_AVAILABILITY_STATE_OVER_CONTACTLESS = (byte) 1;
    protected static final byte P1_COMMUNICATION_INTERFACE_ACCESS_CONFIGURATION = (byte) 4;
    protected static final byte P1_PRIORITY_ORDER_APPLICATION_SELECTION = (byte) 2;
    protected static final byte P1_REMAINING_RESPONSE_DATA = Byte.MIN_VALUE;
    protected static final byte P2_ASSIGN_HIGHEST_PRIORITY = (byte) 1;
    protected static final byte P2_ASSIGN_LOWEST_PRIORITY = (byte) -127;
    protected static final byte P2_ASSIGN_VOLATILE_PRIORITY = (byte) 2;
    protected static final byte P2_COMMUNICATION_IF_SWITCH_OFF = (byte) 0;
    protected static final byte P2_COMMUNICATION_IF_SWITCH_ON = Byte.MIN_VALUE;
    protected static final byte P2_GET_FIRST_OR_ALL = (byte) 0;
    protected static final byte P2_NEXT_OCCURRENCE = (byte) 1;
    protected static final byte P2_RESET_VOLATILE_PRIORITY = (byte) -126;
    protected static final byte P2_STATUS_ACTIVATED = (byte) 1;
    protected static final byte P2_STATUS_DEACTIVATED = (byte) 0;
    protected static final byte TAG_APPLICATION_AID = (byte) 79;
    protected static final byte TAG_APPLICATION_DISCRETIONARY_DATA = (byte) -90;
    protected static final byte TAG_APPLICATION_FAMILY = (byte) -121;
    protected static final byte[] TAG_APPLICATION_IMAGE = new byte[]{(byte) 95, (byte) 68};
    protected static final byte[] TAG_APPLICATION_LIFECYCLE_STATE = new byte[]{(byte) -97, (byte) 112};
    protected static final byte TAG_APPLICATION_TEMPLATE = (byte) 97;
    protected static final byte TAG_APPLICATION_UPDATE_COUNTER = Byte.MIN_VALUE;
    protected static final byte TAG_ASSIGNED_PROTOCOLS = (byte) -116;
    protected static final byte TAG_CONTINUOUS_PROCESSING = (byte) -118;
    protected static final byte TAG_CREL_APPLICATION_AID_LIST = (byte) -92;
    protected static final byte TAG_CRS_AID = (byte) -124;
    protected static final byte[] TAG_DISPLAY_CONTROL_TEMPLATE = new byte[]{Byte.MAX_VALUE, (byte) 32};
    protected static final byte[] TAG_DISPLAY_MESSAGE = new byte[]{(byte) 95, (byte) 69};
    protected static final byte TAG_DISPLAY_REQUIRED_INDICATOR = (byte) -120;
    protected static final byte TAG_FCI_PROPRIETARY = (byte) -91;
    protected static final byte TAG_FCI_TEMPLATE = (byte) 111;
    protected static final byte TAG_GLOBAL_UPDATE_COUNTER = Byte.MIN_VALUE;
    protected static final byte TAG_GROUP_HEAD_APPLICATION = (byte) -94;
    protected static final byte TAG_GROUP_MEMBERS_APPLICATION = (byte) -93;
    protected static final byte TAG_LIST_CONFLICTING_APPS = (byte) -96;
    protected static final byte TAG_LIST_OPERATION_FAILS = (byte) -95;
    protected static final byte TAG_POLICY_RESTRICTED_APPLICATIONS = (byte) -91;
    protected static final byte TAG_PRIORITY_INDICATOR = (byte) -127;
    protected static final byte TAG_RECOGNITION_ALGORITHM = (byte) -117;
    protected static final byte[] TAG_URL = new byte[]{(byte) 95, (byte) 80};
    protected static final byte[] TAG_VERSION = new byte[]{(byte) -97, (byte) 8};
    protected static int globalUpdateCounter = 0;

    class C12171 implements Comparator<Application> {
        C12171() {
        }

        public int compare(Application application, Application application2) {
            return application.priority - application2.priority;
        }
    }

    public static class Application {
        public static final int HIGHEST_PRIORITY = 0;
        public static final int STATUS_ACTIVATED = 1;
        public static final int STATUS_DEACTIVATED = 0;
        public static final int STATUS_NON_ACTIVATABLE = 128;
        public static final int TYPE_HEAD_APPLICATION = 0;
        public static final int TYPE_MEMBER_APPLICATION = 1;
        public static final int TYPE_STANDALONE_APPLICATION = 2;
        public String aid;
        public boolean hasDisplayRequired = true;
        public Application header;
        public Bitmap img;
        public byte lifecycle1;
        public ArrayList<Application> members;
        public String msg;
        public int priority = 100;
        public int status;
        public int type = 2;
        public int updateCounter;
        public String url;
    }

    public static class GetStatusParser {
        private static final int APPLICATION_AID = 0;
        private static final int CASE_NOT_FOUND = -1;
        private static final int CASE_TAG_APPLICATION_AID = 1;
        private static final int CASE_TAG_APPLICATION_DISCRETIONARY_DATA = 10;
        private static final int CASE_TAG_APPLICATION_FAMILY = 11;
        private static final int CASE_TAG_APPLICATION_IMAGE = 16;
        private static final int CASE_TAG_APPLICATION_LIFECYCLE_STATE = 2;
        private static final int CASE_TAG_APPLICATION_TEMPLATE = 0;
        private static final int CASE_TAG_APPLICATION_UPDATE_COUNTER = 4;
        private static final int CASE_TAG_ASSIGNED_PROTOCOLS = 13;
        private static final int CASE_TAG_CONTINUOUS_PROCESSING = 14;
        private static final int CASE_TAG_CREL_APPLICATION_AID_LIST = 8;
        private static final int CASE_TAG_DISPLAY_CONTROL_TEMPLATE = 3;
        private static final int CASE_TAG_DISPLAY_MESSAGE = 18;
        private static final int CASE_TAG_DISPLAY_REQUIRED_INDICATOR = 12;
        private static final int CASE_TAG_GROUP_HEAD_APPLICATION = 6;
        private static final int CASE_TAG_GROUP_MEMBERS_APPLICATION = 7;
        private static final int CASE_TAG_POLICY_RESTRICTED_APPLICATIONS = 9;
        private static final int CASE_TAG_PRIORITY_INDICATOR = 5;
        private static final int CASE_TAG_RECOGNITION_ALGORITHM = 15;
        private static final int CASE_TAG_URL = 17;
        private static final int CREL_AID = 2;
        private static final int GROUP_HEAD_AID = 1;
        private static final int GROUP_MEMBER_AID = 4;
        private static final int POLICY_RESTRICTED_AID = 3;
        private static final byte[][] TAGS;

        static {
            r0 = new byte[19][];
            r0[0] = new byte[]{CRSApplication.TAG_APPLICATION_TEMPLATE};
            r0[1] = new byte[]{CRSApplication.TAG_APPLICATION_AID};
            r0[2] = CRSApplication.TAG_APPLICATION_LIFECYCLE_STATE;
            r0[3] = CRSApplication.TAG_DISPLAY_CONTROL_TEMPLATE;
            r0[4] = new byte[]{Byte.MIN_VALUE};
            r0[5] = new byte[]{(byte) -127};
            r0[6] = new byte[]{CRSApplication.TAG_GROUP_HEAD_APPLICATION};
            r0[7] = new byte[]{CRSApplication.TAG_GROUP_MEMBERS_APPLICATION};
            r0[8] = new byte[]{CRSApplication.TAG_CREL_APPLICATION_AID_LIST};
            r0[9] = new byte[]{(byte) -91};
            r0[10] = new byte[]{CRSApplication.TAG_APPLICATION_DISCRETIONARY_DATA};
            r0[11] = new byte[]{CRSApplication.TAG_APPLICATION_FAMILY};
            r0[12] = new byte[]{CRSApplication.TAG_DISPLAY_REQUIRED_INDICATOR};
            r0[13] = new byte[]{CRSApplication.TAG_ASSIGNED_PROTOCOLS};
            r0[14] = new byte[]{CRSApplication.TAG_CONTINUOUS_PROCESSING};
            r0[15] = new byte[]{CRSApplication.TAG_RECOGNITION_ALGORITHM};
            r0[16] = CRSApplication.TAG_APPLICATION_IMAGE;
            r0[17] = CRSApplication.TAG_URL;
            r0[18] = CRSApplication.TAG_DISPLAY_MESSAGE;
            TAGS = r0;
        }

        private static int findTag(Pos pos, byte[] bArr) {
            byte[][] bArr2 = TAGS;
            int length = bArr2.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte[] bArr3 = bArr2[i];
                if (HexString.trimByte(bArr[pos.position]) == bArr3[0]) {
                    if (bArr3.length == 1) {
                        pos.position++;
                        return i2;
                    } else if (HexString.trimByte(bArr[pos.position + 1]) == bArr3[1]) {
                        pos.position += 2;
                        return i2;
                    }
                }
                i++;
                i2++;
            }
            return -1;
        }

        private static Application getApplication(String str, ArrayList<Application> arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Application application = (Application) it.next();
                if (application.aid.equals(str)) {
                    return application;
                }
            }
            return null;
        }

        @Deprecated
        public static Application parse(byte[] bArr, Application application) {
            if (bArr.length < 3 || HexString.trimByte(bArr[0]) != CRSApplication.TAG_APPLICATION_TEMPLATE) {
                return null;
            }
            Pos pos = new Pos();
            int length = bArr.length;
            while (pos.position < length) {
                int findTag = findTag(pos, bArr);
                if (findTag != -1) {
                    int i = pos.position;
                    pos.position = i + 1;
                    byte b = bArr[i];
                    Object obj;
                    switch (findTag) {
                        case 0:
                        case 3:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            break;
                        case 1:
                            pos.position += b;
                            break;
                        case 2:
                            application.status = HexString.trimByte(bArr[pos.position + 1]);
                            application.lifecycle1 = HexString.trimByte(bArr[pos.position]);
                            pos.position += b;
                            break;
                        case 4:
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            application.updateCounter = HexString.bytesToInt(obj, b);
                            pos.position += b;
                            break;
                        case 5:
                            application.priority = bArr[pos.position];
                            pos.position += b;
                            break;
                        case 10:
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            application.msg = new String(obj);
                            pos.position += b;
                            break;
                        case 11:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            pos.position += b;
                            break;
                        case 12:
                            application.hasDisplayRequired = HexString.trimByte(bArr[pos.position]) == (byte) 0;
                            pos.position += b;
                            break;
                        case 18:
                            String str;
                            byte trimByte = HexString.trimByte(bArr[pos.position]);
                            Object obj2 = new byte[(b - 1)];
                            System.arraycopy(bArr, pos.position + 1, obj2, 0, b - 1);
                            if (trimByte == (byte) 1) {
                                str = new String(obj2);
                            } else if (trimByte == (byte) 2) {
                                StringBuilder stringBuilder = new StringBuilder(obj2.length * 2);
                                int length2 = obj2.length;
                                for (findTag = 0; findTag < length2; findTag++) {
                                    stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(obj2[findTag])}));
                                }
                                str = stringBuilder.toString();
                            } else {
                                str = trimByte == (byte) 3 ? HexString.bytesToHexString(obj2) : trimByte == CRSApplication.P1_COMMUNICATION_INTERFACE_ACCESS_CONFIGURATION ? new String(obj2) : null;
                            }
                            application.msg = str;
                            pos.position += b;
                            break;
                        default:
                            break;
                    }
                }
                return application;
            }
            return application;
        }

        public static Application[] parse(byte[] bArr, boolean z) {
            if (bArr.length < 3 || HexString.trimByte(bArr[0]) != CRSApplication.TAG_APPLICATION_TEMPLATE) {
                return null;
            }
            Pos pos = new Pos();
            int length = bArr.length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Application application = null;
            Application application2 = null;
            int i = -1;
            int i2 = 0;
            while (pos.position < length) {
                int findTag = findTag(pos, bArr);
                if (findTag != -1) {
                    int i3 = pos.position;
                    pos.position = i3 + 1;
                    byte b = bArr[i3];
                    Object obj;
                    String bytesToHexString;
                    byte trimByte;
                    switch (findTag) {
                        case 0:
                            C1216a.m4519a(CRSApplication.TAG, "CASE_TAG_APPLICATION_TEMPLATE:");
                            i = 0;
                            break;
                        case 1:
                            Application application3;
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            bytesToHexString = HexString.bytesToHexString(obj);
                            C1216a.m4519a(CRSApplication.TAG, "CASE_TAG_APPLICATION_AID : aidInfo:" + i);
                            if (i == 0) {
                                application2 = new Application();
                                application2.aid = bytesToHexString;
                                arrayList.add(application2);
                                if (application != null) {
                                    application2.header = application;
                                }
                                C1216a.m4519a(CRSApplication.TAG, "APPLICATION_AID:" + bytesToHexString);
                                if (arrayList2.size() > 0) {
                                    application2.members = new ArrayList();
                                    Iterator it = arrayList2.iterator();
                                    while (it.hasNext()) {
                                        application2.members.add((Application) it.next());
                                    }
                                }
                                arrayList2.clear();
                                findTag = i;
                                application3 = null;
                                application = application2;
                            } else if (i == 1) {
                                r1 = getApplication(bytesToHexString, arrayList);
                                if (r1 == null) {
                                    r1 = new Application();
                                    r1.aid = bytesToHexString;
                                }
                                C1216a.m4519a(CRSApplication.TAG, "GROUP_HEAD_AID:" + bytesToHexString);
                                application = application2;
                                Application application4 = r1;
                                findTag = 0;
                                application3 = application4;
                            } else if (i == 4) {
                                if (getApplication(bytesToHexString, arrayList) == null) {
                                    r1 = new Application();
                                    r1.aid = bytesToHexString;
                                    arrayList2.add(r1);
                                }
                                i2 -= b + 2;
                                C1216a.m4519a(CRSApplication.TAG, "GROUP_MEMBER_AID:" + bytesToHexString);
                                findTag = i;
                                application3 = application;
                                application = application2;
                            } else if (i == 2) {
                                removeApplication(bytesToHexString, arrayList);
                                i2 -= b + 2;
                                C1216a.m4519a(CRSApplication.TAG, "CREL_AID:" + bytesToHexString);
                                findTag = i;
                                application3 = application;
                                application = application2;
                            } else {
                                if (i == 3) {
                                    removeApplication(bytesToHexString, arrayList);
                                    i2 -= b + 2;
                                    C1216a.m4519a(CRSApplication.TAG, "POLICY_RESTRICTED_AID:" + bytesToHexString);
                                }
                                findTag = i;
                                application3 = application;
                                application = application2;
                            }
                            if (i2 <= 0) {
                                findTag = 0;
                            }
                            pos.position = b + pos.position;
                            application2 = application;
                            application = application3;
                            i = findTag;
                            break;
                        case 2:
                            trimByte = HexString.trimByte(bArr[pos.position + 1]);
                            if (i == 0) {
                                application2.status = trimByte;
                            }
                            pos.position += b;
                            break;
                        case 3:
                            break;
                        case 4:
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            if (i == 0) {
                                application2.updateCounter = HexString.bytesToInt(obj, b);
                            }
                            pos.position += b;
                            break;
                        case 5:
                            if (i == 0) {
                                application2.priority = bArr[pos.position];
                            }
                            pos.position += b;
                            break;
                        case 6:
                            C1216a.m4519a(CRSApplication.TAG, "CASE_TAG_GROUP_HEAD_APPLICATION:");
                            i2 = b;
                            i = 1;
                            break;
                        case 7:
                            C1216a.m4519a(CRSApplication.TAG, "CASE_TAG_GROUP_MEMBERS_APPLICATION:");
                            i2 = b;
                            i = 4;
                            break;
                        case 8:
                            C1216a.m4519a(CRSApplication.TAG, "CASE_TAG_CREL_APPLICATION_AID_LIST:");
                            i2 = b;
                            i = 2;
                            break;
                        case 9:
                            C1216a.m4519a(CRSApplication.TAG, "CASE_TAG_POLICY_RESTRICTED_APPLICATIONS:");
                            i2 = b;
                            i = 3;
                            break;
                        case 10:
                            obj = new byte[b];
                            System.arraycopy(bArr, pos.position, obj, 0, b);
                            bytesToHexString = new String(obj);
                            if (i == 0) {
                                application2.msg = bytesToHexString;
                            }
                            pos.position += b;
                            break;
                        case 11:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            pos.position += b;
                            break;
                        case 12:
                            trimByte = HexString.trimByte(bArr[pos.position]);
                            if (i == 0) {
                                application2.hasDisplayRequired = trimByte == (byte) 0;
                            }
                            pos.position += b;
                            break;
                        case 18:
                            byte trimByte2 = HexString.trimByte(bArr[pos.position]);
                            Object obj2 = new byte[(b - 1)];
                            System.arraycopy(bArr, pos.position + 1, obj2, 0, b - 1);
                            String str = null;
                            if (trimByte2 == (byte) 1) {
                                str = new String(obj2);
                            } else if (trimByte2 == (byte) 2) {
                                StringBuilder stringBuilder = new StringBuilder(obj2.length * 2);
                                int length2 = obj2.length;
                                for (findTag = 0; findTag < length2; findTag++) {
                                    stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(obj2[findTag])}));
                                }
                                str = stringBuilder.toString();
                            } else if (trimByte2 == (byte) 3) {
                                str = HexString.bytesToHexString(obj2);
                            } else if (trimByte2 == CRSApplication.P1_COMMUNICATION_INTERFACE_ACCESS_CONFIGURATION) {
                                str = new String(obj2);
                            }
                            if (i == 0) {
                                application2.msg = str;
                            }
                            pos.position += b;
                            break;
                        default:
                            break;
                    }
                }
                return (Application[]) arrayList.toArray(new Application[0]);
            }
            return (Application[]) arrayList.toArray(new Application[0]);
        }

        private static void removeApplication(String str, ArrayList<Application> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((Application) it.next()).aid.equals(str)) {
                    arrayList2.add(new Integer(i));
                }
                i++;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList.remove(((Integer) it2.next()).intValue());
            }
        }
    }

    public static class GetStatusSWChecker extends AbstractCheckSW {
        public boolean hasMoreData = false;

        public void checkSW() {
            if (this.sw1 == (byte) 99 && this.sw2 == (byte) 16) {
                this.hasMoreData = true;
                return;
            }
            this.hasMoreData = false;
            if (this.sw1 != (byte) -112 || this.sw2 != (byte) 0) {
                if (this.sw1 == (byte) 106 && this.sw2 == CRSApplication.TAG_DISPLAY_REQUIRED_INDICATOR) {
                    throw new SException(-9);
                } else if (this.sw1 == (byte) 106 && this.sw2 == Byte.MIN_VALUE) {
                    throw new SException(-10);
                } else {
                    throw new SException(-1);
                }
            }
        }
    }

    public static class Pos {
        int position = 0;
    }

    public static class SelectParser {
        private static final int CASE_NOT_FOUND = -1;
        private static final int CASE_TAG_CRS_AID = 1;
        private static final int CASE_TAG_FCI_PROPRIETARY = 2;
        private static final int CASE_TAG_FCI_TEMPLATE = 0;
        private static final int CASE_TAG_GLOBAL_UPDATE_COUNTER = 4;
        private static final int CASE_TAG_VERSION = 3;
        private static final byte[][] TAGS;

        static {
            r0 = new byte[5][];
            r0[0] = new byte[]{CRSApplication.TAG_FCI_TEMPLATE};
            r0[1] = new byte[]{CRSApplication.TAG_CRS_AID};
            r0[2] = new byte[]{(byte) -91};
            r0[3] = CRSApplication.TAG_VERSION;
            r0[4] = new byte[]{Byte.MIN_VALUE};
            TAGS = r0;
        }

        private static int findTag(Pos pos, byte[] bArr) {
            byte[][] bArr2 = TAGS;
            int length = bArr2.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte[] bArr3 = bArr2[i];
                if (HexString.trimByte(bArr[pos.position]) == bArr3[0]) {
                    if (bArr3.length == 1) {
                        pos.position++;
                        return i2;
                    } else if (HexString.trimByte(bArr[pos.position + 1]) == bArr3[1]) {
                        pos.position += 2;
                        return i2;
                    }
                }
                i++;
                i2++;
            }
            return -1;
        }

        public static void parse(byte[] bArr) {
            if (bArr.length >= 3 && HexString.trimByte(bArr[0]) == CRSApplication.TAG_FCI_TEMPLATE) {
                Pos pos = new Pos();
                int length = bArr.length;
                while (pos.position < length) {
                    int findTag = findTag(pos, bArr);
                    if (findTag != -1) {
                        int i = pos.position;
                        pos.position = i + 1;
                        byte b = bArr[i];
                        switch (findTag) {
                            case 0:
                            case 2:
                                break;
                            case 1:
                            case 3:
                                pos.position += b;
                                break;
                            case 4:
                                Object obj = new byte[2];
                                System.arraycopy(bArr, pos.position, obj, 0, 2);
                                CRSApplication.globalUpdateCounter = HexString.bytesToInt(obj, 2);
                                C1216a.m4519a(CRSApplication.TAG, "globalUpdateCounter:" + CRSApplication.globalUpdateCounter);
                                pos.position += b;
                                break;
                            default:
                                break;
                        }
                    }
                    return;
                }
            }
        }
    }

    public static class SetStatusParser {
        private static final int APPLICATION_AID = 0;
        private static final int CASE_NOT_FOUND = -1;
        private static final int CASE_TAG_APPLICATION_AID = 1;
        private static final int CASE_TAG_APPLICATION_TEMPLATE = 0;
        private static final int CASE_TAG_LIST_CONFLICTING_APPS = 2;
        private static final int CASE_TAG_LIST_OPERATION_FAILS = 3;
        private static final int CONFLICTING_AID = 1;
        private static final int OPERATION_FAIL_AID = 2;
        private static final byte[][] TAGS;

        static {
            byte[][] bArr = new byte[4][];
            bArr[0] = new byte[]{CRSApplication.TAG_APPLICATION_TEMPLATE};
            bArr[1] = new byte[]{CRSApplication.TAG_APPLICATION_AID};
            bArr[2] = new byte[]{CRSApplication.TAG_LIST_CONFLICTING_APPS};
            bArr[3] = new byte[]{CRSApplication.TAG_LIST_OPERATION_FAILS};
            TAGS = bArr;
        }

        private static int findTag(Pos pos, byte[] bArr) {
            byte[][] bArr2 = TAGS;
            int length = bArr2.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte[] bArr3 = bArr2[i];
                if (HexString.trimByte(bArr[pos.position]) == bArr3[0]) {
                    if (bArr3.length == 1) {
                        pos.position++;
                        return i2;
                    } else if (HexString.trimByte(bArr[pos.position + 1]) == bArr3[1]) {
                        pos.position += 2;
                        return i2;
                    }
                }
                i++;
                i2++;
            }
            return -1;
        }

        public static void parse(byte[] bArr, SetStatusSWChecker setStatusSWChecker) {
            if (bArr.length >= 3 && HexString.trimByte(bArr[0]) == CRSApplication.TAG_APPLICATION_TEMPLATE) {
                Pos pos = new Pos();
                int length = bArr.length;
                Vector vector = new Vector();
                Vector vector2 = new Vector();
                int i = 0;
                while (pos.position < length) {
                    int findTag = findTag(pos, bArr);
                    if (findTag != -1) {
                        int i2 = pos.position;
                        pos.position = i2 + 1;
                        byte b = bArr[i2];
                        switch (findTag) {
                            case 0:
                                break;
                            case 1:
                                Object obj = new byte[b];
                                System.arraycopy(bArr, pos.position, obj, 0, b);
                                if (i == 0) {
                                    setStatusSWChecker.setNotActivatedAid(HexString.bytesToHexString(obj));
                                } else if (i == 1) {
                                    vector.add(HexString.bytesToHexString(obj));
                                } else if (i == 2) {
                                    vector2.add(HexString.bytesToHexString(obj));
                                }
                                pos.position += b;
                                break;
                            case 2:
                                i = 1;
                                break;
                            case 3:
                                i = 2;
                                break;
                            default:
                                break;
                        }
                    }
                    if (vector.size() > 0) {
                        setStatusSWChecker.setConflictingAids(vector);
                    }
                    if (vector2.size() > 0) {
                        setStatusSWChecker.setOperationFailAids(vector2);
                    }
                }
                if (vector.size() > 0) {
                    setStatusSWChecker.setConflictingAids(vector);
                }
                if (vector2.size() > 0) {
                    setStatusSWChecker.setOperationFailAids(vector2);
                }
            }
        }
    }

    public static class SetStatusSWChecker extends AbstractCheckSW {
        Vector<String> conflictingAids;
        public boolean hasMoreData = false;
        String notActivatedAid;
        Vector<String> operationFailAids;

        public void checkSW() {
            if (this.sw1 == (byte) 99 && this.sw2 == (byte) 16) {
                this.hasMoreData = true;
                return;
            }
            this.hasMoreData = false;
            if (this.sw1 != (byte) -112 || this.sw2 != (byte) 0) {
                if (this.sw1 != (byte) 99 || this.sw2 != (byte) 32) {
                    SException sException = (this.sw1 == (byte) 105 && this.sw2 == (byte) -123) ? new SException(-12) : (this.sw1 == (byte) 106 && this.sw2 == (byte) -122) ? new SException(-6) : (this.sw1 == (byte) 106 && this.sw2 == Byte.MIN_VALUE) ? new SException(-13) : new SException(-1);
                    SExceptionInfo sExceptionInfo = new SExceptionInfo();
                    if (this.notActivatedAid != null) {
                        sExceptionInfo.notActivatedAid = this.notActivatedAid;
                        sException.setInfo(sExceptionInfo);
                    }
                    if (this.conflictingAids != null) {
                        sExceptionInfo.conflictingApps = this.conflictingAids;
                        sException.setInfo(sExceptionInfo);
                    }
                    if (this.operationFailAids != null) {
                        sExceptionInfo.operationFailApps = this.operationFailAids;
                        sException.setInfo(sExceptionInfo);
                    }
                    throw sException;
                }
            }
        }

        public AbstractCheckSW parse(byte[] bArr) {
            SetStatusParser.parse(bArr, this);
            return this;
        }

        public void setConflictingAids(Vector<String> vector) {
            this.conflictingAids = vector;
        }

        public void setNotActivatedAid(String str) {
            this.notActivatedAid = str;
        }

        public void setOperationFailAids(Vector<String> vector) {
            this.operationFailAids = vector;
        }
    }

    public CRSApplication(ISEMedia iSEMedia) {
        super(iSEMedia, "A00000015143525300");
    }

    private static String getTagName(byte[] bArr) {
        if (Arrays.equals(bArr, TAG_APPLICATION_LIFECYCLE_STATE)) {
            return "TAG_APPLICATION_LIFECYCLE_STATE";
        }
        if (Arrays.equals(bArr, TAG_DISPLAY_CONTROL_TEMPLATE)) {
            return "TAG_DISPLAY_CONTROL_TEMPLATE";
        }
        if (Arrays.equals(bArr, TAG_URL)) {
            return "TAG_URL";
        }
        if (Arrays.equals(bArr, TAG_APPLICATION_IMAGE)) {
            return "TAG_APPLICATION_IMAGE";
        }
        if (Arrays.equals(bArr, TAG_DISPLAY_MESSAGE)) {
            return "TAG_DISPLAY_MESSAGE";
        }
        if (Arrays.equals(bArr, TAG_VERSION)) {
            return "TAG_VERSION";
        }
        if (bArr != null && bArr.length == 1) {
            byte b = bArr[0];
            if (b == TAG_APPLICATION_AID) {
                return "TAG_APPLICATION_AID";
            }
            if (b == Byte.MIN_VALUE) {
                return "TAG_APPLICATION_UPDATE_COUNTER";
            }
            if (b == (byte) -127) {
                return "TAG_PRIORITY_INDICATOR";
            }
            if (b == TAG_GROUP_HEAD_APPLICATION) {
                return "TAG_GROUP_HEAD_APPLICATION";
            }
            if (b == TAG_GROUP_MEMBERS_APPLICATION) {
                return "TAG_GROUP_MEMBERS_APPLICATION";
            }
            if (b == TAG_CREL_APPLICATION_AID_LIST) {
                return "TAG_CREL_APPLICATION_AID_LIST";
            }
            if (b == (byte) -91) {
                return "TAG_POLICY_RESTRICTED_APPLICATIONS";
            }
            if (b == TAG_APPLICATION_DISCRETIONARY_DATA) {
                return "TAG_APPLICATION_DISCRETIONARY_DATA";
            }
            if (b == TAG_APPLICATION_FAMILY) {
                return "TAG_APPLICATION_FAMILY";
            }
            if (b == TAG_DISPLAY_REQUIRED_INDICATOR) {
                return "TAG_DISPLAY_REQUIRED_INDICATOR";
            }
            if (b == TAG_CONTINUOUS_PROCESSING) {
                return "TAG_CONTINUOUS_PROCESSING";
            }
            if (b == TAG_RECOGNITION_ALGORITHM) {
                return "TAG_RECOGNITION_ALGORITHM";
            }
            if (b == TAG_ASSIGNED_PROTOCOLS) {
                return "TAG_ASSIGNED_PROTOCOLS";
            }
            if (b == TAG_APPLICATION_TEMPLATE) {
                return "TAG_APPLICATION_TEMPLATE";
            }
            if (b == TAG_LIST_CONFLICTING_APPS) {
                return "TAG_LIST_CONFLICTING_APPS";
            }
            if (b == TAG_LIST_OPERATION_FAILS) {
                return "TAG_LIST_OPERATION_FAILS";
            }
            if (b == TAG_FCI_TEMPLATE) {
                return "TAG_FCI_TEMPLATE";
            }
            if (b == TAG_CRS_AID) {
                return "TAG_CRS_AID";
            }
            if (b == (byte) -91) {
                return "TAG_FCI_PROPRIETARY";
            }
            if (b == Byte.MIN_VALUE) {
                return "TAG_GLOBAL_UPDATE_COUNTER";
            }
        }
        return "";
    }

    private byte[] setStatus(byte b, byte b2, byte[] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        Object obj = new byte[(length + 5)];
        obj[0] = Byte.MIN_VALUE;
        obj[1] = (byte) -16;
        obj[2] = b;
        obj[3] = b2;
        if (length > 0) {
            obj[4] = (byte) bArr.length;
            System.arraycopy(bArr, 0, obj, 5, bArr.length);
        } else {
            obj[4] = null;
        }
        return setStatus(obj);
    }

    private byte[] setStatus(byte[] bArr) {
        Object obj = (byte[]) null;
        selApplet();
        byte[] bArr2 = (byte[]) null;
        byte[] bArr3 = (byte[]) null;
        SetStatusSWChecker setStatusSWChecker = new SetStatusSWChecker();
        do {
            try {
                Object exchangeAPDU = seMedia.exchangeAPDU(bArr);
                setStatusSWChecker.setSW(exchangeAPDU).checkSW();
                if (obj == null) {
                    obj = new byte[exchangeAPDU.length];
                    System.arraycopy(exchangeAPDU, 0, obj, 0, exchangeAPDU.length);
                } else {
                    Object obj2 = new byte[obj.length];
                    System.arraycopy(obj, 0, obj2, 0, obj.length);
                    obj = new byte[(obj.length + exchangeAPDU.length)];
                    System.arraycopy(obj2, 0, obj, 0, obj2.length);
                    System.arraycopy(exchangeAPDU, 0, obj, obj2.length, exchangeAPDU.length);
                }
                bArr[2] = Byte.MIN_VALUE;
            } catch (IOException e) {
                throw new SException(-16);
            } catch (SException e2) {
                throw e2;
            } catch (Throwable th) {
                closeApplet();
            }
        } while (setStatusSWChecker.hasMoreData);
        closeApplet();
        return obj;
    }

    private byte[] setStatusForContactless(byte b, byte b2, byte[] bArr) {
        Object obj = new byte[(bArr.length + 5)];
        obj[0] = Byte.MIN_VALUE;
        obj[1] = (byte) -16;
        obj[2] = b;
        obj[3] = b2;
        obj[4] = (byte) bArr.length;
        System.arraycopy(bArr, 0, obj, 5, bArr.length);
        return setStatus(obj);
    }

    public void activateApp(String str) {
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object obj = new byte[(hexStringToBytes.length + 2)];
        obj[0] = TAG_APPLICATION_AID;
        obj[1] = (byte) hexStringToBytes.length;
        System.arraycopy(hexStringToBytes, 0, obj, 2, hexStringToBytes.length);
        setStatus((byte) 1, (byte) 1, obj);
    }

    public void deactivateApp(String str) {
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object obj = new byte[(hexStringToBytes.length + 2)];
        obj[0] = TAG_APPLICATION_AID;
        obj[1] = (byte) hexStringToBytes.length;
        System.arraycopy(hexStringToBytes, 0, obj, 2, hexStringToBytes.length);
        setStatus((byte) 1, (byte) 0, obj);
    }

    public Application[] getAllApplication() {
        return getAllApplication(true, null);
    }

    public Application[] getAllApplication(boolean z, String str) {
        byte[] bArr = (byte[]) null;
        if (TextUtils.isEmpty(str)) {
            bArr = new byte[]{TAG_APPLICATION_AID, (byte) 0};
        } else {
            Object hexStringToBytes = HexString.hexStringToBytes(str);
            bArr = new byte[(hexStringToBytes.length + 2)];
            bArr[0] = TAG_APPLICATION_AID;
            bArr[1] = (byte) hexStringToBytes.length;
            System.arraycopy(hexStringToBytes, 0, bArr, 2, hexStringToBytes.length);
        }
        Application[] parse = GetStatusParser.parse(getStatus(P1_APPLICATIONS, (byte) 0, bArr), z);
        if (parse == null) {
            return null;
        }
        Arrays.sort(parse, new C12171());
        return parse;
    }

    public Application getApplication(String str) {
        Application[] allApplication = getAllApplication(false, str);
        return (allApplication == null || allApplication.length < 1) ? null : allApplication[0];
    }

    protected byte[] getStatus(byte b, byte b2, byte[] bArr) {
        Object obj = (byte[]) null;
        Object obj2 = new byte[((bArr.length + 5) + 1)];
        obj2[0] = Byte.MIN_VALUE;
        obj2[1] = (byte) -14;
        obj2[2] = b;
        obj2[3] = b2;
        obj2[4] = (byte) bArr.length;
        System.arraycopy(bArr, 0, obj2, 5, bArr.length);
        selApplet();
        C1216a.m4519a(TAG, "isSelectAid::" + this.isSelectAid);
        byte[] bArr2 = (byte[]) null;
        byte[] bArr3 = (byte[]) null;
        GetStatusSWChecker getStatusSWChecker = new GetStatusSWChecker();
        do {
            try {
                Object exchangeAPDU = seMedia.exchangeAPDU(obj2);
                getStatusSWChecker.setSW(exchangeAPDU).checkSW();
                int i;
                Object obj3;
                if (!getStatusSWChecker.hasMoreData) {
                    i = 0;
                    if (obj != null) {
                        obj3 = new byte[obj.length];
                        System.arraycopy(obj, 0, obj3, 0, obj.length);
                        obj = new byte[((obj.length + exchangeAPDU.length) - i)];
                        System.arraycopy(obj3, 0, obj, 0, obj3.length);
                        System.arraycopy(exchangeAPDU, 0, obj, obj3.length, exchangeAPDU.length - i);
                    } else {
                        obj = new byte[(exchangeAPDU.length - i)];
                        System.arraycopy(exchangeAPDU, 0, obj, 0, obj.length);
                    }
                    obj2[3] = (byte) 1;
                } else if (exchangeAPDU.length <= 2) {
                    obj2[3] = (byte) 1;
                } else {
                    i = 2;
                    if (obj != null) {
                        obj = new byte[(exchangeAPDU.length - i)];
                        System.arraycopy(exchangeAPDU, 0, obj, 0, obj.length);
                    } else {
                        obj3 = new byte[obj.length];
                        System.arraycopy(obj, 0, obj3, 0, obj.length);
                        obj = new byte[((obj.length + exchangeAPDU.length) - i)];
                        System.arraycopy(obj3, 0, obj, 0, obj3.length);
                        System.arraycopy(exchangeAPDU, 0, obj, obj3.length, exchangeAPDU.length - i);
                    }
                    obj2[3] = (byte) 1;
                }
            } catch (IOException e) {
                throw new SException(-16);
            } catch (SException e2) {
                throw e2;
            } catch (Throwable th) {
                closeApplet();
            }
        } while (getStatusSWChecker.hasMoreData);
        closeApplet();
        return obj;
    }

    public void resetOneTimeMainApp(String str) {
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object obj = new byte[(hexStringToBytes.length + 2)];
        obj[0] = TAG_APPLICATION_AID;
        obj[1] = (byte) hexStringToBytes.length;
        System.arraycopy(hexStringToBytes, 0, obj, 2, hexStringToBytes.length);
        setStatus((byte) 2, P2_RESET_VOLATILE_PRIORITY, obj);
    }

    public boolean selectAppletAID(String str) {
        SException e;
        Object obj = (byte[]) null;
        Object openChannel;
        try {
            openChannel = seMedia.openChannel(HexString.hexStringToBytes(str));
            if (openChannel == null) {
                try {
                    C1216a.m4519a(TAG, "select applet AID openChannel failed: " + str);
                    return false;
                } catch (SException e2) {
                    e = e2;
                    C1216a.m4519a(TAG, "select applet AID SE Exception: " + str);
                    e.printStackTrace();
                    C1216a.m4519a(TAG, "select applet AID resSelCM: " + openChannel);
                    return false;
                }
            }
            C1216a.m4519a(TAG, "select applet AID ok: " + str);
            seMedia.closeChannel();
            return true;
        } catch (SException e3) {
            SException sException = e3;
            openChannel = obj;
            e = sException;
            C1216a.m4519a(TAG, "select applet AID SE Exception: " + str);
            e.printStackTrace();
            C1216a.m4519a(TAG, "select applet AID resSelCM: " + openChannel);
            return false;
        }
    }

    public void setMainApp(String str) {
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object obj = new byte[(hexStringToBytes.length + 2)];
        obj[0] = TAG_APPLICATION_AID;
        obj[1] = (byte) hexStringToBytes.length;
        System.arraycopy(hexStringToBytes, 0, obj, 2, hexStringToBytes.length);
        setStatus((byte) 2, (byte) 1, obj);
    }

    public void setOneTimeMainApp(String str) {
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object obj = new byte[(hexStringToBytes.length + 2)];
        obj[0] = TAG_APPLICATION_AID;
        obj[1] = (byte) hexStringToBytes.length;
        System.arraycopy(hexStringToBytes, 0, obj, 2, hexStringToBytes.length);
        setStatus((byte) 2, (byte) 2, obj);
    }

    public void turnOffContactlessIF() {
        setStatusForContactless(P1_COMMUNICATION_INTERFACE_ACCESS_CONFIGURATION, (byte) 0, new byte[]{Byte.MIN_VALUE, (byte) 1, P1_APPLICATIONS});
    }

    public void turnOnContactlessIF() {
        setStatusForContactless(P1_COMMUNICATION_INTERFACE_ACCESS_CONFIGURATION, Byte.MIN_VALUE, new byte[]{Byte.MIN_VALUE, (byte) 1, P1_APPLICATIONS});
    }

    public void verifyPIN() {
        selApplet();
        Object hexStringToBytes = HexString.hexStringToBytes("00200080082817954372FFFFFF");
        C1216a.m4519a(TAG, "verifyPIN : " + hexStringToBytes);
        byte[] bArr = (byte[]) null;
        try {
            new SetStatusSWChecker().setSW(seMedia.exchangeAPDU(hexStringToBytes)).checkSW();
        } catch (IOException e) {
            C1216a.m4519a(TAG, "verifyPIN IO Exception.");
            throw new SException(-16);
        } catch (SException e2) {
            C1216a.m4519a(TAG, "verifyPIN SException.");
            throw e2;
        } catch (SecurityException e3) {
            C1216a.m4519a(TAG, "verifyPIN Security Exception.");
            throw new SException(-20);
        }
    }
}

package com.skcc.wallet.core.se.instance;

import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.BasicCheckSW;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.SException;
import com.skcc.wallet.core.se.util.HexString;
import java.io.IOException;

public class WalletApplet extends Applet {
    private String cMac;
    private String crv;

    class C12181 extends BasicCheckSW {
        C12181() {
        }

        public void checkSW() {
            if (this.sw1 != (byte) -112 || this.sw2 != (byte) 0) {
                if (this.sw1 == (byte) 103 && this.sw2 == (byte) 0) {
                    throw new SException(-3);
                } else if (this.sw1 == (byte) 105 && this.sw2 == (byte) -126) {
                    throw new SException(-4);
                } else if (this.sw1 == (byte) 105 && this.sw2 == (byte) -123) {
                    throw new SException(-5);
                } else if (this.sw1 == (byte) 106 && this.sw2 == (byte) -122) {
                    throw new SException(-6);
                } else if (this.sw1 == (byte) 109 && this.sw2 == (byte) 0) {
                    throw new SException(-7);
                } else if (this.sw1 == (byte) 110 && this.sw2 == (byte) 0) {
                    throw new SException(-8);
                } else {
                    throw new SException(-1);
                }
            }
        }
    }

    class C12192 extends BasicCheckSW {
        C12192() {
        }

        public void checkSW() {
            if (this.sw1 == (byte) 103 && this.sw2 == (byte) 0) {
                throw new SException(-3);
            } else if (this.sw1 == (byte) 105 && this.sw2 == (byte) -126) {
                throw new SException(-4);
            } else if (this.sw1 == (byte) 105 && this.sw2 == (byte) -123) {
                throw new SException(-5);
            } else if (this.sw1 == (byte) 106 && this.sw2 == (byte) -122) {
                throw new SException(-6);
            } else if (this.sw1 == (byte) 109 && this.sw2 == (byte) 0) {
                throw new SException(-7);
            } else if (this.sw1 == (byte) 110 && this.sw2 == (byte) 0) {
                throw new SException(-8);
            } else {
                throw new SException(-1);
            }
        }
    }

    public WalletApplet(ISEMedia iSEMedia) {
        super(iSEMedia, "534B43432057414C4C455401");
        this.crv = "00000000";
        this.cMac = "00000000";
        this.swChecker = new C12181();
    }

    public void changePIN(String str, String str2) {
        selApplet();
        Object obj = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, null, (byte) 36, null, 1, (byte) 16};
        Object bytes = str.getBytes();
        Object bytes2 = str2.getBytes();
        System.arraycopy(bytes, 0, obj, 5, bytes.length);
        System.arraycopy(bytes2, 0, obj, 13, bytes2.length);
        try {
            byte[] exchangeAPDU = seMedia.exchangeAPDU(obj);
            closeApplet();
            try {
                this.swChecker.setSW(exchangeAPDU).checkSW();
            } catch (SException e) {
                if (exchangeAPDU == null || exchangeAPDU.length <= 1) {
                    throw e;
                }
                byte trimByte = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 2]);
                byte trimByte2 = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 1]);
                if (trimByte == (byte) 103 && trimByte2 == (byte) 0) {
                    throw new SException(-3);
                } else if (trimByte == (byte) 105 && trimByte2 == (byte) -123) {
                    throw new SException(-5);
                } else if (trimByte == (byte) 106 && trimByte2 == (byte) -122) {
                    throw new SException(-6);
                } else if (trimByte == (byte) 109 && trimByte2 == (byte) 0) {
                    throw new SException(-7);
                } else if (trimByte == (byte) 110 && trimByte2 == (byte) 0) {
                    throw new SException(-8);
                } else if (trimByte == (byte) 105 && trimByte2 == (byte) -125) {
                    throw new PINBlockedException();
                } else if (trimByte == (byte) 106 && trimByte2 == (byte) -122) {
                    throw new SException(-6);
                } else if (trimByte == (byte) 100 && ((byte) (trimByte2 & 240)) == (byte) -64) {
                    int i = trimByte2 & 15;
                    WrongPINException wrongPINException = new WrongPINException(i);
                    C1216a.m4519a(TAG, "leftPinCount:" + i);
                    if (i < 1) {
                        throw new PINBlockedException();
                    }
                    throw wrongPINException;
                } else {
                    throw new SException(-1);
                }
            }
        } catch (IOException e2) {
            throw new SException(-16);
        } catch (SException e3) {
            throw e3;
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public boolean confirmCryptogram(String str) {
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object obj = new byte[(hexStringToBytes.length + 5)];
        obj[0] = (byte) -112;
        obj[1] = (byte) -120;
        obj[2] = null;
        obj[3] = null;
        obj[4] = (byte) 8;
        System.arraycopy(hexStringToBytes, 0, obj, 5, hexStringToBytes.length);
        try {
            byte[] exchangeAPDU = seMedia.exchangeAPDU(obj);
            closeApplet();
            try {
                this.swChecker.setSW(exchangeAPDU).checkSW();
            } catch (SException e) {
                new C12192().setSW(exchangeAPDU).checkSW();
            }
            return true;
        } catch (IOException e2) {
            throw new SException(-16);
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public void disablePIN(String str) {
        selApplet();
        Object obj = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, null, (byte) 38, null, 1, 8};
        Object bytes = str.getBytes();
        System.arraycopy(bytes, 0, obj, 5, bytes.length);
        try {
            byte[] exchangeAPDU = seMedia.exchangeAPDU(obj);
            closeApplet();
            try {
                this.swChecker.setSW(exchangeAPDU).checkSW();
            } catch (SException e) {
                if (exchangeAPDU == null || exchangeAPDU.length <= 1) {
                    throw e;
                }
                byte trimByte = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 2]);
                byte trimByte2 = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 1]);
                if (trimByte == (byte) 105 && trimByte2 == (byte) -124) {
                    throw new PINDisabledException();
                } else if (trimByte == (byte) 105 && trimByte2 == (byte) -125) {
                    throw new PINBlockedException();
                } else if (trimByte == (byte) 106 && trimByte2 == (byte) -122) {
                    throw new SException(-6);
                } else if (trimByte == (byte) 100 && ((byte) (trimByte2 & 240)) == (byte) -64) {
                    int i = trimByte2 & 15;
                    WrongPINException wrongPINException = new WrongPINException(i);
                    C1216a.m4519a(TAG, "leftPinCount:" + i);
                    if (i < 1) {
                        throw new PINBlockedException();
                    }
                    throw wrongPINException;
                } else {
                    throw new SException(-1);
                }
            }
        } catch (IOException e2) {
            throw new SException(-16);
        } catch (SException e3) {
            throw e3;
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public void enablePIN(String str) {
        selApplet();
        Object obj = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, null, (byte) 40, null, 1, 8};
        Object bytes = str.getBytes();
        System.arraycopy(bytes, 0, obj, 5, bytes.length);
        try {
            byte[] exchangeAPDU = seMedia.exchangeAPDU(obj);
            closeApplet();
            try {
                this.swChecker.setSW(exchangeAPDU).checkSW();
            } catch (SException e) {
                if (exchangeAPDU == null || exchangeAPDU.length <= 1) {
                    throw e;
                }
                byte trimByte = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 2]);
                byte trimByte2 = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 1]);
                if (trimByte == (byte) 105 && trimByte2 == (byte) -124) {
                    throw new PINDisabledException();
                } else if (trimByte == (byte) 105 && trimByte2 == (byte) -125) {
                    throw new PINBlockedException();
                } else if (trimByte == (byte) 106 && trimByte2 == (byte) -122) {
                    throw new SException(-6);
                } else if (trimByte == (byte) 100 && ((byte) (trimByte2 & 240)) == (byte) -64) {
                    int i = trimByte2 & 15;
                    WrongPINException wrongPINException = new WrongPINException(i);
                    C1216a.m4519a(TAG, "leftPinCount:" + i);
                    if (i < 1) {
                        throw new PINBlockedException();
                    }
                    throw wrongPINException;
                } else {
                    throw new SException(-1);
                }
            }
        } catch (IOException e2) {
            throw new SException(-16);
        } catch (SException e3) {
            throw e3;
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public String getCMac() {
        return this.cMac;
    }

    public String getCrv() {
        return this.crv;
    }

    public String getWalletId() {
        byte[] bArr = (byte[]) null;
        selApplet();
        byte[] bArr2 = (byte[]) null;
        try {
            Object exchangeAPDU = seMedia.exchangeAPDU(new byte[]{(byte) 0, (byte) -54, (byte) 1, (byte) 0, (byte) 0});
            Object obj = new byte[(exchangeAPDU.length - 2)];
            System.arraycopy(exchangeAPDU, 0, obj, 0, obj.length);
            String bytesToHexString = HexString.bytesToHexString(obj);
            closeApplet();
            return bytesToHexString;
        } catch (IOException e) {
            throw new SException(-16);
        } catch (SException e2) {
            throw e2;
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public boolean isPinEnabled() {
        selApplet();
        byte[] bArr = (byte[]) null;
        try {
            bArr = seMedia.exchangeAPDU(new byte[]{(byte) 0, (byte) 32, (byte) 0, (byte) 1, (byte) 0});
            byte trimByte = HexString.trimByte(bArr[bArr.length - 2]);
            byte trimByte2 = HexString.trimByte(bArr[bArr.length - 1]);
            if (trimByte == (byte) 105 && trimByte2 == (byte) -124) {
                closeApplet();
                return false;
            } else if (trimByte == (byte) 105 && trimByte2 == (byte) -125) {
                throw new PINBlockedException();
            } else {
                closeApplet();
                return true;
            }
        } catch (IOException e) {
            throw new SException(-16);
        } catch (SException e2) {
            throw e2;
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public void makeCryptogram(String str) {
        selApplet();
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object obj = new byte[(hexStringToBytes.length + 5)];
        obj[0] = (byte) -112;
        obj[1] = (byte) 16;
        obj[2] = null;
        obj[3] = 1;
        obj[4] = 8;
        System.arraycopy(hexStringToBytes, 0, obj, 5, hexStringToBytes.length);
        try {
            obj = seMedia.exchangeAPDU(obj);
            try {
                this.swChecker.setSW(obj).checkSW();
                hexStringToBytes = new byte[8];
                Object obj2 = new byte[8];
                System.arraycopy(obj, 9, hexStringToBytes, 0, hexStringToBytes.length);
                System.arraycopy(obj, 17, obj2, 0, obj2.length);
                this.crv = HexString.bytesToHexString(hexStringToBytes);
                this.cMac = HexString.bytesToHexString(obj2);
            } catch (SException e) {
                if (obj == null || obj.length <= 1) {
                    throw e;
                }
                byte trimByte = HexString.trimByte(obj[obj.length - 2]);
                byte trimByte2 = HexString.trimByte(obj[obj.length - 1]);
                if (trimByte == (byte) 105 && trimByte2 == (byte) -125) {
                    throw new PINBlockedException();
                } else if (trimByte == (byte) 103 && trimByte2 == (byte) 0) {
                    throw new SException(-3);
                } else if (trimByte == (byte) 105 && trimByte2 == (byte) -126) {
                    throw new SException(-4);
                } else if (trimByte == (byte) 105 && trimByte2 == (byte) -123) {
                    throw new SException(-5);
                } else if (trimByte == (byte) 106 && trimByte2 == (byte) -122) {
                    throw new SException(-6);
                } else if (trimByte == (byte) 109 && trimByte2 == (byte) 0) {
                    throw new SException(-7);
                } else if (trimByte == (byte) 110 && trimByte2 == (byte) 0) {
                    throw new SException(-8);
                } else {
                    throw new SException(-1);
                }
            }
        } catch (IOException e2) {
            closeApplet();
            throw new SException(-16);
        } catch (SException e3) {
            closeApplet();
            throw e3;
        }
    }

    protected byte[] selApplet() {
        byte[] bArr = (byte[]) null;
        try {
            return super.selApplet();
        } catch (SException e) {
            throw e;
        }
    }

    public void unblockUserPIN(String str, String str2) {
        selApplet();
        Object hexStringToBytes = HexString.hexStringToBytes(str);
        Object hexStringToBytes2 = HexString.hexStringToBytes(str2);
        Object obj = new byte[((hexStringToBytes.length + 5) + hexStringToBytes2.length)];
        obj[0] = null;
        obj[1] = (byte) 44;
        obj[2] = null;
        obj[3] = 1;
        obj[4] = (byte) 16;
        System.arraycopy(hexStringToBytes, 0, obj, 5, hexStringToBytes.length);
        System.arraycopy(hexStringToBytes2, 0, obj, 13, hexStringToBytes2.length);
        try {
            byte[] exchangeAPDU = seMedia.exchangeAPDU(obj);
            closeApplet();
            this.swChecker.setSW(exchangeAPDU).checkSW();
        } catch (IOException e) {
            throw new SException(-16);
        } catch (SException e2) {
            throw e2;
        } catch (Throwable th) {
            closeApplet();
        }
    }

    public void verifyPIN(String str) {
        selApplet();
        Object obj = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, null, (byte) 32, null, 1, 8};
        Object bytes = str.getBytes();
        System.arraycopy(bytes, 0, obj, 5, bytes.length);
        try {
            byte[] exchangeAPDU = seMedia.exchangeAPDU(obj);
            closeApplet();
            try {
                this.swChecker.setSW(exchangeAPDU).checkSW();
            } catch (SException e) {
                if (exchangeAPDU == null || exchangeAPDU.length <= 1) {
                    throw e;
                }
                byte trimByte = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 2]);
                byte trimByte2 = HexString.trimByte(exchangeAPDU[exchangeAPDU.length - 1]);
                if (trimByte == (byte) 105 && trimByte2 == (byte) -124) {
                    throw new PINDisabledException();
                } else if (trimByte == (byte) 105 && trimByte2 == (byte) -125) {
                    throw new PINBlockedException();
                } else if (trimByte == (byte) 106 && trimByte2 == (byte) -122) {
                    throw new SException(-6);
                } else if (trimByte == (byte) 100 && ((byte) (trimByte2 & 240)) == (byte) -64) {
                    int i = trimByte2 & 15;
                    WrongPINException wrongPINException = new WrongPINException(i);
                    C1216a.m4519a(TAG, "leftPinCount:" + i);
                    if (i < 1) {
                        throw new PINBlockedException();
                    }
                    throw wrongPINException;
                } else {
                    throw new SException(-1);
                }
            }
        } catch (IOException e2) {
            throw new SException(-16);
        } catch (SException e3) {
            throw e3;
        } catch (Throwable th) {
            closeApplet();
        }
    }
}

package com.skcc.wallet.core.se.uicc;

import android.content.Context;
import com.skcc.wallet.core.p057a.C1216a;
import com.skcc.wallet.core.se.ISEMedia;
import com.skcc.wallet.core.se.SEConnectionListener;
import com.skcc.wallet.core.se.SException;
import com.skcc.wallet.core.se.util.HexString;
import java.io.IOException;
import org.simalliance.openmobileapi.Channel;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;
import org.simalliance.openmobileapi.SEService.CallBack;
import org.simalliance.openmobileapi.Session;

public class UICCSimAlliance implements ISEMedia {
    private static final String TAG = "UICCSimAlliance";
    private CallBack callback = new C12201();
    private Channel channel;
    public Context context;
    private boolean hasConnection = false;
    private SEService seService;
    private SEConnectionListener selistener;

    class C12201 implements CallBack {
        C12201() {
        }

        public void serviceConnected(SEService sEService) {
            UICCSimAlliance.this.hasConnection = true;
            if (UICCSimAlliance.this.selistener != null) {
                UICCSimAlliance.this.selistener.onSEConnected();
            }
        }
    }

    public UICCSimAlliance(Context context) {
        this.context = context;
    }

    public void closeChannel() {
        if (this.channel != null) {
            this.channel.close();
        }
        this.channel = null;
    }

    public void closeConnection() {
        if (this.seService != null && this.seService.isConnected()) {
            this.seService.shutdown();
        }
        this.seService = null;
        if (this.selistener != null) {
            this.selistener.onSEDisconnected();
        }
        this.hasConnection = false;
    }

    public byte[] exchangeAPDU(byte[] bArr) {
        if (!this.hasConnection) {
            C1216a.m4522b(TAG, "SE is not connected!!");
            return null;
        } else if (bArr == null) {
            C1216a.m4522b(TAG, "byte command is null");
            return null;
        } else if (this.seService == null) {
            C1216a.m4522b(TAG, "seService is null");
            return null;
        } else if (this.channel == null) {
            C1216a.m4522b(TAG, "channel is null");
            return null;
        } else {
            byte[] transmit = this.channel.transmit(bArr);
            C1216a.m4519a(TAG, "exchangeAPDU :: Send to SE :" + HexString.bytesToHexString(bArr) + "\n" + "Response from SE: " + HexString.bytesToHexString(transmit) + "\n");
            return transmit;
        }
    }

    public Reader getReaderName() {
        return this.seService == null ? null : this.seService.getReaders()[0];
    }

    public boolean isConnected() {
        return this.hasConnection;
    }

    public byte[] openChannel(byte[] bArr) {
        if (this.seService == null) {
            C1216a.m4519a(TAG, "SEService is null!!");
            throw new SException(-20);
        }
        Reader[] readers = this.seService.getReaders();
        if (readers.length < 1) {
            C1216a.m4519a(TAG, "readers is empty.");
            return null;
        }
        C1216a.m4519a(TAG, "reader's len:" + readers.length);
        C1216a.m4519a(TAG, readers[0].getName());
        try {
            Session openSession = readers[0].openSession();
            C1216a.m4519a(TAG, readers[0].getSEService().isConnected());
            C1216a.m4519a(TAG, "AID:" + HexString.bytesToHexString(bArr));
            C1216a.m4519a(TAG, "session isClosed:" + openSession.isClosed());
            this.channel = openSession.openLogicalChannel(bArr);
            if (this.channel == null) {
                return null;
            }
            C1216a.m4519a(TAG, "channel:" + this.channel.toString());
            byte[] selectResponse = this.channel.getSelectResponse();
            if (selectResponse == null) {
                C1216a.m4519a(TAG, "res:null");
                return new byte[]{(byte) -112, (byte) 0};
            }
            C1216a.m4519a(TAG, "session:" + HexString.bytesToHexString(selectResponse));
            return selectResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean openConnection() {
        if (this.seService != null) {
            return false;
        }
        C1216a.m4519a(TAG, "openConnection new SEService()");
        this.seService = new SEService(this.context, this.callback);
        if (this.seService != null) {
            return true;
        }
        C1216a.m4522b(TAG, "SE Service is null!!");
        throw new IOException("Failed to connect to SEService");
    }

    public void setSEListener(SEConnectionListener sEConnectionListener) {
        this.selistener = sEConnectionListener;
    }
}

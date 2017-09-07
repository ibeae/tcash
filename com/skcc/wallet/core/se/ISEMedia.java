package com.skcc.wallet.core.se;

import org.simalliance.openmobileapi.Reader;

public interface ISEMedia {
    void closeChannel();

    void closeConnection();

    byte[] exchangeAPDU(byte[] bArr);

    Reader getReaderName();

    boolean isConnected();

    byte[] openChannel(byte[] bArr);

    boolean openConnection();

    void setSEListener(SEConnectionListener sEConnectionListener);
}

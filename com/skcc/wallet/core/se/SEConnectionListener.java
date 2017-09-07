package com.skcc.wallet.core.se;

public interface SEConnectionListener {
    void onSEConnected();

    void onSEConnectionFail();

    void onSEDisconnected();
}

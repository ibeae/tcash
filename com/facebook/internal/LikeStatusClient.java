package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;

final class LikeStatusClient extends PlatformServiceClient {
    private String objectId;

    LikeStatusClient(Context context, String str, String str2) {
        super(context, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20141001, str);
        this.objectId = str2;
    }

    protected void populateRequestBundle(Bundle bundle) {
        bundle.putString(NativeProtocol.EXTRA_OBJECT_ID, this.objectId);
    }
}

package com.facebook.internal;

import android.content.Context;
import java.net.URI;

public class ImageRequest {
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PROFILEPIC_URL_FORMAT = "https://graph.facebook.com/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private URI imageUri;

    public static class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private Context context;
        private URI imageUrl;

        public Builder(Context context, URI uri) {
            Validate.notNull(uri, "imageUrl");
            this.context = context;
            this.imageUrl = uri;
        }

        public ImageRequest build() {
            return new ImageRequest();
        }

        public Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        public Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        public Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }
    }

    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    private ImageRequest(Builder builder) {
        this.context = builder.context;
        this.imageUri = builder.imageUrl;
        this.callback = builder.callback;
        this.allowCachedRedirects = builder.allowCachedRedirects;
        this.callerTag = builder.callerTag == null ? new Object() : builder.callerTag;
    }

    public static URI getProfilePictureUrl(String str, int i, int i2) {
        Validate.notNullOrEmpty(str, "userId");
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (max == 0 && max2 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        android.net.Uri.Builder encodedPath = new android.net.Uri.Builder().encodedPath(String.format(PROFILEPIC_URL_FORMAT, new Object[]{str}));
        if (max2 != 0) {
            encodedPath.appendQueryParameter(HEIGHT_PARAM, String.valueOf(max2));
        }
        if (max != 0) {
            encodedPath.appendQueryParameter(WIDTH_PARAM, String.valueOf(max));
        }
        encodedPath.appendQueryParameter(MIGRATION_PARAM, MIGRATION_VALUE);
        return new URI(encodedPath.toString());
    }

    public Callback getCallback() {
        return this.callback;
    }

    public Object getCallerTag() {
        return this.callerTag;
    }

    public Context getContext() {
        return this.context;
    }

    public URI getImageUri() {
        return this.imageUri;
    }

    public boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }
}

package com.facebook.android;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

@Deprecated
public class FbDialog extends WebDialog {
    private DialogListener mListener;

    class C04251 implements OnCompleteListener {
        C04251() {
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            FbDialog.this.callDialogListener(bundle, facebookException);
        }
    }

    public FbDialog(Context context, String str, Bundle bundle, DialogListener dialogListener) {
        super(context, str, bundle, WebDialog.DEFAULT_THEME, null);
        setDialogListener(dialogListener);
    }

    public FbDialog(Context context, String str, Bundle bundle, DialogListener dialogListener, int i) {
        super(context, str, bundle, i, null);
        setDialogListener(dialogListener);
    }

    public FbDialog(Context context, String str, DialogListener dialogListener) {
        this(context, str, dialogListener, (int) WebDialog.DEFAULT_THEME);
    }

    public FbDialog(Context context, String str, DialogListener dialogListener, int i) {
        super(context, str, i);
        setDialogListener(dialogListener);
    }

    private void callDialogListener(Bundle bundle, FacebookException facebookException) {
        if (this.mListener != null) {
            if (bundle != null) {
                this.mListener.onComplete(bundle);
            } else if (facebookException instanceof FacebookDialogException) {
                FacebookDialogException facebookDialogException = (FacebookDialogException) facebookException;
                this.mListener.onError(new DialogError(facebookDialogException.getMessage(), facebookDialogException.getErrorCode(), facebookDialogException.getFailingUrl()));
            } else if (facebookException instanceof FacebookOperationCanceledException) {
                this.mListener.onCancel();
            } else {
                this.mListener.onFacebookError(new FacebookError(facebookException.getMessage()));
            }
        }
    }

    private void setDialogListener(DialogListener dialogListener) {
        this.mListener = dialogListener;
        setOnCompleteListener(new C04251());
    }
}

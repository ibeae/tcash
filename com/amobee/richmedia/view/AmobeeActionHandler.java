package com.amobee.richmedia.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.amobee.richmedia.controller.OrmmaController.Dimensions;
import com.amobee.richmedia.controller.OrmmaController.PlayerProperties;
import com.amobee.richmedia.controller.util.OrmmaPlayer;
import com.amobee.richmedia.controller.util.OrmmaPlayerListener;
import com.amobee.richmedia.controller.util.OrmmaUtils;
import com.amobee.richmedia.view.AmobeeView.ACTION;
import java.util.HashMap;
import java.util.Map.Entry;

public class AmobeeActionHandler extends Activity {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ACTION;
    private HashMap<ACTION, Object> actionData = new HashMap();
    private RelativeLayout layout;

    class C03381 implements OrmmaPlayerListener {
        C03381() {
        }

        public void onComplete() {
            AmobeeActionHandler.this.finish();
        }

        public void onError() {
            AmobeeActionHandler.this.finish();
        }

        public void onPrepared() {
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ACTION() {
        int[] iArr = $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ACTION;
        if (iArr == null) {
            iArr = new int[ACTION.values().length];
            try {
                iArr[ACTION.PLAY_AUDIO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ACTION.PLAY_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ACTION = iArr;
        }
        return iArr;
    }

    private void doAction(Bundle bundle) {
        String string = bundle.getString(AmobeeView.ACTION_KEY);
        if (string != null) {
            ACTION valueOf = ACTION.valueOf(string);
            switch ($SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ACTION()[valueOf.ordinal()]) {
                case 1:
                    initPlayer(bundle, valueOf).playAudio();
                    return;
                case 2:
                    initPlayer(bundle, valueOf).playVideo();
                    return;
                default:
                    return;
            }
        }
    }

    private void setPlayerListener(OrmmaPlayer ormmaPlayer) {
        ormmaPlayer.setListener(new C03381());
    }

    OrmmaPlayer initPlayer(Bundle bundle, ACTION action) {
        LayoutParams layoutParams;
        PlayerProperties playerProperties = (PlayerProperties) bundle.getParcelable(AmobeeView.PLAYER_PROPERTIES);
        Dimensions dimensions = (Dimensions) bundle.getParcelable(AmobeeView.DIMENSIONS);
        View ormmaPlayer = new OrmmaPlayer(this);
        ormmaPlayer.setPlayData(playerProperties, OrmmaUtils.getData(AmobeeView.EXPAND_URL, bundle));
        if (dimensions == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(dimensions.width, dimensions.height);
            layoutParams.topMargin = dimensions.f436y;
            layoutParams.leftMargin = dimensions.f435x;
        }
        ormmaPlayer.setLayoutParams(layoutParams);
        this.layout.addView(ormmaPlayer);
        this.actionData.put(action, ormmaPlayer);
        setPlayerListener(ormmaPlayer);
        return ormmaPlayer;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.layout = new RelativeLayout(this);
        this.layout.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(this.layout);
        doAction(extras);
    }

    protected void onStop() {
        for (Entry entry : this.actionData.entrySet()) {
            switch ($SWITCH_TABLE$com$amobee$richmedia$view$AmobeeView$ACTION()[((ACTION) entry.getKey()).ordinal()]) {
                case 1:
                case 2:
                    ((OrmmaPlayer) entry.getValue()).releasePlayer();
                    break;
                default:
                    break;
            }
        }
        super.onStop();
    }
}

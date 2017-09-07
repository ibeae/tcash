package com.amobee.richmedia.controller.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.amobee.adsdk.Log;
import com.amobee.richmedia.controller.OrmmaController.PlayerProperties;

public class OrmmaPlayer extends VideoView implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static String LOG_TAG = "AmobeeView Player";
    private static String transientText = "Loading. Please Wait..";
    private AudioManager aManager = ((AudioManager) getContext().getSystemService("audio"));
    private String contentURL;
    private boolean isReleased;
    private OrmmaPlayerListener listener;
    private int mutedVolume;
    private PlayerProperties playProperties;
    private RelativeLayout transientLayout;

    public OrmmaPlayer(Context context) {
        super(context);
    }

    void addTransientMessage() {
        if (!this.playProperties.inline) {
            this.transientLayout = new RelativeLayout(getContext());
            this.transientLayout.setLayoutParams(getLayoutParams());
            View textView = new TextView(getContext());
            textView.setText(transientText);
            textView.setTextColor(-1);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.transientLayout.addView(textView, layoutParams);
            ((ViewGroup) getParent()).addView(this.transientLayout);
        }
    }

    void clearTransientMessage() {
        if (this.transientLayout != null) {
            ((ViewGroup) getParent()).removeView(this.transientLayout);
        }
    }

    void displayControl() {
        if (this.playProperties.showControl()) {
            MediaController mediaController = new MediaController(getContext());
            setMediaController(mediaController);
            mediaController.setAnchorView(this);
        }
    }

    void loadContent() {
        this.contentURL = this.contentURL.trim();
        this.contentURL = OrmmaUtils.convert(this.contentURL);
        if (this.contentURL != null || this.listener == null) {
            setVideoURI(Uri.parse(this.contentURL));
            displayControl();
            startContent();
            return;
        }
        removeView();
        this.listener.onError();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.playProperties.doLoop()) {
            start();
        } else if (this.playProperties.exitOnComplete() || this.playProperties.inline) {
            releasePlayer();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Log.m813i(LOG_TAG, "Player error : " + i);
        clearTransientMessage();
        removeView();
        if (this.listener != null) {
            this.listener.onError();
        }
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        clearTransientMessage();
        if (this.listener != null) {
            this.listener.onPrepared();
        }
    }

    public void playAudio() {
        loadContent();
    }

    public void playVideo() {
        if (this.playProperties.doMute()) {
            this.mutedVolume = this.aManager.getStreamVolume(3);
            this.aManager.setStreamVolume(3, 0, 4);
        }
        loadContent();
    }

    public void releasePlayer() {
        if (!this.isReleased) {
            this.isReleased = true;
            stopPlayback();
            removeView();
            if (this.playProperties != null && this.playProperties.doMute()) {
                unMute();
            }
            if (this.listener != null) {
                this.listener.onComplete();
            }
        }
    }

    void removeView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void setListener(OrmmaPlayerListener ormmaPlayerListener) {
        this.listener = ormmaPlayerListener;
    }

    public void setPlayData(PlayerProperties playerProperties, String str) {
        this.isReleased = false;
        this.playProperties = playerProperties;
        this.contentURL = str;
    }

    void startContent() {
        setOnCompletionListener(this);
        setOnErrorListener(this);
        setOnPreparedListener(this);
        if (!this.playProperties.inline) {
            addTransientMessage();
        }
        if (this.playProperties.isAutoPlay()) {
            start();
        }
    }

    void unMute() {
        this.aManager.setStreamVolume(3, this.mutedVolume, 4);
    }
}

package com.amobee.richmedia.controller.util;

public interface OrmmaPlayerListener {
    void onComplete();

    void onError();

    void onPrepared();
}

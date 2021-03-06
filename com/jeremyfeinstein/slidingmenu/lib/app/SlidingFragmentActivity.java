package com.jeremyfeinstein.slidingmenu.lib.app;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SlidingFragmentActivity extends SherlockFragmentActivity implements SlidingActivityBase {
    private SlidingActivityHelper mHelper;

    public View findViewById(int i) {
        View findViewById = super.findViewById(i);
        return findViewById != null ? findViewById : this.mHelper.findViewById(i);
    }

    public SlidingMenu getSlidingMenu() {
        return this.mHelper.getSlidingMenu();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHelper = new SlidingActivityHelper(this);
        this.mHelper.onCreate(bundle);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean onKeyUp = this.mHelper.onKeyUp(i, keyEvent);
        return onKeyUp ? onKeyUp : super.onKeyUp(i, keyEvent);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.mHelper.onPostCreate(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mHelper.onSaveInstanceState(bundle);
    }

    public void setBehindContentView(int i) {
        setBehindContentView(getLayoutInflater().inflate(i, null));
    }

    public void setBehindContentView(View view) {
        setBehindContentView(view, new LayoutParams(-1, -1));
    }

    public void setBehindContentView(View view, LayoutParams layoutParams) {
        this.mHelper.setBehindContentView(view, layoutParams);
    }

    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, null));
    }

    public void setContentView(View view) {
        setContentView(view, new LayoutParams(-1, -1));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.mHelper.registerAboveContentView(view, layoutParams);
    }

    public void setSlidingActionBarEnabled(boolean z) {
        this.mHelper.setSlidingActionBarEnabled(z);
    }

    public void showContent() {
        this.mHelper.showContent();
    }

    public void showMenu() {
        this.mHelper.showMenu();
    }

    public void showSecondaryMenu() {
        this.mHelper.showSecondaryMenu();
    }

    public void toggle() {
        this.mHelper.toggle();
    }
}

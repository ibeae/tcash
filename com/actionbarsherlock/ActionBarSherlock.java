package com.actionbarsherlock;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.internal.ActionBarSherlockNative;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Iterator;

public abstract class ActionBarSherlock {
    private static final Class<?>[] CONSTRUCTOR_ARGS = new Class[]{Activity.class, Integer.TYPE};
    public static final boolean DEBUG = false;
    public static final int FLAG_DELEGATE = 1;
    private static final HashMap<Implementation, Class<? extends ActionBarSherlock>> IMPLEMENTATIONS = new HashMap();
    protected static final String TAG = "ActionBarSherlock";
    protected final Activity mActivity;
    protected final boolean mIsDelegate;
    protected MenuInflater mMenuInflater;

    public interface OnCreatePanelMenuListener {
        boolean onCreatePanelMenu(int i, Menu menu);
    }

    public interface OnMenuItemSelectedListener {
        boolean onMenuItemSelected(int i, MenuItem menuItem);
    }

    public interface OnPreparePanelListener {
        boolean onPreparePanel(int i, View view, Menu menu);
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Implementation {
        public static final int DEFAULT_API = -1;
        public static final int DEFAULT_DPI = -1;

        int api() default -1;

        int dpi() default -1;
    }

    public interface OnActionModeFinishedListener {
        void onActionModeFinished(ActionMode actionMode);
    }

    public interface OnActionModeStartedListener {
        void onActionModeStarted(ActionMode actionMode);
    }

    public interface OnCreateOptionsMenuListener {
        boolean onCreateOptionsMenu(Menu menu);
    }

    public interface OnOptionsItemSelectedListener {
        boolean onOptionsItemSelected(MenuItem menuItem);
    }

    public interface OnPrepareOptionsMenuListener {
        boolean onPrepareOptionsMenu(Menu menu);
    }

    static {
        registerImplementation(ActionBarSherlockCompat.class);
        registerImplementation(ActionBarSherlockNative.class);
    }

    protected ActionBarSherlock(Activity activity, int i) {
        this.mActivity = activity;
        this.mIsDelegate = (i & 1) != 0;
    }

    public static void registerImplementation(Class<? extends ActionBarSherlock> cls) {
        if (!cls.isAnnotationPresent(Implementation.class)) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " is not annotated with @Implementation");
        } else if (!IMPLEMENTATIONS.containsValue(cls)) {
            IMPLEMENTATIONS.put((Implementation) cls.getAnnotation(Implementation.class), cls);
        }
    }

    public static boolean unregisterImplementation(Class<? extends ActionBarSherlock> cls) {
        return IMPLEMENTATIONS.values().remove(cls);
    }

    public static ActionBarSherlock wrap(Activity activity) {
        return wrap(activity, 0);
    }

    public static ActionBarSherlock wrap(Activity activity, int i) {
        Iterator it;
        Object obj;
        Iterator it2;
        int i2 = 0;
        HashMap hashMap = new HashMap(IMPLEMENTATIONS);
        for (Implementation dpi : hashMap.keySet()) {
            if (dpi.dpi() == 213) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            Object obj2 = activity.getResources().getDisplayMetrics().densityDpi == 213 ? 1 : null;
            it2 = hashMap.keySet().iterator();
            while (it2.hasNext()) {
                int dpi2 = ((Implementation) it2.next()).dpi();
                if (!(obj2 == null || dpi2 == 213) || (obj2 == null && dpi2 == 213)) {
                    it2.remove();
                }
            }
        }
        for (Implementation dpi3 : hashMap.keySet()) {
            if (dpi3.api() != -1) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            int i3 = VERSION.SDK_INT;
            it2 = hashMap.keySet().iterator();
            while (it2.hasNext()) {
                dpi2 = ((Implementation) it2.next()).api();
                if (dpi2 > i3) {
                    it2.remove();
                } else if (dpi2 > i2) {
                    i2 = dpi2;
                }
            }
            it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                if (((Implementation) it.next()).api() != i2) {
                    it.remove();
                }
            }
        }
        if (hashMap.size() > 1) {
            throw new IllegalStateException("More than one implementation matches configuration.");
        } else if (hashMap.isEmpty()) {
            throw new IllegalStateException("No implementations match configuration.");
        } else {
            try {
                return (ActionBarSherlock) ((Class) hashMap.values().iterator().next()).getConstructor(CONSTRUCTOR_ARGS).newInstance(new Object[]{activity, Integer.valueOf(i)});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            } catch (Throwable e2222) {
                throw new RuntimeException(e2222);
            }
        }
    }

    public abstract void addContentView(View view, LayoutParams layoutParams);

    protected final boolean callbackCreateOptionsMenu(Menu menu) {
        return this.mActivity instanceof OnCreatePanelMenuListener ? ((OnCreatePanelMenuListener) this.mActivity).onCreatePanelMenu(0, menu) : this.mActivity instanceof OnCreateOptionsMenuListener ? ((OnCreateOptionsMenuListener) this.mActivity).onCreateOptionsMenu(menu) : true;
    }

    protected final boolean callbackOptionsItemSelected(MenuItem menuItem) {
        return this.mActivity instanceof OnMenuItemSelectedListener ? ((OnMenuItemSelectedListener) this.mActivity).onMenuItemSelected(0, menuItem) : this.mActivity instanceof OnOptionsItemSelectedListener ? ((OnOptionsItemSelectedListener) this.mActivity).onOptionsItemSelected(menuItem) : false;
    }

    protected final boolean callbackPrepareOptionsMenu(Menu menu) {
        return this.mActivity instanceof OnPreparePanelListener ? ((OnPreparePanelListener) this.mActivity).onPreparePanel(0, null, menu) : this.mActivity instanceof OnPrepareOptionsMenuListener ? ((OnPrepareOptionsMenuListener) this.mActivity).onPrepareOptionsMenu(menu) : true;
    }

    public boolean dispatchCloseOptionsMenu() {
        return false;
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
    }

    public abstract boolean dispatchCreateOptionsMenu(android.view.Menu menu);

    public void dispatchDestroy() {
    }

    public abstract void dispatchInvalidateOptionsMenu();

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchMenuOpened(int i, android.view.Menu menu) {
        return false;
    }

    public boolean dispatchOpenOptionsMenu() {
        return false;
    }

    public abstract boolean dispatchOptionsItemSelected(android.view.MenuItem menuItem);

    public void dispatchPanelClosed(int i, android.view.Menu menu) {
    }

    public void dispatchPause() {
    }

    public void dispatchPostCreate(Bundle bundle) {
    }

    public void dispatchPostResume() {
    }

    public abstract boolean dispatchPrepareOptionsMenu(android.view.Menu menu);

    public void dispatchRestoreInstanceState(Bundle bundle) {
    }

    public void dispatchSaveInstanceState(Bundle bundle) {
    }

    public void dispatchStop() {
    }

    public void dispatchTitleChanged(CharSequence charSequence, int i) {
    }

    public void ensureActionBar() {
    }

    public abstract ActionBar getActionBar();

    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            if (getActionBar() != null) {
                this.mMenuInflater = new MenuInflater(getThemedContext(), this.mActivity);
            } else {
                this.mMenuInflater = new MenuInflater(this.mActivity);
            }
        }
        return this.mMenuInflater;
    }

    protected abstract Context getThemedContext();

    public abstract boolean hasFeature(int i);

    public abstract boolean requestFeature(int i);

    public abstract void setContentView(int i);

    public void setContentView(View view) {
        setContentView(view, new LayoutParams(-1, -1));
    }

    public abstract void setContentView(View view, LayoutParams layoutParams);

    public abstract void setProgress(int i);

    public abstract void setProgressBarIndeterminate(boolean z);

    public abstract void setProgressBarIndeterminateVisibility(boolean z);

    public abstract void setProgressBarVisibility(boolean z);

    public abstract void setSecondaryProgress(int i);

    public void setTitle(int i) {
        setTitle(this.mActivity.getString(i));
    }

    public abstract void setTitle(CharSequence charSequence);

    public abstract void setUiOptions(int i);

    public abstract void setUiOptions(int i, int i2);

    public abstract ActionMode startActionMode(Callback callback);
}

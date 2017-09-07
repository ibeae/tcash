package com.jeremyfeinstein.slidingmenu.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.C0146g;
import android.support.v4.view.C0152j;
import android.support.v4.view.C0157m;
import android.support.v4.view.C0168o;
import android.support.v4.view.C0177u;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.actionbarsherlock.view.Menu;
import com.facebook.widget.PlacePickerFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnClosedListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import java.util.ArrayList;
import java.util.List;

public class CustomViewAbove extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final String TAG = "CustomViewAbove";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new C12091();
    protected int mActivePointerId;
    private OnClosedListener mClosedListener;
    private View mContent;
    private int mCurItem;
    private boolean mEnabled;
    private int mFlingDistance;
    private List<View> mIgnoredViews;
    private float mInitialMotionX;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private float mLastMotionX;
    private float mLastMotionY;
    protected int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnPageChangeListener mOnPageChangeListener;
    private OnOpenedListener mOpenedListener;
    private boolean mQuickReturn;
    private float mScrollX;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private int mTouchSlop;
    protected VelocityTracker mVelocityTracker;
    private CustomViewBehind mViewBehind;

    static class C12091 implements Interpolator {
        C12091() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    public interface OnPageChangeListener {
        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    class C12102 extends SimpleOnPageChangeListener {
        C12102() {
        }

        public void onPageSelected(int i) {
            if (CustomViewAbove.this.mViewBehind != null) {
                switch (i) {
                    case 0:
                    case 2:
                        CustomViewAbove.this.mViewBehind.setChildrenEnabled(true);
                        return;
                    case 1:
                        CustomViewAbove.this.mViewBehind.setChildrenEnabled(false);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public CustomViewAbove(Context context) {
        this(context, null);
    }

    public CustomViewAbove(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mEnabled = true;
        this.mIgnoredViews = new ArrayList();
        this.mTouchMode = 0;
        this.mQuickReturn = false;
        this.mScrollX = 0.0f;
        initCustomViewAbove();
    }

    private void completeScroll() {
        if (this.mScrolling) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            if (isMenuOpen()) {
                if (this.mOpenedListener != null) {
                    this.mOpenedListener.onOpened();
                }
            } else if (this.mClosedListener != null) {
                this.mClosedListener.onClosed();
            }
        }
        this.mScrolling = false;
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (i != -1 && pointerIndex != -1) {
            float c = C0152j.m492c(motionEvent, pointerIndex);
            float f = c - this.mLastMotionX;
            float abs = Math.abs(f);
            float d = C0152j.m494d(motionEvent, pointerIndex);
            float abs2 = Math.abs(d - this.mLastMotionY);
            if (abs > ((float) (isMenuOpen() ? this.mTouchSlop / 2 : this.mTouchSlop)) && abs > abs2 && thisSlideAllowed(f)) {
                startDrag();
                this.mLastMotionX = c;
                this.mLastMotionY = d;
                setScrollingCacheEnabled(true);
            } else if (abs > ((float) this.mTouchSlop)) {
                this.mIsUnableToDrag = true;
            }
        }
    }

    private int determineTargetPage(float f, int i, int i2) {
        int i3 = this.mCurItem;
        return (Math.abs(i2) <= this.mFlingDistance || Math.abs(i) <= this.mMinimumVelocity) ? Math.round(((float) this.mCurItem) + f) : (i <= 0 || i2 <= 0) ? (i >= 0 || i2 >= 0) ? i3 : i3 + 1 : i3 - 1;
    }

    private void endDrag() {
        this.mQuickReturn = false;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int getLeftBound() {
        return this.mViewBehind.getAbsLeftBound(this.mContent);
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int a = C0152j.m489a(motionEvent, i);
        if (a == -1) {
            this.mActivePointerId = -1;
        }
        return a;
    }

    private int getRightBound() {
        return this.mViewBehind.getAbsRightBound(this.mContent);
    }

    private boolean isInIgnoredView(MotionEvent motionEvent) {
        Rect rect = new Rect();
        for (View hitRect : this.mIgnoredViews) {
            hitRect.getHitRect(rect);
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int b = C0152j.m490b(motionEvent);
        if (C0152j.m491b(motionEvent, b) == this.mActivePointerId) {
            b = b == 0 ? 1 : 0;
            this.mLastMotionX = C0152j.m492c(motionEvent, b);
            this.mActivePointerId = C0152j.m491b(motionEvent, b);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void pageScrolled(int i) {
        int width = getWidth();
        int i2 = i % width;
        onPageScrolled(i / width, ((float) i2) / ((float) width), i2);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void startDrag() {
        this.mIsBeingDragged = true;
        this.mQuickReturn = false;
    }

    private boolean thisSlideAllowed(float f) {
        return isMenuOpen() ? this.mViewBehind.menuOpenSlideAllowed(f) : this.mViewBehind.menuClosedSlideAllowed(f);
    }

    private boolean thisTouchAllowed(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() + this.mScrollX);
        if (isMenuOpen()) {
            return this.mViewBehind.menuOpenTouchAllowed(this.mContent, this.mCurItem, (float) x);
        }
        switch (this.mTouchMode) {
            case 0:
                return this.mViewBehind.marginTouchAllowed(this.mContent, x);
            case 1:
                return !isInIgnoredView(motionEvent);
            case 2:
                return false;
            default:
                return false;
        }
    }

    public void addIgnoredView(View view) {
        if (!this.mIgnoredViews.contains(view)) {
            this.mIgnoredViews.add(view);
        }
    }

    public boolean arrowScroll(int i) {
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i == 17 || i == 1) {
                pageLeft = pageLeft();
            } else {
                if (i == 66 || i == 2) {
                    pageLeft = pageRight();
                }
                pageLeft = false;
            }
        } else if (i == 17) {
            pageLeft = findNextFocus.requestFocus();
        } else {
            if (i == 66) {
                pageLeft = (findFocus == null || findNextFocus.getLeft() > findFocus.getLeft()) ? findNextFocus.requestFocus() : pageRight();
            }
            pageLeft = false;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return pageLeft;
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && C0168o.m544a(view, -i);
    }

    public void clearIgnoredViews() {
        this.mIgnoredViews.clear();
    }

    public void computeScroll() {
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            pageScrolled(currX);
        }
        invalidate();
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mViewBehind.drawShadow(this.mContent, canvas);
        this.mViewBehind.drawFade(this.mContent, canvas, getPercentOpen());
        this.mViewBehind.drawSelector(this.mContent, canvas, getPercentOpen());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    float distanceInfluenceForSnapDuration(float f) {
        return FloatMath.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                return VERSION.SDK_INT >= 11 ? C0146g.m466a(keyEvent) ? arrowScroll(2) : C0146g.m467a(keyEvent, 1) ? arrowScroll(1) : false : false;
            default:
                return false;
        }
    }

    public int getBehindWidth() {
        return this.mViewBehind == null ? 0 : this.mViewBehind.getBehindWidth();
    }

    public int getChildWidth(int i) {
        switch (i) {
            case 0:
                return getBehindWidth();
            case 1:
                return this.mContent.getWidth();
            default:
                return 0;
        }
    }

    public View getContent() {
        return this.mContent;
    }

    public int getContentLeft() {
        return this.mContent.getLeft() + this.mContent.getPaddingLeft();
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getDestScrollX(int i) {
        switch (i) {
            case 0:
            case 2:
                return this.mViewBehind.getMenuLeft(this.mContent, i);
            case 1:
                return this.mContent.getLeft();
            default:
                return 0;
        }
    }

    protected float getPercentOpen() {
        return Math.abs(this.mScrollX - ((float) this.mContent.getLeft())) / ((float) getBehindWidth());
    }

    public int getTouchMode() {
        return this.mTouchMode;
    }

    void initCustomViewAbove() {
        setWillNotDraw(false);
        setDescendantFocusability(Menu.CATEGORY_ALTERNATIVE);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = C0177u.m562a(viewConfiguration);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setInternalPageChangeListener(new C12102());
        this.mFlingDistance = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    public boolean isMenuOpen() {
        return this.mCurItem == 0 || this.mCurItem == 2;
    }

    public boolean isSlidingEnabled() {
        return this.mEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1 || (action != 0 && this.mIsUnableToDrag)) {
            endDrag();
            return false;
        }
        switch (action) {
            case 0:
                action = C0152j.m490b(motionEvent);
                this.mActivePointerId = C0152j.m491b(motionEvent, action);
                if (this.mActivePointerId != -1) {
                    float c = C0152j.m492c(motionEvent, action);
                    this.mInitialMotionX = c;
                    this.mLastMotionX = c;
                    this.mLastMotionY = C0152j.m494d(motionEvent, action);
                    if (!thisTouchAllowed(motionEvent)) {
                        this.mIsUnableToDrag = true;
                        break;
                    }
                    this.mIsBeingDragged = false;
                    this.mIsUnableToDrag = false;
                    if (isMenuOpen() && this.mViewBehind.menuTouchInQuickReturn(this.mContent, this.mCurItem, motionEvent.getX() + this.mScrollX)) {
                        this.mQuickReturn = true;
                        break;
                    }
                }
                break;
            case 2:
                determineDrag(motionEvent);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (!this.mIsBeingDragged) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged || this.mQuickReturn;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContent.layout(0, 0, i3 - i, i4 - i2);
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.mContent.measure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    protected void onPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            completeScroll();
            scrollTo(getDestScrollX(this.mCurItem), getScrollY());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        if (!this.mIsBeingDragged && !thisTouchAllowed(motionEvent)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        int a;
        float scrollX;
        switch (action & 255) {
            case 0:
                completeScroll();
                this.mActivePointerId = C0152j.m491b(motionEvent, C0152j.m490b(motionEvent));
                x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                break;
            case 1:
                if (!this.mIsBeingDragged) {
                    if (this.mQuickReturn && this.mViewBehind.menuTouchInQuickReturn(this.mContent, this.mCurItem, motionEvent.getX() + this.mScrollX)) {
                        setCurrentItem(1);
                        endDrag();
                        break;
                    }
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, (float) this.mMaximumVelocity);
                a = (int) C0157m.m506a(velocityTracker, this.mActivePointerId);
                scrollX = ((float) (getScrollX() - getDestScrollX(this.mCurItem))) / ((float) getBehindWidth());
                int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                if (this.mActivePointerId != -1) {
                    setCurrentItemInternal(determineTargetPage(scrollX, a, (int) (C0152j.m492c(motionEvent, pointerIndex) - this.mInitialMotionX)), true, true, a);
                } else {
                    setCurrentItemInternal(this.mCurItem, true, true, a);
                }
                this.mActivePointerId = -1;
                endDrag();
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    determineDrag(motionEvent);
                    if (this.mIsUnableToDrag) {
                        return false;
                    }
                }
                if (this.mIsBeingDragged) {
                    a = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (this.mActivePointerId != -1) {
                        x = C0152j.m492c(motionEvent, a);
                        scrollX = this.mLastMotionX - x;
                        this.mLastMotionX = x;
                        float scrollX2 = ((float) getScrollX()) + scrollX;
                        x = (float) getLeftBound();
                        scrollX = (float) getRightBound();
                        if (scrollX2 >= x) {
                            x = scrollX2 > scrollX ? scrollX : scrollX2;
                        }
                        this.mLastMotionX += x - ((float) ((int) x));
                        scrollTo((int) x, getScrollY());
                        pageScrolled((int) x);
                        break;
                    }
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    setCurrentItemInternal(this.mCurItem, true, true);
                    this.mActivePointerId = -1;
                    endDrag();
                    break;
                }
                break;
            case 5:
                a = C0152j.m490b(motionEvent);
                this.mLastMotionX = C0152j.m492c(motionEvent, a);
                this.mActivePointerId = C0152j.m491b(motionEvent, a);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                a = getPointerIndex(motionEvent, this.mActivePointerId);
                if (this.mActivePointerId != -1) {
                    this.mLastMotionX = C0152j.m492c(motionEvent, a);
                    break;
                }
                break;
        }
        return true;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return false;
        }
        setCurrentItem(this.mCurItem - 1, true);
        return true;
    }

    boolean pageRight() {
        if (this.mCurItem >= 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void removeIgnoredView(View view) {
        this.mIgnoredViews.remove(view);
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        this.mScrollX = (float) i;
        this.mViewBehind.scrollBehindTo(this.mContent, i, i2);
        ((SlidingMenu) getParent()).manageLayers(getPercentOpen());
    }

    public void setAboveOffset(int i) {
        this.mContent.setPadding(i, this.mContent.getPaddingTop(), this.mContent.getPaddingRight(), this.mContent.getPaddingBottom());
    }

    public void setContent(View view) {
        if (this.mContent != null) {
            removeView(this.mContent);
        }
        this.mContent = view;
        addView(this.mContent);
    }

    public void setCurrentItem(int i) {
        setCurrentItemInternal(i, true, false);
    }

    public void setCurrentItem(int i, boolean z) {
        setCurrentItemInternal(i, z, false);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        if (z2 || this.mCurItem != i) {
            int menuPage = this.mViewBehind.getMenuPage(i);
            boolean z3 = this.mCurItem != menuPage;
            this.mCurItem = menuPage;
            int destScrollX = getDestScrollX(this.mCurItem);
            if (z3 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(menuPage);
            }
            if (z3 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(menuPage);
            }
            if (z) {
                smoothScrollTo(destScrollX, 0, i2);
                return;
            }
            completeScroll();
            scrollTo(destScrollX, 0);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void setCustomViewBehind(CustomViewBehind customViewBehind) {
        this.mViewBehind = customViewBehind;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOnClosedListener(OnClosedListener onClosedListener) {
        this.mClosedListener = onClosedListener;
    }

    public void setOnOpenedListener(OnOpenedListener onOpenedListener) {
        this.mOpenedListener = onOpenedListener;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setSlidingEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setTouchMode(int i) {
        this.mTouchMode = i;
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            completeScroll();
            if (isMenuOpen()) {
                if (this.mOpenedListener != null) {
                    this.mOpenedListener.onOpened();
                    return;
                }
                return;
            } else if (this.mClosedListener != null) {
                this.mClosedListener.onClosed();
                return;
            } else {
                return;
            }
        }
        setScrollingCacheEnabled(true);
        this.mScrolling = true;
        int behindWidth = getBehindWidth();
        int i6 = behindWidth / 2;
        float distanceInfluenceForSnapDuration = (((float) i6) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) behindWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            behindWidth = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs))) * 4;
        } else {
            behindWidth = (int) (((((float) Math.abs(i4)) / ((float) behindWidth)) + 1.0f) * 100.0f);
            behindWidth = MAX_SETTLE_DURATION;
        }
        this.mScroller.startScroll(scrollX, scrollY, i4, i5, Math.min(behindWidth, MAX_SETTLE_DURATION));
        invalidate();
    }
}

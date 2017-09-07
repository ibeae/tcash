package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.actionbarsherlock.C0247R;

public class IcsListPopupWindow {
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private ListAdapter mAdapter;
    private Context mContext;
    private View mDropDownAnchorView;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private OnItemClickListener mItemClickListener;
    private OnItemSelectedListener mItemSelectedListener;
    private int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private final PopupWindowCompat mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    class C02711 implements OnItemSelectedListener {
        C02711() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                DropDownListView access$600 = IcsListPopupWindow.this.mDropDownList;
                if (access$600 != null) {
                    access$600.mListSelectionHidden = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private static class DropDownListView extends ListView {
        private boolean mHijackFocus;
        private boolean mListSelectionHidden;

        public DropDownListView(Context context, boolean z) {
            super(context, null, C0247R.attr.dropDownListViewStyle);
            this.mHijackFocus = z;
            setCacheColorHint(0);
        }

        public boolean hasFocus() {
            return this.mHijackFocus || super.hasFocus();
        }

        public boolean hasWindowFocus() {
            return this.mHijackFocus || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.mHijackFocus || super.isFocused();
        }

        public boolean isInTouchMode() {
            return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
        }
    }

    private class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        public void run() {
            IcsListPopupWindow.this.clearListSelection();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        public void onChanged() {
            if (IcsListPopupWindow.this.isShowing()) {
                IcsListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            IcsListPopupWindow.this.dismiss();
        }
    }

    private class PopupScrollListener implements OnScrollListener {
        private PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !IcsListPopupWindow.this.isInputMethodNotNeeded() && IcsListPopupWindow.this.mPopup.getContentView() != null) {
                IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
                IcsListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private class PopupTouchInterceptor implements OnTouchListener {
        private PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && IcsListPopupWindow.this.mPopup != null && IcsListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < IcsListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < IcsListPopupWindow.this.mPopup.getHeight()) {
                IcsListPopupWindow.this.mHandler.postDelayed(IcsListPopupWindow.this.mResizePopupRunnable, 250);
            } else if (action == 1) {
                IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
            }
            return false;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        public void run() {
            if (IcsListPopupWindow.this.mDropDownList != null && IcsListPopupWindow.this.mDropDownList.getCount() > IcsListPopupWindow.this.mDropDownList.getChildCount() && IcsListPopupWindow.this.mDropDownList.getChildCount() <= IcsListPopupWindow.this.mListItemExpandMaximum) {
                IcsListPopupWindow.this.mPopup.setInputMethodMode(2);
                IcsListPopupWindow.this.show();
            }
        }
    }

    public IcsListPopupWindow(Context context) {
        this(context, null, C0247R.attr.listPopupWindowStyle);
    }

    public IcsListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mListItemExpandMaximum = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mPopup = new PopupWindowCompat(context, attributeSet, i);
        this.mPopup.setInputMethodMode(1);
    }

    public IcsListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mListItemExpandMaximum = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        if (VERSION.SDK_INT < 11) {
            this.mPopup = new PopupWindowCompat(new ContextThemeWrapper(context, i2), attributeSet, i);
        } else {
            this.mPopup = new PopupWindowCompat(context, attributeSet, i, i2);
        }
        this.mPopup.setInputMethodMode(1);
    }

    private int buildDropDown() {
        int measuredHeight;
        int i;
        int i2;
        boolean z = true;
        View linearLayout;
        LayoutParams layoutParams;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mDropDownList = new DropDownListView(context, !this.mModal);
            if (this.mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(this.mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new C02711());
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            if (this.mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
            }
            View view = this.mDropDownList;
            View view2 = this.mPromptView;
            if (view2 != null) {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.mPromptPosition) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.mDropDownWidth, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view2.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                linearLayout = view;
                measuredHeight = 0;
            }
            this.mPopup.setContentView(linearLayout);
            i = measuredHeight;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.mPopup.getContentView();
            linearLayout = this.mPromptView;
            if (linearLayout != null) {
                layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                i = layoutParams.bottomMargin + (linearLayout.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i = 0;
            }
        }
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            measuredHeight = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
            }
            i2 = measuredHeight;
        } else {
            i2 = 0;
        }
        if (this.mPopup.getInputMethodMode() != 2) {
            z = false;
        }
        measuredHeight = getMaxAvailableHeight(this.mDropDownAnchorView, this.mDropDownVerticalOffset, z);
        if (this.mDropDownHeight == -1) {
            return measuredHeight + i2;
        }
        measuredHeight = measureHeightOfChildren(0, 0, -1, measuredHeight - i, -1);
        if (measuredHeight > 0) {
            i += i2;
        }
        return measuredHeight + i;
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        i2 = Math.max((i2 - (iArr[1] + view.getHeight())) - i, (iArr[1] - rect.top) + i);
        if (this.mPopup.getBackground() == null) {
            return i2;
        }
        this.mPopup.getBackground().getPadding(this.mTempRect);
        return i2 - (this.mTempRect.top + this.mTempRect.bottom);
    }

    private boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    private int measureHeightOfChildren(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
        }
        int listPaddingTop = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
        int dividerHeight = (this.mDropDownList.getDividerHeight() <= 0 || this.mDropDownList.getDivider() == null) ? 0 : this.mDropDownList.getDividerHeight();
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        while (i2 <= i3) {
            View view = this.mAdapter.getView(i2, null, this.mDropDownList);
            if (this.mDropDownList.getCacheColorHint() != 0) {
                view.setDrawingCacheBackgroundColor(this.mDropDownList.getCacheColorHint());
            }
            measureScrapChild(view, i2, i);
            if (i2 > 0) {
                listPaddingTop += dividerHeight;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i2 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i2 >= i5) {
                    i6 = listPaddingTop;
                }
                i2++;
            }
        }
        return listPaddingTop;
    }

    private void measureScrapChild(View view, int i, int i2) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.mDropDownList.getPaddingLeft() + this.mDropDownList.getPaddingRight(), layoutParams.width);
        int i3 = layoutParams.height;
        view.measure(childMeasureSpec, i3 > 0 ? MeasureSpec.makeMeasureSpec(i3, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.mListSelectionHidden = true;
            dropDownListView.requestLayout();
        }
    }

    public void dismiss() {
        this.mPopup.dismiss();
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right) + i;
            return;
        }
        this.mDropDownWidth = i;
    }

    public void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public void setInputMethodMode(int i) {
        this.mPopup.setInputMethodMode(i);
    }

    public void setModal(boolean z) {
        this.mModal = true;
        this.mPopup.setFocusable(z);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setPromptPosition(int i) {
        this.mPromptPosition = i;
    }

    public void setSelection(int i) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.mListSelectionHidden = false;
            dropDownListView.setSelection(i);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i, true);
            }
        }
    }

    public void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void show() {
        int i = 0;
        int i2 = -1;
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        if (this.mPopup.isShowing()) {
            int width = this.mDropDownWidth == -1 ? -1 : this.mDropDownWidth == -2 ? this.mDropDownAnchorView.getWidth() : this.mDropDownWidth;
            if (this.mDropDownHeight == -1) {
                if (!isInputMethodNotNeeded) {
                    buildDropDown = -1;
                }
                PopupWindowCompat popupWindowCompat;
                if (isInputMethodNotNeeded) {
                    popupWindowCompat = this.mPopup;
                    if (this.mDropDownWidth != -1) {
                        i2 = 0;
                    }
                    popupWindowCompat.setWindowLayoutMode(i2, 0);
                } else {
                    popupWindowCompat = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i = -1;
                    }
                    popupWindowCompat.setWindowLayoutMode(i, -1);
                }
            } else if (this.mDropDownHeight != -2) {
                buildDropDown = this.mDropDownHeight;
            }
            this.mPopup.setOutsideTouchable(true);
            this.mPopup.update(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, width, buildDropDown);
            return;
        }
        int i3;
        if (this.mDropDownWidth == -1) {
            i3 = -1;
        } else if (this.mDropDownWidth == -2) {
            this.mPopup.setWidth(this.mDropDownAnchorView.getWidth());
            i3 = 0;
        } else {
            this.mPopup.setWidth(this.mDropDownWidth);
            i3 = 0;
        }
        if (this.mDropDownHeight == -1) {
            i = -1;
        } else if (this.mDropDownHeight == -2) {
            this.mPopup.setHeight(buildDropDown);
        } else {
            this.mPopup.setHeight(this.mDropDownHeight);
        }
        this.mPopup.setWindowLayoutMode(i3, i);
        this.mPopup.setOutsideTouchable(true);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        this.mPopup.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }
}

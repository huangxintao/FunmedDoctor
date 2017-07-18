package me.murphy.common.commonwidget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Murphy on 16/3/21.
 * 屏蔽掉ViewPager的滑动事件,交给子View去处理.
 */
public class NoSmoothScrollViewPager extends ViewPager {
    private final String TAG = "CustomViewPager";
    private boolean isCanScroll = true;

    public NoSmoothScrollViewPager(Context context) {
        super(context);
    }

    public NoSmoothScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isCanScroll() {
        return isCanScroll;
    }

    public void setIsCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onInterceptTouchEvent(ev);
    }
}

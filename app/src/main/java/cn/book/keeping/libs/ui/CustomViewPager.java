package cn.book.keeping.libs.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by yh on 16/6/17.
 */
public class CustomViewPager extends ViewPager {

    private boolean scroll = true;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setScroll(boolean scroll) {
        this.scroll = scroll;
    }

    public boolean onTouchEvent(MotionEvent arg0) {
        return this.scroll ? super.onTouchEvent(arg0) : false;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return this.scroll ? super.onInterceptTouchEvent(arg0) : false;
    }


}

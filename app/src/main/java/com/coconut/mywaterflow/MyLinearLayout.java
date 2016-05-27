package com.coconut.mywaterflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public class MyLinearLayout extends LinearLayout{


    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int count = getChildCount();
        int width = getWidth() / count;
        int height = getHeight();

        float eventX = event.getX();
        // 点击最左边的一个ListView
        if (eventX < width) {
            event.setLocation(width / 2, event.getY());
            getChildAt(0).dispatchTouchEvent(event);
            return true;
        } else if (eventX >= width && eventX < width*2) {  // 滑动中间的ListView,分两种情况,
            // 在上部分就滑动全部ListView,在下部分,就只滑动中间的ListView
            float eventY = event.getY();
            if (eventY < getHeight()/2) {   //点击在上部分,滑动全部
                event.setLocation(width/2,eventY);
                for (int i = 0;i < count;i++) {
                    getChildAt(i).dispatchTouchEvent(event);

                }
                return true;
            } else if (eventY>= getHeight()/2) {   // 点击在下部分,滑动中间的ListView
                event.setLocation(width/2,eventY);
                getChildAt(1).dispatchTouchEvent(event);
                return  true;
            }
        } else if (eventX >= 2*width) {
            event.setLocation(width/2,event.getY());
            getChildAt(2).dispatchTouchEvent(event);
            return  true;
        }

        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}

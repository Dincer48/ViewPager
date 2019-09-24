package com.example.dincerkizildere.viewpager;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;



public class ViewPagerPlaceHolder  extends View {
    public ViewPagerPlaceHolder(Context context) {
        super(context);
    }

    public ViewPagerPlaceHolder(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public ViewPagerPlaceHolder(Context context,AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ViewPagerPlaceHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void setHeaderHeight() {


        HollyViewPager pager = ViewPagerBus.get(getContext());
        if (pager != null) {
            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = pager.settings.headerHeightPx;
            super.setLayoutParams(params);
        }
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        if (!isInEditMode()){
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    setHeaderHeight();
                    getViewTreeObserver().removeOnPreDrawListener(this);
                    return false;
                }
            });
        }
    }
}

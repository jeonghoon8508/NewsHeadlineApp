package com.example.forget.newsheadlineapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class AutoHeightImageView extends android.support.v7.widget.AppCompatImageView{
    public AutoHeightImageView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if(drawable != null) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) Math.ceil((float)width * (float) drawable.getIntrinsicHeight() / (float) drawable.getIntrinsicWidth());
            setMeasuredDimension(width, height);
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}

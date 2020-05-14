package com.example.mentalmath.Widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mentalmath.R;

public class CustomRL {
    private Context context;

    public CustomRL(Context c) {
        this.context = c;
    }

    public void setAutorization(RelativeLayout relativeLayout) {
//        float mRadius = 30f;
//        int[] colors = {Color.rgb(236, 236, 236), Color.rgb(128, 128, 128)};
//        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
//        gradientDrawable.setCornerRadius(0f);
//        gradientDrawable.setCornerRadii(new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius});
        relativeLayout.setBackgroundResource(R.drawable.rectangle);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(SizeDP(80), SizeDP(137), SizeDP(50), 0);
        relativeLayout.setLayoutParams(params);
    }

    private int SizeDP(float count) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, count, context.getResources().getDisplayMetrics());
        int numb = Math.round(px);
        return numb;
    }
}

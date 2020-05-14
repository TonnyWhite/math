package com.example.mentalmath.Widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CustomTV {
    private Context context;

public CustomTV(Context c){
    this.context = c;
}

    public void setWelcome(TextView textView, String text) {
//        Typeface typeface = Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.Fonts));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        params.height = SizeDP(87);
        params.setMargins(0,SizeDP(16),0, 0);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextColor(Color.rgb(59, 144, 51));
    }


    public void setRegistration(TextView textView, String text) {
//        Typeface typeface = Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.Fonts));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        params.height = SizeDP(23);
        params.setMargins(0,SizeDP(289),0, 0);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextColor(Color.rgb(9, 90, 81));
    }

    public void setSignIn(TextView textView, String text) {
        float mRadius = 20f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius});
        gradientDrawable.setStroke(
                2, // Border width
                Color.rgb(229, 255, 226) // Border color
        );
        gradientDrawable.setColor(Color.rgb(229, 255, 226));
        textView.setBackgroundDrawable(gradientDrawable);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        params.height = SizeDP(36);
        params.width = SizeDP(93);
        params.setMargins(SizeDP(33),SizeDP(247),0, 0);
        textView.setLayoutParams(params);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
        textView.setTextColor(Color.rgb(0, 0, 0));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextColor(Color.rgb(9, 90, 81));
    }

    private int SizeDP(float count) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, count, context.getResources().getDisplayMetrics());
        int numb = Math.round(px);
        return numb;
    }


}

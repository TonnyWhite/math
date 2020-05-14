package com.example.mentalmath.Widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class CustomEditText {
    private Context context;

    public CustomEditText(Context c) {
        this.context = c;
    }

    public void setLogin(AutoCompleteTextView editText, String hint) {
        float mRadius = 20f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius});
        gradientDrawable.setStroke(
                2, // Border width
                Color.rgb(229, 255, 226) // Border color
        );
        gradientDrawable.setColor(Color.rgb(229, 255, 226));
        editText.setBackgroundDrawable(gradientDrawable);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.height = SizeDP(34);
        params.width = SizeDP(209);
        params.setMargins(SizeDP(33),SizeDP(141),0, 0);
        editText.setLayoutParams(params);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        editText.setTextColor(Color.rgb(0, 0, 0));
        editText.setGravity(Gravity.LEFT);
        editText.setHint(hint);
        editText.setHintTextColor(Color.rgb(9, 90, 81));
    }

    public void setPassword(AutoCompleteTextView editText, String hint) {
        float mRadius = 20f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius});
        gradientDrawable.setStroke(
                2, // Border width
                Color.rgb(229, 255, 226) // Border color
        );
        gradientDrawable.setColor(Color.rgb(229, 255, 226));
        editText.setBackgroundDrawable(gradientDrawable);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.height = SizeDP(34);
        params.width = SizeDP(209);
        params.setMargins(SizeDP(33),SizeDP(197),0, 0);
        editText.setLayoutParams(params);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        editText.setTextColor(Color.rgb(0, 0, 0));
        editText.setGravity(Gravity.LEFT);
        editText.setHint(hint);
        editText.setHintTextColor(Color.rgb(9, 90, 81));
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    private int SizeDP(float count) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, count, context.getResources().getDisplayMetrics());
        int numb = Math.round(px);
        return numb;

    }
}

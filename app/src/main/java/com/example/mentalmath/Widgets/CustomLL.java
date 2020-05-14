package com.example.mentalmath.Widgets;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.mentalmath.R;

public class CustomLL {
    private Context context;

    public CustomLL(Context c) {
        this.context = c;
    }
    public void setEdit(LinearLayout linearLayout, String key) {
        if (key.equals("Content")) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            linearLayout.setLayoutParams(params);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
//            linearLayout.setBackgroundColor(Color.rgb(255, 255, 255));
        }
    }
    public void setMain(LinearLayout linearLayout) {
        ScrollView.LayoutParams params = new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
    }


    private int SizeDP(float count) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, count, context.getResources().getDisplayMetrics());
        int numb = Math.round(px);
        return numb;
    }
}

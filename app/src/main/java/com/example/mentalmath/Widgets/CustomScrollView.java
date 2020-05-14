package com.example.mentalmath.Widgets;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class CustomScrollView {
    private Context context;
    public CustomScrollView(Context context) {
        this.context = context;
    }
    public void setMainLL(ScrollView scrollView) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        scrollView.setLayoutParams(params);
    }
}
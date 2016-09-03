package com.akodiakson.magictavern.ui;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.akodiakson.magictavern.NavTab;

public class IconBinder {
    @BindingAdapter("iconBinding")
    public static void bindIcons(ImageView imageView, NavTab navTab){
        // Your setter code goes here, like setDrawable or similar
        Context context = imageView.getContext();
        Drawable drawable = ContextCompat.getDrawable(context, navTab.getIconResource());
        imageView.setImageDrawable(drawable);
    }
}

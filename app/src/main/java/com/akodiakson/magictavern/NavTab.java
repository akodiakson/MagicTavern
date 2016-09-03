package com.akodiakson.magictavern;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class NavTab extends BaseObservable {

    private @StringRes int tabTextResource;
    private @DrawableRes int iconResource;
    private TopLevelNavTab type;
    private boolean isActive;

    public NavTab(TopLevelNavTab type, int tabTextResource, int iconResource) {
        this.type = type;
        this.tabTextResource = tabTextResource;
        this.iconResource = iconResource;
    }


    @Bindable
    public int getTabTextResource() {
        return tabTextResource;
    }

    public void setTabTextResource(int tabTextResource) {
        this.tabTextResource = tabTextResource;
    }

    @Bindable
    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    @Bindable
    public TopLevelNavTab getType() {
        return type;
    }

    @Bindable
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
        notifyPropertyChanged(BR.active);
    }
}

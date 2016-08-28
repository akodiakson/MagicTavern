package com.akodiakson.magictavern;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public enum TopLevelNavTab {

    EPISODES(0, R.string.tab_title_episodes, R.drawable.ic_mic_black_24dp),
    EARTH_STUFF(1, R.string.tab_title_earth_stuff, R.drawable.ic_mic_black_24dp);

    private int position;
    private @StringRes int tabTextLabel;
    private @DrawableRes int tabIconResource;

    TopLevelNavTab(int position, int tabTextLabel, int tabIconResource) {
        this.position = position;
        this.tabTextLabel = tabTextLabel;
        this.tabIconResource = tabIconResource;
    }

    public int getTabTextLabel() {
        return tabTextLabel;
    }

    public int getTabIconResource() {
        return tabIconResource;
    }
}

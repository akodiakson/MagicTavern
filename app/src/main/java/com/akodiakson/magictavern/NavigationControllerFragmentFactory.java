package com.akodiakson.magictavern;

import android.support.v4.app.Fragment;

import com.akodiakson.magictavern.ui.EpisodesFragment;

public class NavigationControllerFragmentFactory {

    public static Fragment getFragment(NavTab topLevelNavTab) {
        switch (topLevelNavTab.getType()) {

            case EPISODES:
                return EpisodesFragment.newInstance();
            case EARTH_STUFF:
                return EpisodesFragment.newInstance();
            case FOON_STUFF:
                return EpisodesFragment.newInstance();
            default:
                return EpisodesFragment.newInstance();
        }
    }
}

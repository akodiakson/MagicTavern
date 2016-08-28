package com.akodiakson.magictavern;

import android.support.v4.app.Fragment;

import com.akodiakson.magictavern.ui.EpisodesFragment;

public class NavigationControllerFragmentFactory {

    public static Fragment getFragment(TopLevelNavTab topLevelNavTab) {
        switch (topLevelNavTab) {

            case EPISODES:
                return EpisodesFragment.newInstance();
            default:
                return EpisodesFragment.newInstance();
        }
    }
}

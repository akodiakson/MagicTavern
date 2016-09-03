package com.akodiakson.magictavern;

import java.util.ArrayList;
import java.util.List;

public class NavigationController {

    private static NavigationController navigationController;

    private NavTab activeTab;

    private static List<NavTab> navTabs;

    static {
        navTabs = new ArrayList<>();
        navTabs.add(new NavTab(TopLevelNavTab.EPISODES, R.string.tab_title_episodes, R.drawable.ic_mic_black_24dp));
        navTabs.add(new NavTab(TopLevelNavTab.EARTH_STUFF, R.string.tab_title_earth_stuff, R.drawable.ic_mic_black_24dp));
        navTabs.add(new NavTab(TopLevelNavTab.FOON_STUFF, R.string.tab_title_foon_stuff, R.drawable.ic_mic_black_24dp));
    }

    private NavigationController() {
    }

    public static NavigationController getInstance() {
        if(navigationController == null){
            navigationController = new NavigationController();
        }
        return navigationController;
    }

    public NavTab getActiveTab() {
        if(activeTab == null){
            activeTab = navTabs.get(0);
        }
        return activeTab;
    }

    public void setActiveTab(NavTab activeTab) {
        this.activeTab = activeTab;
    }

    public static List<NavTab> getNavTabs() {
        return navTabs;
    }
}

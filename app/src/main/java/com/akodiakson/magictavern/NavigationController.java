package com.akodiakson.magictavern;

public class NavigationController {

    private static NavigationController navigationController;

    private TopLevelNavTab activeTab;

    private NavigationController() {
    }

    public static NavigationController getInstance() {
        if(navigationController == null){
            navigationController = new NavigationController();
        }
        return navigationController;
    }

    public TopLevelNavTab getActiveTab() {
        if(activeTab == null){
            activeTab = TopLevelNavTab.EPISODES;
        }
        return activeTab;
    }

    public void setActiveTab(TopLevelNavTab activeTab) {
        this.activeTab = activeTab;
    }

}

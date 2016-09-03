package com.akodiakson.magictavern.ui;

import com.akodiakson.magictavern.NavTab;
import com.akodiakson.magictavern.NavigationContract;
import com.akodiakson.magictavern.NavigationController;

public class NavigationPresenter implements NavigationContract.Presenter {

    private NavigationContract.View view;
    private NavigationController navigationController;

    public NavigationPresenter(NavigationContract.View view, NavigationController navigationController) {
        this.view = view;
        this.navigationController = navigationController;
    }

    @Override
    public void selectNavigationOption(NavTab topLevelNavTab) {
        navigationController.setActiveTab(topLevelNavTab);
        view.onNavigationOptionSelected(topLevelNavTab);
    }
}

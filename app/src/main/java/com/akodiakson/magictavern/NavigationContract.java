package com.akodiakson.magictavern;

public interface NavigationContract {

    interface Presenter {
        void selectNavigationOption(NavTab topLevelNavTab);
    }

    interface View {
        void onNavigationOptionSelected(NavTab topLevelNavTab);
    }
}

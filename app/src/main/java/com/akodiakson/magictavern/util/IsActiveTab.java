package com.akodiakson.magictavern.util;

import com.akodiakson.magictavern.NavigationController;
import com.akodiakson.magictavern.TopLevelNavTab;

public class IsActiveTab {

    public static boolean isActiveTab(TopLevelNavTab topLevelNavTab){
        return NavigationController.getInstance().getActiveTab().equals(topLevelNavTab);
    }
}

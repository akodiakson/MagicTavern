package com.akodiakson.magictavern.ui;

import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.akodiakson.magictavern.NavigationController;
import com.akodiakson.magictavern.NavigationControllerFragmentFactory;
import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.TopLevelNavTab;
import com.akodiakson.magictavern.databinding.ActivityMainBinding;
import com.akodiakson.magictavern.databinding.LayoutBottomNavBinding;
import com.akodiakson.magictavern.util.ActivityUtils;

@BindingMethods({
        @BindingMethod(type = android.widget.ImageView.class,
                attribute = "app:srcCompat",
                method = "setImageDrawable") })
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        NavigationController navigationController = NavigationController.getInstance();
        TopLevelNavTab activeTab = navigationController.getActiveTab();
        LayoutBottomNavBinding bottomNavBinding = activityMainBinding.mainActivityBottomNavLayout;
        bottomNavBinding.setActiveTab(activeTab);
        bottomNavBinding.firstNavOption.setTopLevelNavTabDescriptor(TopLevelNavTab.EPISODES);
        bottomNavBinding.secondNavOption.setTopLevelNavTabDescriptor(TopLevelNavTab.EARTH_STUFF);
        bottomNavBinding.thirdNavOption.setTopLevelNavTabDescriptor(TopLevelNavTab.EARTH_STUFF);

        Fragment fragment = NavigationControllerFragmentFactory.getFragment(activeTab);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.main_fragment_frame);
    }
}

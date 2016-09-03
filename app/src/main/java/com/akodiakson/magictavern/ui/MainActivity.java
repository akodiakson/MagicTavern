package com.akodiakson.magictavern.ui;

import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.akodiakson.magictavern.NavTab;
import com.akodiakson.magictavern.NavigationContract;
import com.akodiakson.magictavern.NavigationController;
import com.akodiakson.magictavern.NavigationControllerFragmentFactory;
import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.databinding.ActivityMainBinding;
import com.akodiakson.magictavern.databinding.LayoutBottomNavBinding;
import com.akodiakson.magictavern.util.ActivityUtils;


@BindingMethods({
        @BindingMethod(type = android.widget.ImageView.class,
                attribute = "app:srcCompat",
                method = "setImageDrawable") })
public class MainActivity extends AppCompatActivity implements NavigationContract.View{

    private NavigationContract.Presenter presenter;
    private LayoutBottomNavBinding bottomNavBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bottomNavBinding = activityMainBinding.mainActivityBottomNavLayout;
        NavigationController navigationController = NavigationController.getInstance();

        presenter = new NavigationPresenter(this, navigationController);
        bottomNavBinding.firstNavOption.setTopLevelNavTabDescriptor(NavigationController.getNavTabs().get(0));
        bottomNavBinding.firstNavOption.setPresenter(presenter);
        bottomNavBinding.secondNavOption.setTopLevelNavTabDescriptor(NavigationController.getNavTabs().get(1));
        bottomNavBinding.secondNavOption.setPresenter(presenter);
        bottomNavBinding.thirdNavOption.setTopLevelNavTabDescriptor(NavigationController.getNavTabs().get(2));
        bottomNavBinding.thirdNavOption.setPresenter(presenter);

        NavTab activeTab = navigationController.getActiveTab();
        presenter.selectNavigationOption(activeTab);
    }

    @Override
    public void onNavigationOptionSelected(NavTab selectedTab) {
        Fragment fragment = NavigationControllerFragmentFactory.getFragment(selectedTab);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.main_fragment_frame);
        bottomNavBinding.firstNavOption.notifyPropertyChanged(com.akodiakson.magictavern.BR.active);
        bottomNavBinding.secondNavOption.notifyPropertyChanged(com.akodiakson.magictavern.BR.active);
        bottomNavBinding.thirdNavOption.notifyPropertyChanged(com.akodiakson.magictavern.BR.active);
    }
}

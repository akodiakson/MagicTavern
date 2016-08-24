package com.akodiakson.magictavern.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.api.MagicTavernRssFeedApi;
import com.akodiakson.magictavern.databinding.ActivityMainBinding;
import com.akodiakson.magictavern.model.Item;
import com.akodiakson.magictavern.ui.adapter.EpisodeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EpisodesContract.View, EpisodeAdapter.Callbacks{

    private ActivityMainBinding activityMainBinding;

    private EpisodesContract.UserActionsListener actionsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.episodeRecyclerView.setLayoutManager(layoutManager);
        activityMainBinding.episodeRecyclerView.setAdapter(new EpisodeAdapter(this, new ArrayList<Item>()));

        actionsListener = new EpisodesPresenter(this, MagicTavernRssFeedApi.getInstance());
    }

    @Override
    protected void onResume() {
        super.onResume();
        actionsListener.loadEpisodes();
    }


    @Override
    public void onItemSelected(Item selectedItem) {
        BottomSheetDialogFragment bottomSheetDialogFragment = EpisodeBottomSheetDialogFragment.newInstance(selectedItem);
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

    }

    @Override
    public void showEpisodes(List<Item> episodes) {
        activityMainBinding.episodeRecyclerView.setAdapter(new EpisodeAdapter(this, episodes));
    }
}

package com.akodiakson.magictavern.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.api.MagicTavernRssFeedApi;
import com.akodiakson.magictavern.databinding.FragmentEpisodesBinding;
import com.akodiakson.magictavern.model.Item;
import com.akodiakson.magictavern.ui.adapter.EpisodeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EpisodesFragment extends Fragment implements EpisodesContract.View, EpisodeAdapter.Callbacks{

    private FragmentEpisodesBinding episodesBinding;

    private EpisodesContract.UserActionsListener actionsListener;

    public EpisodesFragment() {
        // Required empty public constructor
    }

    public static EpisodesFragment newInstance(){
        return new EpisodesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        episodesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_episodes, container, false);
        episodesBinding.episodeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        episodesBinding.episodeRecyclerView.setAdapter(new EpisodeAdapter(this, new ArrayList<Item>()));
        actionsListener = new EpisodesPresenter(this, MagicTavernRssFeedApi.getInstance());
        return episodesBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        actionsListener.loadEpisodes();
    }

    @Override
    public void onItemSelected(Item selectedItem) {
        BottomSheetDialogFragment bottomSheetDialogFragment = EpisodeBottomSheetDialogFragment.newInstance(selectedItem);
        bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }

    @Override
    public void showEpisodes(List<Item> episodes) {
        episodesBinding.episodeRecyclerView.setAdapter(new EpisodeAdapter(this, episodes));
    }

}

package com.akodiakson.magictavern.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.databinding.FragmentBottomSheetBinding;
import com.akodiakson.magictavern.model.Item;


public class EpisodeBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private Item selectedEpisode;

    public static BottomSheetDialogFragment newInstance(Item selectedItem) {
        EpisodeBottomSheetDialogFragment episodeBottomSheetDialogFragment = new EpisodeBottomSheetDialogFragment();
        episodeBottomSheetDialogFragment.setRetainInstance(true);
        episodeBottomSheetDialogFragment.setSelectedEpisode(selectedItem);
        return episodeBottomSheetDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBottomSheetBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, container, false);
        binding.setEpisode(selectedEpisode);
//
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
//        CoordinatorLayout.Behavior behavior = params.getBehavior();
//
//        if( behavior != null && behavior instanceof BottomSheetBehavior) {
////            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
//        }
        return binding.getRoot();
    }


    private void setSelectedEpisode(Item selectedEpisode) {
        this.selectedEpisode = selectedEpisode;
    }
}

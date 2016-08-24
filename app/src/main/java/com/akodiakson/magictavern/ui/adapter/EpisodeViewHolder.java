package com.akodiakson.magictavern.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.akodiakson.magictavern.databinding.ItemEpisodeBinding;


public class EpisodeViewHolder extends RecyclerView.ViewHolder {

    private ItemEpisodeBinding itemEpisodeBinding;

    public EpisodeViewHolder(View rowView){
        super(rowView);
        itemEpisodeBinding = DataBindingUtil.bind(rowView);
    }

    public ItemEpisodeBinding getItemEpisodeBinding() {
        return itemEpisodeBinding;
    }
}

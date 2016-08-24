package com.akodiakson.magictavern.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.databinding.ItemEpisodeBinding;
import com.akodiakson.magictavern.model.Item;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {

    private List<Item> episodes;

    private static final int ITEM_TYPE_EPISODE = 1;
    private Callbacks callbacks;

    public EpisodeAdapter(Callbacks callbacks, List<Item> episodes){
        this.callbacks = callbacks;
        this.episodes = new ArrayList<>(episodes);
    }

    @Override
    public int getItemViewType(int position) {
        return ITEM_TYPE_EPISODE;
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {
        final int adapterPosition = holder.getAdapterPosition();
        final Item episode = episodes.get(adapterPosition);
        ItemEpisodeBinding itemEpisodeBinding = holder.getItemEpisodeBinding();
        itemEpisodeBinding.setEpisode(episode);
        itemEpisodeBinding.executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callbacks.onItemSelected(episodes.get(adapterPosition));
            }
        });
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episode, parent, false);
        return new EpisodeViewHolder(rowView);
    }

    public interface Callbacks{
        void onItemSelected(Item selectedItem);
    }
}

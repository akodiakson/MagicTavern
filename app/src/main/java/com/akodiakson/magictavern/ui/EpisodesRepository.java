package com.akodiakson.magictavern.ui;

import com.akodiakson.magictavern.model.Item;

import java.util.List;

public interface EpisodesRepository {

    interface LoadEpisodesCallback {
        void onEpisodesLoaded(List<Item> episodes);
    }

    void loadEpisodes(LoadEpisodesCallback callback);
}

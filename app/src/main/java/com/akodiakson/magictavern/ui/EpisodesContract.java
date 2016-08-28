package com.akodiakson.magictavern.ui;

import com.akodiakson.magictavern.model.Item;

import java.util.List;

public interface EpisodesContract {

    interface View {
        void showEpisodes(List<Item> episodes);
    }

    interface UserActionsListener{
        void loadEpisodes();
    }
}

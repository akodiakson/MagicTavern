package com.akodiakson.magictavern.ui;

import com.akodiakson.magictavern.model.Item;

import java.util.List;

public class EpisodesPresenter implements EpisodesContract.UserActionsListener {

    private final EpisodesContract.View episodesView;
    private final EpisodesRepository episodesRepository;

    public EpisodesPresenter(EpisodesContract.View episodesView, EpisodesRepository episodesRepository) {
        this.episodesView = episodesView;
        this.episodesRepository = episodesRepository;
    }

    @Override
    public void loadEpisodes() {
        episodesRepository.loadEpisodes(new EpisodesRepository.LoadEpisodesCallback() {
            @Override
            public void onEpisodesLoaded(List<Item> episodes) {
                episodesView.showEpisodes(episodes);
            }
        });
    }
}

package com.akodiakson.magictavern.api;

import com.akodiakson.magictavern.model.MagicTavernRssResponse;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

public interface RssService {

    @GET
    Observable<MagicTavernRssResponse> retrieveFeed(@Url String url);
}

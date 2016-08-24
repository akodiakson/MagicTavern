package com.akodiakson.magictavern.api;

import com.akodiakson.magictavern.model.MagicTavernRssResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Observable;

public class MagicTavernRssFeedApi {

    //http://feeds.soundcloud.com/users/soundcloud:users:208311266/sounds.rss
    private static final String ENDPOINT_URL = "http://feeds.soundcloud.com/users/soundcloud:users:208311266/";
    private static final String FILE_NAME = "sounds.rss";

    private static MagicTavernRssFeedApi INSTANCE;

    public static MagicTavernRssFeedApi getInstance() {
        if(INSTANCE == null){
            INSTANCE = new MagicTavernRssFeedApi();
        }
        return INSTANCE;
    }

    public Observable<MagicTavernRssResponse> retrieveFeed() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        RssService serviceInterface = retrofit.create(RssService.class);
        Observable<MagicTavernRssResponse> call = serviceInterface.retrieveFeed(FILE_NAME);
        return call;
    }
}

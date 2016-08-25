package com.akodiakson.magictavern.api;

import android.util.Log;

import com.akodiakson.magictavern.model.Item;
import com.akodiakson.magictavern.model.MagicTavernRssResponse;
import com.akodiakson.magictavern.ui.EpisodesRepository;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MagicTavernRssFeedApi implements EpisodesRepository {

    //http://feeds.soundcloud.com/users/soundcloud:users:208311266/sounds.rss
    private static final String ENDPOINT_URL = "http://feeds.soundcloud.com/users/soundcloud:users:208311266/";
    private static final String FILE_NAME = "sounds.rss";

    private static MagicTavernRssFeedApi INSTANCE;

    private List<Item> cachedEpisodes;

    public static MagicTavernRssFeedApi getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MagicTavernRssFeedApi();
        }
        return INSTANCE;
    }

    @Override
    public void loadEpisodes(final LoadEpisodesCallback callback) {
        if(cachedEpisodes != null){
            callback.onEpisodesLoaded(cachedEpisodes);
            return;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        RssService serviceInterface = retrofit.create(RssService.class);
        Observable<MagicTavernRssResponse> call = serviceInterface.retrieveFeed(FILE_NAME);
        call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MagicTavernRssResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.i("subscriber onCompleted", "");
                        if (!isUnsubscribed()) {
                            unsubscribe();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("subscriber onError", e.getMessage(), e);
                        if (!isUnsubscribed()) {
                            unsubscribe();
                        }
                    }

                    @Override
                    public void onNext(MagicTavernRssResponse magicTavernRssResponse) {
                        Log.i("subscriber onNext", magicTavernRssResponse.toString());
                        List<Item> items = magicTavernRssResponse.getChannel().getItems();
                        cachedEpisodes = items;
                        callback.onEpisodesLoaded(items);
                        if (!isUnsubscribed()) {
                            unsubscribe();
                        }
                    }
                });
    }
}

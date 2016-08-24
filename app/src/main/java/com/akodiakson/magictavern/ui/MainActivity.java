package com.akodiakson.magictavern.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.api.MagicTavernRssFeedApi;
import com.akodiakson.magictavern.databinding.ActivityMainBinding;
import com.akodiakson.magictavern.model.Item;
import com.akodiakson.magictavern.model.MagicTavernRssResponse;
import com.akodiakson.magictavern.ui.adapter.EpisodeAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements EpisodeAdapter.Callbacks{

    private Subscription subscription;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.episodeRecyclerView.setLayoutManager(layoutManager);
        activityMainBinding.episodeRecyclerView.setAdapter(new EpisodeAdapter(this, new ArrayList<Item>()));
    }

    @Override
    protected void onResume() {
        super.onResume();

        subscription = getMagicTavernRssFeedObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MagicTavernRssResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.i("subscriber onCompleted", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("subscriber onError", e.getMessage(), e);
                    }

                    @Override
                    public void onNext(MagicTavernRssResponse magicTavernRssResponse) {
                        Log.i("subscriber onNext", magicTavernRssResponse.toString());
                        updateView(magicTavernRssResponse);
                    }
                });
    }

    private void updateView(MagicTavernRssResponse magicTavernRssResponse) {
        List<Item> newEpisodes = magicTavernRssResponse.getChannel().getItems();
        activityMainBinding.episodeRecyclerView.setAdapter(new EpisodeAdapter(this, newEpisodes));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(subscription != null  && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    private Observable<MagicTavernRssResponse> getMagicTavernRssFeedObservable() {
        return MagicTavernRssFeedApi.getInstance().retrieveFeed();
    }

    @Override
    public void onItemSelected(Item selectedItem) {
//        Intent intent = EpisodeDetailActivity.getIntent(this, selectedItem);
//        startActivity(intent);
        BottomSheetDialogFragment bottomSheetDialogFragment = EpisodeBottomSheetDialogFragment.newInstance(selectedItem);
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

    }
}

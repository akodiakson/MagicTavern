package com.akodiakson.magictavern.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        Fragment existingFragment = fragmentManager.findFragmentById(frameId);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(existingFragment != null){
            return;
        } else {
            transaction.add(frameId, fragment);
            transaction.commit();
        }
    }

}
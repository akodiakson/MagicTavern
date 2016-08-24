package com.akodiakson.magictavern.util;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.TextView;

import com.akodiakson.magictavern.model.Item;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SummaryBindingUtil {
    @BindingAdapter("summaryBinding")
    public static void summaryBinding(TextView textView, String summary) {
        String[] parts = summary.split("\n");
        textView.setText(parts[0]);
    }

    @BindingAdapter("dateAndLengthOfEpisodeBinding")
    public static void dateAndLengthOfEpisodeBinding(TextView textView, Item episode){
        String formattedPubDate = getFormattedPubDate(episode);
        String formattedDuration = getFormattedDuration(episode);
        textView.setText(formattedPubDate + " - " + formattedDuration);

    }

    private static String getFormattedDuration(Item episode) {
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss",  Locale.ENGLISH);
        try {
            Date dt = formatter.parse(episode.getDuration());
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            int hour = cal.get(Calendar.HOUR);
            int minute = cal.get(Calendar.MINUTE);
            StringBuilder builder = new StringBuilder();
            if(hour > 0){
                builder.append(hour).append("hour and ");
            }
            builder.append(minute).append(" minutes");
            return builder.toString();
        } catch (ParseException e) {
            Log.e("ParseException", e.getMessage(), e);
        }
        return null;
    }

    private static String getFormattedPubDate(Item episode) {
        SimpleDateFormat sourceDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
        try {
            Date parsedDate = sourceDateFormat.parse(episode.getPubDate());
            SimpleDateFormat destinationDateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
            return destinationDateFormat.format(parsedDate);
        } catch (ParseException e) {
            Log.e("dateAndLengthOfEp", e.getMessage(), e);
            e.printStackTrace();
            return null;
        }
    }
}
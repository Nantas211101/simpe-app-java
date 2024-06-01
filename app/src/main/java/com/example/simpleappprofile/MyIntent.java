package com.example.simpleappprofile;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;


public class MyIntent {

    public void createAlarm(String message, int hour, int minutes, Context context) {
        android.content.Intent intent = new android.content.Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
    //SetTimer
    public void startTimer(String message, int seconds, Context context) {
        android.content.Intent intent = new android.content.Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    //ShowAlarms
    public void showAlarms(Context context) {
        android.content.Intent intent = new android.content.Intent(AlarmClock.ACTION_SHOW_ALARMS);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    //AddCalendarEvent
    public void addEvent(String title, String location, long begin, long end, Context context) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public void playMedia(Context context) {
        String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + "dQw4w9WgXcQ"));

        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));

        try {
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
        }
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
        //playMedia(Uri.parse(url)); khum choi dc playMedia vi qua dan
    }


    public void openWeb(Context context) {
        Uri webpage = Uri.parse(context.getString(R.string.default_web_url));
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        intent.setPackage("com.android.chrome");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            // Chrome is not installed; fall back to the default browser.
            intent.setPackage(null);
            context.startActivity(intent);
        }
    }

    public void dialPhoneNumber(String phoneNumber, Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}

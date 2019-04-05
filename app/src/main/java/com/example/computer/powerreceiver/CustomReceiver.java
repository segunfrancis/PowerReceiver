package com.example.computer.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private static final String RANDOM_NUMBER = "random number";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        int randomNumber = intent.getIntExtra(RANDOM_NUMBER, 0);
        int randomNumberSquared = randomNumber * randomNumber;

        if (intentAction != null) {
            String toastMessage = context.getString(R.string.unknown_action);
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getString(R.string.power_connected);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = context.getString(R.string.power_disconnected);
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    toastMessage = context.getString(R.string.headset_connected);
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = context.getString(R.string.custom_broadcast) + "\n" + randomNumberSquared;
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.workmanager;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        OneTimeWorkRequest testWorkRequest = new OneTimeWorkRequest.Builder(TestWorker.class).build();
        WorkManager.getInstance(context).enqueueUniqueWork("Probando", ExistingWorkPolicy.REPLACE, testWorkRequest);
    }
}

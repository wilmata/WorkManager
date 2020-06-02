package com.example.workmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

public class TestWorker extends Worker {


    public TestWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }


    @NonNull
    @Override
    public Result doWork() {
        try {

            Thread.sleep(1000);
            Log.d("PRUEBA", "Probando");

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        OneTimeWorkRequest refreshWorkRequest = new OneTimeWorkRequest.Builder(TestWorker.class).build();
        WorkManager.getInstance(getApplicationContext()).enqueueUniqueWork("Probando", ExistingWorkPolicy.REPLACE, refreshWorkRequest);

        return  Result.success();
    }
}
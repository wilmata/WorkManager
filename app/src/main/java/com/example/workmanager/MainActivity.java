package com.example.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.graphics.BlendMode;
import android.nfc.Tag;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        OneTimeWorkRequest testWorkRequest = new OneTimeWorkRequest.Builder(TestWorker.class).build();
        WorkManager.getInstance(this).enqueueUniqueWork("Probando", ExistingWorkPolicy.REPLACE,testWorkRequest);
    }
}
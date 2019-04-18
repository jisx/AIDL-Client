package com.example.messageclientdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.messageservicedemo.IRemoteService;

public class MainActivity extends AppCompatActivity {


    IRemoteService mIRemoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("android.intent.action.remote.service");
        intent.setPackage("com.example.messageservicedemo");//包名很重要
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    public void buttonClick(View view) throws RemoteException {
        Toast.makeText(this, mIRemoteService.message("xasd"), Toast.LENGTH_SHORT).show();
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            mIRemoteService = IRemoteService.Stub.asInterface(service);
        }

        public void onServiceDisconnected(ComponentName className) {
            mIRemoteService = null;
        }
    };
}

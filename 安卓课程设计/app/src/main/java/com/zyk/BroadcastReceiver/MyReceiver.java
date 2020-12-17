package com.zyk.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       Toast.makeText(context,"静态广播:"+intent.getAction()+":"+intent.getStringExtra("tv"),
               Toast.LENGTH_LONG).show();
        System.out.println(intent.getStringExtra("tv"));
    }

}

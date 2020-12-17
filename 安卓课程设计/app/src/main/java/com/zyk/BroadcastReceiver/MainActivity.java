package com.zyk.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver = null;
    private EditText editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.tv);
    }

    public void zhuce(View view) {
        if (myReceiver == null){
            myReceiver = new MyReceiver();
            IntentFilter filter = new IntentFilter("");
            //注册
            registerReceiver(myReceiver,filter);
            Toast.makeText(this,"已成功注册广播接收器", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"已拥有广播接收器", Toast.LENGTH_SHORT).show();
        }

    }

    public void zhuxiao(View view) {
        if (myReceiver != null){
            unregisterReceiver(myReceiver);
            myReceiver = null;
            Toast.makeText(this,"已成功注销接广播收器", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"没有注册广播接收器", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSend(View view) {
        String str = editText.getText().toString();
        if (!"".equals(str) && str != null){
            if (myReceiver != null){
                Intent intent = new Intent("");
                intent.putExtra("tv",editText.getText().toString().trim());
                sendBroadcast(intent);
                Toast.makeText(this,"发送", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"请先注册!", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(MainActivity.this,"消息不能为空!", Toast.LENGTH_SHORT).show();
        }
    }
}

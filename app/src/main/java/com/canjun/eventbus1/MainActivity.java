package com.canjun.eventbus1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.canjun.eventbus.EventBus;
import com.canjun.eventbus1.apt.EventBusIndex;
import com.canjun.eventbus1.msg.MessageEvent;
import com.canjun.eventbus_anntation.Subscribe;
import com.canjun.eventbus_anntation.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        EventBus.getDefault().addIndex(new EventBusIndex());
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
//        EventBus.getDefault().unregister(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleMessageEvent(MessageEvent msg){
        Toast.makeText(MainActivity.this,msg.text,0).show();
    }
}

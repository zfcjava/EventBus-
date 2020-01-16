package com.canjun.eventbus1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.canjun.eventbus.EventBus;
import com.canjun.eventbus1.msg.MessageEvent;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageEvent msg = new MessageEvent();
                msg.text="from Second";
                EventBus.getDefault().post(msg);
            }
        });
    }
}

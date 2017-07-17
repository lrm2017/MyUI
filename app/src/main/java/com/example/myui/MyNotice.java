package com.example.myui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MyNotice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notice);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_notice);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    public static void actionStart(Context context, String data1) {
        Intent intent = new Intent(context, MyNotice.class);
        intent.putExtra("param1", data1);
        context.startActivity(intent);
    }
}

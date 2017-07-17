package com.example.myui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MyCredit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_credit);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_credit);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, MyCredit.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}

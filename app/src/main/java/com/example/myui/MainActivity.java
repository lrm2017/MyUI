package com.example.myui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<IdentityMessage> identityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_title);//
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        /*ActionBar actionBar  = getSupportActionBar();
        if( actionBar != null ) {  //将系统默认的文本隐藏
            actionBar.hide();
        }*/
        initIdentity();  //初始化列表的信息
        IdentityAdapter adapter = new IdentityAdapter(MainActivity.this, R.layout.identity_item,
                identityList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IdentityMessage identityMessages = identityList.get(position);
                Toast.makeText(MainActivity.this, "你点到了" + identityMessages.getName(),
                        Toast.LENGTH_SHORT).show();
                if ("我的评分".equals(identityMessages.getName())) {
                    MyCredit.actionStart(MainActivity.this, "data1", "data2");
                }
                else if ("我的关注".equals(identityMessages.getName())) {
                    MyNotice.actionStart(MainActivity.this, "data1");
                }
            }
        });
    }

    private void initIdentity() {
        IdentityMessage myNotice = new IdentityMessage("我关注的", R.drawable.mylike);
        identityList.add(myNotice);
        IdentityMessage NoticeMe = new IdentityMessage("关注我的", R.drawable.likeme);
        identityList.add(NoticeMe);
        IdentityMessage MyMessages = new IdentityMessage("我的信息", R.drawable.mymessage);
        identityList.add(MyMessages);
        IdentityMessage MyActivity = new IdentityMessage("我的活动", R.drawable.myactivity);
        identityList.add(MyActivity);
        IdentityMessage MyCredit = new IdentityMessage("我的评分", R.drawable.myscore);
        identityList.add(MyCredit);
    }
}

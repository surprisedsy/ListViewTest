package com.example.jeh80.listviewtest;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshActivity();
        listViewIndex();
    }

    private void listViewIndex()
    {
        ListView listView;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.apple), "사과", "유통기한++");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pork), "삼겹살", "유통기한 스티커 확인");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.spinach), "시금치", "유통기한++");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrawable = item.getIcon();


            }
        });
    }

    private void refreshActivity()
    {
        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}

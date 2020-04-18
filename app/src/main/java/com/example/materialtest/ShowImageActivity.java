package com.example.materialtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShowImageActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private SwipeRefreshLayout swipeRefresh;

    private Picture[] pictures = {new Picture("图片1", R.drawable.picture_1_b),
            new Picture("图片2",R.drawable.picture_2_b),
            new Picture("图片3",R.drawable.picture_3_b),
            new Picture("图片4",R.drawable.picture_4_b),
            new Picture("图片5",R.drawable.picture_5_b),
            new Picture("图片6",R.drawable.picture_6_b),
            new Picture("图片7",R.drawable.picture_7_b),
            new Picture("图片8",R.drawable.picture_8_b),
            new Picture("图片9",R.drawable.picture_9_b),
            new Picture("图片10",R.drawable.picture_10_b),
            new Picture("图片11",R.drawable.picture_11_b),
            new Picture("图片12",R.drawable.picture_12_b),
            new Picture("图片12",R.drawable.picture_13_b),
            new Picture("图片12",R.drawable.picture_14_b)
    };

    private List<Picture> pictureList = new ArrayList<>();

    private PictureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        ActivityCollector.addActivity(this); // 将正在创建的活动添加到活动管理器中

        initPicture();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PictureAdapter(pictureList);
        recyclerView.setAdapter(adapter);


        // RecyclerView下拉刷新的逻辑处理
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {  // 下拉监听器
            @Override
            public void onRefresh() {
                refreshFruits();  // 本地刷新
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowImageActivity.this, "下拉可对图库进行刷新", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void refreshFruits(){
        new Thread(new Runnable() {  // 开启一个线程
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);  // 线程沉睡2秒 （本地刷新太快，就看不出效果，所以沉睡下线程）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {  // 将线程切回主线程
                    @Override
                    public void run() {
                        initPicture();   // 重新生成数据
                        adapter.notifyDataSetChanged();  // 通知数据发生了变化
                        swipeRefresh.setRefreshing(false);  // 刷新事件结束，并隐藏刷新进度条
                    }
                });
            }
        }).start();
    }

    private void initPicture(){
        pictureList.clear();
//        for(int i = 0; i < 50 ; i++){
//            Random random = new Random();
//            int index = random.nextInt(pictures.length);
//            pictureList.add(pictures[index]);
//        }
        for(int i = 0; i < 25 ; i++){
            Random random = new Random();
            int index = random.nextInt(pictures.length);
            pictureList.add(pictures[index]);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityCollector.removeActivity(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back_image:
                finish();
        }
        return true;
    }
}

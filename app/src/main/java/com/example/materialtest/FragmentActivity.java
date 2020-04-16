package com.example.materialtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // 从SharedPreferences文件中读取缓存数据，如果不为null说明之前已经请求过天气数据了，
        // 那么就没有必要让用户再次选择城市，而是直接跳转WeatherDataActivity。
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather", null) != null){
            Intent intent = new Intent(this, WeatherDataActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

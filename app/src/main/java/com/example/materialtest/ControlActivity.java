package com.example.materialtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://192.168.43.126:8081");
        setBuiltInZoomControls(true);//设置内置的缩放控件。

        ActivityCollector.addActivity(this); // 将正在创建的活动添加到活动管理器中

        Button paizhao = (Button)findViewById(R.id.back2);
        paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ControlActivity.this, "你点击了拍照按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setBuiltInZoomControls(boolean b) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}

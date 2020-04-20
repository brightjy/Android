package com.tj.day05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editUrl;
    private Button btnGo, btnBack;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.editUrl);
        btnGo = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        webView = findViewById(R.id.webView);
        // 손가락 줌,아웃 기능 추가
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setBuiltInZoomControls(true);
        // 자바스크립트연동
        webView.getSettings().setJavaScriptEnabled(true);
        // 크롬에서 되는 건 다 되게 해라
        webView.setWebChromeClient(new WebChromeClient());
        // webView에 해당 url 접속
        /*webView.loadUrl("http://192.168.20.97:8181/");*/
        webView.loadUrl("https://www.naver.com");
        btnGo.setOnClickListener(goListener);// btnGo 이벤트
        editUrl.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // keyCode가 enter key이면, goListener의 onClick실행
                if(keyCode==KeyEvent.KEYCODE_ENTER){
                    goListener.onClick(btnGo);
                }
                return false;
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
    }
    private View.OnClickListener goListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            webView.loadUrl(editUrl.getText().toString().trim());
        }
    };
}

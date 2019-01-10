package com.example.tae.googleassignment;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText textInput;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding views
        webView = findViewById(R.id.webView);
        textInput = findViewById(R.id.textInput);


    }

    public void onSearchClick(View view) {

        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        String text = textInput.getText().toString();
        intent.putExtra(SearchManager.QUERY, text);
        startActivity(intent);
            }

    }


package com.example.andym.psicotecnicostropa.tropa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.andym.psicotecnicostropa.R;

public class main_tropaymarineria extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_publicidad);
        WebView web = (WebView)findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://www.tropaymarineria.es/");


    }

}

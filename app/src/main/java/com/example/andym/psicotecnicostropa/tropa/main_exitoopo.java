package com.example.andym.psicotecnicostropa.tropa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.andym.psicotecnicostropa.R;

public class main_exitoopo extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_publicidad);
        WebView web = (WebView)findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.exitooposiciones.com/landing.html");



    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(main_exitoopo.this, main_examen.class));
        overridePendingTransition(R.anim.transpain, R.anim.transpaout);
        finish();
    }
}

package com.example.andym.psicotecnicostropa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;


public class main_splash extends Activity {

    //String version = "5.1.4";
    String version = String.valueOf((BuildConfig.VERSION_NAME));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_splash);

        TextView mensaje = (TextView)findViewById(R.id.mensaje);

        RelativeLayout padre = (RelativeLayout)findViewById(R.id.padre);
        ImageView imagen = (ImageView)findViewById(R.id.imageView1);
        Calendar c1 = new GregorianCalendar();

        int dia = c1.get(Calendar.DAY_OF_MONTH);
        int mes = c1.get(Calendar.MONTH)+1;


        if( (mes ==11 || mes ==12) || (mes ==1 && dia <=7)){
            imagen.setImageResource(R.drawable.splashtrialnavideno);
            padre.setBackgroundResource(R.color.rojonavidad);
            mensaje.setText("Psicotécnicos Tropa\nte desea unas felices fiestas");
        }else{
            imagen.setImageResource(R.drawable.splash);
        }

        mostrar();
    }

    private void mostrar() {

        showAlertDialog();

    }


    @SuppressWarnings("deprecation")
    public void showAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(main_splash.this).create();
        alertDialog.setTitle(getString(R.string.atencion));
        alertDialog.setMessage(getString(R.string.versiontrial));
        alertDialog.setCancelable(false);
        alertDialog.setIcon(getResources().getDrawable(R.drawable.iexc));
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                        startActivity(new Intent(main_splash.this, main_principal.class));
                        overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                        finish();
                    }
                }).start();
            }
        });

        alertDialog.show();
    }
}

package com.example.andym.psicotecnicostropa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andym.psicotecnicostropa.tropa.main_principal;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.example.andym.psicotecnicostropa.tropa.academia.main_estudio_academia_sub.readStream;


public class main_splash extends Activity {

    String version = String.valueOf((BuildConfig.VERSION_NAME));
    TextView textoServi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_splash);

        textoServi = (TextView)findViewById(R.id.textoServi);

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
        try {

            Thread leerarchivo = new Thread() {
                public void run() {
                    try {
                        String contents;
                        URLConnection conn = new URL("http://s593975491.mialojamiento.es/APPpsicotecnicostropa(1)/textoServiTrial.html").openConnection();
                        InputStream in = conn.getInputStream();
                        contents = readStream(in);
                        textoServi.setText(Html.fromHtml(contents));

                    } catch (Exception e) {

                    }
                    /*try {
                        Thread.sleep(3000);
                        startActivity(new Intent(main_splash.this, main_principal.class));
                        overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                        finish();
                    } catch (InterruptedException e) {
                    }*/
                }
            };
            leerarchivo.start();
        } catch (Exception e) {

        }
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
                            Thread.sleep(3000);
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

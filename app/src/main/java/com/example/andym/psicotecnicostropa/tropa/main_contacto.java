package com.example.andym.psicotecnicostropa.tropa;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andym.psicotecnicostropa.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by xe63008 on 26/04/2017.
 */

public class main_contacto extends Activity {
    String Easunto;
    String Emensaje = "";
    EditText mensaje;
    Button btnEnviarEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contacto);

        /*LinearLayout padre = (LinearLayout)findViewById(R.id.lytMain);
        Calendar c1 = new GregorianCalendar();
        int dia = c1.get(Calendar.DAY_OF_MONTH);
        int mes = c1.get(Calendar.MONTH)+1;
        if( (mes ==11 || mes ==12) || (mes ==1 && dia <=7)){
            padre.setBackgroundResource(R.color.rojonavidad);
        }else{

        }*/

        final String[] items = {getString(R.string.asunto1), getString(R.string.asunto2), getString(R.string.asunto3), getString(R.string.asunto4), getString(R.string.asunto5)};

        TextView tmensaje;
        TextView tasunto;
        Spinner asunto;

        mensaje = (EditText) findViewById(R.id.mensaje);
        tmensaje = (TextView) findViewById(R.id.tmensaje);
        tasunto = (TextView) findViewById(R.id.tasunto);
        asunto = (Spinner) findViewById(R.id.asunto);
        btnEnviarEmail = (Button) findViewById(R.id.btnEnviarEmail);
        tmensaje.setText(getString(R.string.Cmensaje));
        tasunto.setText(getString(R.string.Casunto));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                main_contacto.this,
                android.R.layout.simple_spinner_dropdown_item, items);
        asunto.setAdapter(adapter);
        // Spinner on item click listener
        asunto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                Easunto = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        // Crear adView.
        AdView adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-3897421105469965/7146736136");
        adView.setAdSize(AdSize.BANNER);
        // Buscar LinearLayout suponiendo que se le ha asignado
        // el atributo android:id="@+id/mainLayout".
        LinearLayout layout = (LinearLayout)findViewById(R.id.lytMain);
        // Añadirle adView.
        layout.addView(adView);
        // Iniciar una solicitud genérica.
        AdRequest adRequest = new AdRequest.Builder().build();
        // Cargar adView con la solicitud de anuncio.
        adView.loadAd(adRequest);

    }

    public void onClick(View v) {
        // Reemplazamos el email por algun otro real
        String[] to = {"psicotecnicostropatrial@gmail.com"};
        String[] cc = {""};
        Emensaje = mensaje.getText().toString();
        if (Emensaje.equals("")) {
            Toast t = Toast.makeText(this,
                    String.format(getString(R.string.devesesc)),
                    Toast.LENGTH_LONG);
            t.show();
        } else {
            enviar(to, cc, Easunto, Emensaje);
            finish();
        }

    }

    private void enviar(String[] to, String[] cc, String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        // String[] to = direccionesEmail;
        // String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        // emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}

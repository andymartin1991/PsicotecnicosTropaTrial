package com.example.andym.psicotecnicostropa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

import static java.lang.String.valueOf;

public class main_principal extends Activity {

    int contadorinten = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_principal);

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

        final Button fatiga, aleatorio, trucos, contacta, examen, estudio, foro, facebook, twiter, instagran, informacion, evolucion, calcular, ayuda, pruebafisica, compartir, votar;

        fatiga = (Button) findViewById(R.id.button1);
        aleatorio = (Button) findViewById(R.id.button2);
        trucos = (Button) findViewById(R.id.button3);
        contacta = (Button) findViewById(R.id.button4);
        examen = (Button) findViewById(R.id.button5);
        estudio = (Button) findViewById(R.id.button15);
        foro = (Button) findViewById(R.id.button11);
        facebook = (Button) findViewById(R.id.button12);
        twiter = (Button) findViewById(R.id.button13);
        instagran = (Button) findViewById(R.id.button14);
        informacion = (Button) findViewById(R.id.button21);
        evolucion = (Button) findViewById(R.id.button22);
        calcular = (Button) findViewById(R.id.button23);
        ayuda = (Button) findViewById(R.id.button24);
        pruebafisica = (Button) findViewById(R.id.button25);
        compartir = (Button) findViewById(R.id.button31);
        votar = (Button) findViewById(R.id.button32);

        final boolean[] entra = {true};
        estudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    estudio.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            startActivity(new Intent(main_principal.this, main_optTipo.class));
                            overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                            entra[0] = true;
                        }
                    }).start();

                }
            }
        });

        aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (entra[0] == true) {
                    try {
                        String state = Environment.getExternalStorageState();

                        File ruta_sd;
                        if (Environment.MEDIA_MOUNTED.equals(state)) {
                            // We can read and write the media
                            ruta_sd = getExternalFilesDir(null);
                        } else {
                            // Load another directory, probably local memory
                            ruta_sd = getFilesDir();
                        }
                        //File ruta_sd = getExternalFilesDir(null);
                        File f = new File(ruta_sd.getAbsolutePath(), "intentoaleatorio");
                        if (!f.exists()) {
                            OutputStreamWriter fout =
                                    new OutputStreamWriter(
                                            new FileOutputStream(f));
                            fout.write("10");
                            fout.close();
                            System.out.println(ruta_sd);
                            System.out.println(f);
                        }
                    } catch (Exception ex) {
                        Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                    }
                    FileReader fr = null;
                    try {
                        File ruta_sd;
                        String state = Environment.getExternalStorageState();
                        if (Environment.MEDIA_MOUNTED.equals(state)) {
                            // We can read and write the media
                            ruta_sd = getExternalFilesDir(null);
                        } else {
                            // Load another directory, probably local memory
                            ruta_sd = getFilesDir();
                        }
                        File f = new File(ruta_sd.getAbsolutePath(), "intentoaleatorio");
                        fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        while ((linea = valueOf(br.readLine().toString())) != null)
                            if (!linea.isEmpty()) {
                                contadorinten = (Integer.parseInt(linea)-1);
                                break;
                            }
                    } catch (Exception y) {
                        y.printStackTrace();
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if(contadorinten!=0) {
                        try {
                            String state = Environment.getExternalStorageState();

                            File ruta_sd;
                            if (Environment.MEDIA_MOUNTED.equals(state)) {
                                // We can read and write the media
                                ruta_sd = getExternalFilesDir(null);
                            } else {
                                // Load another directory, probably local memory
                                ruta_sd = getFilesDir();
                            }
                            //File ruta_sd = getExternalFilesDir(null);
                            File f = new File(ruta_sd.getAbsolutePath(), "intentoaleatorio");

                            OutputStreamWriter fout =
                                    new OutputStreamWriter(
                                            new FileOutputStream(f));
                            fout.write(valueOf(contadorinten));
                            fout.close();
                            System.out.println(ruta_sd);
                            System.out.println(f);

                        } catch (Exception ex) {
                            Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                        }
                    }


                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    aleatorio.startAnimation(animation);
                    if(contadorinten != 0){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Te quedan " + (contadorinten) + " intentos", Toast.LENGTH_SHORT);
                        toast1.show();
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                }

                                startActivity(new Intent(main_principal.this, main_preguntasAleatorio.class));
                                overridePendingTransition(R.anim.transpain, R.anim.transpaout);

                            }
                        }).start();
                    }else{
                        trial();
                    }
                    entra[0] = true;

                }
            }
        });

        trucos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Próximamente", Toast.LENGTH_SHORT);
                    toast1.show();
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    trucos.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        contacta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    contacta.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            startActivity(new Intent(main_principal.this, main_contacto.class));
                            overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        examen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    try {
                        String state = Environment.getExternalStorageState();

                        File ruta_sd;
                        if (Environment.MEDIA_MOUNTED.equals(state)) {
                            // We can read and write the media
                            ruta_sd = getExternalFilesDir(null);
                        } else {
                            // Load another directory, probably local memory
                            ruta_sd = getFilesDir();
                        }
                        //File ruta_sd = getExternalFilesDir(null);
                        File f = new File(ruta_sd.getAbsolutePath(), "intentoexamen");
                        if (!f.exists()) {
                            OutputStreamWriter fout =
                                    new OutputStreamWriter(
                                            new FileOutputStream(f));
                            fout.write("10");
                            fout.close();
                            System.out.println(ruta_sd);
                            System.out.println(f);
                        }
                    } catch (Exception ex) {
                        Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                    }
                    FileReader fr = null;
                    try {
                        File ruta_sd;
                        String state = Environment.getExternalStorageState();
                        if (Environment.MEDIA_MOUNTED.equals(state)) {
                            // We can read and write the media
                            ruta_sd = getExternalFilesDir(null);
                        } else {
                            // Load another directory, probably local memory
                            ruta_sd = getFilesDir();
                        }
                        File f = new File(ruta_sd.getAbsolutePath(), "intentoexamen");
                        fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        while ((linea = valueOf(br.readLine().toString())) != null)
                            if (!linea.isEmpty()) {
                                contadorinten = (Integer.parseInt(linea)-1);
                                break;
                            }
                    } catch (Exception y) {
                        y.printStackTrace();
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if(contadorinten!=0) {
                        try {
                            String state = Environment.getExternalStorageState();

                            File ruta_sd;
                            if (Environment.MEDIA_MOUNTED.equals(state)) {
                                // We can read and write the media
                                ruta_sd = getExternalFilesDir(null);
                            } else {
                                // Load another directory, probably local memory
                                ruta_sd = getFilesDir();
                            }
                            //File ruta_sd = getExternalFilesDir(null);
                            File f = new File(ruta_sd.getAbsolutePath(), "intentoexamen");

                            OutputStreamWriter fout =
                                    new OutputStreamWriter(
                                            new FileOutputStream(f));
                            fout.write(valueOf(contadorinten));
                            fout.close();
                            System.out.println(ruta_sd);
                            System.out.println(f);

                        } catch (Exception ex) {
                            Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                        }
                    }


                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    examen.startAnimation(animation);
                    if(contadorinten != 0){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Te quedan " + (contadorinten) + " intentos", Toast.LENGTH_SHORT);
                        toast1.show();
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                }

                                startActivity(new Intent(main_principal.this, main_examen.class));
                                overridePendingTransition(R.anim.transpain, R.anim.transpaout);

                            }
                        }).start();
                    }else{
                        trial();
                    }
                    entra[0] = true;

                }
            }
        });

        fatiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    try {
                        String state = Environment.getExternalStorageState();

                        File ruta_sd;
                        if (Environment.MEDIA_MOUNTED.equals(state)) {
                            // We can read and write the media
                            ruta_sd = getExternalFilesDir(null);
                        } else {
                            // Load another directory, probably local memory
                            ruta_sd = getFilesDir();
                        }
                        //File ruta_sd = getExternalFilesDir(null);
                        File f = new File(ruta_sd.getAbsolutePath(), "intentofatiga");
                        if (!f.exists()) {
                            OutputStreamWriter fout =
                                    new OutputStreamWriter(
                                            new FileOutputStream(f));
                            fout.write("10");
                            fout.close();
                            System.out.println(ruta_sd);
                            System.out.println(f);
                        }
                    } catch (Exception ex) {
                        Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                    }
                    FileReader fr = null;
                    try {
                        File ruta_sd;
                        String state = Environment.getExternalStorageState();
                        if (Environment.MEDIA_MOUNTED.equals(state)) {
                            // We can read and write the media
                            ruta_sd = getExternalFilesDir(null);
                        } else {
                            // Load another directory, probably local memory
                            ruta_sd = getFilesDir();
                        }
                        File f = new File(ruta_sd.getAbsolutePath(), "intentofatiga");
                        fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        while ((linea = valueOf(br.readLine().toString())) != null)
                            if (!linea.isEmpty()) {
                                contadorinten = (Integer.parseInt(linea)-1);
                                break;
                            }
                    } catch (Exception y) {
                        y.printStackTrace();
                    } finally {
                        try {
                            if (null != fr) {
                                fr.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if(contadorinten!=0) {
                        try {
                            String state = Environment.getExternalStorageState();

                            File ruta_sd;
                            if (Environment.MEDIA_MOUNTED.equals(state)) {
                                // We can read and write the media
                                ruta_sd = getExternalFilesDir(null);
                            } else {
                                // Load another directory, probably local memory
                                ruta_sd = getFilesDir();
                            }
                            //File ruta_sd = getExternalFilesDir(null);
                            File f = new File(ruta_sd.getAbsolutePath(), "intentofatiga");

                            OutputStreamWriter fout =
                                    new OutputStreamWriter(
                                            new FileOutputStream(f));
                            fout.write(valueOf(contadorinten));
                            fout.close();
                            System.out.println(ruta_sd);
                            System.out.println(f);

                        } catch (Exception ex) {
                            Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                        }
                    }


                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    fatiga.startAnimation(animation);
                    if(contadorinten != 0){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Te quedan " + (contadorinten) + " intentos", Toast.LENGTH_SHORT);
                        toast1.show();
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                }

                                startActivity(new Intent(main_principal.this, main_optTipoFatiga.class));
                                overridePendingTransition(R.anim.transpain, R.anim.transpaout);

                            }
                        }).start();
                    }else{
                        trial();
                    }
                    entra[0] = true;

                }
            }
        });

        foro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    foro.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://www.fuerzasarmadas.eu/"));
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            startActivity(intent);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    facebook.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.facebook.com/psicotecnicos.tropa"));
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            startActivity(intent);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        twiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    twiter.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://twitter.com/psicostropa"));
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            startActivity(intent);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        instagran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    instagran.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://instagram.com/psicotecnicostropa/"));
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            startActivity(intent);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    informacion.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            startActivity(new Intent(main_principal.this, main_info.class));
                            overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        evolucion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    evolucion.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            startActivity(new Intent(main_principal.this, main_evolucion.class));
                            overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    calcular.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            startActivity(new Intent(main_principal.this, main_calculabaremo.class));
                            overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    trial();
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    ayuda.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        pruebafisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    pruebafisica.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            startActivity(new Intent(main_principal.this, main_fisica.class));
                            overridePendingTransition(R.anim.transpain, R.anim.transpaout);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    compartir.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            Intent intentCompartir = new Intent(Intent.ACTION_SEND);
                            intentCompartir.setType("text/plain");
                            intentCompartir.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                            intentCompartir.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.naroh.tropaPsicotecnicoTrial");
                            intentCompartir.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(Intent.createChooser(intentCompartir, getString(R.string.compartiren)));
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });

        votar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (entra[0] == true) {
                    entra[0] = false;
                    Animation animation = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotar);
                    votar.startAnimation(animation);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                            }
                            Intent intent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://play.google.com/store/apps/details?id=com.naroh.tropaPsicotecnicoTrial"));
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                            startActivity(intent);
                            entra[0] = true;
                        }
                    }).start();
                }
            }
        });
    }

    private void trial() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setIcon(getResources().getDrawable(R.drawable.iexc));
        dialogo1.setTitle(getString(R.string.atencion));
        dialogo1.setMessage(getString(R.string.trial));
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(getString(R.string.comprar),

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        final Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=com.naroh.tropaPsicotecnicoOficial"));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                        startActivity(intent);
                    }
                });
        dialogo1.setNegativeButton(getString(R.string.ahorano),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
        dialogo1.show();
    }
}
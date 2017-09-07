package com.example.leonel.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_actividad);

        // Capturamos los objetos gráficos que vamos a usar
        TextView text = (TextView) findViewById(R.id.textView1);
        Button button = (Button) findViewById(R.id.boton);

        // Agregamos al textView un texto
        text.setText(R.string.cadena1);

        // Cambiamos el texto al botón
        button.setText(R.string.salir);

        // Evento onclick del botón, cuando se pulse, cerramos la actividad
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
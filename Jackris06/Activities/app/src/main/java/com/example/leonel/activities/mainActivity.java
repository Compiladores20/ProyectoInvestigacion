package com.example.leonel.activities;

/**
 * Created by LEONEL on 6/9/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class mainActivity extends Activity {

    protected static final int REQUEST_CODE = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Capturamos los objetos gráficos que vamos a usar
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        // Fijamos un evento onclick para el button1, cada vez que
        // lo pulsemos se llamará a este método (que abrirá una actividad)
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity.this, Activity1.class);
                startActivity(intent);
            }
        });

        //button2 pasará parámetros a otra actividad, y los devolverá
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity.this, ParametrosActivity.class);

                // damos valor al parámetro a pasar
                intent.putExtra("param1", "valor del parámetro 1 (viene de mainActivity)");
            /*
             * Inicia una actividad que devolverá un resultado cuando
             * haya terminado. Cuando la actividad termina, se llama al método
             * onActivityResult() con el requestCode dado.
             * El uso de un requestCode negativo es lo mismo que llamar a
             * startActivity(intent) (la actividad no se iniciará como una
             * sub-actividad).
             */
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    /*
     * Éste método se llama cuando la actividad que iniciamos con un startActivityForResult
     * finaliza, dandi el REQUEST_CODE con el que llamó, el resultCode se devuelve, junto con
     * algunos datos adicionales, el resultCode será RESULT_CANCELED si la actividad devuelve
     * eso explícitamente, si no devuelve ningún resultado o si la operación finalizó de forma inesperada.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            // cogemos el valor devuelto por la otra actividad
            String result = data.getStringExtra("result");
            // enseñamos al usuario el resultado
            Toast.makeText(this, "ParametrosActivity devolvió: " + result, Toast.LENGTH_LONG).show();
        }
    }
}
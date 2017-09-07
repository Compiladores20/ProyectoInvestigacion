package com.example.leonel.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ParametrosActivity extends Activity {
    private static final int OK_RESULT_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_actividad);

        // Capturamos los objetos gráficos que vamos a usar
        TextView text = (TextView) findViewById(R.id.textView1);
        Button button = (Button) findViewById(R.id.boton);
        TextView params = (TextView) findViewById(R.id.params);

        text.setText(R.string.cadena2);

        button.setText(R.string.salir);

        //Al pulsar el botón cerramos la ventana y volveremos a la anterior
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //Cierra la actividad y la saca de la pila
                returnParams();
            }
        });

        // Mostramos los parámetros recibidos de la actividad mainActivity
        Bundle reicieveParams = getIntent().getExtras();
        params.setText(reicieveParams.getString("param1"));
    }

    protected void returnParams() {
        Intent intent = new Intent();
        intent.putExtra("result", "'Valor devuelto por ParametrosActivity'");
        setResult(OK_RESULT_CODE, intent);
        finish();
    }
}
package com.example.leonel.menuactivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int _difficulty;
    TextView _difficult;
    Button btn_facil,btn_medio,btn_dificil;
    Button btn_comojugar, btn_salir;
    String comojugar = "Juego 1: Consiste en adivinar las expresiones regulares dada una cantidad de lenguajes producidos." +
            "La dificultad puede variar entre fácil, medio o difícil e implicará expresiones regulares más complejas.\n\n"+
            "Juego 2: Juego de referencia que ejemplifica los distintos lenguajes producidos dada una expresión.\n\n" +
            "Juego 3: Ejercicio que consiste en clasificar las expresiones regulares entre verdaderas y falsas dependiendo de la situación.\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _difficulty = 1;

        this._difficult = (TextView) findViewById(R.id.Difficulty);
        btn_facil = (Button) findViewById(R.id.button5);
        btn_facil.setOnClickListener(this);
        btn_medio = (Button) findViewById(R.id.button6);
        btn_medio.setOnClickListener(this);
        btn_dificil = (Button) findViewById(R.id.button7);
        btn_dificil.setOnClickListener(this);
        btn_comojugar  = (Button) findViewById(R.id.button11);
        btn_comojugar.setOnClickListener(this);
        btn_salir = (Button) findViewById(R.id.button12);
        btn_salir.setOnClickListener(this);
    }


    public void onClick (View v){
            switch(v.getId()){
                case R.id.button5:
                    this._difficulty = 1;
                    this._difficult.setText("Fácil");
                    break;
                case R.id.button6:
                    this._difficulty = 2;
                    this._difficult.setText("Medio");
                    break;
                case R.id.button7:
                    this._difficulty = 3;
                    this._difficult.setText("Dificil");
                    break;
                case R.id.button11:
                    Toast.makeText(MainActivity.this, this.comojugar, Toast.LENGTH_LONG).show();
                    break;
                case R.id.button12:
                    finish();
                    System.exit(0);
                    break;
            }
    }

    public void Game_1(View view) {
        Intent i = new Intent(this, Juego1.class );
        i.putExtra("Dificultad", this._difficulty);
        startActivity(i);
    }

    public void Juego2(View view){
        Intent i = new Intent(this,Juego_2.class);
        startActivity(i);
    }

    public void Juego3(View view){
        Intent i = new Intent(this, Juego3.class);
        i.putExtra("Dificultad", this._difficulty);
        startActivity(i);
    }
}

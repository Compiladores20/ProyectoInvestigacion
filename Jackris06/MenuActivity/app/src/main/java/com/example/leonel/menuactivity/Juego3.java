package com.example.leonel.menuactivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.transition.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.leonel.menuactivity.generadorERYL.GeneradorJuego3;

public class Juego3 extends AppCompatActivity implements View.OnClickListener {

    int dificultad;

    TextView _score;
    TextView _lang;

    Button _empezar;
    Button _true;
    Button _false;

    int _intscore;
    String _actualregex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego3);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
            this.dificultad = extras.getInt("Dificultad");
        _actualregex = "";
        _intscore = 0;
        _score = (TextView) findViewById(R.id._score);
        _lang = (TextView) findViewById(R.id._langregexp);

        _true = (Button) findViewById(R.id.button9);
        _true.setOnClickListener(this);

        _false = (Button) findViewById(R.id.button10);
        _false.setOnClickListener(this);

        _empezar = (Button) findViewById(R.id.start);
        _empezar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button9:
                checkEntry(1);
                //getLang(1);
                break;
            case R.id.button10:
                checkEntry(0);
                break;
            case R.id.start:
                getFirst();
                break;
        }
    }

    private void getLang(int pBool) {
        String exp = generadorERYL.GeneradorJuego3(this.dificultad);
        String[] expr = exp.split("#");
        int bool = Character.getNumericValue(expr[0].charAt(0));
        String pTVText = expr[0].substring(1)+"\n";
        for (int i  = 1; i < expr.length;i++){
            pTVText = pTVText + expr[i] +"\n";
        }
        if(_actualregex.equals("")) {
            System.out.println("EMPTY");
            _actualregex = expr[0].substring(1);
        }
        else if(pBool==1 &&  bool == 1) {
            _intscore = _intscore + 1;
            _actualregex = expr[0].substring(1);
       }else if (pBool == 0 && bool == 0){
            _intscore = _intscore + 1;
            _actualregex = expr[0].substring(1);
        }
        else if(pBool == 1 && bool == 0){
            _actualregex = expr[0].substring(1);
        }else if(pBool == 0 && bool == 1){
            _actualregex = expr[0].substring(1);
        }
        _score.setText(Integer.toString(_intscore));


    }

    private void checkEntry(int pBool){

        String expr = _actualregex.substring(0).replaceAll("#","\n");
        int bool = Character.getNumericValue(_actualregex.charAt(0));
        if (pBool == bool){
            _intscore = _intscore + 1;
            _score.setText("Puntos: "+ _intscore);
        }
        _actualregex = generadorERYL.GeneradorJuego3(this.dificultad);
        this._lang.setText(_actualregex.substring(0).replaceAll("#","\n"));
    }

    private void getFirst(){
        this._intscore = 0;
        this._empezar.setVisibility(View.GONE);
        this._actualregex = generadorERYL.GeneradorJuego3(this.dificultad);
        _lang.setText(_actualregex.substring(0).replaceAll("#","\n"));
    }
}
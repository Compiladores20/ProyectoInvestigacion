package com.example.leonel.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by LEONEL on 26/8/2017.
 */

public class MainActivity extends  Activity implements  View.OnClickListener {

    private String textContent = "";
    private Button[] btn = new Button[5];
    private Button btn_unfocus;
    private int[] btn_id = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_group);

        for(int i = 0; i < btn.length;i++){
            btn[i] = (Button) findViewById(btn_id[i]);
            btn[i].setBackgroundColor(Color.rgb(207,207,207));
            btn[i].setOnClickListener(this);
        }
        btn_unfocus = btn[1];
    }

    @Override
    public void onClick (View v){
        final MediaPlayer ASound = MediaPlayer.create(this, R.raw.a);
        final MediaPlayer BSound = MediaPlayer.create(this, R.raw.b);
        final MediaPlayer CSound = MediaPlayer.create(this, R.raw.c);
        final MediaPlayer DSound = MediaPlayer.create(this, R.raw.d);
        final MediaPlayer ESound = MediaPlayer.create(this, R.raw.e);
        switch(v.getId()){
            case R.id.btn0:
                setFocus(btn_unfocus,btn[0]);
                printContent(btn[0]);
                changeText(btn[0].getText().toString());
                ASound.start();
                break;
            case R.id.btn1:
                setFocus(btn_unfocus,btn[1]);
                printContent(btn[1]);
                changeText(btn[1].getText().toString());
                BSound.start();
                break;
            case R.id.btn2:
                setFocus(btn_unfocus,btn[2]);
                printContent(btn[2]);
                changeText(btn[2].getText().toString());
                CSound.start();
                break;
            case R.id.btn3:
                setFocus(btn_unfocus,btn[3]);
                printContent(btn[3]);
                changeText(btn[3].getText().toString());
                DSound.start();
                break;
            case R.id.btn4:
                setFocus(btn_unfocus,btn[4]);
                printContent(btn[4]);
                changeText(btn[4].getText().toString());
                ESound.start();
                break;
        }
    }

    private void setFocus(Button btn_unfocus, Button btn_focus){
        btn_unfocus.setTextColor(Color.rgb(49,50,51));
        btn_unfocus.setBackgroundColor(Color.rgb(207,207,207));
        btn_focus.setTextColor(Color.rgb(255,255,255));
        btn_focus.setBackgroundColor(Color.rgb(3,106,150));
        this.btn_unfocus = btn_focus;
    }

    private void printContent(Button pButton){
        Log.i("Myapp",pButton.getText().toString());
    }
    private void changeText(String pEntry){
        TextView text = (TextView) findViewById(R.id.textView5);
        text.setText(textContent+pEntry);
        textContent =  textContent + pEntry;
    }
}


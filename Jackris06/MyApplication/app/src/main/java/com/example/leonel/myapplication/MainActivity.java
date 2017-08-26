package com.example.leonel.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by LEONEL on 26/8/2017.
 */

public class MainActivity extends Activity implements  View.OnClickListener{
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
        switch(v.getId()){
            case R.id.btn0:
                setFocus(btn_unfocus,btn[0]);
                break;
            case R.id.btn1:
                setFocus(btn_unfocus,btn[1]);
                break;
            case R.id.btn2:
                setFocus(btn_unfocus,btn[2]);
                break;
            case R.id.btn3:
                setFocus(btn_unfocus,btn[3]);
                break;
            case R.id.btn4:
                setFocus(btn_unfocus,btn[4]);
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
}


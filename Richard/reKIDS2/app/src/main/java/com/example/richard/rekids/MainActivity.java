package com.example.richard.rekids;

import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton imgBtnId00,imgBtnId01,imgBtnId02,imgBtnId03,imgBtnId04,imgBtnId05,
            imgBtnId10, imgBtnId11, imgBtnId12,imgBtnId13,imgBtnId14,imgBtnId15,
            imgBtnId20, imgBtnId21, imgBtnId22,imgBtnId23,imgBtnId24,imgBtnId25,
            boton1,boton2,boton3,boton4,boton5,boton6;
   // boolean ActivateArray[][] = {{false,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false}};
    int array[][] ={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    int arrayDatos[][]={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    ImageButton previos = null;
    int yPrevios,xPrevios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imgBtnId00 = (ImageButton) findViewById(R.id.imageButton00);
        imgBtnId01 = (ImageButton) findViewById(R.id.imageButton01);
        imgBtnId02 = (ImageButton) findViewById(R.id.imageButton02);
        imgBtnId03 = (ImageButton) findViewById(R.id.imageButton03);
        imgBtnId04 = (ImageButton) findViewById(R.id.imageButton04);
        imgBtnId05 = (ImageButton) findViewById(R.id.imageButton05);
        //vamos a colocarle el metodo de escucha
        imgBtnId00.setOnClickListener(this);
        imgBtnId01.setOnClickListener(this);
        imgBtnId02.setOnClickListener(this);
        imgBtnId03.setOnClickListener(this);
        imgBtnId04.setOnClickListener(this);
        imgBtnId05.setOnClickListener(this);


        imgBtnId10 = (ImageButton) findViewById(R.id.imageButton10);
        imgBtnId11 = (ImageButton) findViewById(R.id.imageButton11);
        imgBtnId12 = (ImageButton) findViewById(R.id.imageButton12);
        imgBtnId13 = (ImageButton) findViewById(R.id.imageButton13);
        imgBtnId14 = (ImageButton) findViewById(R.id.imageButton14);
        imgBtnId15 = (ImageButton) findViewById(R.id.imageButton15);
        //vamos a colocarle el metodo de escucha
        imgBtnId10.setOnClickListener(this);
        imgBtnId11.setOnClickListener(this);
        imgBtnId12.setOnClickListener(this);
        imgBtnId13.setOnClickListener(this);
        imgBtnId14.setOnClickListener(this);
        imgBtnId15.setOnClickListener(this);


        imgBtnId20 = (ImageButton) findViewById(R.id.imageButton20);
        imgBtnId21 = (ImageButton) findViewById(R.id.imageButton21);
        imgBtnId22 = (ImageButton) findViewById(R.id.imageButton22);
        imgBtnId23 = (ImageButton) findViewById(R.id.imageButton23);
        imgBtnId24 = (ImageButton) findViewById(R.id.imageButton24);
        imgBtnId25 = (ImageButton) findViewById(R.id.imageButton25);
        //vamos a colocarle el metodo de escucha
        imgBtnId20.setOnClickListener(this);
        imgBtnId21.setOnClickListener(this);
        imgBtnId22.setOnClickListener(this);
        imgBtnId23.setOnClickListener(this);
        imgBtnId24.setOnClickListener(this);
        imgBtnId25.setOnClickListener(this);



        boton1 = (ImageButton) findViewById(R.id.boton1);
        boton2 = (ImageButton) findViewById(R.id.boton2);
        boton3 = (ImageButton) findViewById(R.id.boton3);
        boton4 = (ImageButton) findViewById(R.id.boton4);
        boton5 = (ImageButton) findViewById(R.id.boton5);
        boton6 = (ImageButton) findViewById(R.id.boton6);
        //vamos a colocarle el metodo de escucha
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
        boton6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.imageButton00:
                SelBoton(imgBtnId00,0,0);
                break;
            case R.id.imageButton01:
                SelBoton(imgBtnId01,1,0);
                break;
            case R.id.imageButton02:
                SelBoton(imgBtnId02,2,0);
                break;
            case R.id.imageButton03:
                SelBoton(imgBtnId03,3,0);
                break;
            case R.id.imageButton04:
                SelBoton(imgBtnId04,4,0);
                break;
            case R.id.imageButton05:
                SelBoton(imgBtnId05,5,0);
                break;


            case R.id.imageButton10:
                SelBoton(imgBtnId10,0,1);
                break;
            case R.id.imageButton11:
                SelBoton(imgBtnId11,1,1);
                break;
            case R.id.imageButton12:
                SelBoton(imgBtnId12,2,1);
                break;
            case R.id.imageButton13:
                SelBoton(imgBtnId13,3,1);
                break;
            case R.id.imageButton14:
                SelBoton(imgBtnId14,4,1);
                break;
            case R.id.imageButton15:
                SelBoton(imgBtnId15,5,1);
                break;


            case R.id.imageButton20:
                SelBoton(imgBtnId20,0,2);
                break;
            case R.id.imageButton21:
                SelBoton(imgBtnId21,1,2);
                break;
            case R.id.imageButton22:
                SelBoton(imgBtnId22,2,2);
                break;
            case R.id.imageButton23:
                SelBoton(imgBtnId23,3,2);
                break;
            case R.id.imageButton24:
                SelBoton(imgBtnId24,4,2);
                break;
            case R.id.imageButton25:
                SelBoton(imgBtnId25,5,2);
                break;
            //aqui iniciamos con los botones de simbolos del teclado
            case R.id.boton1:
                Tecla(1);
                break;
            case R.id.boton2:
                Tecla(2);
                break;
            case R.id.boton3:
                Tecla(3);
                break;
            case R.id.boton4:
                Tecla(4);
                break;
            case R.id.boton5:
                Tecla(5);
                break;
            case R.id.boton6:
                Tecla(6);
                break;
        }

    }

    public void Tecla(int valor){

        if(previos!= null){
            if((valor != 5)&&(valor != 6)){
                if(valor == 1){
                    previos.setImageResource(R.drawable.img1);
                }
                if(valor == 2){
                    previos.setImageResource(R.drawable.img2);
                }
                if(valor == 3){
                    previos.setImageResource(R.drawable.img3);
                }
                if(valor == 4){
                    previos.setImageResource(R.drawable.img4);

                }
                arrayDatos[yPrevios][xPrevios] = valor;
                array[yPrevios][xPrevios] =  1;
                previos.setBackgroundColor(Color.TRANSPARENT);
            }

            if(valor == 5){
                previos.setImageResource(R.drawable.img0);
                array[yPrevios][xPrevios] = 0;
                arrayDatos[yPrevios][xPrevios] = 0;
                previos.setBackgroundColor(Color.TRANSPARENT);
            }
            if(valor == 6){
                int filas = 3;
                int columnas = 6;
                String string = "";
                //metodo salvaje aparece

                //Esto cuenta los valore activados
                for (int x = 0;x < columnas;x++){
                    int contador = 0;
                    for(int cont = 0; cont <3;cont++ ){
                        if(array[cont][x] != 0){
                            contador = contador + 1;
                        }

                    }
                    if(contador != 0){
                    string += "(";}
                    for(int y = 0; y < contador ; y++ ){
                        if(array[y][x] == 0){
                            contador = contador+1;
                        }
                        if( (array[y][x] == 1) || (array[y][x]== 4)){
                            if(arrayDatos[y][x]==1){
                                string += "a";
                            }
                            if(arrayDatos[y][x] == 2){
                                string += "b";
                            }
                            if(arrayDatos[y][x] == 3){
                                string += "c";
                            }
                            if(arrayDatos[y][x] == 4){
                                string += "d";
                            }
                            if(array[y][x]== 4){
                                string += "*";
                            }
                            if(y + 1 != contador ){
                                string += "+";
                            }

                        }
                        if(array[y][x] == 2){
                            if(y == 0){
                                string +="(";
                            }else if(array[y-1][x] != 2){
                                string +="(";
                            }

                            if(arrayDatos[y][x]==1){
                                string += "a";
                            }
                            if(arrayDatos[y][x] == 2){
                                string += "b";
                            }
                            if(arrayDatos[y][x] == 3){
                                string += "c";
                            }
                            if(arrayDatos[y][x] == 4){
                                string += "d";
                            }

                            if(y + 1 != contador ){
                                if(array[y+1][x] != 2){
                                    string += ")*";
                                }
                                string += "+";
                            }else{
                                string += ")*";
                            }
                        }




                        //este es el metodo de los botones grises
                        if(array[y][x] == 3){

                            if(x - 1 < 0){
                                string += "(";
                            }else if(array[y][x-1]!= 3){
                                string += "(";
                            }

                        if(arrayDatos[y][x]==1){
                            string += "a";
                        }
                        if(arrayDatos[y][x] == 2){
                            string += "b";
                        }
                        if(arrayDatos[y][x] == 3){
                            string += "c";
                        }
                        if(arrayDatos[y][x] == 4){
                            string += "d";
                        }

                        if(x+1 == columnas){
                            string += ")*";
                        }else if(array[y][x+1]!=3){
                            string += ")*";
                            if(y +1 != filas){
                                int counter2 =0;
                                for(int cont = y+1; cont <3;cont++ ){
                                    if(array[cont][x] != 0){
                                        counter2 = counter2 + 1;
                                        System.out.println(counter2);
                                    }
                                }

                                if(counter2>0){
                                    string += "+";
                                }
                                contador = y+1+counter2;
                            }

                        }else{
                            x+=1;
                            y = y-1;
                           }
                        }


                    }
                    if(contador != 0){
                    string += ")";}
                }


                //aqui vamos a hacer el barrido de el string para eliminar parentesis vacios

                //****************************************************************************************************
     /*           char previo;
                previo = string.charAt(0);
                for(int valorString = 0; valorString <= string.length();valorString++){
                    if(string.charAt(valorString)==')'){
                        System.out.println("entra al bucle");
                        if(previo=='('){

                        }
                    }

                    previo = string.charAt(valorString);
                }
     */

                // aqui falta el metodo de los grices



                TextView txt = (TextView) findViewById(R.id.Salida);
                txt.setText(string);

            }
            //arrayDatos[yPrevios][xPrevios] = valor;
        }


    }




    public void SelBoton(ImageButton boton,int x,int y){
        if(previos!= null && arrayDatos[yPrevios][xPrevios] == 0){
            previos.setBackgroundColor(Color.TRANSPARENT);
        }
        previos = boton;
        yPrevios = y;
        xPrevios = x;
        if(array[y][x] == 0){
            boton.setBackgroundColor(Color.RED);
        }else if (array[y][x] == 1){
            boton.setBackgroundColor(Color.BLUE);
            array[y][x] = array[y][x] + 1;
        }else if(array[y][x] == 2){
            boton.setBackgroundColor(Color.GRAY);
            array[y][x] = array[y][x] + 1;
        }else if(array[y][x] == 3){
            boton.setBackgroundColor(Color.GREEN);
            array[y][x] = array[y][x] + 1;
        }else if(array[y][x] == 4){
            array[y][x] = 1;
            boton.setBackgroundColor(Color.TRANSPARENT);
        }
    }



}

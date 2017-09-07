package com.example.leonel.menuactivity;

public class generadorERYL {

//	public static void main(String[] args)
//	{
//		 TODO Auto-generated method stub
//		String hola="a+b";
//		String[] arrayhola= {"hola","adios"};
//		String prueba="as#asd#fds#fds#";
//		double numero=(Math.random()*2);
//		int escogido=(int)numero;
//		System.out.println(parte2(1));
//		System.out.println(parte2(2));
//		System.out.println(parte2(3));
//		hola=GeneradorExpresionesRegulares(3);
//		System.out.println(GeneradorJuego3(1));
//		System.out.println(generarNlenguajes(5,"(a+b)"));
//		System.out.println(generadorLenguajes(hola));
//	}
public static String GeneradorJuego1(int dificultad)
{
	String expresionregular=GeneradorExpresionesRegulares(dificultad);
	int numerolenjuages=0;
	if(dificultad==3) {numerolenjuages=10;}
	else if(dificultad==2) {numerolenjuages=7;}
	else if(dificultad==1) {numerolenjuages=5;}
	return expresionregular+generarNlenguajes(numerolenjuages,expresionregular);
}
	public static String GeneradorJuego2(String expresionregular)
	{
		return generarNlenguajes(5,expresionregular);
	}
	public static String GeneradorJuego3(int dificultad)
	{
		String resultado="";
		String expresionregular=GeneradorExpresionesRegulares(dificultad);
		double numero1=(Math.random()*2);
		int verdaderoOfalso=(int)numero1;
		resultado+=verdaderoOfalso+expresionregular;
		if(verdaderoOfalso==0)
		{
			String expresionregularfalsa=GeneradorExpresionesRegulares(dificultad);
			resultado+=lenguajesfalsos(expresionregular,expresionregularfalsa);
		}
		else if(verdaderoOfalso==1)
		{
			resultado+="#"+generadorLenguajes(expresionregular)+"#"+generadorLenguajes(expresionregular)+"#"+generadorLenguajes(expresionregular);
		}
		return resultado;
	}
	public static String lenguajesfalsos(String verdadero,String falso)
	{
		String resultado="";
		int cont=0;
		double numero1=(Math.random()*3);
		int numerofalso=(int)numero1;
		while(cont<3)
		{
			if(cont==numerofalso)
			{
				resultado+="#"+generadorLenguajes(falso);
			}
			else
			{
				resultado+="#"+generadorLenguajes(verdadero);
			}
			cont++;
		}
		return resultado;
	}
	public static String generadorLenguajes(String expresionregular)
	{
		String resultado="";
		String variable1="";
		String variable2="";
		String variable3="";
		String variable4="";
		String variable5="";
		String variable6="";
		String variable="";
		expresionregular+="#";
		while(expresionregular.compareTo("#")!=0)
		{

			if(expresionregular.substring(0,1).compareTo("(")==0)
			{

				while(expresionregular.substring(0,1).compareTo(")")!=0)
				{
					//System.out.println(expresionregular.substring(0,1)+":expresion regular en while que termina en )");
					variable+=expresionregular.substring(0,1);
					expresionregular=expresionregular.substring(1);
				}
				variable+=expresionregular.substring(0,1);
				//System.out.println(variable+":variable");
				expresionregular=expresionregular.substring(1);//para eliminar el )
				//System.out.println(expresionregular+":expresion regular en generadorLenguajes4");
				if(expresionregular.compareTo("#")==0)
				{
					if(variable1.compareTo("")==0) {variable1=variable;}
					else if(variable2.compareTo("")==0) {variable2=variable;}
					else if(variable3.compareTo("")==0) {variable3=variable;}
					else if(variable4.compareTo("")==0) {variable4=variable;}
					else if(variable5.compareTo("")==0) {variable5=variable;}
					else if(variable6.compareTo("")==0) {variable6=variable;}
				}
			}
			else if(expresionregular.substring(0,1).compareTo("+")==0)
			{
				if(variable1.compareTo("")==0) {variable1=variable;}
				else if(variable2.compareTo("")==0) {variable2=variable;}
				else if(variable3.compareTo("")==0) {variable3=variable;}
				else if(variable4.compareTo("")==0) {variable4=variable;}
				else if(variable5.compareTo("")==0) {variable5=variable;}
				else if(variable6.compareTo("")==0) {variable6=variable;}
				expresionregular=expresionregular.substring(1);
				variable="";
			}
			else if(expresionregular.substring(1,2).compareTo("#")==0)
			{
				variable+=expresionregular.substring(0,1);
				if(variable1.compareTo("")==0) {variable1=variable;}
				else if(variable2.compareTo("")==0) {variable2=variable;}
				else if(variable3.compareTo("")==0) {variable3=variable;}
				else if(variable4.compareTo("")==0) {variable4=variable;}
				else if(variable5.compareTo("")==0) {variable5=variable;}
				else if(variable6.compareTo("")==0) {variable6=variable;}
				expresionregular=expresionregular.substring(1);
				variable="";
			}
			else//Si no es un parentesis o una suma, se le agrega a variable para agregar a alguna variable
			{

				variable+=expresionregular.substring(0,1);
				expresionregular=expresionregular.substring(1);
			}

		}
		//System.out.println(variable2+"       ho");
		if (variable2.compareTo("")!=0)//Tengo certeza que hay una suma
		{
			resultado=aplicarSuma(variable1,variable2,variable3,variable4,variable5,variable6);
		}
		else
		{
			resultado=variable1;
		}
		if(detectorparentesis(resultado))
		{
			resultado=dividirPorParentesis(resultado);
		}
		if(resultado.compareTo("")==0) {}
		else if(detectorClean(resultado))
		{
			resultado=aplicarVariable(resultado);
		}
		return resultado;
	}
	public static String aplicarSuma(String variable1,String variable2,String variable3,String variable4,String variable5,String variable6)
	{
		String resultado = "";
		double numero=(Math.random()*6)+1;
		int escogido=(int)numero;
		//System.out.println("escogido:"+escogido+" 1:"+variable1+" 2:"+variable2+" 3:"+variable3+" 4:"+variable4);
		if(escogido==6)
		{
			if(variable6.compareTo("")==0)
			{
				resultado=aplicarSuma(variable1,variable2,variable3,variable4,variable5,variable1);
			}
			else
			{
				resultado=variable6;
			}
		}
		else if(escogido==5)
		{
			if(variable5.compareTo("")==0)
			{
				resultado=aplicarSuma(variable1,variable2,variable3,variable4,variable2,variable1);
			}
			else
			{
				resultado=variable5;
			}
		}
		else if(escogido==4)
		{
			if(variable4.compareTo("")==0)
			{
				resultado=aplicarSuma(variable1,variable2,variable3,variable1,variable2,variable1);
			}
			else
			{
				resultado=variable4;
			}
		}
		else if(escogido==3)
		{
			if(variable3.compareTo("")==0)
			{
				resultado=aplicarSuma(variable1,variable2,variable1,variable2,variable1,variable2);
			}
			else
			{
				resultado=variable3;
			}
		}
		else if(escogido==2)
		{
			resultado=variable2;
		}
		else if(escogido==1)
		{
			resultado=variable1;
		}
		//System.out.println("resultado"+resultado);
		return resultado;
	}
	public static String CleanSimple(String variable)
	{
		String resultado="";
		//System.out.println("Clean simple:"+variable);
		if(variable.length()>2)
		{
			resultado=CleanAtravesado(variable);
		}
		else
		{
			int cont;
			double numero=(Math.random()*5);
			cont=(int)numero;
			while(cont!=0)
			{
				resultado+=variable.substring(0,variable.length()-1);
				cont--;
			}
		}
		return resultado;
	}
	public static String dividirPorParentesis(String expresionregular)
	{
		//System.out.println("lo que llega a dividir parentesis :"+expresionregular);
		String resultado="";
		String variable1="";
		String variable2="";
		String variable3="";
		String variable4="";
		String variable5="";
		String variable6="";
		String variable="";
		expresionregular+="#";
		while(expresionregular.compareTo("#")!=0)
		{
			//System.out.println("Expresion regular en el while:"+expresionregular);
			if(expresionregular.substring(0,1).compareTo("(")==0)
			{
				if(variable.compareTo("")==0)
				{
					variable+=expresionregular.substring(0,1);
					expresionregular=expresionregular.substring(1);
				}
				else
				{
					if(variable1.compareTo("")==0) {variable1=variable;}
					else if(variable2.compareTo("")==0) {variable2=variable;}
					else if(variable3.compareTo("")==0) {variable3=variable;}
					else if(variable4.compareTo("")==0) {variable4=variable;}
					else if(variable5.compareTo("")==0) {variable5=variable;}
					else if(variable6.compareTo("")==0) {variable6=variable;}
					//expresionregular=expresionregular.substring(1);
					variable=expresionregular.substring(0,1);
					expresionregular=expresionregular.substring(1);
				}
			}
			else if(expresionregular.substring(0,1).compareTo(")")==0)
			{
				if (expresionregular.substring(1,2).compareTo("*")==0)
				{
					variable+=expresionregular.substring(0,2);
					expresionregular=expresionregular.substring(2);
				}
				else
				{
					variable+=expresionregular.substring(0,1);
					expresionregular=expresionregular.substring(1);
				}
				if(variable1.compareTo("")==0) {variable1=variable;}
				else if(variable2.compareTo("")==0) {variable2=variable;}
				else if(variable3.compareTo("")==0) {variable3=variable;}
				else if(variable4.compareTo("")==0) {variable4=variable;}
				else if(variable5.compareTo("")==0) {variable5=variable;}
				else if(variable6.compareTo("")==0) {variable6=variable;}
				//expresionregular=expresionregular.substring(1);
				variable="";
			}
			else
			{
				variable+=expresionregular.substring(0,1);
				expresionregular=expresionregular.substring(1);
			}
		}

		if (variable.compareTo("")!=0)
		{
			if(variable1.compareTo("")==0) {variable1=variable;}
			else if(variable2.compareTo("")==0) {variable2=variable;}
			else if(variable3.compareTo("")==0) {variable3=variable;}
			else if(variable4.compareTo("")==0) {variable4=variable;}
			else if(variable5.compareTo("")==0) {variable5=variable;}
			else if(variable6.compareTo("")==0) {variable6=variable;}
		}
		//System.out.println(variable3+"holi");
		if(variable1.compareTo("")==0)
		{
			resultado=aplicarVariable(variable);
		}
		else
		{
			resultado+=aplicarVariable(variable1);
			resultado+=aplicarVariable(variable2);
			resultado+=aplicarVariable(variable3);
			resultado+=aplicarVariable(variable4);
			resultado+=aplicarVariable(variable5);
			resultado+=aplicarVariable(variable6);
		}
		return resultado;
	}
	public static String aplicarVariable(String expresionregular)
	{
		//System.out.println("lo que llega a aplicar variable: "+expresionregular);
		String resultado="";
		if((expresionregular.compareTo("(")!=0)&&(expresionregular.compareTo(")")!=0))
		{
			if(expresionregular.compareTo("")==0) {}
			else if(expresionregular.substring(0,1).compareTo("(")==0)//Parentesis, bo estoy revisando si el parentesis tiene Clean
			{

				if(expresionregular.substring(expresionregular.length()-1).compareTo("*")==0)
				{
					resultado=CleanParentesis(expresionregular);
				}
				else
				{
					//System.out.println("entre a parentesis sin clean");
					resultado=generadorLenguajes(expresionregular.substring(1,expresionregular.length()-1));
					//System.out.println("despues de sumar me da:"+resultado);
				}
			}
			else if(expresionregular.substring(expresionregular.length()-1).compareTo("*")==0) //Es clean
			{
				resultado=CleanSimple(expresionregular);
			}
			else
			{
				if(detectorparentesis(expresionregular))
				{
					resultado=dividirPorParentesis(expresionregular);
				}
				else if(detectorClean(expresionregular))
				{
					resultado=CleanAtravesado(expresionregular);
				}
				else
				{
					resultado=expresionregular;
				}
			}
		}

		//System.out.println(resultado+"resultado de aplicar");
		return resultado;
	}
	public static String CleanParentesis(String expresionregular)
	{
		String resultado="";
		int cont;
		double numero=(Math.random()*5);
		cont=(int)numero;
		while(cont!=0)
		{
			resultado+=generadorLenguajes(expresionregular.substring(1,expresionregular.length()-2));
			cont--;
		}
		return resultado;
	}
	public static boolean detectorparentesis(String expresionregular)
	{
		boolean parentesis=false;
		expresionregular+="#";
		while(expresionregular.compareTo("#")!=0)
		{
			if(expresionregular.substring(0,1).compareTo("(")==0) {parentesis=true;}
			expresionregular=expresionregular.substring(1);
		}
		return parentesis;
	}
	public static boolean detectorClean(String expresionregular)
	{
		boolean clean=false;
		expresionregular+="#";
		while(expresionregular.compareTo("#")!=0)
		{
			if(expresionregular.substring(0,1).compareTo("*")==0)
			{
				clean=true;
			}
			expresionregular=expresionregular.substring(1);
		}
		return clean;
	}
	public static String CleanAtravesado(String expresionregular)
	{
		String resultado="";
		while(expresionregular.compareTo("")!=0)
		{
			//System.out.println(resultado+"resultado");
			if(expresionregular.length()>1)
			{
				//System.out.println(resultado+"resultado");
				if(expresionregular.substring(1,2).compareTo("*")==0)
				{
					resultado+=CleanSimple(expresionregular.substring(0,2));
					expresionregular=expresionregular.substring(2);
				}
				else
				{
					resultado+=expresionregular.substring(0,1);
					expresionregular=expresionregular.substring(1);
				}
			}
			else
			{
				//System.out.println(expresionregular+"resultado");
				resultado+=expresionregular.substring(0,1);
				expresionregular=expresionregular.substring(1);
			}
		}
		//System.out.println(resultado+"resultado");
		return resultado;
	}
	public static String generarNlenguajes(int N,String expresionregular)
	{
		String resultado="";
		int Z=N;
		N=30;
		String[] lenguajes=new String[30];
		lenguajes[0]=generadorLenguajes(expresionregular);
		int contRevisados=0;
		int contMI=0;
		int contLenguajes=1;
		String lenguaje="";
		boolean nosepudocrearlenguaje=false;
		while(N>0)
		{
			lenguaje=generadorLenguajes(expresionregular);
			contMI=0;
			contRevisados=0;
			while((contRevisados<contLenguajes)&&(contMI<100))
			{
				if(detectorLenguajesIguales(lenguajes[contRevisados],lenguaje))
				{
					generadorLenguajes(expresionregular);
					contMI++;
					contRevisados=0;
				}
				else
				{
					contRevisados++;
				}
			}
			if(contMI<100)
			{
				if (contRevisados<30)
				{
					lenguajes[contRevisados]=lenguaje;
					contLenguajes++;
				}
			}
			N--;
		}
		for(int i=0;i<contLenguajes;i++)
		{
			resultado+=lenguajes[i]+"#";//System.out.println("lenguajes["+i+"]:"+lenguajes[i]);
		}
		return recortadorString2(resultado,"#",Z);
	}
	public static boolean detectorLenguajesIguales(String lenguaje0,String lenguaje1)
	{
		boolean soniguales=false;
		if(lenguaje0.compareTo(lenguaje1)==0) {soniguales=true;}
		return soniguales;
	}
	public static String recortadorString(String string,String split)
	{
		while(string.substring(0,1).compareTo(split)!=0)
		{
			string=string.substring(1);
		}
		return string.substring(1);
	}
	public static String recortadorString2(String string,String split,int numero)
	{
		int cont=0;
		int cont2=0;
		while(cont<numero)
		{
			if(cont2==string.length()-1)
			{
				cont=numero;
			}
			if((string.substring(cont2,cont2+1).compareTo(split)==0)&&(cont2<string.length()))
			{
				cont++;
				cont2++;
			}
			else
			{
				cont2++;
			}

		}
		return "#"+string.substring(0,cont2-1);
	}
	public static String parte1(int dificultad)
	{
		double numero1=(Math.random()*4);
		String resultado="";
		int escogidovariable=(int)numero1;
		String[] variablesexpresiones={"a","b","c","d","e"};
		resultado+=variablesexpresiones[escogidovariable];
		int modificador=2;
		if(dificultad==1) {modificador+=2;}
		else if(dificultad==2) {modificador++;}
		double numero2=(Math.random()*modificador);
		int escogidoClean=(int)numero2;
		if(escogidoClean==0) {resultado+="*";}
		return resultado;
	}
	public static String parte2(int dificultad)
	{
		String resultado="";
		int modificador=2;
		if(dificultad==1) {modificador+=3;}
		else if(dificultad==2) {modificador++;}
		double numero1=(Math.random()*modificador);
		int escogidoParentesis=(int)numero1;
		if(escogidoParentesis==0)
		{
			double numero2=(Math.random()*3);
			int cantidavariables=(int)numero2;
			if (cantidavariables==2)
			{
				resultado+="("+parte1(dificultad)+"+"+parte1(dificultad)+"+"+parte1(dificultad)+")";
			}
			else
			{
				resultado+="("+parte1(dificultad)+"+"+parte1(dificultad)+")";
			}
			if(dificultad!=1)
			{
				double numero3=(Math.random()*3);
				int tieneClean=(int)numero3;
				if(tieneClean==1)
				{
					resultado="("+resultado+"*)";
				}
			}

		}
		else
		{
			resultado+="("+parte1(dificultad)+")";
		}
		return resultado;
	}
	public static String GeneradorExpresionesRegulares(int dificultad)
	{
		String resultado="";
		double numero1=(Math.random()*3)+1;
		int cantidadvariables=(int)numero1;
		if(dificultad==2) {cantidadvariables+=2;}
		else if(dificultad==3) {cantidadvariables+=3;}
		while(cantidadvariables>0)
		{
			resultado+=parte2(dificultad);
			cantidadvariables--;
		}
		return resultado;
	}
}
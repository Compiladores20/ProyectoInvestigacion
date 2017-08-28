package GeneradorERYL;

public class generadorERYL {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String hola="(hola)";
		double numero=(Math.random()*6)+1;
		int escogido=(int)numero;
		while(escogido!=2)
		{
			numero=(Math.random()*6)+1;
			escogido=(int)numero;
			System.out.println(escogido);
		}
		System.out.println(hola.substring(1, hola.length()-1));

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
					variable+=expresionregular.substring(0,1);
					expresionregular=expresionregular.substring(1);
				}
				expresionregular=expresionregular.substring(1);//para eliminar el )
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
			else//Si no es un parentesis o una suma, se le agrega a variable para agregar a alguna variable
			{
				variable+=expresionregular.substring(0,1);
				expresionregular=expresionregular.substring(1);
			}
				
		}
		if (variable2.compareTo("")!=0)//Tengo certeza que hay una suma
		{
			resultado=aplicarSuma(variable1,variable2,variable3,variable4,variable5,variable6);
		}
		resultado=dividirPorParentesis(resultado);
		return resultado;
	}
	public static String aplicarSuma(String variable1,String variable2,String variable3,String variable4,String variable5,String variable6)
	{
		String resultado = "";
		double numero=(Math.random()*6)+1;
		int escogido=(int)numero;
		if(escogido==6)
		{
			if(variable6.compareTo("")==0)
			{
				aplicarSuma(variable1,variable2,variable3,variable4,variable5,variable1);
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
				aplicarSuma(variable1,variable2,variable3,variable4,variable2,variable1);
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
				aplicarSuma(variable1,variable2,variable3,variable1,variable2,variable1);
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
				aplicarSuma(variable1,variable2,variable1,variable2,variable1,variable2);
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
		return resultado;
	}
	public static String CleanSimple(String variable)
	{
		String resultado="";
		int cont;
		double numero=(Math.random()*5);
		cont=(int)numero;
		while(cont!=0)
		{
			resultado+=variable.substring(0,variable.length()-1);
			cont--;
		}
		return resultado;
	}
	public static String dividirPorParentesis(String expresionregular)
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
				if(variable1.compareTo("")==0) {variable1=variable;}
				else if(variable2.compareTo("")==0) {variable2=variable;}
				else if(variable3.compareTo("")==0) {variable3=variable;}
				else if(variable4.compareTo("")==0) {variable4=variable;}
				else if(variable5.compareTo("")==0) {variable5=variable;}
				else if(variable6.compareTo("")==0) {variable6=variable;}
				//expresionregular=expresionregular.substring(1);
				variable="";
			}
			else if(expresionregular.substring(1,2).compareTo("#")!=0)
			{
				variable+=expresionregular.substring(0,1);
				expresionregular=expresionregular.substring(1);
			}
			else
			{
				if(variable1.compareTo("")==0)
				{
					variable=expresionregular.substring(0,1);
					variable1=variable;
				}
				else
				{
					variable+=expresionregular.substring(0,1);
					expresionregular=expresionregular.substring(1);
					if(variable2.compareTo("")==0) {variable2=variable;}
					else if(variable3.compareTo("")==0) {variable3=variable;}
					else if(variable4.compareTo("")==0) {variable4=variable;}
					else if(variable5.compareTo("")==0) {variable5=variable;}
					else if(variable6.compareTo("")==0) {variable6=variable;}
				}
			}
		}
		resultado+=aplicarVariable(variable1);
		resultado+=aplicarVariable(variable2);
		resultado+=aplicarVariable(variable3);
		resultado+=aplicarVariable(variable4);
		resultado+=aplicarVariable(variable5);
		resultado+=aplicarVariable(variable6);
		return resultado;
	}
	public static String aplicarVariable(String expresionregular)
	{
		String resultado="";
		if(expresionregular.substring(0,1).compareTo("(")==0)//Parentesis, bo estoy revisando si el parentesis tiene Clean
		{
			if(expresionregular.substring(expresionregular.length()-1).compareTo("*")==0)
			{
				resultado=CleanParentesis(expresionregular);
			}
			else
			{
				resultado=generadorLenguajes(expresionregular.substring(1,expresionregular.length()-1));
			}
		}
		else if(expresionregular.substring(expresionregular.length()-1).compareTo("*")==0) //Es clean
		{
			resultado=CleanSimple(expresionregular);
		}
		else
		{
			resultado=expresionregular;
		}
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
}

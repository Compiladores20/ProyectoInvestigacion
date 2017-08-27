
public class main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String hola="holadfdwe";
		System.out.println(hola.substring(hola.length()-1));
		lectorERunParentesis("((h+b)*8*)");
		lectorERunParentesis("(h+b*+8*)*");
		lectorERunParentesis("(h+b*+8*)*");
		lectorERunParentesis("(h+b*+8*)*");
		lectorERunParentesis("(h+b*+8*)*");
		//lectorERunParentesis("(h+b*)*");
		//lectorERunParentesis("(h+b*)*");
		//double numero=(Math.random()*3)+1;
		//System.out.println((int)numero);
	}


	public static String lectorERunParentesis(String expresionregular) 
	{
		int cont=0;
		boolean salir=false;
		String salida="";
		//System.out.println(expresionregular);
		if(expresionregular.substring(0,1).compareTo("(")==0)
		{
			expresionregular=expresionregular.substring(1);
			String variable1="";
			String variable2="";
			String variable3="";
			

			while(!salir)
			{
				//System.out.println(expresionregular);
				
				if(expresionregular.compareTo(")")==0)
				{
					double numero=(Math.random()*3)+1;
					int escogido=(int)numero;
					String resultadoSuma=detector(variable1,variable2,variable3,escogido);
					salida+=resultadoSuma;
					salir=true;
					salir=true;
				}
				else
				{
					
					if(expresionregular.substring(0,1).compareTo(")")==0)//Hay que hacer Clean del parentesis
					{
						//System.out.println("Entre a clean");
						String resultadoClean=CleanParentesis(variable1,variable2,variable3);
						//System.out.println(resultadoClean);
						salida+=resultadoClean;
						salir=true;
					}
					else//Hay que encontrar las variables
					{
						//System.out.println("Entre aqui con "+expresionregular.substring(0,1));
						
						if(expresionregular.substring(0,1).compareTo("+")==0)//encuentra una suma
						{
							expresionregular=expresionregular.substring(1);
						}
						else//encuentra una variable
						{
							boolean variableclean=false;
							if(expresionregular.substring(1,2).compareTo("*")==0) {variableclean=true;}//detecta si la variable tiene clean
							if(variable1.compareTo("")==0)
							{
								if(variableclean)
								{
									variable1=expresionregular.substring(0,2);
									expresionregular=expresionregular.substring(2);
								}
								else 
								{
									variable1=expresionregular.substring(0,1);
									expresionregular=expresionregular.substring(1);
								}
								//System.out.println("1 "+variable1);
							}
							else if(variable2.compareTo("")==0)
							{
								if(variableclean)
								{
									variable2=expresionregular.substring(0,2);
									expresionregular=expresionregular.substring(2);
								}
								else 
								{
									variable2=expresionregular.substring(0,1);
									expresionregular=expresionregular.substring(1);
								}
								//System.out.println("2 "+variable2);
							}
							else if(variable3.compareTo("")==0)
							{
								if(variableclean)
								{
									variable3=expresionregular.substring(0,2);
									expresionregular=expresionregular.substring(2);
								}
								else 
								{
									variable3=expresionregular.substring(0,1);
									expresionregular=expresionregular.substring(1);
								}

								//System.out.println("3 "+variable3);
							}
						}
					}
				}
				//System.out.println(expresionregular);
			}
		}

		
	System.out.println("final "+salida);
	return salida;
	}
	public static String detector(String variable1,String variable2,String variable3,int escogido)
	{
		String resultado="";
		if(escogido==3)
		{
			if(variable3.compareTo("")==0)
			{
				detector(variable1,variable2,variable3,escogido-1);
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
		if(resultado.length()>1) // si es mayor que uno es clean
		{
			resultado=CleanSimple(resultado);
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
			resultado+=variable.substring(0,1);
			cont--;
		}
		return resultado;
	}
	public static String CleanParentesis(String variable1,String variable2,String variable3)
	{
		String resultado="";
		int cont;
		double numero=(Math.random()*5);
		cont=(int)numero;
		while(cont!=0)
		{
			double numero2=(Math.random()*3)+1;
			int escogido=(int)numero2;
			resultado+=detector(variable1,variable2,variable3,escogido);
			cont--;
		}
		return resultado;
	}
	public static String revisarSumasTodaLaExpresion(String expresionregular)
	{
		String salida="";
		boolean haysuma=false;
		boolean salir=false;
		String variable1="";
		String variable2="";
		String variable3="";
		String variable4="";
		String variable5="";
		String variable6="";
		expresionregular+="#";
		while (!salir)
		{
			if(expresionregular.compareTo("#")==0)
			{
				salir=true;
			}
			else 
				{
					if(expresionregular.substring(0,1).compareTo("(")==0)
					{
						boolean terminoparentesis=false;
						String variable="";
						while(!terminoparentesis)
						{
							if(expresionregular.substring(0,1).compareTo(")")==0)
							{
								if(expresionregular.substring(1,2).compareTo("*")==0)//Es un parentesis con Clean
								{
									variable+=expresionregular.substring(0,2);
									expresionregular=expresionregular.substring(2);
								}
								else//Es un parentesis sin clean
								{
									variable+=expresionregular.substring(0,1);
									expresionregular=expresionregular.substring(1);
								}
								if(variable1.compareTo("")==0)
								{
									variable1=variable;
								}
								else if(variable2.compareTo("")==0)
								{
									variable2=variable;
								}
								else if(variable3.compareTo("")==0)
								{
									variable3=variable;
								}
								else if(variable4.compareTo("")==0)
								{
									variable4=variable;
								}
								else if(variable5.compareTo("")==0)
								{
									variable5=variable;
								}
								else if(variable6.compareTo("")==0)
								{
									variable6=variable;
								}
							}
							else
							{
								variable+=expresionregular.substring(0,1);
								expresionregular=expresionregular.substring(1);
							}
						}
					}
					else if(expresionregular.substring(0,1).compareTo("+")==0)
					{
						haysuma=true;
						expresionregular=expresionregular.substring(1);
					}
					else
					{
						boolean encontreparentesis=false;
						String variable="";
						while (!encontreparentesis)
						{
							
							if(expresionregular.substring(0,1).compareTo("(")==0)// cuando termina la expresion y encuentra un parentesis
							{
								encontreparentesis=true;
								if(variable1.compareTo("")==0)
								{
									variable1=variable;
								}
								else if(variable2.compareTo("")==0)
								{
									variable2=variable;
								}
								else if(variable3.compareTo("")==0)
								{
									variable3=variable;
								}
								else if(variable4.compareTo("")==0)
								{
									variable4=variable;
								}
								else if(variable5.compareTo("")==0)
								{
									variable5=variable;
								}
								else if(variable6.compareTo("")==0)
								{
									variable6=variable;
								}
							}
							else// si no ha termirminado la expresion 
							{
								variable+=expresionregular.substring(0,1);
								expresionregular=expresionregular.substring(1);
							}
						}
					}
				}
		}
		//cuando termino de detectar todas las posibles variables
		if(haysuma)
		{
			double numero=(Math.random()*6)+1;
			int escogido=(int)numero;
			salida+=SumaVariablesYParentesis(variable1,variable2,variable3,variable4,variable5,variable6,escogido);
		}
		return salida;
	}
	public static String SumaVariablesYParentesis(String variable1,String variable2,
			String variable3,String variable4,String variable5,String variable6,int escogido)
	{
		String resultado="";
		
		if(escogido==6)
		{
			if(variable6.compareTo("")==0)
			{
				SumaVariablesYParentesis(variable1,variable2,variable3,variable4,variable5,variable6,escogido-1);
			}
			else
			{
				if(esParentesis(variable6))
				{
					variable6=lectorERunParentesis(variable6);
				}
				else if(variable6.substring(variable6.length()-1).compareTo("*")==0)
				{
					variable6=CleanSimple(variable6);
				}
				resultado=variable6;
			}
		}
		else if(escogido==5)
		{
			if(variable5.compareTo("")==0)
			{
				SumaVariablesYParentesis(variable1,variable2,variable3,variable4,variable5,variable6,escogido-1);
			}
			else
			{
				if(esParentesis(variable5))
				{
					variable5=lectorERunParentesis(variable5);
				}
				else if(variable5.substring(variable5.length()-1).compareTo("*")==0)
				{
					variable5=CleanSimple(variable5);
				}
				resultado=variable5;
			}
		}
		else if(escogido==4)
		{
			if(variable4.compareTo("")==0)
			{
				SumaVariablesYParentesis(variable1,variable2,variable3,variable4,variable5,variable6,escogido-1);
			}
			else
			{
				if(esParentesis(variable4))
				{
					variable4=lectorERunParentesis(variable4);
				}
				else if(variable4.substring(variable4.length()-1).compareTo("*")==0)
				{
					variable4=CleanSimple(variable4);
				}
				resultado=variable4;
			}
		}
		else if(escogido==3)
		{
			if(variable3.compareTo("")==0)
			{
				SumaVariablesYParentesis(variable1,variable2,variable3,variable4,variable5,variable6,escogido-1);
			}
			else
			{
				if(esParentesis(variable3))
				{
					variable3=lectorERunParentesis(variable3);
				}
				else if(variable3.substring(variable3.length()-1).compareTo("*")==0)
				{
					variable3=CleanSimple(variable3);
				}
				resultado=variable3;
			}
		}
		else if (escogido==2)
		{
			if(esParentesis(variable2))
			{
				variable2=lectorERunParentesis(variable2);
			}
			else if(variable2.substring(variable2.length()-1).compareTo("*")==0)
			{
				variable2=CleanSimple(variable2);
			}
			resultado=variable2;
		}
		else if (esco)
		return resultado;
	}
	public static boolean esParentesis(String variable)
	{
		boolean parentesis=false;
		if(variable.substring(0,1).compareTo("(")==0) {parentesis=true;}
		return parentesis;
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Calculadora 
{
	public static void main(String[]args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
       
        int optione;
        do {
		option();
		bw.write("\n");
		bw.flush();
		optione= Integer.parseInt(br.readLine());
		operation(optione, getParameters(optione));
        }while(optione!=0);
	}
	public static void option() throws IOException
    {//Addition, substraction, multiplication,division,residuo,factorial,exponentiation,sin,cos,integreted
       
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        bw.write("Seleccione alguna de las siguientes opciones: \n1. Suma\n2. Resta\n3. Multiplicacion"
        + "\n4. Division\n5. potencia\n6. Factorial\n7. cuadrado de dos numeros\n8. fibonacci"
        + "\n9. suma riemann\n10. ecuacion cuadratica\n11. serie taylor seno\n12. serie taylor coseno\n13. residuo \n14. salir");
        bw.flush();
    }
    
    public static int[] getParameters(int option) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        
        int[] parameters = null;
        
        switch(option){
            case 1: //Addition
            {
               parameters = new int [2]; 
               
               bw.write("A continuacion se va a realizar una suma\n");
               bw.flush();
               bw.write("Ingrese el primer numero: \n"); 
               bw.flush();
               parameters [0] = Integer.parseInt(br.readLine());
               bw.write("Ingrese el segundo numero: \n"); 
               bw.flush();
               parameters [1] = Integer.parseInt(br.readLine());
            }
            break;
            case 2: //Substraction
            {
                parameters = new int [2]; 
               
               bw.write("A continuacion se va a realizar una resta\n"); 
               bw.flush();
               bw.write("Ingrese el primer numero: \n"); 
               bw.flush();
               parameters [0] = Integer.parseInt(br.readLine());
               bw.write("Ingrese el segundo numero: \n"); 
               bw.flush();
               parameters [1] = Integer.parseInt(br.readLine());
                
            }
            break;
            case 3: //Multiplication
            {
                parameters = new int [2]; 
               
               bw.write("A continuacion se va a realizar una multiplicacion\n"); 
               
               bw.write("Ingrese el primer numero: \n"); 
               bw.flush();
               parameters [0] = Integer.parseInt(br.readLine());
               bw.write("Ingrese el segundo numero: \n"); 
               bw.flush();
               parameters [1] = Integer.parseInt(br.readLine());
                
            }
            break;
            case 4: //Division
            {
                parameters = new int [2]; 
               
               bw.write("A continuacion se va a realizar una division\n"); 
               bw.write("Ingrese el primer numero: \n"); 
               bw.flush();
               parameters [0] = Integer.parseInt(br.readLine());
               bw.write("Ingrese el segundo numero: \n"); 
               bw.flush();
               parameters [1] = Integer.parseInt(br.readLine());
            }
            break;
            case 5: //potencia
            {
               parameters = new int [2]; 
               
            bw.write("escriba su base \n");
   	        bw.flush();
   	        parameters[0]=Integer.parseInt(br.readLine());
   	        bw.write("escriba el exponente   \n");
   	        bw.flush();
   	        parameters[1]= Integer.parseInt(br.readLine());
   	       
            }
            break;
            case 6: //Factorial
            {
                parameters = new int [1]; 
               
               bw.write("A continuacion se va a realizar un factorial\n"); 
               bw.write("Ingrese el valor a calcular: \n"); 
               bw.flush();
               parameters [0] = Integer.parseInt(br.readLine());
               
            }
            break;
            case 7: //cadrado de dos numeros
            {
                parameters = new int [2]; 
               
                bw.write("escriba los numeros \n");
    	    	bw.flush();
    	    	bw.write("Ingrese el valor de x \n");
    	    	bw.flush();
    		    parameters[0]= Integer.parseInt(br.readLine());
    		    bw.write("Ingrese el valor de y  \n");
    		    bw.flush();
    		    parameters[1]= Integer.parseInt(br.readLine());
            }
            break;
         
            case 8: //fibonacci
            {
                parameters = new int [1]; 
               
               bw.write("A continuacion se va a realizar la sucesion fibonacci\n"); 
               bw.flush();
               bw.write("Ingrese el valor de las iteraciones a realizar: \n"); 
               bw.flush();
               parameters [0] = Integer.parseInt(br.readLine());
            }
            break;
            case 9: //suam de riemann
            {
                parameters = new int [3]; 
               
                System.out.println("escriba el valor de del punto de incio");
    	    	parameters[0]= Integer.parseInt(br.readLine());
    	    	System.out.println("escriba el valor de del punto final");
    	    	parameters[1]= Integer.parseInt(br.readLine());
    	    	System.out.println("escriba el valor de del incremento");
    	    	parameters[2]= Integer.parseInt(br.readLine());
    	    	
            }
            break;
            case 10: //ecuacion cuadratica
            {
                parameters = new int [3]; 

    	    		System.out.println("escriba el valor de x");
    	    		parameters [0]= Integer.parseInt(br.readLine());
    	 	        System.out.println("escriba el valor de y");
    	 	        parameters [1]= Integer.parseInt(br.readLine());
    	 	        System.out.println("escriba el valor de z");
    	 	        parameters [2]= Integer.parseInt(br.readLine());
    	 
            }
            break;
            case 11: //serie de taylor para seno
            {
                parameters = new int [2]; 
               
                bw.write("serie taylor para seno "+"\n");
    	        bw.flush();
    	        
    	        bw.write("¿cuantas iteraciones desea hacer?"+"\n");
    	        bw.flush();
    	        
    	        parameters[0] = Integer.parseInt(br.readLine());
    	        bw.write("¿Que valor va tener x?"+"\n");
    	        bw.flush();
    		    
    		    parameters[1] = Integer.parseInt(br.readLine());
    		    
            }
            break;
            case 12: //serie de taylor para coseno
            {
                parameters = new int [2]; 
               
                bw.write("serie taylor para coseno "+"\n");
                bw.flush();
	        
                bw.write("¿cuantas iteraciones desea hacer?"+"\n");
                bw.flush();
                parameters[0]= Integer.parseInt(br.readLine());
	        
                bw.write("¿Que valor va tener x?"+"\n");
                bw.flush();
		    
                parameters[1] = Integer.parseInt(br.readLine());
		    
            }
            break;
            case 13: //residuo
            {
                parameters = new int [2]; 
                
                bw.write("serie taylor para coseno "+"\n");
       	        bw.flush();
    	        
    	        bw.write("Ingrese el valor del primer numero"+"\n");
    	        bw.flush();
    	        parameters[0]= Integer.parseInt(br.readLine());
    	        
    	        bw.write("Ingrese el valor del segundo numero"+"\n");
    	        bw.flush();
    		    
    		    parameters[1] = Integer.parseInt(br.readLine());
            }
            break;
            default:
            {
                System.exit(0);
            }
        }
        
        return parameters;
        
    }
    
    
	

	public static void  operation(int option,int[]parameters) throws IOException 
	{
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		DecimalFormat df = new DecimalFormat("#0.00");
		 Operaciones operation= new Operaciones();
		switch(option)
		{
        case 1: //Addition
        {
        	bw.write("la suma de "+parameters[0]+" y "+parameters[1]+" es "+operation.suma(parameters[0], parameters[1]) + "\n");
	   	        bw.flush();
        }
        break;
        case 2: //Substraction
        {
        	bw.write("la resta de "+parameters[0]+" y "+parameters[1]+" es "+df.format(operation.resta(parameters[0], parameters[1])));
	   	        bw.flush();    
        }
        break;
        case 3: //Multiplication
        {
        	bw.write("la multiplicacion de "+parameters[0]+" y "+parameters[1]+" es "+df.format(operation.multiplicacion(parameters[0], parameters[1])));
	   	        bw.flush();
        }
        break;
        case 4: //Division
        {
        	if (parameters[1]== 0){
        		bw.write("la division  no se puede realizar \n" );
        		bw.flush();
        	}
        	else{
        	bw.write("la division de "+parameters[0]+" y "+parameters[1]+" es "+df.format(operation.division(parameters[0], parameters[1])));
	   	    bw.flush();
        	}
        }
        break;
        case 5: //potencia
        {
        	bw.write("la potencia de "+parameters[0]+" y "+parameters[1]+" es "+df.format(operation.potencia(parameters[0], parameters[1])));
	   	        bw.flush();
        }
        break;
        case 6: //Factorial
        {
        	
        	bw.write("el factorial de "+parameters[0]+" es "+df.format(operation.factorial_de_numero(parameters[0])));
	   	        bw.flush();
        }
        break;
        case 7: //cuadrado de dos numeros
        {
        	
        		bw.write("el cuadrado de "+parameters[0]+" y "+parameters[1]+" es "+operation.cuadrados(parameters[0], parameters[1])+"\n");
		        bw.flush();
        	
	   	        
        }
        break;
        
        case 8: //suma riemann
        {
        	bw.write("suma de rieman es: "+"\n"+operation.suma_riemann(parameters[0], parameters[1], parameters[2])+"\n");
			bw.flush();
        }
        break;
        case 9: //ecuacion cuadratia
        {
        	
 	 	        bw.write("el resultado de la funcion es "+operation.cuadratica(parameters[0],parameters[1],parameters[2])+"\n");

 		        bw.flush();
        }
        break;
        case 10: //serie de taylor seno
        {
        	double conversion = parameters[1]*3.141592/180.0;
        	bw.write("El seno de "+parameters[1]+" segun la serie de taylor es:"+(df.format(operation.serie_taylor_seno(parameters[0], conversion)))+"\n");
		    bw.flush();
        }
        break;
        case 11: //serie de taylor coseno
        {
        	double conversion = parameters[1]*3.141592/180.0;
		    bw.write("el coseno de "+parameters[1]+" segun la serie de taylor es:"+(df.format(operation.serie_taylor_seno(parameters[0], conversion)))+"\n");
		    bw.flush();
        }
        break;
        case 12: //residuo
        {
		    bw.write("el residuo de "+parameters[0]+" y "+parameters[1]+" es: "+(df.format(operation.residue(parameters[0],parameters[1])))+"\n");
		    bw.flush();
        }
        break;
        default:
        {
            System.exit(0);
        }
        
		}
	}
}	

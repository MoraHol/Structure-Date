import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Operaciones {
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public  int suma(int num1,int num2) {
		return num1 + num2;
	}
	public  int resta(int num1,int num2) {
		return num1-num2;
	}
	public int multiplicacion(int num1,int num2) {
		int result = 0;
		for(int i=0;i<num2;i++){
			 result= suma(result,(int) num1);
			
		}
		return result;
	}
	public  double division(double num1,double num2) {
		if (num2 != 0){
			return num1/num2;
		}
		else{
			return Double.NaN;
		}
	}
		 
		    /**
		     * este metodo permite la suma de los cuadrados de x
		     * @param x
		     * @param y
		     * @return seno claculado en el valor enviado como parametro
		     */
		   public  int cuadrados (int x, int y){
		       return (int)(Math.pow(x,2)+ Math.pow(y,2));
		   }
		   /**
		    * 
		    * @param x
		    * @param y
		    * @param z
		    * @return 
		    */
		 public  int cuadratica (int x, int y,int z){
		        return (4 * (int) Math.pow(x,2)) + (2 * y)+(2 * z);
		}
			public  double suma_riemann (int punto_inicial,int punto_final,int incremento){
				int x_i,x_i_1,y_i;
				double respuesta = 0.0, temp;
				
				x_i_1= punto_inicial;
				x_i= incremento+ x_i_1;
				
				for (int i=x_i;i <= punto_final;i += incremento){
					y_i= (x_i*x_i);
					temp = (y_i)*(x_i-x_i_1);
					respuesta += temp;
					
					x_i_1= x_i;
					x_i= incremento+ x_i_1;
					
				}	
				return respuesta;
		 
			}
			/**
			 * 
			 * @param numero   		//este parametro permite el ingreso del numero al cual se le halla el factorial;
			 * @param factorial   	//este parametro siempre va a ser 1;
			 * @return
			 */
			public static double factorial_de_numero(int numero) {
				double factorial=1;
				
				while(numero != 0) {
					factorial*= numero;
					numero --;
				}
				return factorial;	
			}
			
			public static int fibonnacci(int iteraciones) throws IOException {
				int n1 = 0,n2 = 1,suma;
				
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				bw.write(n1+"\n"+n2+"\n");
				bw.flush();
				for (int x=0;x<=iteraciones;x++) {
					suma=n1; 
					n1=n2;
					n2=suma+n1;
					bw.write(n2+"\n");
					bw.flush();
				}
				return n2;
			}
			
			public static double potencia(double x, int exponente) {
				double resultado=0;
				
				if (exponente == 0) {
					resultado = 1;
				}else if(exponente == 1) {
					resultado = x;
				}else if(exponente > 1) {
					resultado = Math.pow(x,exponente);
				}else if(exponente<0) {
					resultado = 1/Math.pow(x,exponente*(-1));
				}
				return resultado;
			}
			
			
				public static double serie_taylor_seno(int terminos, double x) {
					double signo=1,dividendo,divisor,seno = 0;
					int n;
					
					for(n=0;n <= terminos;n++) {
						dividendo= potencia(x, 2*n+1);
						divisor= factorial_de_numero(2*n+1);
					
					if(n%2==0) {
						signo = 1;
					}else {
						signo= -1;
					}
						seno += (dividendo/divisor)*signo;
					}
					return seno;
			}
				public  double serie_taylor_coseno(int terminos, double x){
					double signo=1,dividendo,divisor,coseno = 0;
					int n;
					
					for(n=0;n <= terminos;n++) {
						dividendo= potencia(x, 2*n);
						divisor= factorial_de_numero(2*n);
					
					if(n%2==0) {
						signo = 1;
					}else {
						signo= -1;
					}
						
						coseno += (dividendo/divisor)*signo;
					}	
						
					
					return coseno;
				}
				public int residue (int num1, int num2) {
					return num1 % num2;
				}
	}


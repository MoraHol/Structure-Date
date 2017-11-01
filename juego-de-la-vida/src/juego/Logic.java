package juego;

import java.util.Random;

import processing.core.PApplet;

public class Logic extends PApplet
{
	// creacion de objeto random
	static Random rd = new Random();
	
	// Cuán probable es que una célula esté viva al inicio (en porcentaje)
	static float probabilityOfAliveAtStart = 10;
	
	// tamaño de las celdas
	int cellSize = 10;

	// Variables para el temporizador
	int interval = 100;
	int lastRecordedTime = 0;

	// Colors para celdas vivas/muertas 
	int alive = color(200, 0, 0);
	int dead = color(0);

	static int size = 100;
	 // Buffer para registrar el estado de las celdas y usar esto mientras se cambian las demás en las interacciones
	static int [][] boardBuffer = new int [size][size];

	// Pausa
	boolean pause = false;
	
	//estado de la celda viva/muerta
	static int state ;
	
	static int[][] board = new  int [size][size];
	
	public static void main (String[] args) 
	{
		PApplet.main ( "juego.Logic" );
		
	}
	public void settings() {
		size (500, 500);
		noSmooth();
		
		
		
	}
	public void setup() {
		stroke(48);
		for (int i = 0; i <width / cellSize; i ++) 
		{
			for (int j = 0; j <height / cellSize; j ++) 
			{
				state = rd.nextInt(100);
				if (state > probabilityOfAliveAtStart) 
				{ 
					state = 0;
			    }
			    else 
			    {
			        state = 1;
			    }
			    board[i][j] = state; // guarda el estado de la celula
			}
		}
		background(0);
		
	}
	public void draw() {
		//dibujar las celdas
		for (int x=0; x<width/cellSize; x++) 
		{
			for (int y=0; y<height/cellSize; y++) 
			{
				if (board[x][y]==1) 
				{
					fill(alive); // If alive
				}
		      else 
		      {
		        fill(dead); // If dead
		      }
		      rect (x*cellSize, y*cellSize, cellSize, cellSize);
		    }
		 }
		 //Iterar si el temporizador marca
		 if (millis()-lastRecordedTime>interval) 
		 {
			 if (!pause) 
			 {
				 iteration();
			     lastRecordedTime = millis();
			 }
		}
		  
		// Crear nuevas celdas manualmente en pausa
		if (pause && mousePressed) 
		{
			// Mapa y evitar errores sin límite
		    int xCellOver = (int)(map(mouseX, 0, width, 0, width/cellSize));
		    xCellOver = constrain(xCellOver, 0, width/cellSize-1);
		    int yCellOver = (int)(map(mouseY, 0, height, 0, height/cellSize));
		    yCellOver = constrain(yCellOver, 0, height/cellSize-1);

		    // Verificar contra celdas en buffer
		    if (boardBuffer[xCellOver][yCellOver]==1) 
		    { 
		    	// Celda está viva
		    	board[xCellOver][yCellOver]=0; // matar
		    	fill(dead); // llenar con el color de las muertas
		    }
		    else 
		    { 
		    	// celda esta muerta
		    	board[xCellOver][yCellOver]=1; // revivir
		    	fill(alive); // llenar con el color de viva
		    }
		 } 
		 else if (pause && !mousePressed) 
		 { 
			 // Y luego guardar en el búfer una vez que el mouse sube
			 // Guarde las celdas en el buffer (para que operemos con una matriz manteniendo la otra intacta)
			 for (int x=0; x<width/cellSize; x++) 
			 {
				 for (int y=0; y<height/cellSize; y++) 
				 {
					 boardBuffer[x][y] = board[x][y];
				 }
			 }
		 }
		
	}
	void iteration() { // cuando el reloj marca
		  // Guarde las celdas en el buffer (para que operemos con una matriz manteniendo la otra intacta)
		for (int i=0; i <width/cellSize; i++) 
		{
			for (int j=0; j <height/cellSize; j++)
		    {
		      boardBuffer[i][j] = board[i][j];
		    }
		}	
		formaSimple();
		//notoroidal();
	}
	
	public void keyPressed() {
		if (key == 'r' || key == 'R') 
		{
			// Reiniciar: reinicialización de las celdas
			for (int i = 0; i <width / cellSize; i ++) 
			{
				for (int j = 0; j < height / cellSize; j ++) 
				{
					state = rd.nextInt(100);
					if (state > probabilityOfAliveAtStart) 
					{ 
						state = 0;
				    }
				    else 
				    {
				        state = 1;
				    }
				    board[i][j] = state; // guarda el estado de la celula
				}
			}
		    		
		    	
		    
		}
		if (key == ' ') 
		{ // Encendido / apagado de pausa
			pause = !pause;
		}
		if (key=='c' || key == 'C') 
		{ 
			// limpiar todo
			for (int x=0; x<width/cellSize; x++) 
			{
				for (int y=0; y<height/cellSize; y++) 
				{
					board[x][y] = 0; // poner todo en cero
					boardBuffer[x][y] = 0;
				}
		    }
		}
		
	}
	public static void notoroidal()
	{
		// vecindad
		//while(true)
		{
			int counter = 0;
			for (int i = 0; i < size;i++)
			{
				for (int j = 0; j < size;j++)
				{
					
					if(i < 1)
					{
						if(j < 1){
							counter = board [i][j+1]+ board [i+1][j]+ board [i+1][j+1];
						}
						else
						{
							if(j == size - 1 )
							{
								counter = board[i][j-1] + board[i+1][j-1] + board[i+1][j];
							}
							else
							{
								counter = board[i][j - 1] + board[i][j + 1] + board[i + 1][j - 1] + board[i+1][j] + board[i+ 1][j +1];
							}
						}
					}
					else 
					{
						if(i == size - 1) {
							if(j < 1) {
								counter = board [i-1][j] + board [i-1][j+1] + board [i][j+1];
							}
							else
							{
								if(j == size - 1) 
								{
									counter = board [i-1][j-1] + board [i-1][j] + board [i][j-1];
								}
								else
								{
									counter = board [i-1][j-1] + board [i-1][j] + board [i-1][j+1] + board [i][j-1] + board [i][j+1];
								}
							}
						}
						else
						{
							if(j < 1)
							{
								counter = board [i-1][j] + board [i-1][j+1] + board [i][j+1] + board [i+1][j] + board [i+1][j+1];
							}
							else
							{
								if ( j == size - 1) 
								{
									counter = board [i-1][j-1] + board [i-1][j] + board [i][j-1] + board [i+1][j-1] + board [i+1][j];
								}	
								else
								{
									counter = board [i-1][j-1] + board [i-1][j] + board [i-1][j+1]+ board [i][j-1] + board [i][j+1]+ board [i+1][j-1]+ board [i+1][j]+ board [i+1][j+1];
								}
							}
						}
					}
					if (boardBuffer [i][j] == 1)
					{
						if(counter < 2 || counter > 3)
							board [i][j] = 0;	
					}
					else
					{
						if (counter == 3)
						{
							board [i][j] = 1;
						}
					}							
				}
			}
		}
	}
	public static void formaSimple () 
	{
		//vecindad de forma rapida y con mudulo
		int counter = 0;
		int n = size-1;
		for (int i = 0; i < size;i++)
		{
			for (int j = 0; j < size;j++)
			{
				counter = board [(i-1+n)%n][(j-1+n)%n] + board [(i-1+n)%n][j] + board [(i-1+n)%n][(j+1)%n]+ board [i][(j-1+n)%n] + board [i][(j+1)%n]+ board [(i+1)%n][(j-1+n)%n]+ board [(i+1)%n][j]+ board [(i+1)%n][(j+1)%n];
				
				if (boardBuffer [i][j] == 1)
				{
					if(counter < 2 || counter > 3)
						board [i][j] = 0;	
				}
				else 
				{
					if (counter == 3)
					{
						board [i][j] = 1;
					}
				}
			}
		}
	}
}

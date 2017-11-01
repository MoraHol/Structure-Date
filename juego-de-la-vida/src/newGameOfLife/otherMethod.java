package newGameOfLife;

import java.util.Random;

import processing.core.PApplet;

public class otherMethod extends PApplet
{
	// creacion de objeto random
	static Random rd = new Random();
	
	// Cuán probable es que una célula esté viva al inicio (en porcentaje)
	static float probabilityOfAliveAtStart = 15;
	
	static // tamaño de las celdas
	int cellSize = 5;

	// Variables para el temporizador
	int interval = 100;
	int lastRecordedTime = 0;

	// Colors para celdas vivas/muertas 
	int alive = color(60, 10, 200);
	int dead = color(0);

	
	// Buffer para registrar el estado de las celdas y usar esto mientras se cambian las demás en las interacciones
	int [][] boardBuffer; 
	
	// Pausa
	boolean pause = false;
	
	//estado de la celda viva/muerta
	static float state ;
	//contine la matriz del tablero
	int[][] board; 
	
	public static void main (String[] args) 
	{
		
		PApplet.main ( "newGameOfLife.otherMethod" );
		
	}
	public void settings() {
		size (640, 360);
		noSmooth();
		
		
		
	}
	public void setup() 
	{
		board = new  int [width / cellSize][height / cellSize];
		boardBuffer = new int [width / cellSize][ height/ cellSize];
		stroke(48);
		for (int i = 0; i < width / cellSize ; i ++) 
		{
			for (int j = 0; j < height / cellSize ; j ++) 
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
			    board[i][j] = (int)(state); // guarda el estado de la celula
			}
		}
		background(0);
		
	}
	public void draw() {
		//dibujar las celdas
		for (int x=0; x < width /cellSize ; x++) 
		{
			for (int y=0; y < height/cellSize; y++) 
			{
				if (board[x][y] == 1) 
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
			 for (int x=0; x<width /cellSize; x++) 
			 {
				 for (int y=0; y< height /cellSize; y++) 
				 {
					 boardBuffer[x][y] = board[x][y];
				 }
			 }
		 }
		
	}
	void iteration() { // cuando el reloj marca
		  // Guarde las celdas en el buffer (para que operemos con una matriz manteniendo la otra intacta)
		for (int i=0; i < width /cellSize; i++) 
		{
			for (int j=0; j <height /cellSize; j++)
		    {
		      boardBuffer[i][j] = board[i][j];
		    }
		}	
		//formaSimple();
		notoroidal();
		//otraforma();
	}
	
	public void keyPressed() {
		if (key == 'r' || key == 'R') 
		{
			// Reiniciar: reinicialización de las celdas
			for (int i = 0; i <width  / cellSize; i ++) 
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
				    board[i][j] = (int)(state); // guarda el estado de la celula
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
				}
		    }
		}
		
	}
	public  void notoroidal()
	{
		// vecindad
		//while(true)
		{
			int counter = 0;
			for (int i = 0; i < width / cellSize;i++)
			{
				for (int j = 0; j < height / cellSize;j++)
				{
					
					if(i < 1)
					{
						if(j < 1){
							counter = board [i][j+1]+ board [i+1][j]+ board [i+1][j+1];
						}
						else
						{
							if(j == ( height/ cellSize)-1 )
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
						if(i == (width / cellSize)-1) 
						{
							if(j < 1) 
							{
								counter = board [i-1][j] + board [i-1][j+1] + board [i][j+1];
							}
							else
							{
								if(j == (height / cellSize)-1) 
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
								if ( j ==  (height / cellSize)-1) 
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
	public void formaSimple () 
	{
		//vecindad de forma rapida y con mudulo
		int counter = 0;
		int n = (height / cellSize)-1;
		int n1 = (width / cellSize)-1; 
		for (int i = 0; i < width / cellSize;i++)
		{
			for (int j = 0; j < height / cellSize;j++)
			{
				counter = board [(i-1+n1)%n1][(j-1+n)%n] + board [(i-1+n1)%n1][j] + board [(i-1+n1)%n1][(j+1)%n]+ board [i][(j-1+n)%n] + board [i][(j+1)%n]+ board [(i+1)%n1][(j-1+n)%n]+ board [(i+1)%n1][j]+ board [(i+1)%n1][(j+1)%n];
				
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
	public void otraforma() {
		// Visit each cell:
		  for (int x=0; x<width/cellSize; x++) {
		    for (int y=0; y<height/cellSize; y++) {
		      // And visit all the neighbours of each cell
		      int neighbours = 0; // We'll count the neighbours
		      for (int xx=x-1; xx<=x+1;xx++) {
		        for (int yy=y-1; yy<=y+1;yy++) {  
		          if (((xx>=0)&&(xx<width/cellSize))&&((yy>=0)&&(yy<height/cellSize))) { // Make sure you are not out of bounds
		            if (!((xx==x)&&(yy==y))) { // Make sure to to check against self
		              if (boardBuffer[xx][yy]==1){
		                neighbours ++; // Check alive neighbours and count them
		              }
		            } // End of if
		          } // End of if
		        } // End of yy loop
		      } //End of xx loop
		      // We've checked the neigbours: apply rules!
		      if (boardBuffer[x][y]==1) { // The cell is alive: kill it if necessary
		        if (neighbours < 2 || neighbours > 3) {
		          board[x][y] = 0; // Die unless it has 2 or 3 neighbours
		        }
		      } 
		      else { // The cell is dead: make it live if necessary      
		        if (neighbours == 3 ) {
		          board[x][y] = 1; // Only if it has 3 neighbours
		        }
		      } // End of if
		    } // End of y loop
		  } // End of x loop
		} // End of function
	
}


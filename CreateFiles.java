import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateFiles {

	public static void main(String[] args) throws IOException  
	{
		// TODO Auto-generated method stub
		CreateFiles cf = new CreateFiles();
		System.out.println(cf.countReads("T"));
	}
	/**
	 * 
	 */
	public  CreateFiles() 
	{
		int start, length;
		String sequence;
		Random rd = new Random();
		int lines = 1000;
		try {
		BufferedWriter bw = new BufferedWriter( new FileWriter("secuencias.umd"));
		for(int z = 0; z < lines; z++){
			start = Math.abs(rd.nextInt());
			length = 5 + rd.nextInt(25);
			
			 sequence = "";
			 
			 for(int j = 0; j < length; j++){
				 switch(rd.nextInt(4))
				 {
				 case 0:
					 sequence += "A";
					 break;
				 case 1: 
					 sequence += "C";
					 break;
				 case 2: 
					 sequence += "G";
					 break;
				 case 3: 
					 sequence += "T";
					 break;
				 }
			 }
			 bw.write(start + "," + ( start + length )+ "," + sequence + "\n");
		}
		bw.flush();
	}
	catch (IOException e)
		{
		e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param motif
	 * @return lines //returns the number of lines in which the motif is repeated
	 * @throws IOException
	 */
	public int countReads(String motif) throws IOException 
	{
		
		BufferedReader br = new BufferedReader( new FileReader("secuencias.umd"));
		
		
		String read;
		int lines = 0;
		read = br.readLine();// fist line
		while (read != null)
		{
			if ( read.split (",") [2].contains( motif ) )
			{
				lines+= 1;
			}
			read= br.readLine();
		}
		return lines;
	}		
}
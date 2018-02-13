package POO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class palindrome {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String word = "";
		int start = 0;
		int end= 0;
		boolean change = false;
		BufferedReader rd = new BufferedReader (new InputStreamReader(System.in));
		word = JOptionPane.showInputDialog(null, "Digite la palabra que quiere comprobar:");
		end = word.length()-1;
		
		while ((start<end) && (!change)){
			 
			if (word.charAt(start)== word.charAt(end)){				
				start++;
				end--;
			} else {
				change = true;
			}
		}
		
		if (!change)
			JOptionPane.showMessageDialog(null, word + " es un palindromo");
		else
			JOptionPane.showMessageDialog(null,word + " no es un palindromo");
		
	}

}

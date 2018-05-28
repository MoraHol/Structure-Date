package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad Minuto de Dios (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas
 * 
 * clase para mostrar im�genes de numeros
 * 
 * Ejercicio: Puzzle
 * 
 * @author Alexis Holguin
 * @since Mayo 20, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Imagen4 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3928962661025159963L;
	public Imagen4() {
		setSize(200,200);
	}
	// Se crea un m�todo cuyo par�metro debe ser un objeto Graphics
		public void paint(Graphics grafico) {
			Dimension height = getSize();

			// Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

			//ImageIcon Img = new ImageIcon(getClass().getResource("src/Images/muro_laberinto.png"));
			ImageIcon img = new ImageIcon("src/images/4.png");

			// se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

			grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);

			setOpaque(false);
			super.paintComponent(grafico);
		}
}

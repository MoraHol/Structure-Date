package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Imagen17 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8229256423116040302L;
	public Imagen17() {
		setSize(200,200);
	}
	// Se crea un método cuyo parámetro debe ser un objeto Graphics
		public void paint(Graphics grafico) {
			Dimension height = getSize();

			// Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

			//ImageIcon Img = new ImageIcon(getClass().getResource("src/Images/muro_laberinto.png"));
			ImageIcon img = new ImageIcon("src/images/17.png");

			// se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

			grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);

			setOpaque(false);
			super.paintComponent(grafico);
		}
}

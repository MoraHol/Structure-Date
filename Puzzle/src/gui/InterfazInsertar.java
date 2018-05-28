package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
// TODO: Auto-generated Javadoc

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Universidad Minuto de Dios (Bogotá - Colombia) Departamento de
 * Ingeniería de Sistemas
 * 
 * clase para mostrar interfaz que permitirá insertar la matriz por pantalla al
 * usuario
 * 
 * Ejercicio: Puzzle.
 *
 * @author Alexis Holguin
 * @since Mayo 20, 2018
 *        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class InterfazInsertar extends JFrame implements ActionListener {

	/** comando para insertar matriz por pantalla. */
	private static final String INSERTAR = "insertar";

	/** Arraylist para almacenar los JtextFields creados. */
	private ArrayList<JTextField> textFields;

	/** tamaño del puzzle. */
	private int n;

	/** atributo que conecta con la Interfaz Principal. */
	private InterfazPuzzle principal;

	/**
	 * generar ventana de un determinado tamaño de JTextFields para mostrarlos por
	 * pantalla.
	 *
	 * @param n
	 *            tamaño del puzzle
	 * @param principal
	 *            ventana principal del programa
	 */
	public InterfazInsertar(int n, InterfazPuzzle principal) {
		this.principal = principal;
		this.n = n;
		setResizable(false);
		setLocation(0, 0);
		setSize(400, 400);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setActionCommand(INSERTAR);
		btnInsertar.addActionListener(this);
		panel.add(btnInsertar);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		textFields = new ArrayList<>();
		panel_1.setLayout(new GridLayout(n, n));
		for (int i = 0; i < n * n; i++) {
			textFields.add(new JTextField());
			panel_1.add(textFields.get(i));
		}
	}

	/**
	 * generar una matriz a partir de los ingresado por pantalla.
	 *
	 * @return the int[][]
	 */
	private int[][] Insertar() {
		try {
			int[][] array = new int[n][n];
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					array[i][j] = Integer.parseInt(textFields.get(count).getText());
					count++;
				}
			}
			return array;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "faltan llenar posiciones");
			return null;
		}
	}

	/*
	 * (sin Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals(INSERTAR)) {
			int[][] matriz = Insertar();
			if (matriz != null) {
				principal.insertar(matriz);
				this.setVisible(false);
			}
		}

	}

}

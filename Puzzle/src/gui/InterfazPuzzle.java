package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import java.awt.Font;
import Puzzle.Puzzle2;
import javax.swing.JButton;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad Minuto de Dios (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas
 * 
 * clase que maneja toda la parte gráfica del puzzle
 * 
 * Ejercicio: Puzzle
 * 
 * @author Alexis Holguin
 * @since Mayo 20, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class InterfazPuzzle extends JFrame implements ActionListener {
	// -----------------------------------------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------------------------------------
	private static final long serialVersionUID = -4443378289133988492L;
	/**
	 * atributo para manejar la parte lógica del puzzle
	 */
	private Puzzle2 puzzle;
	/**
	 * tamaño del puzzle
	 */
	private int n;
	/**
	 * comando para generar randomicamente
	 */
	private static final String GENERAR_PROBLEMA = "generar problema";
	/**
	 * comando para mostrar en la interfaz el puzzle ordenado
	 */
	private static final String GENERAR = "generar puzzle";
	/**
	 * comando para mostrar el siguiente paso en la interfaz
	 */
	private static final String NEXTSTEP = "siguiente paso";
	/**
	 * comando para generar la solución de un puzzle problema dado
	 */
	private static final String GENERAR_SOLUCION = "generar solucion";
	/**
	 * comando para insertar un puzzle especifico ingresad por la interfaz
	 */
	private static final String INSERTAR_PUZZLE = "insertar";
	/**
	 * comboBox para escoger el tamaño del puzzle
	 */
	private JComboBox<String> comboBoxTamaño;
	/**
	 * panel para ingresar los paneles correspondientes para la creación del puzzle
	 */
	private JPanel panelPuzzle;
	/**
	 * Muestra en la interfaz el numero de movimientos necesarios para resolver un
	 * puzzle indicado
	 */
	private JLabel Movimientos;
	/**
	 * bandera para saber si ya ha sido generado una solución a un determinado
	 * puzzle
	 */
	private boolean flag;

	// -----------------------------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------------------------
	public InterfazPuzzle() {
		setSize(700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		setLocationRelativeTo(null);
		JLabel LabelTamaño = new JLabel("Tama\u00F1o");
		panel.add(LabelTamaño);

		comboBoxTamaño = new JComboBox<String>();
		comboBoxTamaño.setModel(new DefaultComboBoxModel<String>(new String[] { "", "3x3", "4x4", "5x5", "6x6" }));
		comboBoxTamaño.setActionCommand(GENERAR);
		comboBoxTamaño.addActionListener(this);
		panel.add(comboBoxTamaño);

		panel.add(new JLabel(""));

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setActionCommand(GENERAR_PROBLEMA);
		btnGenerar.addActionListener(this);
		panel.add(btnGenerar);

		panel.add(new JLabel(""));

		JButton btnInsertarPuzzleEspecifico = new JButton("Insertar Puzzle Especifico");
		btnInsertarPuzzleEspecifico.setActionCommand(INSERTAR_PUZZLE);
		btnInsertarPuzzleEspecifico.addActionListener(this);
		panel.add(btnInsertarPuzzleEspecifico);

		JButton btnGenerarSolucion = new JButton("Generar Solucion");
		panel.add(btnGenerarSolucion);
		btnGenerarSolucion.setActionCommand(GENERAR_SOLUCION);
		btnGenerarSolucion.addActionListener(this);

		JButton btnSiguientePaso = new JButton("Siguiente paso");
		btnSiguientePaso.setActionCommand(NEXTSTEP);
		btnSiguientePaso.addActionListener(this);
		panel.add(btnSiguientePaso);

		panelPuzzle = new JPanel();
		getContentPane().add(panelPuzzle, BorderLayout.CENTER);
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		panel_2.add(new JLabel(""));
		panel_2.add(new JLabel(""));
		panel_2.add(new JLabel(""));
		panel_2.add(new JLabel(""));

		JLabel LabelMovimientos = new JLabel("movimientos:");
		LabelMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(LabelMovimientos);

		Movimientos = new JLabel("0");
		panel_2.add(Movimientos);

	}

	// -----------------------------------------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------------------------------------
	/**
	 * generará un puzzle desordenado
	 */
	private void generarProblema() {
		try {
			puzzle = new Puzzle2(n);
			panelPuzzle.removeAll();
			cicloGenerador(n, puzzle.getProblema());
			Movimientos.setText("0");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor seleccione tamaño");
		}
	}

	/**
	 * generará la solución a un puzzle determinado
	 */
	private void generarSolucion() {
		try {
			if (flag) {
				puzzle.generarSolucion();
				Movimientos.setText(Integer.toString(puzzle.getMovimientos()));
				JOptionPane.showMessageDialog(null, "Se ha generardo la solucion");
			} else {
				JOptionPane.showMessageDialog(null, "Ya se ha generado una solcuión para este puzzle", "Puzzle",
						JOptionPane.WARNING_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Primero deber generar el puzzle", "Puzzle", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * se generara un una interfaz para insertar un puzzle especifico
	 */
	private void insertarPuzzle() {
		try {
			InterfazInsertar interfazInsertar = new InterfazInsertar(n, this);
			interfazInsertar.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor seleccione tamaño");
		}
	}

	/**
	 * genera un puzzle insertado por pantalla y lo mostrara por pantalla
	 * 
	 * @param matriz
	 *            matriz insertada por interfaz
	 */
	public void insertar(int[][] matriz) {
		puzzle = new Puzzle2(matriz, n);
		panelPuzzle.removeAll();
		flag = true;
		cicloGenerador(n, puzzle.getProblema());
	}

	/**
	 * genera un puzzle ordenado al escoger un tamaño en el comoboBox
	 */
	private void generarPuzzle() {
		puzzle = null;
		panelPuzzle.removeAll();
		if (comboBoxTamaño.getSelectedItem().equals("3x3")) {
			n = 3;
			int[][] solucion = Puzzle2.MakeSolution(n);
			cicloGenerador(n, solucion);
			Movimientos.setText("0");
		} else if (comboBoxTamaño.getSelectedItem().equals("4x4")) {
			n = 4;
			int[][] solucion = Puzzle2.MakeSolution(n);
			cicloGenerador(n, solucion);
			Movimientos.setText("0");
		} else if (comboBoxTamaño.getSelectedItem().equals("5x5")) {
			n = 5;
			int[][] solucion = Puzzle2.MakeSolution(n);
			cicloGenerador(n, solucion);
			Movimientos.setText("0");
		} else if (comboBoxTamaño.getSelectedItem().equals("6x6")) {
			n = 6;
			int[][] solucion = Puzzle2.MakeSolution(n);
			cicloGenerador(n, solucion);
			Movimientos.setText("0");
		}
	}

	/**
	 * muestra el pantalla el puzzle
	 * 
	 * @param n
	 *            tamaño del puzzle
	 * @param matriz
	 *            puzzle a mostrar
	 */
	private void cicloGenerador(int n, int[][] matriz) {
		panelPuzzle.setLayout(new GridLayout(n, n));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matriz[i][j] == 0) {
					panelPuzzle.add(new ImagenVacio());
				} else if (matriz[i][j] == 1) {
					panelPuzzle.add(new Imagen1());
				} else if (matriz[i][j] == 2) {
					panelPuzzle.add(new Imagen2());
				} else if (matriz[i][j] == 3) {
					panelPuzzle.add(new Imagen3());
				} else if (matriz[i][j] == 4) {
					panelPuzzle.add(new Imagen4());
				} else if (matriz[i][j] == 5) {
					panelPuzzle.add(new Imagen5());
				} else if (matriz[i][j] == 6) {
					panelPuzzle.add(new Imagen6());
				} else if (matriz[i][j] == 7) {
					panelPuzzle.add(new Imagen7());
				} else if (matriz[i][j] == 8) {
					panelPuzzle.add(new Imagen8());
				} else if (matriz[i][j] == 9) {
					panelPuzzle.add(new Imagen9());
				} else if (matriz[i][j] == 10) {
					panelPuzzle.add(new Imagen10());
				} else if (matriz[i][j] == 11) {
					panelPuzzle.add(new Imagen11());
				} else if (matriz[i][j] == 12) {
					panelPuzzle.add(new Imagen12());
				} else if (matriz[i][j] == 13) {
					panelPuzzle.add(new Imagen13());
				} else if (matriz[i][j] == 14) {
					panelPuzzle.add(new Imagen14());
				} else if (matriz[i][j] == 15) {
					panelPuzzle.add(new Imagen15());
				} else if (matriz[i][j] == 16) {
					panelPuzzle.add(new Imagen16());
				} else if (matriz[i][j] == 17) {
					panelPuzzle.add(new Imagen17());
				} else if (matriz[i][j] == 18) {
					panelPuzzle.add(new Imagen18());
				} else if (matriz[i][j] == 19) {
					panelPuzzle.add(new Imagen19());
				} else if (matriz[i][j] == 20) {
					panelPuzzle.add(new Imagen20());
				} else if (matriz[i][j] == 21) {
					panelPuzzle.add(new Imagen21());
				} else if (matriz[i][j] == 22) {
					panelPuzzle.add(new Imagen22());
				} else if (matriz[i][j] == 23) {
					panelPuzzle.add(new Imagen23());
				} else if (matriz[i][j] == 24) {
					panelPuzzle.add(new Imagen24());
				} else if (matriz[i][j] == 25) {
					panelPuzzle.add(new Imagen25());
				} else if (matriz[i][j] == 26) {
					panelPuzzle.add(new Imagen26());
				} else if (matriz[i][j] == 27) {
					panelPuzzle.add(new Imagen27());
				} else if (matriz[i][j] == 28) {
					panelPuzzle.add(new Imagen28());
				} else if (matriz[i][j] == 29) {
					panelPuzzle.add(new Imagen29());
				} else if (matriz[i][j] == 30) {
					panelPuzzle.add(new Imagen30());
				} else if (matriz[i][j] == 31) {
					panelPuzzle.add(new Imagen31());
				} else if (matriz[i][j] == 32) {
					panelPuzzle.add(new Imagen32());
				} else if (matriz[i][j] == 33) {
					panelPuzzle.add(new Imagen33());
				} else if (matriz[i][j] == 34) {
					panelPuzzle.add(new Imagen34());
				} else if (matriz[i][j] == 35) {
					panelPuzzle.add(new Imagen35());
				}

				panelPuzzle.updateUI();
			}
		}
	}

	/**
	 * muestra en pantalla el siguiente paso para llegar a solución
	 */
	private void siguientePaso() {
		panelPuzzle.removeAll();
		int[][] paso = puzzle.getPasos().pop().getInfo();
		panelPuzzle.setLayout(new GridLayout(n, n));
		cicloGenerador(n, paso);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		// generara un puzzle ordenado
		if (comando.equals(GENERAR)) {
			generarPuzzle();
			flag = true;
		}
		if (comando.equals(NEXTSTEP)) {
			try {
				if (!puzzle.getPasos().isEmpty()) {
					flag = false;
					siguientePaso();
				} else {
					puzzle = null;
					flag = true;
					if (JOptionPane.showConfirmDialog(this, "ya esta soluciondo el puzzle ¿Desea generar otro?",
							"Puzzle", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						generarProblema();
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Genere primero la solucion", "Puzzle", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (comando.equals(GENERAR_PROBLEMA)) {
			generarProblema();
		}
		if (comando.equals(GENERAR_SOLUCION)) {
			generarSolucion();
		}
		if (comando.equals(INSERTAR_PUZZLE)) {
			insertarPuzzle();
		}
	}

}

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

public class InterfazPuzzle extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4443378289133988492L;
	private Puzzle2 puzzle;
	private int n;
	private static final String GENERAR_PROBLEMA = "generar problema";
	private static final String GENERAR = "generar puzzle";
	private static final String NEXTSTEP = "siguiente paso";
	private JComboBox<String> comboBoxTamaño;
	private JPanel panelPuzzle;
	private JLabel Movimientos;

	public InterfazPuzzle() {
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

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
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));

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

	private void generarProblema() {
		try {
			puzzle = new Puzzle2(n);
			panelPuzzle.removeAll();
			panelPuzzle.setLayout(new GridLayout(n, n));
			cicloGenerador(n, puzzle.getProblema());
			Movimientos.setText(Integer.toString(puzzle.getMovimientos()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor seleccione tamaño");
		}
	}

	private void generarPuzzle() {
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

	public static void main(String[] args) {
		InterfazPuzzle puzzle = new InterfazPuzzle();
		puzzle.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		// generara un puzzle ordenado
		if (comando.equals(GENERAR)) {
			generarPuzzle();
		}
		if (comando.equals(NEXTSTEP)) {
			try {
				if (!puzzle.getPasos().isEmpty()) {
					siguientePaso();
				} else {
					if (JOptionPane.showConfirmDialog(this, "ya esta soluciondo el puzzle ¿Desea generar otro?",
							"Puzzle", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						generarProblema();
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Genere primero el Puzzle");
			}
		}
		if (comando.equals(GENERAR_PROBLEMA)) {
			generarProblema();
		}
	}

	private void siguientePaso() {
		panelPuzzle.removeAll();
		int[][] paso = puzzle.getPasos().pop().getInfo();
		panelPuzzle.setLayout(new GridLayout(n, n));
		cicloGenerador(n, paso);
	}
}

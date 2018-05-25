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

public class InterfazInsertar extends JFrame implements ActionListener {
	private static final String INSERTAR = "insertar";
	private ArrayList<JTextField> textFields;
	private int n;
	private InterfazPuzzle principal;
	public InterfazInsertar(int n,InterfazPuzzle principal) {
		this.principal = principal;
		this.n = n;
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(400,400);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setActionCommand(INSERTAR);
		btnInsertar.addActionListener(this);
		panel.add(btnInsertar);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		textFields = new ArrayList<>();
		panel_1.setLayout(new GridLayout(n,n));
		for (int i = 0; i < n*n; i++) {
			textFields.add(new JTextField());
			panel_1.add(textFields.get(i));
		}
	}
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
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "faltan llenar posiciones");
			return null;
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if(comando.equals(INSERTAR)) {
			int[][] matriz = Insertar();
			if (matriz != null) {
				principal.insertar(matriz);
				this.setVisible(false);
			}
		}

	}

}

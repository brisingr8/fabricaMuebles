package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import fabricaDeMuebles.Gestionar;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * FABRICA DE MUEBLES
 * 
 * @author alvaro
 * @version 1.0
 */

public class Principal {

	JFrame frame;

//	private JFileChooser fileChooser = new JFileChooser();
//	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");

	/**
	 * 
	 * @param args
	 *            argumentos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("F�brica de muebles IES Gran Capit�n");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
//		fileChooser.setFileFilter(filtro);

		AltaMueble alta = new AltaMueble();
		MostrarMueble mostrar = new MostrarMueble();
		MostrarTienda mostrarTienda = new MostrarTienda();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 444, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevaTienda = new JMenuItem("Nueva tienda");
		mntmNuevaTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mntmNuevaTienda
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmNuevaTienda);

		JMenuItem mntmAbrirTienda = new JMenuItem("Abrir tienda...");
		mntmAbrirTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnArchivo.add(mntmAbrirTienda);

		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnMueble = new JMenu("Mueble");
		mnMueble.setMnemonic('M');
		menuBar.add(mnMueble);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				alta.reset();
				alta.setVisible(true);
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnMueble.add(mntmAlta);

		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnMueble.add(mntmBaja);

		JMenuItem menuModificar = new JMenuItem("Modificar");
		menuModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		JSeparator separator_3 = new JSeparator();
		mnMueble.add(separator_3);
		mnMueble.add(menuModificar);

		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.setMnemonic('M');
		menuBar.add(mnMostrar);

		JMenuItem menuItemMostrarMueble = new JMenuItem("Mostrar mueble");
		menuItemMostrarMueble.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		menuItemMostrarMueble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar.setVisible(true);
			}
		});
		mnMostrar.add(menuItemMostrarMueble);

		JMenuItem menuItemTienda = new JMenuItem("Mostrar tienda");
		menuItemTienda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuItemTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTienda(mostrarTienda);
			}
			
			private void mostrarTienda(MostrarTienda mostrarTienda) {
				if (Gestionar.getTienda().size() == 0) {
					JOptionPane.showMessageDialog(mostrarTienda.getContentPane(), "Tienda vac�a ",
							"Tienda vac�a", JOptionPane.INFORMATION_MESSAGE);
				} else {
					mostrarTienda.refrescar(Gestionar.getTienda().get(0));
					// mostrarConcesionario.refrescarBotones();
					mostrarTienda.setVisible(true);
				}
			}
		});
		mnMostrar.add(menuItemTienda);

		JMenuItem menuItemMostrarTipo = new JMenuItem("Mostrar tienda por tipo");
		menuItemMostrarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnMostrar.add(menuItemMostrarTipo);

		JSeparator separator_2 = new JSeparator();
		mnMostrar.add(separator_2);

		JMenuItem menuItemTamanoTienda = new JMenuItem("Mostrar tama�o tienda");
		menuItemTamanoTienda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		menuItemTamanoTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTamano();
			}

			/**
			 * METODO PARA MOSTRAR TAMA�O DE LA TIENDA
			 */
			private void mostrarTamano() {
				if (Gestionar.getTienda().size() == 0) {
					JOptionPane.showMessageDialog(null, "Tienda vac�a ",
							"Tienda vac�a", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"N�mero de muebles: " + Gestionar.getTienda().size(), "Tama�o tienda",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mnMostrar.add(menuItemTamanoTienda);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('Y');
		menuBar.add(mnAyuda);

		JMenuItem mntmJavadoc = new JMenuItem("Javadoc");
		mntmJavadoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnAyuda.add(mntmJavadoc);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/principal.jpg")));
		lblNewLabel.setBounds(10, 32, 424, 228);
		frame.getContentPane().add(lblNewLabel);
	}
}

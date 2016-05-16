package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import fabricaDeMuebles.Fichero;
import fabricaDeMuebles.Gestionar;
import fabricaDeMuebles.Tienda;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 * FABRICA DE MUEBLES
 * 
 * @author alvaro
 * @version 1.0
 */

public class Principal {

	JFrame frame;
	
	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");

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
		frame.setTitle("Fábrica de muebles IES Gran Capitán");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		fileChooser.setFileFilter(filtro);

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
				comprobarCambios();
				Gestionar.setTienda(new Tienda());
				Gestionar.setFile(new File("Sin título"));
				Gestionar.setModificado(false);
				frame.setTitle(Gestionar.getFile().getPath());
			}
		});
		mntmNuevaTienda
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmNuevaTienda);

		JMenuItem mntmAbrirTienda = new JMenuItem("Abrir tienda...");
		mntmAbrirTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mnArchivo.add(mntmAbrirTienda);

		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
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
					JOptionPane.showMessageDialog(mostrarTienda.getContentPane(), "Tienda vacía ",
							"Tienda vacía", JOptionPane.INFORMATION_MESSAGE);
				} else {
					mostrarTienda.refrescar(Gestionar.getTienda().get(0));
					// mostrarTienda.refrescarBotones();
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

		JMenuItem menuItemTamanoTienda = new JMenuItem("Mostrar tamaño tienda");
		menuItemTamanoTienda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		menuItemTamanoTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTamano();
			}

			/**
			 * METODO PARA MOSTRAR TAMAÑO DE LA TIENDA
			 */
			private void mostrarTamano() {
				if (Gestionar.getTienda().size() == 0) {
					JOptionPane.showMessageDialog(null, "Tienda vacía ",
							"Tienda vacía", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"Número de muebles: " + Gestionar.getTienda().size(), "Tamaño tienda",
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
	
	private void comprobarCambios() {
		if (Gestionar.modificado()) {
			switch (JOptionPane.showOptionDialog(frame.getContentPane(), "Tienda modificada. ¿Guardar cambios?",
					"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null)) {
			case JOptionPane.YES_OPTION:
				guardar();
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		}
	}
	
	private void abrir() {
		comprobarCambios();
		int seleccion = fileChooser.showOpenDialog(frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				Gestionar.setTienda(Fichero.abrir(file));
				Gestionar.setFile(file);
				frame.setTitle(Gestionar.getFile().getPath());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Fichero no contiene tiendas.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "No se puede abrir el fichero.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void guardarComo() {
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				if (Fichero.existe(file)) {
					switch (JOptionPane.showOptionDialog(frame.getContentPane(),
							"El fichero ya existe. ¿Desea sobreescribirlo?", "Confirmar", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null)) {
					case JOptionPane.NO_OPTION:
						return;
					case JOptionPane.YES_OPTION:
						rutina(file);
						return;
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "El sistema no puede guardar el fichero.",
						"Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void guardar() {
		if (Gestionar.getFile().getName().equals("Sin título")) {
			guardarComo();
		} else {
			try {
				File file = fileChooser.getSelectedFile();
				rutina(file);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "El sistema no puede guardar el fichero.",
						"Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void rutina(File file) throws IOException {
		Fichero.guardar(file, Gestionar.getTienda());
		Gestionar.setModificado(false);
		Gestionar.setFile(file);
		frame.setTitle(Gestionar.getFile().getPath());
	}
}

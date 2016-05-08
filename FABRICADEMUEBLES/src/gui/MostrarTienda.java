package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fabricaDeMuebles.Gestionar;
import fabricaDeMuebles.Mueble;
import fabricaDeMuebles.Tienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarTienda extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	void refrescar(Mueble mueble) {
		textFieldID.setText(mueble.getID());
		textFieldTipo.setText(String.valueOf(mueble.getTipo()));
		textFieldMaterial.setText(String.valueOf(mueble.getMaterial()));
		refrescarBotones(Gestionar.getTienda(), Gestionar.getTienda().index(mueble));
	}

	private void refrescarBotones(Tienda tienda, int index) {
		if (index == 0) {
			buttonAtras.setEnabled(false);
		} else {
			buttonAtras.setEnabled(true);
		}
		if (index == tienda.size() - 1) {
			buttonSiguiente.setEnabled(false);
		} else {
			buttonSiguiente.setEnabled(true);
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarTienda() {
		super();
		lblTipo.setBounds(26, 44, 43, 22);
		labelID.setBounds(26, 11, 35, 22);

		// buttonBuscar.setVisible(false);
		// panelColor.setVisible(false);
		// comboBoxMarca.setVisible(false);
		// comboBoxModelo.setVisible(false);
		// textFieldMatricula.setEditable(false);
		comboBoxMaterial.setVisible(false);
		comboBoxTipo.setVisible(false);
		okButton.setVisible(false);

		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Mueble mueble = Gestionar.getTienda().get(textFieldID.getText());
					int index = Gestionar.getTienda().index(mueble);
					
					mueble = Gestionar.getTienda().posterior(index);
					textFieldID.setText(mueble.getID());
					textFieldTipo.setText(String.valueOf(mueble.getTipo().toString()));
					textFieldMaterial.setText(String.valueOf(mueble.getMaterial().toString()));

					index = Gestionar.getTienda().index(mueble);

					refrescarBotones(Gestionar.getTienda(), index);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Mueble mueble = Gestionar.getTienda().get(textFieldID.getText());
					int index = Gestionar.getTienda().index(mueble);

					mueble = Gestionar.getTienda().anterior(index);
					textFieldID.setText(mueble.getID());
					textFieldTipo.setText(String.valueOf(mueble.getTipo()));
					textFieldMaterial.setText(String.valueOf(mueble.getMaterial()));

					index = Gestionar.getTienda().index(mueble);

					refrescarBotones(Gestionar.getTienda(), index);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}

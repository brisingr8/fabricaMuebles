package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fabricaDeMuebles.Gestionar;
import fabricaDeMuebles.Material;
import fabricaDeMuebles.Tipo;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class AltaMueble extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AltaMueble() {
		super();

		labelID.setVisible(false);
		textFieldID.setVisible(false);
		buttonAtras.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		setTitle("Alta mueble");

		okButton.setText("Aceptar");

//		comboBoxTipo.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent arg0) {
//				comboBoxTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
//			}
//		});
//		comboBoxMaterial.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent arg0) {
//				comboBoxMaterial.setModel(new DefaultComboBoxModel(Material.values()));
//			}
//		});
		
		comboBoxTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
		comboBoxMaterial.setModel(new DefaultComboBoxModel(Material.values()));

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Gestionar.getTienda().annadir((Tipo) comboBoxTipo.getSelectedItem(), (Material) comboBoxMaterial.getSelectedItem());
//					Gestionar.setModificado(true);
					JOptionPane.showMessageDialog(contentPanel, "Mueble añadido con éxito.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
}

package gui;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fabricaDeMuebles.Armario;
import fabricaDeMuebles.Gestionar;
import fabricaDeMuebles.Mesa;
import fabricaDeMuebles.Mueble;
import fabricaDeMuebles.Silla;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarMueble extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public MostrarMueble() {
		super();
		lblMaterial.setSize(49, 22);
		textFieldMaterial.setLocation(83, 68);
		textFieldTipo.setSize(108, 22);
		textFieldTipo.setLocation(83, 40);
		comboBoxMaterial.setSize(108, 22);
		comboBoxTipo.setSize(108, 22);
		textFieldID.setSize(108, 22);
		labelID.setSize(49, 22);
		lblTipo.setSize(49, 22);
		labelID.setLocation(24, 11);
		textFieldID.setLocation(83, 12);
		comboBoxMaterial.setLocation(83, 69);
		comboBoxTipo.setLocation(83, 40);
		lblTipo.setLocation(24, 40);
		lblMaterial.setLocation(24, 69);

		comboBoxMaterial.setVisible(false);
		comboBoxTipo.setVisible(false);
		buttonAtras.setVisible(false);
		buttonSiguiente.setVisible(false);

		okButton.setText("Buscar");

		setTitle("Mostrar mueble");
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					if(textFieldID.getText().equals("SI")){
						Mueble mueble = Gestionar.getTienda().get(textFieldID.getText());
						textFieldTipo.setText(String.valueOf(mueble.getTipo()));
						textFieldMaterial.setText(String.valueOf(mueble.getMaterial()));
//					}
//					else if(textFieldID.getText().equals("ME")){
//						Mesa mesa = (Mesa) Gestionar.getTienda().get(textFieldID.getText());
//						textFieldTipo.setText(String.valueOf(mesa.getTipo()));
//						textFieldMaterial.setText(String.valueOf(mesa.getMaterial()));
//					}
//					else if(textFieldID.getText().equals("ME")){
//						Armario armario = (Armario) Gestionar.getTienda().get(textFieldID.getText());
//						textFieldTipo.setText(String.valueOf(armario.getTipo()));
//						textFieldMaterial.setText(String.valueOf(armario.getMaterial()));
//					}					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPanel, "Error. " + e1.getMessage(), "Error",
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

//	public void reset() {
//		textFieldMatricula.setText("");
//		textFieldColor.setText("");
//		textFieldMarca.setText("");
//		textFieldModelo.setText("");
//	}
}
package gui;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fabricaDeMuebles.Material;
import fabricaDeMuebles.Tipo;
import java.awt.TextField;

public class Base extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JLabel lblTipo;
	protected JLabel lblMaterial;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComboBox<Tipo> comboBoxTipo;
	protected JComboBox<Material> comboBoxMaterial;
	protected JButton okButton;
	protected JButton cancelButton;
	private JPanel panel_1;
	protected JLabel labelID;
	protected TextField textFieldID;
	protected TextField textFieldTipo;
	protected TextField textFieldMaterial;
	protected JButton buttonAtras;
	protected JButton buttonSiguiente;
	

	/**
	 * Create the dialog.
	 */
	public Base() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(26, 44, 65, 22);
		
		lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(26, 77, 49, 22);
		
		labelID = new JLabel("ID");
		labelID.setBounds(26, 11, 65, 22);
		
		textFieldID = new TextField();
		textFieldID.setBounds(85, 11, 108, 22);
		
		textFieldTipo = new TextField();
		textFieldTipo.setEditable(false);
		textFieldTipo.setBounds(85, 44, 108, 22);
		
		textFieldMaterial = new TextField();
		textFieldMaterial.setEditable(false);
		textFieldMaterial.setBounds(85, 77, 108, 22);
		
		comboBoxMaterial = new JComboBox<Material>();
		comboBoxMaterial.setBounds(85, 77, 108, 22);
		
		comboBoxTipo = new JComboBox<Tipo>();
		comboBoxTipo.setBounds(85, 44, 108, 22);
		
		getContentPane().setLayout(null);
		getContentPane().add(lblMaterial);
		getContentPane().add(labelID);
		getContentPane().add(lblTipo);
		getContentPane().add(comboBoxTipo);
		getContentPane().add(comboBoxMaterial);
		getContentPane().add(textFieldID);
		getContentPane().add(textFieldTipo);
		getContentPane().add(textFieldMaterial);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 238, 444, 33);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		okButton = new JButton();
		okButton.setBounds(250, 5, 88, 23);
		panel_1.add(okButton);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(348, 5, 86, 23);
		panel_1.add(cancelButton);
		
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		buttonAtras = new JButton("<");
		buttonAtras.setBounds(346, 215, 43, 23);
		getContentPane().add(buttonAtras);
		
		buttonSiguiente = new JButton(">");
		buttonSiguiente.setBounds(391, 215, 43, 23);
		getContentPane().add(buttonSiguiente);
	}
}

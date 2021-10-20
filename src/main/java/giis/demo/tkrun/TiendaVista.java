package giis.demo.tkrun;

import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class TiendaVista {

	private JFrame frame;
	private JTextField txtFechaHoy;
	private JButton btnTabCarreras;
	private JTable tabCarreras;
	private JComboBox<Object> lstCarreras;
	private JLabel descuento;
	private JTable tabDetalle;

	/**
	 * Create the application.
	 */
	public TiendaVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Menu Principal");
		frame.setName("Menu Principal");
		frame.setBounds(0, 0, 492, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));

		final JLabel lblSimulacion;
		final JLabel lblFechaHoy;
		final JLabel lblLstCarreras;

		lblSimulacion = new JLabel("Simulación de la fecha de hoy para mostrar las carreras");
		frame.getContentPane().add(lblSimulacion, "cell 0 1");

		lblFechaHoy = new JLabel("Fecha de hoy (formato ISO):");
		frame.getContentPane().add(lblFechaHoy, "flowx,cell 0 3");

		txtFechaHoy = new JTextField();
		txtFechaHoy.setName("txtFechaHoy");
		frame.getContentPane().add(txtFechaHoy, "cell 0 3,growx");
		txtFechaHoy.setColumns(10);

		btnTabCarreras = new JButton("Ver carreras en esta tabla");
		lblFechaHoy.setLabelFor(btnTabCarreras);
		frame.getContentPane().add(btnTabCarreras, "cell 0 3");

		JLabel lblLbltable = new JLabel("Proximas carreras:");
		frame.getContentPane().add(lblLbltable, "cell 0 4");

		// Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para
		// poder ver los headers de la tabla
		tabCarreras = new JTable();
		tabCarreras.setName("tabCarreras");
		tabCarreras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCarreras.setDefaultEditor(Object.class, null); // readonly
		JScrollPane tablePanel = new JScrollPane(tabCarreras);
		frame.getContentPane().add(tablePanel, "cell 0 5,grow");

		lblLstCarreras = new JLabel("La misma informacion que en la tabla, pero en forma de lista/combo");
		frame.getContentPane().add(lblLstCarreras, "cell 0 6");

		lstCarreras = new JComboBox<>();
		frame.getContentPane().add(lstCarreras, "cell 0 7,growx");

		JLabel lblAlSeleccionarLa = new JLabel("Al seleccionar la tabla (no el combo) muestra detalles");
		frame.getContentPane().add(lblAlSeleccionarLa, "cell 0 8");

		JLabel lblPorcentajeDescuento = new JLabel("Porcentaje de descuento: ");
		frame.getContentPane().add(lblPorcentajeDescuento, "flowx,cell 0 9");

		descuento = new JLabel("##");
		descuento.setName("descuento");
		descuento.setFont(UIManager.getFont("TextField.font"));
		frame.getContentPane().add(descuento, "cell 0 9");

		tabDetalle = new JTable();
		tabDetalle.setName("tabDetalle");
		tabDetalle.setRowSelectionAllowed(false);
		tabDetalle.setDefaultEditor(Object.class, null); // readonly
		tabDetalle.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabDetalle);
		tableDetallePanel.setMinimumSize(new Dimension(200, 95));
		tableDetallePanel.setPreferredSize(new Dimension(300, 95));
		frame.getContentPane().add(tableDetallePanel, "cell 0 10");
	}

	// Getters y Setters anyadidos para acceso desde el controlador (repersentacion
	// compacta)
	public JFrame getFrame() {
		return this.frame;
	}

	public String getFechaHoy() {
		return this.txtFechaHoy.getText();
	}

	public void setFechaHoy(String fechaIso) {
		this.txtFechaHoy.setText(fechaIso);
	}

	public JButton getBtnTablaCarreras() {
		return this.btnTabCarreras;
	}

	public JTable getTablaCarreras() {
		return this.tabCarreras;
	}

	public JComboBox<Object> getListaCarreras() {
		return this.lstCarreras;
	}

	public void setDescuento(String descuento) {
		this.descuento.setText(descuento + "%");
	}

	public void setDescuentoNoAplicable() {
		this.descuento.setText("N/A");
	}

	public JTable getDetalleCarrera() {
		return this.tabDetalle;
	}

}
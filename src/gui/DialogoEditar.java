package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import clases.Empleado;
import dao.EmpleadoDAO;
import net.miginfocom.swing.MigLayout;

public class DialogoEditar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodEmp;
	private JTextField txtTfno;
	private JTextField txtSalario;
	private JSpinner spinner;
	private JTextField txtCodDpto;
	private JTextField txtFechaNac;
	private JTextField txtComision;
	private JTextField txtFechaIngreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoEditar dialog = new DialogoEditar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoEditar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Editar Empleado:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblNewLabel, "cell 0 0 5 1");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre*:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_1, "cell 1 2,alignx trailing");
		}
		{
			txtNombre = new JTextField();
			contentPanel.add(txtNombre, "cell 2 2 3 1,growx");
			txtNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Cod Empleado*:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_2, "cell 1 3,alignx trailing");
		}
		{
			txtCodEmp = new JTextField();
			txtCodEmp.setEnabled(false);
			txtCodEmp.setEditable(false);
			contentPanel.add(txtCodEmp, "cell 2 3,growx");
			txtCodEmp.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Cód Departamento*:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_4, "cell 3 3,alignx trailing");
		}
		{
			txtCodDpto = new JTextField();
			contentPanel.add(txtCodDpto, "cell 4 3,growx");
			txtCodDpto.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Teléfono:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_5, "cell 1 4,alignx trailing,aligny top");
		}
		{
			txtTfno = new JTextField();
			contentPanel.add(txtTfno, "cell 2 4,growx");
			txtTfno.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Fecha Nacimiento:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_6, "cell 3 4,alignx trailing");
		}
		{
			txtFechaNac = new JTextField();
			contentPanel.add(txtFechaNac, "cell 4 4,growx");
			txtFechaNac.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Salario:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_7, "cell 1 5,alignx trailing");
		}
		{
			txtSalario = new JTextField();
			contentPanel.add(txtSalario, "cell 2 5,growx");
			txtSalario.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Comisión:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_8, "cell 3 5,alignx trailing");
		}
		{
			txtComision = new JTextField();
			contentPanel.add(txtComision, "cell 4 5,growx");
			txtComision.setColumns(10);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Número Hijos:");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_9, "cell 1 6,alignx trailing");
		}
		{
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			contentPanel.add(spinner, "cell 2 6,growx");
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Fecha Ingreso:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPanel.add(lblNewLabel_6, "cell 3 6,alignx trailing");
		}
		{
			txtFechaIngreso = new JTextField();
			txtFechaIngreso.setColumns(10);
			contentPanel.add(txtFechaIngreso, "cell 4 6,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Editar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						validarDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void validarDatos() {
		
		try {
			String nombre = txtNombre.getText();
			int codEmp = Integer.parseInt(txtCodEmp.getText());
			int codDpto = Integer.parseInt(txtCodDpto.getText());
			
			int tfno = Integer.parseInt(txtTfno.getText());
			
			//DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			double salario = Double.parseDouble(txtSalario.getText());
			double comision = Double.parseDouble(txtComision.getText());
			int numHijos = (int) spinner.getValue();
		
			Date fechaNac = Date.valueOf(LocalDate.parse(txtFechaNac.getText(), formateador));
			
			Date fechaIngreso = Date.valueOf(LocalDate.parse(txtFechaIngreso.getText(), formateador));
			
			
			Empleado emp = new Empleado(codEmp, codDpto, tfno, 
					fechaIngreso, fechaNac, salario, comision, 
					numHijos, nombre);
			
			EmpleadoDAO daoEmp = new EmpleadoDAO();
			daoEmp.editar(emp);
			setVisible(false);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(contentPanel,
					"No se ha podido insertar.");
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(contentPanel,
					"debe introducir una fecha correcta. "+e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, 
					"Compruebe los datos, tienen un formato incorrecto");
		}
		
	}
	
	
	public void inicializar(int codEmp) {	
		EmpleadoDAO daoEmp = new EmpleadoDAO();
		Empleado emp = daoEmp.getEmpleado(codEmp);
		
		txtNombre.setText(emp.getNombre());
		txtCodEmp.setText(""+emp.getCodEmpleado());
		txtCodDpto.setText(""+emp.getCodDpto());
		txtTfno.setText(""+emp.getTfno());
		
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		
		txtFechaNac.setText(formateador.format(emp.getFechaNaciemiento()));
		txtFechaIngreso.setText(formateador.format(emp.getFechaingreso()));
		txtSalario.setText(""+emp.getSalario());
		txtComision.setText(""+emp.getComision());
		spinner.setValue(emp.getNumHijos());
	}

}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clases.Empleado;
import dao.EmpleadoDAO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaMostrar extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMostrar frame = new VentanaMostrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMostrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][][]"));
		
		JLabel lblNewLabel = new JLabel("Listado de Empleados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digop Empleado", "C\u00F3digo Departamento", "Tel\u00E9fono", "Fecha Ingreso", "Fecha Nacimiento", "Salario", "Comisi\u00F3n", "N\u00FAmero de Hijos", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Object.class, Object.class, Double.class, Double.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Mostrar Datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos();
			}
		});
		contentPane.add(btnNewButton, "flowx,cell 0 2,alignx center");
		
		JButton btnNewButton_1 = new JButton("Nuevo Empleado");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		contentPane.add(btnNewButton_1, "cell 0 2");
	}

	protected void insertar() {
		DialogoInsertar dialogoIns = new DialogoInsertar();
		dialogoIns.setModal(true);
		dialogoIns.setVisible(true);
		
	}

	protected void mostrarDatos() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		
		// instancia un objeto de acceso a datos (DAO) para recoger los datos 
		// de la BD
		EmpleadoDAO daoEmp = new EmpleadoDAO();
		
		// Recogemos la lista de empleados del DAO
		ArrayList<Empleado> listaEmpleados = daoEmp.getEmpleados();
		
		for (Empleado e : listaEmpleados) {
			Object [] fila = {
				e.getCodEmpleado(), e.getCodDpto(), e.getTfno(), e.getFechaingreso(),
				e.getFechaNaciemiento(), e.getSalario(), e.getComision(), e.getNumHijos(),
				e.getNombre()
			};
			modelo.addRow(fila);
			
		}
	}

}

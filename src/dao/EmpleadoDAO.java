package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Empleado;
import utilidades.ConexionBD;

/**
 * Clase que gestiona todos los accesos a BD para extraer o llevar información 
 * de los empleados a la base de datos
 * @author David
 *
 */
public class EmpleadoDAO {

	private ConexionBD conexion;
	private Connection con;
	private Statement sentencia;
	private PreparedStatement sentenciaPrep;
	private ResultSet resultado;
	
	
	/**
	 * Construcor de la clase que instancia la conexión que usará en cada uno de los
	 * métodos
	 */
	public EmpleadoDAO() {
		this.conexion = new ConexionBD();
	}
	
	public ArrayList<Empleado> getEmpleados() {
		
		// instanciamos la lista
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		
		// Conectamos con la base de datos
		con = this.conexion.getConexion();
		
		String consulta = "select * from empleados";
		
		try {
			// Crea el objeto Statement con el que se pueden lanzar consultas
			sentencia = con.createStatement();
			// Se ejecuta la consulta y se recoge el ResultSet (resultado)
			resultado = sentencia.executeQuery(consulta);
			
			// Hacemos un bucle para recorrer el cursor con los resultados
			// next devuelve true mientras haya datos, false en caso contrario
			while(resultado.next()) {
				
				// recogemos todos los datos invocando a los método  getters correspondientes
				int codEmp = resultado.getInt("cod_empleado");
				int codDpto = resultado.getInt("cod_departamento");
				int tfno = resultado.getInt("telefono");
				Date fechaNac = resultado.getDate("fecha_nacimiento");
				Date fechaIngreso = resultado.getDate("fecha_ingreso");
				double comision = resultado.getDouble("comision");
				int numHijos= resultado.getInt("num_hijos");
				String nombre = resultado.getString("nombre");
				
				// Instanciamos el objeto de tipo Empleado
				Empleado e = new Empleado(codEmp, codDpto, tfno, fechaIngreso, fechaNac,
						tfno, comision, numHijos, nombre);
				
				lista.add(e);
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta "+e.getMessage());
		} finally {
			try {
				resultado.close();
				sentencia.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("error liberando recursos. " + e.getMessage());
			}
			
		}
		return lista;

	}
	
	public void insertar(Empleado e) {
		
		con=this.conexion.getConexion();
		try {
			String consulta= "insert into empleados (cod_empleado, cod_departamento, telefono,\r\n"
					+ " fecha_nacimiento, fecha_ingreso, salario,\r\n"
					+ " comision, num_hijos, nombre)\r\n"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			sentenciaPrep=con.prepareStatement(consulta);
			
			// incializamos la sentencia preparada indicando porque valor debe sustituir 
			// las interrogaciones
			sentenciaPrep.setInt(1, e.getCodEmpleado());
			sentenciaPrep.setInt(2, e.getCodDpto());
			
		}
		
	}
	
	
}

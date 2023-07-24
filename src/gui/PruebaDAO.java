package gui;

import java.util.ArrayList;

import clases.Empleado;
import dao.EmpleadoDAO;

public class PruebaDAO {

	public static void main(String[] args) {
		
		
		System.out.println("Probando dao de empleados...");
		
		// instancia un objeto de acceso a datos (DAO) para recoger los datos 
		// de la BD
		EmpleadoDAO daoEmp = new EmpleadoDAO();
		
		// Recogemos la lista de empleados del DAO
		ArrayList<Empleado> listaEmpleados = daoEmp.getEmpleados();
		
		System.out.println("La lista de empleados es ");
		System.out.println(listaEmpleados);

	}

}

package clases;

import java.sql.Date;
import java.util.Objects;

public class Empleado {

	private int codEmpleado;
	private int codDpto;
	private int tfno;
	private Date fechaingreso;
	private Date fechaNaciemiento;
	private double salario;
	private double comision;
	private int numHijos;
	private String nombre;
	
	public Empleado() {
		this.codEmpleado = 0;
		this.codDpto = 0;
		this.tfno = 0;
		this.fechaingreso = null;
		this.fechaNaciemiento = null;
		this.salario = 0;
		this.comision = 0;
		this.numHijos = 0;
		this.nombre = "";
	}
	
	public Empleado(int codEmpleado, int codDpto, int tfno, Date fechaingreso, Date fechaNaciemiento, double salario,
			double comision, int numHijos, String nombre) {
		this.codEmpleado = codEmpleado;
		this.codDpto = codDpto;
		this.tfno = tfno;
		this.fechaingreso = fechaingreso;
		this.fechaNaciemiento = fechaNaciemiento;
		this.salario = salario;
		this.comision = comision;
		this.numHijos = numHijos;
		this.nombre = nombre;
	}

	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public int getCodDpto() {
		return codDpto;
	}

	public void setCodDpto(int codDpto) {
		this.codDpto = codDpto;
	}

	public int getTfno() {
		return tfno;
	}

	public void setTfno(int tfno) {
		this.tfno = tfno;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechaNaciemiento() {
		return fechaNaciemiento;
	}

	public void setFechaNaciemiento(Date fechaNaciemiento) {
		this.fechaNaciemiento = fechaNaciemiento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "codEmpleado: " + codEmpleado + "\ncodDpto: " + codDpto + "\ntfno: " + tfno + "\nfechaingreso: "
				+ fechaingreso + "\nfechaNaciemiento: " + fechaNaciemiento + "\nsalario: " + salario + "\ncomision: "
				+ comision + "\nnumHijos: " + numHijos + "\nnombre: " + nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codEmpleado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return codEmpleado == other.codEmpleado;
	}
	
	
	
}

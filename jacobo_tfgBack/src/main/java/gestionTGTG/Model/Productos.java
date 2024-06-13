package gestionTGTG.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos 
{
	
	@Id
	@Column (name = "cod_producto", columnDefinition = "varchar(100) not null")
	private String codProducto;
	
	@Column (name = "nombre", columnDefinition = "varchar(100) not null")
	private String nombre;
	
	@Column (name = "descripcion", columnDefinition = "varchar(255) not null")
	private String descripcion;
	
	@Column (name = "precio_actual", columnDefinition = "double not null")
	private double precioActual;
	
	@Column (name = "precio_original", columnDefinition = "double not null")
	private double precioOriginal;
	
	@Column (name = "num_serie", columnDefinition = "int(15) not null")
	private String numeroSerie;
	
	@Column (name = "categoria", columnDefinition = "varchar(255) not null")
	private String categoria;
	
	@Column (name = "desperfecto", columnDefinition = "varchar(255) not null")
	private String desperfecto;

	public Productos() {
		
	}
	
	public Productos(String codProducto, String nombre, String descripcion, double precioActual, double precioOriginal,
			String numeroSerie, String categoria, String desperfecto) {
		super();
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioActual = precioActual;
		this.precioOriginal = precioOriginal;
		this.numeroSerie = numeroSerie;
		this.categoria = categoria;
		this.desperfecto = desperfecto;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(double precioActual) {
		this.precioActual = precioActual;
	}

	public double getPrecioOriginal() {
		return precioOriginal;
	}

	public void setPrecioOriginal(double precioOriginal) {
		this.precioOriginal = precioOriginal;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDesperfecto() {
		return desperfecto;
	}

	public void setDesperfecto(String desperfecto) {
		this.desperfecto = desperfecto;
	}
	
	
}
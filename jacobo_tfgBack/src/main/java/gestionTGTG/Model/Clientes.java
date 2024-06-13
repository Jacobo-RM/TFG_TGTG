package gestionTGTG.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor

@Entity
@Table(name = "clientes")
public class Clientes 
{
	@Id
	@Column (name = "nif_cliente", columnDefinition = "varchar(10) not null")
	private String nif;
	
	@Column (name = "nombre", columnDefinition = "varchar(100) not null")
	private String nombre;
	
	@Column (name = "direccion", columnDefinition = "varchar(100) not null")
	private String direccion;
	
	@Column (name = "telefono", columnDefinition = "varchar(9) not null")
	private String telefono;
	
	@Column (name = "correo", columnDefinition = "varchar(30) not null")
	private String correo;

	public Clientes() {
		
	}
	
}
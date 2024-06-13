package gestionTGTG.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "empleados")
public class Empleados 
{
	
	@Id
	@Column (name = "naf", columnDefinition = "varchar(12) not null")
	private String naf;
	
	@Column (name = "nombre", columnDefinition = "varchar(100) not null")
	private String nombre;
	
	@Column (name = "puesto_laboral", columnDefinition = "varchar(100) not null")
	private String puestoLaboral;
	
	@Column (name = "horario_entrada", columnDefinition = "bigint(20) not null")
	private long horarioEntrada;
	
	@Column (name = "horario_salida", columnDefinition = "bigint(20) not null")
	private long horarioSalida;
	
	@ManyToOne
	@JoinColumn (name = "cod_empresa", columnDefinition = "bigint(20) not null")
	private Empresa codEmpresa;

	public Empleados() {
		
	}

}

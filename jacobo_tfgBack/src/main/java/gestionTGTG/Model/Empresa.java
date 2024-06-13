package gestionTGTG.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresaeci")
public class Empresa 
{
	
	@Id
	@Column (name = "cod_empresa", columnDefinition = "varchar(20) not null")
	private String codEmpresa;
	
	@Column (name = "cif", columnDefinition = "varchar(9) not null")
	private String cif;
	
	@Column (name = "cuenta_SS", columnDefinition = "int(9) not null")
	private int cuentaSS;

	@Column (name = "domicilio", columnDefinition = "varchar(255) not null")
	private String domicilio;
	
	@Column (name = "telefono", columnDefinition = "varchar(255) not null")
	private String telefono;
	
	@Column (name = "correo", columnDefinition = "varchar(100) not null")
	private String correo;
	
	@Column (name = "url_Web", columnDefinition = "varchar(255) not null")
	private String urlWeb;

	public Empresa() {
		
	}
	public Empresa(String codEmpresa, String cif, int cuentaSS, String domicilio, String telefono,
			String correo, String urlWeb) {
		super();
		this.codEmpresa = codEmpresa;
		this.cif = cif;
		this.cuentaSS = cuentaSS;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correo = correo;
		this.urlWeb = urlWeb;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public int getCuentaSS() {
		return cuentaSS;
	}

	public void setCuentaSS(int cuentaSS) {
		this.cuentaSS = cuentaSS;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUrlWeb() {
		return urlWeb;
	}

	public void setUrlWeb(String urlWeb) {
		this.urlWeb = urlWeb;
	}
}

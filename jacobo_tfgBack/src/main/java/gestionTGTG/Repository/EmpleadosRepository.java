package gestionTGTG.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTGTG.Model.Empleados;
import gestionTGTG.Model.Empresa;

public interface EmpleadosRepository extends JpaRepository<Empleados,String>
{
	
}

package gestionTGTG.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTGTG.Model.Clientes;
import gestionTGTG.Model.Empresa;

public interface ClientesRepository extends JpaRepository<Clientes,String>
{
	List<Clientes> findByNifEquals(String nif);
}
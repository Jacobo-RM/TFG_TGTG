package gestionTGTG.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTGTG.Model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,String>
{

}

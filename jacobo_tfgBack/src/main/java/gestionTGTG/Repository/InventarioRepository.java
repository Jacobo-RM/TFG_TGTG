package gestionTGTG.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTGTG.Model.Empresa;
import gestionTGTG.Model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario,String>
{

}

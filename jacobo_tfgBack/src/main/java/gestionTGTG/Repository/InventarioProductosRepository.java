package gestionTGTG.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTGTG.Model.InventarioProductos;

public interface InventarioProductosRepository extends JpaRepository<InventarioProductos, String> {
	
	List<InventarioProductos> findByCodProducto(String codProducto);
}
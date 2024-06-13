package gestionTGTG.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTGTG.Model.Empresa;
import gestionTGTG.Model.Productos;

public interface ProductosRepository extends JpaRepository<Productos,String>
{
	List<Productos> findByCategoriaEquals(String categoria);
	
	List<Productos> findByPrecioActual(double precioActual);
	
	List<Productos> findByPrecioActualBetween(double precio1, double precio2);
	
} 
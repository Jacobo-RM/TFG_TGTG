package gestionTGTG.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;


import gestionTGTG.Model.Clientes;
import gestionTGTG.Model.Empleados;
import gestionTGTG.Model.Empresa;
import gestionTGTG.Model.Inventario;
import gestionTGTG.Model.InventarioProductos;
import gestionTGTG.Model.Productos;
import gestionTGTG.Repository.ClientesRepository;
import gestionTGTG.Repository.EmpleadosRepository;
import gestionTGTG.Repository.EmpresaRepository;
import gestionTGTG.Repository.InventarioProductosRepository;
import gestionTGTG.Repository.InventarioRepository;
import gestionTGTG.Repository.ProductosRepository;


@Service
public class ServiceTGTG 
{
	private final ClientesRepository clientesRepository;
	private final EmpresaRepository empresaRepository;
	private final EmpleadosRepository empleadosRepository;
	private final InventarioRepository inventarioRepository;
	private final ProductosRepository productosRepository;
	private InventarioProductosRepository inventarioProductosRepository;
	
	public ServiceTGTG(ClientesRepository clientesRepository, EmpresaRepository empresaRepository,
			EmpleadosRepository empleadosRepository, InventarioRepository inventarioRepository,
			 ProductosRepository productosRepository, InventarioProductosRepository inventarioProductosRepository) {
		super();
		this.clientesRepository = clientesRepository;
		this.empresaRepository = empresaRepository;
		this.empleadosRepository = empleadosRepository;
		this.inventarioRepository = inventarioRepository;
		this.productosRepository = productosRepository;
		this.inventarioProductosRepository = inventarioProductosRepository;
	}
	
	
/////////////////////////////////////////////////////////////////////METODOS GET//////////////////////////////////////////////////////////////////////////////////////////////////	



	public Empresa getEmpresaByCod(String codEmpresa)
	{
		return this.empresaRepository.findById(codEmpresa).orElse(null);
	}
	
	public List<Clientes> getAllClientes()
	{
		return this.clientesRepository.findAll();
	}
	
	public List<Clientes> getClientesByNif(String nif)
	{
		return this.clientesRepository.findByNifEquals(nif);
	}

	public List<Inventario> getAllInventario()
	{
		return this.inventarioRepository.findAll();
	}
	
	public List<Productos> getAllProductos()
	{
		return this.productosRepository.findAll();
	}
	
	public List<Empleados> getAllEmpleados()
	{
		return this.empleadosRepository.findAll();
	}

	public List<Productos> getProductosByCategoria(String categoria)
	{
		return this.productosRepository.findByCategoriaEquals(categoria);
	}
	
	public List<Productos> getProductosByPrecio(double precioActual)
	{
		return this.productosRepository.findByPrecioActual(precioActual);
	}
	
	public List<Productos> getProductosByRangoPrecio(double precio1, double precio2)
	{
		return this.productosRepository.findByPrecioActualBetween(precio1, precio2);
	}	
	
	 public String productoStock(String codProducto) {
	        List<InventarioProductos> inventarioProductoList = inventarioProductosRepository.findByCodProducto(codProducto);
	        
	        if (inventarioProductoList != null && !inventarioProductoList.isEmpty()) {
	            int totalCantidad = 0;
	            for (InventarioProductos inventarioProducto : inventarioProductoList) {
	                totalCantidad += inventarioProducto.getCantidad();
	            }
	            if (totalCantidad > 0) {
	                return "Producto en stock. Cantidad total: " + totalCantidad;
	            } else {
	                return "Producto no disponible.";
	            }
	        } else {
	            return "Producto no encontrado en el inventario.";
	        }
	   }
	
	 
	
	public boolean deleteUnEmpleado(String naf)
	{
		boolean funciona = false;
		Empleados e = this.empleadosRepository.findById(naf).orElse(null);
		if (e != null)
		{
			this.empleadosRepository.delete(e);
			funciona = true;
		}
		
		return funciona;
	}
	
	
	public boolean addEmpleado(String naf,  String nombre, String puestoLaboral, long horaEntrada, long horaSalida, String codEmpresa)
	{
		boolean funciona = false;
		Empresa empresa = this.empresaRepository.findById(codEmpresa).orElse(null);
		Empleados empleados = this.empleadosRepository.findById(naf).orElse(null);
		
		if (empleados == null && empresa != null)
		{
			empleados = new Empleados(naf, nombre, puestoLaboral, horaEntrada, horaSalida, empresa);
			this.empleadosRepository.save(empleados);
			funciona = true;
		}
		
		return funciona;
	}
	
	
	public boolean updateProductPrice(String codProducto, double porcentaje) {
	    boolean funciona = false;
	    Productos p = this.productosRepository.findById(codProducto).orElse(null);

	    if (p != null) {
	        p.setPrecioActual(p.getPrecioActual() * (1 - (porcentaje / 100.0)));
	        this.productosRepository.save(p);
	        funciona = true;
	    }

	    return funciona;
	}
	
    public boolean updateEmpleado(String naf, String nombre, String puestoLaboral, long horaEntrada, long horaSalida, String codEmpresa) {
        boolean funciona = false;
        Empleados e = this.empleadosRepository.findById(naf).orElse(null);
        Empresa empresa = this.empresaRepository.findById(codEmpresa).orElse(null);

        if (e != null && empresa != null) {
            e.setNombre(nombre);
            e.setPuestoLaboral(puestoLaboral);
            e.setHorarioEntrada(horaEntrada);
            e.setHorarioEntrada(horaSalida);
            e.setCodEmpresa(empresa);
            this.empleadosRepository.save(e);
            funciona = true;
        }

        return funciona;
    }
	
	
	
	
	public boolean addProducto (String codProducto, String nombre, String descripcion, double precioActual, double precioOriginal,
			String numeroSerie, String categoria, String desperfecto)
	{
		boolean funciona = false;
		Productos p = this.productosRepository.findById(codProducto).orElse(null);
		
		if (p != null)
		{
			p = new Productos(codProducto, nombre, descripcion, precioActual, precioOriginal, numeroSerie, categoria, desperfecto);
			this.productosRepository.save(p);
			funciona = true;
		}
		return funciona;
	}

	









}
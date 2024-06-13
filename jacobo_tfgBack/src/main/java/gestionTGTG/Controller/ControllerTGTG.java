package gestionTGTG.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gestionTGTG.Model.Clientes;
import gestionTGTG.Model.Empleados;
import gestionTGTG.Model.Empresa;
import gestionTGTG.Model.Inventario;
import gestionTGTG.Model.InventarioProductos;
import gestionTGTG.Model.Productos;
import gestionTGTG.Service.ServiceTGTG;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/elCorteIngles/ToGoodToGo")
@CrossOrigin(origins = "*")
public class ControllerTGTG 
{
	private final ServiceTGTG servicetgtg;
	
	public ControllerTGTG(ServiceTGTG servicetgtg)
	{
		this.servicetgtg = servicetgtg;
	}
	
/////////////PAGINA PARA VER LAS SOLICITUDES: http://localhost:8082/swagger-ui/index.html#////////////////////////////
	
	
/////////////////////////////////////////////////////////////////////METODOS GET//////////////////////////////////////////////////////////////////////////////////////////////////	

	@Operation(
		      summary = "Devuelve la empresa",
		      description = "Devuelve la empresa según el codigo de esta",
		      tags = {"get"})
	@GetMapping("/empresa/{codEmpresa}")
	public Empresa getEmpresasByCod(@PathVariable("codEmpresa") String codEmpresa)
	{
		return this.servicetgtg.getEmpresaByCod(codEmpresa);
	}
	
	
    @Operation(
            summary = "Obtener todos los clientes",
            description = "Obtiene una lista de todos los clientes registrados",
            tags = {"Clientes"}
    )

    @GetMapping("/clientes")
    public List<Clientes> getAllClientes() {
        return this.servicetgtg.getAllClientes();
    }
    
	
    @Operation(
            summary = "Obtener clientes por NIF",
            description = "Obtiene el cliente registrado con el NIF seleccionado",
            tags = {"Clientes"})
	
    @GetMapping("/clientes/{nif}")
    public List<Clientes> getClientesByNif(@PathVariable("nif") String nif) {
        return this.servicetgtg.getClientesByNif(nif);
    }
    
	@Operation(
		      summary = "Devuelve empleados contratados",
		      description = "Devuelve todos los empleados.",
		      tags = {"get"})
	@GetMapping("/empleadosActuales")
	public List<Empleados> getAllEmpleados()
	{
		return this.servicetgtg.getAllEmpleados();
	}
    
    @Operation(
            summary = "Obtener todos los productos en inventario",
            description = "Obtiene una lista de todos los productos disponibles en el inventario",
            tags = {"get"}
    )
    @GetMapping("/inventario")
    public List<Inventario> getAllInventario() {
        return this.servicetgtg.getAllInventario();
    }
    
    @Operation(
            summary = "Obtener todos los productos",
            description = "Obtiene una lista de todos los productos",
            tags = {"get"}
    )
    @GetMapping("/productos")
    public List<Productos> getAllProductos() {
        return this.servicetgtg.getAllProductos();
    }

	
	@Operation(
		      summary = "Devuelve los productos por categoria",
		      description = "Devuelve todos los productos según la categoría que escojas",
		      tags = {"get"})
	@GetMapping("/productosByCategoria/{categoria}")
	public List<Productos> getProductosByCategoria(@PathVariable ("categoria") String categoria)
	{
		return this.servicetgtg.getProductosByCategoria(categoria);
	}
	
	
   @Operation(
            summary = "Obtener productos por precio",
            description = "Obtiene una lista de productos con un precio igual al proporcionado",
            tags = {"get"}
    )
    @GetMapping("/productosByPrecio/{precioActual}")
    public List<Productos> getProductosByPrecio(@PathVariable("precioActual") double precioActual) {
        return this.servicetgtg.getProductosByPrecio(precioActual);
    }
	
	@Operation(
		      summary = "Devuelve los productos por rango precio",
		      description = "Devuelve todos los productos según el rango de precio que indiques.",
		      tags = {"get"})
	@GetMapping("/productos/rangoDePrecio/{precio1}/{precio2}")
	public List<Productos> getProductosByRangoPrecio( @PathVariable ("precio1")double precio1, @PathVariable ("precio2") double precio2)
	{
		return this.servicetgtg.getProductosByRangoPrecio(precio1, precio2);
	}
	
    @Operation(
            summary = "Verificar stock de un producto",
            description = "Verifica la cantidad en stock de un producto específico",
            tags = {"get"}
    )
    @GetMapping("/producto/{codProducto}/stock")
    public String checkProductStock(@PathVariable("codProducto") String codProducto) {
        return this.servicetgtg.productoStock(codProducto);
    }
	
	///////////////////////////////////////////////////////////DELETE///////////////////////////////////////////////////////
	
	@Operation(
		      summary = "Eliminar un empleado",
		      description = "Despide/elimina un empleado de la base de datos",
		      tags = {"delete"})
	 @DeleteMapping("/despedirTrabajador/{naf}")
	 public boolean deleteUnEmpleado(@PathVariable("naf") String naf)
	 {
		 return this.servicetgtg.deleteUnEmpleado(naf);
	 }
	
	/////////////////////////////////////////////////////////////PUT/////////////////////////////////////////////////////////
	 
	@Operation(
		      summary = "Añadir descuento",
		      description = "Actualiza el precio de un producto que elijas con un porcentaje a eleccion. EJEMPLO: un 20%",
		      tags = {"put"})
	  @PutMapping("/productos/actualizarPrecio/{codProducto}/{porcentaje}")
	    public boolean updateProductPrice(@PathVariable ("codProducto") String codProducto, @PathVariable ("porcentaje")double porcentaje) {
	        return this.servicetgtg.updateProductPrice(codProducto, porcentaje);
	  }
	
    @PutMapping("/actualizarEmpleados/{naf}")
    public boolean updateEmpleado(@PathVariable("naf") String naf, @RequestParam("nombre") String nombre, @RequestParam("puestoLaboral") String puestoLaboral, @RequestParam("horaEntrada") long horaEntrada, @RequestParam("horaSalida") long horaSalida, @RequestParam("codEmpresa") String codEmpresa) {
	return this.servicetgtg.updateEmpleado(naf, nombre, puestoLaboral, horaEntrada, horaSalida, codEmpresa);
	}

	
	////////////////////////////////////////////////////////POST///////////////////////////////////////////////////////////////

	@Operation(
		      summary = "Contartar un empleado",
		      description = "Añade un empleado de la base de datos",
		      tags = {"post"})
	@PostMapping("/contratarEmpleado/{naf}/{nombre}/{puestoLaboral}/{horaEntrada}/{horaSalida}/{codEmpresa}")
	public boolean addEmpleado(@PathVariable ("naf") @RequestBody String naf,  @PathVariable("nombre") @RequestBody String nombre, @PathVariable("puestoLaboral")@RequestBody String puestoLaboral,
			@PathVariable("horaEntrada")@RequestBody long horaEntrada, @PathVariable("horaSalida") @RequestBody long horaSalida, @PathVariable("codEmpresa") @RequestBody String codEmpresa)
	{
		return this.servicetgtg.addEmpleado(naf, nombre, puestoLaboral, horaEntrada, horaSalida, codEmpresa);
	}
	
	@Operation(
		      summary = "Añade un producto",
		      description = "Añade un producto a la base de datos",
		      tags = {"post"})
	@PostMapping("/addProducto")
	public boolean addProducto(@RequestParam("codProducto") String codProducto,@RequestParam("nombre") String nombre,@RequestParam("descripcion") String descripcion, @RequestParam("precioActual") double precioActual,@RequestParam("precioOriginal") double precioOriginal,
			@RequestParam("numeroSerie") String numeroSerie,@RequestParam("categoria") String categoria,@RequestParam("desperfecto") String desperfecto) {
	    return this.servicetgtg.addProducto(codProducto, nombre, descripcion, precioActual, precioOriginal, numeroSerie, categoria, desperfecto);
	}

	
	
}
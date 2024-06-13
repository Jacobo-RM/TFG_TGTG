package gestionTGTG.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "inventario_productos")
public class InventarioProductos {

    @Id
    @Column(name = "cod_inventario", columnDefinition = "varchar(11) not null")
    private String codInventario;

    @Column(name = "cod_producto", columnDefinition = "varchar(100) not null")
    private String codProducto;

    @Column(name = "cantidad", columnDefinition = "int not null")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "cod_inventario", referencedColumnName = "cod_inventario", insertable = false, updatable = false)
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto", insertable = false, updatable = false)
    private Productos producto;


    public InventarioProductos(String codInventario, String codProducto, int cantidad, Inventario inventario, Productos producto) {
        this.codInventario = codInventario;
        this.codProducto = codProducto;
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.producto = producto;
    }


    public InventarioProductos() {
    }

    // Getters and Setters
    public String getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(String codInventario) {
        this.codInventario = codInventario;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}

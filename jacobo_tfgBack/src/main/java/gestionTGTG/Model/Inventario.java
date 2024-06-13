package gestionTGTG.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @Column(name = "cod_inventario", columnDefinition = "varchar(11) not null")
    private String codInventario;

    @ManyToOne
    @JoinColumn(name = "cod_empresa", columnDefinition = "varchar(11) not null")
    private Empresa codEmpresa;

    @Column(name = "descripcion", columnDefinition = "varchar(255) not null")
    public String descripcion;

    @OneToMany(mappedBy = "inventario")
    private List<InventarioProductos> inventarioProductos;

    public Inventario() {

    }

    public Inventario(String codInventario, Empresa codEmpresa, String descripcion) {
        super();
        this.codInventario = codInventario;
        this.codEmpresa = codEmpresa;
        this.descripcion = descripcion;
    }

    public String getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(String codInventario) {
        this.codInventario = codInventario;
    }

    public Empresa getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Empresa codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<InventarioProductos> getInventarioProductos() {
        return inventarioProductos;
    }

    public void setInventarioProductos(List<InventarioProductos> inventarioProductos) {
        this.inventarioProductos = inventarioProductos;
    }
}

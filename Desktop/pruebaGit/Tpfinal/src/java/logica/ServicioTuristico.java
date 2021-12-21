
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ServicioTuristico implements Serializable {
    
    //atributos y mapeo
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo_servicio;
    @Basic
    private String nombre;
    private String descripcion;
    private String destino_servicio;
    private double costo_servicio;
    private String fecha_servicio;
    private String habilitado;
    /*
    @Temporal(TemporalType.DATE)
    private Date fecha_servicio;
    */    

    //relacion ServicioT - PaqueteT : N a N
    @ManyToMany
    private List<PaqueteTuristico> lista_paquetes;
    
    //relacion ServicioT - Ventas : 1 a N
    //la hice desde ventas N a 1
    
    //constructor
    public ServicioTuristico() {
    }

    public ServicioTuristico(int codigo_servicio, String nombre, String descripcion, String destino_servicio, double costo_servicio, String fecha_servicio, String habilitado, List<PaqueteTuristico> lista_paquetes) {
        this.codigo_servicio = codigo_servicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.destino_servicio = destino_servicio;
        this.costo_servicio = costo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.habilitado = habilitado;
        this.lista_paquetes = lista_paquetes;
    }

    
    
    //getters y setters
    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino_servicio() {
        return destino_servicio;
    }

    public void setDestino_servicio(String destino_servicio) {
        this.destino_servicio = destino_servicio;
    }

    public double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public String getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(String fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public List<PaqueteTuristico> getLista_paquetes() {
        return lista_paquetes;
    }

    public void setLista_paquetes(List<PaqueteTuristico> lista_paquetes) {
        this.lista_paquetes = lista_paquetes;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
 
}


package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class PaqueteTuristico implements Serializable {
    
    //atributos y mapeo
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo_paquete;
    @Basic
    private double costo_paquete;
    private String habilitado;
    
    //relacion PaqueteT - ServicioT : N a N
    @ManyToMany
    private List<ServicioTuristico> lista_servicios_incluidos;
    
    //relacion PaqueteT - Ventas : 1 a N
    //la hice desde ventas
    
    //constructor
    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int codigo_paquete, double costo_paquete, String habilitado, List<ServicioTuristico> lista_servicios_incluidos) {
        this.codigo_paquete = codigo_paquete;
        this.costo_paquete = costo_paquete;
        this.habilitado = habilitado;
        this.lista_servicios_incluidos = lista_servicios_incluidos;
    }

    
    //getters y setters
    public int getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(int codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

    public double getCosto_paquete() {
        return costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public List<ServicioTuristico> getLista_servicios_incluidos() {
        return lista_servicios_incluidos;
    }

    public void setLista_servicios_incluidos(List<ServicioTuristico> lista_servicios_incluidos) {
        this.lista_servicios_incluidos = lista_servicios_incluidos;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    void calcularCosto(List<ServicioTuristico> listaServiciosInc) {
        double total=0;
        double costoT=0;
        
        for (ServicioTuristico serv:listaServiciosInc) {
            double costoServ = serv.getCosto_servicio();
            total += costoServ;
        }
        
        //costo del paquete es igual a la suma de los costos de los servicios que lo componen menos un 10% de descuento
        costoT = total - (total*0.1);
        
        this.costo_paquete = costoT;
    }
    
}


package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    
    //atributos y mapeo
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int num_venta;
    @Basic
    private String medio_pago;
    private String fecha_venta;
    
    //relacion Empleado - Ventas : 1 a N
    @ManyToOne 
    private Empleado empleadoRel;
    
    //relacion Cliente - Venta : 1 a N
    @ManyToOne
    private Cliente clienteRel;
    
    //relacion ServicioT - Ventas : 1 a N
    @ManyToOne
    private ServicioTuristico servicioRel;
    
    //relacion PaqueteT - Ventas : 1 a N
    @ManyToOne
    private PaqueteTuristico paqueteRel;
    
    
    
    //constructor
    

    public Venta(int num_venta, String medio_pago, String fecha_venta, Empleado empleadoRel, Cliente clienteRel, ServicioTuristico servicioRel, PaqueteTuristico paqueteRel) {
        this.num_venta = num_venta;
        this.medio_pago = medio_pago;
        this.fecha_venta = fecha_venta;
        this.empleadoRel = empleadoRel;
        this.clienteRel = clienteRel;
        this.servicioRel = servicioRel;
        this.paqueteRel = paqueteRel;
    }

    public Venta() {
    }
    
    //getters y setters
    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Empleado getEmpleadoRel() {
        return empleadoRel;
    }

    public void setEmpleadoRel(Empleado numEmpleado) {
        this.empleadoRel = numEmpleado;
    }

    public Cliente getClienteRel() {
        return clienteRel;
    }

    public void setClienteRel(Cliente clienteRel) {
        this.clienteRel = clienteRel;
    }

    public ServicioTuristico getServicioRel() {
        return servicioRel;
    }

    public void setServicioRel(ServicioTuristico servicioRel) {
        this.servicioRel = servicioRel;
    }

    public PaqueteTuristico getPaqueteRel() {
        return paqueteRel;
    }

    public void setPaqueteRel(PaqueteTuristico paqueteRel) {
        this.paqueteRel = paqueteRel;
    }
    
}

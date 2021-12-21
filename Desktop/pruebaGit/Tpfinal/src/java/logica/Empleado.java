
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Empleado implements Serializable {
    
    //atributos y mapeo
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_empleado;
    @Basic
    private String nombre;
    private String apellido;
    private String direccion;
    private int dni;
    private String fecha_nac;
    private String nacionalidad;
    private String celular;
    private String email;
    private String habilitado;
    
    /* tengo que averiguar bien como funciona
    @Temporal(TemporalType.DATE)
    private Date fecha_nac;
    */
    
    private String cargo;
    private double sueldo;
    
    //relacion Empleado - Usuario : 1 a 1
    @OneToOne
    private Usuario usu;
    
    //relacion Empleado - Venta : 1 a N
    //la hice desde venta N a 1
    
    //constructores

    public Empleado(int id_empleado, String nombre, String apellido, String direccion, int dni, String fecha_nac, String nacionalidad, String celular, String email, String habilitado, String cargo, double sueldo, Usuario usu) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.habilitado = habilitado;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usu = usu;
    }
    

    public Empleado() {
    }
    
    //getters y setters
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
       
}

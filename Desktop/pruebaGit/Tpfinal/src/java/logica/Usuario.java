
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    
    //atributos y mapeo
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_usuario;
    @Basic
    private String nombre_usu;
    private String contrasenia;
    
    //relacion Usuario - Empleado : 1 a 1
    //ya la hice desde empleado
    
    //relacion Usuario - Venta : 1 a N
    //@OneToMany
    //private List<Venta> lista_ventas;
    
    //constructores

    public Usuario(int id_usuario, String nombre_usu, String contrasenia) {
        this.id_usuario = id_usuario;
        this.nombre_usu = nombre_usu;
        this.contrasenia = contrasenia;
    }

    public Usuario() {
    }
    
    //getters y setters

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
/*
    public Empleado getEmple() {
        return emple;
    }

    public void setEmple(Empleado emple) {
        this.emple = emple;
    }

    public List<Venta> getLista_ventas() {
        return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
        this.lista_ventas = lista_ventas;
    }
 */   
}


package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {

    //creamos instancias para cada jpa controller que tengo
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    ClienteJpaController clienJPA = new ClienteJpaController();
    PaqueteTuristicoJpaController paqJPA = new PaqueteTuristicoJpaController();
    ServicioTuristicoJpaController servJPA = new ServicioTuristicoJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    
    //funciones de EMPLEADO y USUARIO
    public void crearEmpleado(Empleado emple, Usuario usu) {
        
        usuJPA.create(usu);
        empleJPA.create(emple);
    }

    public List<Empleado> traerEmpleados() {
        return empleJPA.findEmpleadoEntities();
    }
    
    public void eliminarEmpleado(int idEmple) {
        try {
            empleJPA.destroy(idEmple);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Empleado buscarEmpleado(int idEmple) {
        return empleJPA.findEmpleado(idEmple);
    }
    
    public void modificarEmpleado(Empleado emple) {
        try {
            empleJPA.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Usuario> traerUsuarios() {
        return usuJPA.findUsuarioEntities();
    }

    public void eliminarUsuario(int idUsu) {
        
        try {
            usuJPA.destroy(idUsu);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario buscarUsuario(int idUsu) {
        return usuJPA.findUsuario(idUsu);
    }

    public void modificarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //funciones de CLIENTE
    public void crearCliente(Cliente cliente) {
        clienJPA.create(cliente);
    }
    
    public List<Cliente> traerClientes() {
        return clienJPA.findClienteEntities();
    }
    
    public void eliminarCliente(int idClien) {
        try {
            clienJPA.destroy(idClien);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente buscarCliente(int idClien) {
        return clienJPA.findCliente(idClien);
    }
    
    public void modificarCliente(Cliente clien) {
        try {
            clienJPA.edit(clien);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    //funciones SERVICIO
    public void crearServicio(ServicioTuristico servicio) {
        
        servJPA.create(servicio);
    }
    
    public List<ServicioTuristico> traerServicios() {
        return servJPA.findServicioTuristicoEntities();
    }
    
    public void eliminarServicio(int codServ) {
        try {
            servJPA.destroy(codServ);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServicioTuristico buscarServicio(int codServ) {
        return servJPA.findServicioTuristico(codServ);
    }

    public void modificarServicio(ServicioTuristico serv) {
        try {
            servJPA.edit(serv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearPaquete(PaqueteTuristico paquete) {
        paqJPA.create(paquete);
    }

    public List<PaqueteTuristico> traerPaquetes() {
         return paqJPA.findPaqueteTuristicoEntities();
    }

    public PaqueteTuristico buscarPaquete(int codPaq) {
        return paqJPA.findPaqueteTuristico(codPaq);
    }

    public void modificarPaquete(PaqueteTuristico paq) {
        try {
            paqJPA.edit(paq);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearVenta(Venta ven) {
        ventaJPA.create(ven);
    }

    public List<Venta> traerVentas() {
        return ventaJPA.findVentaEntities();
    }

}

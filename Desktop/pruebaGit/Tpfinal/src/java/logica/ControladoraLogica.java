
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;


public class ControladoraLogica {
    
    //creamos una instancia a la controladora de persistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearEmpleado (String nombre, String apellido, String direccion, int dni, String fecha_nac, String nacionalidad, String celular, String email, String cargo, double sueldo, String nombre_usuario, String contrasenia) {
    
        Empleado emple = new Empleado();
        Usuario usu = new Usuario();
        
        //asigno valores al empleado
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDireccion(direccion);
        emple.setDni(dni);
        emple.setFecha_nac(fecha_nac);
        emple.setNacionalidad(nacionalidad);
        emple.setCelular(celular);
        emple.setEmail(email);
        //emple.setFecha_nac(fecha_nac);
        emple.setCargo(cargo);
        emple.setSueldo(sueldo);
        emple.setHabilitado("SI");
        
        //asigno valores a usuario
        usu.setNombre_usu(nombre_usuario);
        usu.setContrasenia(contrasenia);
        
        //asigno usuario a empleado
        emple.setUsu(usu);
        
        //llamamos a la controladora de persistencia para que almacene los objetos cargados en la bd
        controlPersis.crearEmpleado (emple, usu);
    }
    
    public List<Empleado> traerEmpleados() {
        return controlPersis.traerEmpleados();
    }
    
    public void eliminarEmpleado(int idEmple) {
        controlPersis.eliminarEmpleado(idEmple);
    }
    
    public Empleado buscarEmpleado(int idEmple) {
        return controlPersis.buscarEmpleado(idEmple);
    }
    
    public void modificarEmpleado(Empleado emple) {
        controlPersis.modificarEmpleado(emple);
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public void eliminarUsuario(int idUsu) {
        controlPersis.eliminarUsuario(idUsu);
    }

    public Usuario buscarUsuario(int idUsu) {
        return controlPersis.buscarUsuario(idUsu);    
    }

    public void modificarUsuario(Usuario usu) {
        controlPersis.modificarUsuario(usu);
    }

    //funciones de CLIENTE
    public void crearCliente(String nombre, String apellido, String direccion, int dni, String fecha_nac, String nacionalidad, String celular, String email) {
        Cliente cliente = new Cliente();
        
        //asigno valores al empleado
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setFecha_nac(fecha_nac);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        cliente.setHabilitado("SI");
        
        //llamamos a la controladora de persistencia para que almacene los objetos cargados en la bd
        controlPersis.crearCliente (cliente);
    }
    
    public List<Cliente> traerClientes() {
        return controlPersis.traerClientes();
    }
    
    public void eliminarCliente(int idClien) {
        controlPersis.eliminarCliente(idClien);
    }
    
    public Cliente buscarCliente(int idClien) {
        return controlPersis.buscarCliente(idClien); 
    }
    
    public void modificarCliente(Cliente clien) {
        controlPersis.modificarCliente(clien);
    }

    //funciones de SERVICIO
    public void crearServicio(String nombreServ, String descripcion, String destino, double costo, String fecha) {
        
        ServicioTuristico servicio = new ServicioTuristico();
        
        servicio.setNombre(nombreServ);
        servicio.setDescripcion(descripcion);
        servicio.setDestino_servicio(destino);
        servicio.setCosto_servicio(costo);
        servicio.setFecha_servicio(fecha);
        servicio.setHabilitado("SI");
        
        controlPersis.crearServicio (servicio);
    }
    
    public List<ServicioTuristico> traerServicios() {
        return controlPersis.traerServicios();
    }
    
    public void eliminarServicio(int codServ) {
        controlPersis.eliminarServicio(codServ);
    }

    public ServicioTuristico buscarServicio(int codServ) {
        return controlPersis.buscarServicio(codServ); 
    }

    public void modificarServicio(ServicioTuristico serv) {
        controlPersis.modificarServicio(serv);
    }

    public void crearPaquete(List<ServicioTuristico> listaServiciosInc) {
        
        PaqueteTuristico paquete = new PaqueteTuristico();
        
        paquete.setHabilitado("SI");
        
        //asigno costo del paquete 
        paquete.calcularCosto(listaServiciosInc);
        
        //asigno servicios al paquete
        paquete.setLista_servicios_incluidos(listaServiciosInc);
        
        //le digo a la controladora de la persistencia que cree el paquete
        controlPersis.crearPaquete(paquete);
        
        //asigno paquete a servicios
        for (ServicioTuristico serv: listaServiciosInc) {
            List <PaqueteTuristico> listaPaq = serv.getLista_paquetes();
            listaPaq.add(paquete);
            serv.setLista_paquetes(listaPaq);
        }
    }

    public List<PaqueteTuristico> traerPaquetes() {
        return controlPersis.traerPaquetes();
    }

    public PaqueteTuristico buscarPaquete(int codPaq) {
        return controlPersis.buscarPaquete(codPaq);
    }

    public void modificarPaquete(PaqueteTuristico paq) {
        controlPersis.modificarPaquete(paq);
    }

    public void crearVentaServ(String medPago, String fechaVen, Empleado emple, Cliente clien, ServicioTuristico serv) {
        
        Venta ven = new Venta();
        
        ven.setMedio_pago(medPago);
        ven.setFecha_venta(fechaVen);
        
        //asigno empleado, cliente y servicio a la venta
        ven.setEmpleadoRel(emple);
        ven.setClienteRel(clien);
        ven.setServicioRel(serv);
        
        //le digo a la controladora de la persistencia que cree la venta desde esta controladora L
        controlPersis.crearVenta(ven);
    }

    public void crearVentaPaq(String medPago, String fechaVen, Empleado emple, Cliente clien, PaqueteTuristico paq) {
        
        Venta ven = new Venta();
        
        ven.setMedio_pago(medPago);
        ven.setFecha_venta(fechaVen);
        
        //asigno empleado, cliente y servicio a la venta
        ven.setEmpleadoRel(emple);
        ven.setClienteRel(clien);
        ven.setPaqueteRel(paq);
        
        //le digo a la controladora de la persistencia que cree la venta desde esta controladora L
        controlPersis.crearVenta(ven);
    }

    public List<Venta> traerVentas() {
        return controlPersis.traerVentas();
    }


}

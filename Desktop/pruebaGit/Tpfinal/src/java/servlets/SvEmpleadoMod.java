
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Empleado;


@WebServlet(name = "SvEmpleadoMod", urlPatterns = {"/SvEmpleadoMod"})
public class SvEmpleadoMod extends HttpServlet {

    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del empleado a modificar
        int idEmple = Integer.parseInt(request.getParameter("idEmple"));
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        int dni = Integer.parseInt(request.getParameter("dni"));
        String fecha_nac = request.getParameter("fecha_nac");
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        String hab = request.getParameter("select");
        
        Empleado emple = control.buscarEmpleado(idEmple);
        //reasigno valores al empleado
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDireccion(direccion);
        emple.setDni(dni);
        emple.setFecha_nac(fecha_nac);
        emple.setNacionalidad(nacionalidad);
        emple.setCelular(celular);
        emple.setEmail(email);
        emple.setCargo(cargo);
        emple.setSueldo(sueldo);
        emple.setHabilitado(hab);
        
        control.modificarEmpleado(emple);
        
        //actualizo mi lista de empleados
        request.getSession().setAttribute("listaEmpleados", control.traerEmpleados());
        response.sendRedirect("empleados_lista.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del empleado a modificar
        int idEmple = Integer.parseInt(request.getParameter("idEmple"));
        
        Empleado emple = control.buscarEmpleado(idEmple);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("empleado", emple);
        
        response.sendRedirect("empleados_edit.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

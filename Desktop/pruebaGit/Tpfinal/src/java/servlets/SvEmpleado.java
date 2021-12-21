
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //guardo todos los datos que recibo del formulario en variables
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        int dni = Integer.parseInt(request.getParameter("dni"));
        String fecha_nac = request.getParameter("fecha_nac");
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        /*
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");   
        try {
            Date fecha_nac = formato.parse(request.getParameter("fecha_nac"));
        } catch (ParseException ex) {
            Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        String cargo = request.getParameter("cargo");
        double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        String nombre_usuario = request.getParameter("nombre_usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        //traigo la sesion actual y asigno atributos mientras dure la sesion (para utilizarlos en otos jsp)
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fecha_nac", fecha_nac);
        request.getSession().setAttribute("nacionalidad", nacionalidad);
        request.getSession().setAttribute("celular", celular);
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("cargo", cargo);
        request.getSession().setAttribute("sueldo", sueldo);
        
        request.getSession().setAttribute("nombre_usuario", nombre_usuario);
        request.getSession().setAttribute("contrasenia", contrasenia);
        
        //le digo a la controladora de la logica que cree un empleado con estos datos
        control.crearEmpleado(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email, cargo, sueldo, nombre_usuario, contrasenia);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

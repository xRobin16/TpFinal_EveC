
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;


@WebServlet(name = "SvClienteAlta", urlPatterns = {"/SvClienteAlta"})
public class SvClienteAlta extends HttpServlet {
    
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
        
        //traigo la sesion actual y asigno atributos mientras dure la sesion (para utilizarlos en otos jsp)
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fecha_nac", fecha_nac);
        request.getSession().setAttribute("nacionalidad", nacionalidad);
        request.getSession().setAttribute("celular", celular);
        request.getSession().setAttribute("email", email);
        
        //le digo a la controladora de la logica que cree un empleado con estos datos
        control.crearCliente(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

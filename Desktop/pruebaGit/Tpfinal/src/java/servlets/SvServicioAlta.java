
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;


@WebServlet(name = "SvServicioAlta", urlPatterns = {"/SvServicioAlta"})
public class SvServicioAlta extends HttpServlet {

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
        
        String nombreServ = request.getParameter("nombreServ");
        String descripcion = request.getParameter("descripcion");
        String destino = request.getParameter("destino");
        double costo = Double.parseDouble(request.getParameter("costo"));
        String fecha = request.getParameter("fecha");

        //traigo la sesion actual y asigno atributos mientras dure la sesion (para utilizarlos en otos jsp)
        request.getSession().setAttribute("nombreServ", nombreServ);
        request.getSession().setAttribute("descripcion", descripcion);
        request.getSession().setAttribute("destino", destino);
        request.getSession().setAttribute("costo", costo);
        request.getSession().setAttribute("fecha", fecha);
        
        //le digo a la controladora de la logica que cree un servicio con estos datos
        control.crearServicio(nombreServ, descripcion, destino, costo, fecha);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

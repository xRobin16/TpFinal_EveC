
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.ServicioTuristico;


@WebServlet(name = "SvServicioConsulta", urlPatterns = {"/SvServicioConsulta"})
public class SvServicioConsulta extends HttpServlet {

    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <ServicioTuristico> listaServicios = control.traerServicios();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("servicios_lista.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


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
import logica.ServicioTuristico;


@WebServlet(name = "SvServicioMod", urlPatterns = {"/SvServicioMod"})
public class SvServicioMod extends HttpServlet {
    
    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del servicio a modificar
        int codServ = Integer.parseInt(request.getParameter("codServ"));
        
        String nombreServ = request.getParameter("nombreServ");
        String descripcion = request.getParameter("descripcion");
        String destino = request.getParameter("destino");
        double costo = Double.parseDouble(request.getParameter("costo"));
        String fecha = request.getParameter("fecha");
        String hab = request.getParameter("select");
        
        ServicioTuristico serv = control.buscarServicio(codServ);
        serv.setNombre(nombreServ);
        serv.setDescripcion(descripcion);
        serv.setDestino_servicio(destino);
        serv.setCosto_servicio(costo);
        serv.setFecha_servicio(fecha);
        serv.setHabilitado(hab);
        
        control.modificarServicio(serv);
        
        //actualizo mi lista de servicios
        request.getSession().setAttribute("listaServicios", control.traerServicios());
        response.sendRedirect("servicios_lista.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del servicio a modificar
        int codServ = Integer.parseInt(request.getParameter("codServ"));
        
        ServicioTuristico serv = control.buscarServicio(codServ);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("servicio", serv);
        
        response.sendRedirect("servicios_edit.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


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
import logica.PaqueteTuristico;
import logica.ServicioTuristico;


@WebServlet(name = "SvPaqueteMod", urlPatterns = {"/SvPaqueteMod"})
public class SvPaqueteMod extends HttpServlet {

    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del paquete a modificar
        int codServ = Integer.parseInt(request.getParameter("codPaq"));
        
        String hab = request.getParameter("select");
        
        //busco a que paquete pertenece el codigo que recibo del formulario
        PaqueteTuristico paq = control.buscarPaquete(codServ);
        
        //actualizo los datos modificados
        paq.setHabilitado(hab);
        
        control.modificarPaquete(paq);
        
        //actualizo mi lista de usuarios
        request.getSession().setAttribute("listaPaquetes", control.traerPaquetes());
        response.sendRedirect("paquetes_lista.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del paquete a modificar
        int codPaq = Integer.parseInt(request.getParameter("codPaq"));
        
        PaqueteTuristico paq = control.buscarPaquete(codPaq);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("paquete", paq);
        
        List <ServicioTuristico> listaServicios = control.traerServicios();
        misession.setAttribute("listaServicios", listaServicios);
        
        response.sendRedirect("paquetes_edit.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

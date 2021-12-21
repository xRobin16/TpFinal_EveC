
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.ControladoraLogica;
import logica.Empleado;
import logica.ServicioTuristico;


@WebServlet(name = "SvVentaServAlta", urlPatterns = {"/SvVentaServAlta"})
public class SvVentaServAlta extends HttpServlet {

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
        
        int idEmple = Integer.parseInt(request.getParameter("empleadoSelect"));
        int idClien = Integer.parseInt(request.getParameter("clienteSelect"));
        int codServ = Integer.parseInt(request.getParameter("servicioSelect"));
        String medPago = request.getParameter("medPago");
        String fechaVen = request.getParameter("fechaVen");
        
        //traigo la sesion actual y asigno atributos mientras dure la sesion (para utilizarlos en otos jsp)
        request.getSession().setAttribute("idEmple", idEmple);
        request.getSession().setAttribute("idClien", idClien);
        request.getSession().setAttribute("codServ", codServ);
        request.getSession().setAttribute("medPago", medPago);
        request.getSession().setAttribute("fechaVen", fechaVen);
        
        Empleado emple = control.buscarEmpleado(idEmple);
        Cliente clien = control.buscarCliente(idClien);
        ServicioTuristico serv = control.buscarServicio(codServ);
        
        //le digo a la controladora logica que cree una venta con los datos guardados
        control.crearVentaServ(medPago, fechaVen, emple, clien, serv);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

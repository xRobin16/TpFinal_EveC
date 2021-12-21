
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
import logica.Cliente;
import logica.ControladoraLogica;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;


@WebServlet(name = "SvVentaDirec", urlPatterns = {"/SvVentaDirec"})
public class SvVentaDirec extends HttpServlet {

    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession misession = request.getSession();
        
        //cargo lista de empleados
        List <Empleado> listaEmpleados = control.traerEmpleados();
        misession.setAttribute("listaEmpleados", listaEmpleados);
        
        //cargo lista de clientes
        List <Cliente> listaClientes = control.traerClientes();
        misession.setAttribute("listaClientes", listaClientes);
        
        //cargo lista de servicios
        List <ServicioTuristico> listaServicios = control.traerServicios();
        misession.setAttribute("listaServicios", listaServicios);

        //cargo lista de paquetes
        List <PaqueteTuristico> listaPaquetes = control.traerPaquetes();
        misession.setAttribute("listaPaquetes", listaPaquetes);
        
        response.sendRedirect("ventas_serv.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

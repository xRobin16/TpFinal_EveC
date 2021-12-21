
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;
import logica.ServicioTuristico;


@WebServlet(name = "SvPaqueteAlta", urlPatterns = {"/SvPaqueteAlta"})
public class SvPaqueteAlta extends HttpServlet {
    
    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //guardo la lista de codigos servicios que recibo del formulario (los recibo como string)
        String[] listaServSelec = request.getParameterValues("servSelec");
        
        //List list = Arrays.asList(listaServSelec);
	
        //creo una lista de tipo SERVICIOS
        List <ServicioTuristico> listaServiciosInc = new ArrayList<>();
        
        //cambio los codigos string a enteros
        for (String codigoServ : listaServSelec ) {
            int codServ = Integer.parseInt(codigoServ);
            
            //busco los servicios incluidos utilizando su codigo
            ServicioTuristico serv = control.buscarServicio(codServ);
            
            //y los agrego a la lista de servicios incluidos
            listaServiciosInc.add(serv);   
        }
        
        //traigo la sesion actual y asigno atributos mientras dure la sesion (para utilizarlos en otos jsp)
        request.setAttribute("listaServSelec", listaServSelec);
        
        //le digo a la controladora de la logica que cree un paquete con estos datos
        control.crearPaquete(listaServiciosInc);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

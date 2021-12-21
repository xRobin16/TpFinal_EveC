
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;


@WebServlet(name = "SvEmpleadoDel", urlPatterns = {"/SvEmpleadoDel"})
public class SvEmpleadoDel extends HttpServlet {

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
        
        //traigo la id del empleado a eliminar
        int idEmple = Integer.parseInt(request.getParameter("idEmple"));
        //y traigo la id del usuario a eliminar
        int idUsu = Integer.parseInt(request.getParameter("idUsu"));
        
        control.eliminarEmpleado(idEmple);
        control.eliminarUsuario(idUsu);
        
        //actualizo mi lista de usuarios
        request.getSession().setAttribute("listaEmpleados", control.traerEmpleados());
        
        response.sendRedirect("empleados_lista.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

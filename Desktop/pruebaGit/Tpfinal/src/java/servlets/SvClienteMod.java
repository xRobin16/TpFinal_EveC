
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.ControladoraLogica;


@WebServlet(name = "SvClienteMod", urlPatterns = {"/SvClienteMod"})
public class SvClienteMod extends HttpServlet {

    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del cliente a modificar
        int idClien = Integer.parseInt(request.getParameter("idClien"));
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        int dni = Integer.parseInt(request.getParameter("dni"));
        String fecha_nac = request.getParameter("fecha_nac");
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String hab = request.getParameter("select");
        
        Cliente clien = control.buscarCliente(idClien);
        //reasigno valores al cliente
        clien.setNombre(nombre);
        clien.setApellido(apellido);
        clien.setDireccion(direccion);
        clien.setDni(dni);
        clien.setFecha_nac(fecha_nac);
        clien.setNacionalidad(nacionalidad);
        clien.setCelular(celular);
        clien.setEmail(email);
        clien.setHabilitado(hab);
        
        control.modificarCliente(clien);
        
        //actualizo mi lista de clientes
        request.getSession().setAttribute("listaClientes", control.traerClientes());
        response.sendRedirect("clientes_lista.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del cliente a modificar
        int idClien = Integer.parseInt(request.getParameter("idClien"));
        
        Cliente clien = control.buscarCliente(idClien);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("cliente", clien);
        
        response.sendRedirect("clientes_edit.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

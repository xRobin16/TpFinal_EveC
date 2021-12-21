
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
import logica.Usuario;


@WebServlet(name = "SvUsuarioModificar", urlPatterns = {"/SvUsuarioModificar"})
public class SvUsuarioModificar extends HttpServlet {

    //creo una instancia global de controladora de la logica para utilizarla en cualquier metodo
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del usuario a modificar
        int idUsu = Integer.parseInt(request.getParameter("idUsu"));
        
        String nombre_usuario = request.getParameter("nombre_usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        Usuario usu = control.buscarUsuario(idUsu);
        usu.setNombre_usu(nombre_usuario);
        usu.setContrasenia(contrasenia);
        
        control.modificarUsuario(usu);
        
        //actualizo mi lista de usuarios
        request.getSession().setAttribute("listaUsuarios", control.traerUsuarios());
        response.sendRedirect("usuarios_lista.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo la id del usuario a modificar
        int idUsu = Integer.parseInt(request.getParameter("idUsu"));
        
        Usuario usu = control.buscarUsuario(idUsu);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("usuario", usu);
        
        response.sendRedirect("usuarios_edit.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

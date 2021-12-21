

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Usuarios</title>
    </head>
    <body>
        <h1>Edicion de Usuario</h1>
        <h2>Datos del Usuario</h2>
        
        <% HttpSession misession = request.getSession();
                
                Usuario usu = (Usuario) misession.getAttribute("usuario"); 
                
                String nombreCompleto = usu.getNombre_usu();
                String pw = usu.getContrasenia();
                int idUsu = usu.getId_usuario();
        %>
        <form action="SvUsuarioModificar" method="get">

            <p><label>Nombre de Usuario: </label><input type="text" name="nombre_usuario" value="<%=nombreCompleto%>"</p>
            <p><label>Contrasenia: </label><input type="password" name="contrasenia" value="<%=pw%>"></p>
            
            <p><input type="hidden" name="idUsu" value="<%=idUsu%>"</p>
            
            <button type="submit"> Guardar </button>
        </form>
    </body>
</html>

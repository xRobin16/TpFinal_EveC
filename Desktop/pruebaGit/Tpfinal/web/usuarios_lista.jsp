

<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Usuarios</title>
    </head>
    <body>
        <h1>Lista de usuarios</h1>
        
        <table class="default">
            <thead>

                <tr>
                    <th>Nombre usuario</th>
                    <th>Contrasenia</th>
                    <th>Modificar</th>
                </tr>
                
            </thead>
            <tbody>
                <% HttpSession misession = request.getSession();
                
                List <Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                for (Usuario usu : listaUsuarios) {
                %>
                    <tr>
                        <% String nombreCompleto = usu.getNombre_usu(); %>
                        <td> 
                            <%=nombreCompleto %> 
                        </td>
                        <% String pw = usu.getContrasenia(); %>
                        <td> 
                            <%=pw %> 
                        </td>
                        <% int idUsu = usu.getId_usuario(); %>
                        
                        
                        <td><form name="formModificarUsu" action="SvUsuarioModificar" method="POST">
                                <input type="hidden" name="idUsu" value="<%=idUsu%>">
                                <button type="submit">Modificar</button>
                            </form>
                        </td>
                    </tr>
                <%}%>
                
                
            </tbody>
        </table>
        <br>
        
        <button onclick=location.href="index.jsp">Volver al Menu</button>
        
        <form action="SvEmpleadoConsulta" method="GET">
                <a href="SvEmpleadoConsulta" class="SUBMIT">Ver Empleados</a> 
            </form>
    </body>
</html>

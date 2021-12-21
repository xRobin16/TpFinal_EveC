

<%@page import="logica.Usuario"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de empleados</title>
    </head>
    <body>
        <button onclick=location.href="empleados.jsp">Crear Empleado</button>
        <h1>Lista de Empleados</h1>
        
        <table class="default">
            <thead>
                <tr>                    
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>DIRECCION</th>
                    <th>DNI</th>
                    <th>FECHA NAC</th>
                    <th>NACIONALIDAD</th>
                    <th>CELULAR</th>
                    <th>EMAIL</th>
                    <th>CARGO</th>
                    <th>SUELDO</th>
                    <th>USUARIO</th>
                    <th>HABILITADO ||</th>
                </tr>              
            </thead>
            <tbody>
                <% HttpSession misession = request.getSession();
                
                List <Empleado> listaEmpleados = (List) request.getSession().getAttribute("listaEmpleados");
                for (Empleado emple : listaEmpleados) {
                %>
                    <tr>
                        <% String nombre = emple.getNombre(); %>
                        <td> 
                            <%=nombre%> 
                        </td>
                        <% String apellido = emple.getApellido(); %>
                        <td> 
                            <%=apellido %> 
                        </td>
                        <% String direccion = emple.getDireccion(); %>
                        <td> 
                            <%=direccion %> 
                        </td>
                        <% int dni = emple.getDni(); %>
                        <td> 
                            <%=dni %> 
                        </td>
                        <% String fecha = emple.getFecha_nac(); %>
                        <td> 
                            <%=fecha %> 
                        </td>
                        <% String nacion = emple.getNacionalidad(); %>
                        <td> 
                            <%=nacion %> 
                        </td>
                        <% String celular = emple.getCelular(); %>
                        <td> 
                            <%=celular %> 
                        </td>
                        <% String email = emple.getEmail(); %>
                        <td> 
                            <%=email %> 
                        </td>
                        <% String cargo = emple.getCargo(); %>
                        <td> 
                            <%=cargo %> 
                        </td>
                        <% double sueldo = emple.getSueldo(); %>
                        <td> 
                            <%=sueldo %> 
                        </td>
                        <% Usuario usu = emple.getUsu();
                           String nomUsu = usu.getNombre_usu();
                        %>
                        <td> 
                            <%=nomUsu %> 
                        </td>
                        <% String hab = emple.getHabilitado(); %>
                        <td> 
                            <%=hab %> 
                        </td>
                        
                        <% int idEmple = emple.getId_empleado();
                            int idUsu = usu.getId_usuario(); %>
                        
       
                        <td><form name="formModificarEmpleado" action="SvEmpleadoMod" method="POST">
                                <input type="hidden" name="idEmple" value="<%=idEmple%>">
                                <button type="submit">Modificar</button>
                            </form>
                        </td>
                    </tr>
                <%}%>
                
            </tbody>
        </table>
        <br>
        
        <button onclick=location.href="index.jsp">Volver al Menu</button>
        
        <form action="SvUsuarioConsulta" method="GET">
            <a href="SvUsuarioConsulta" class="SUBMIT">Ver Usuarios</a> 
        </form>
    </body>
</html>



<%@page import="logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Clientes</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        
        <table class="default">
            <thead>
                <tr>                    
                    <th>NOMBRE ||</th>
                    <th>APELLIDO ||</th>
                    <th>DIRECCION ||</th>
                    <th>DNI ||</th>
                    <th>FECHA NAC ||</th>
                    <th>NACION ||</th>
                    <th>CELULAR ||</th>
                    <th>EMAIL ||</th>
                    <th>HABILITADO ||</th>
            </thead>
            <tbody>
                <% HttpSession misession = request.getSession();
                
                List <Cliente> listaClientes = (List) request.getSession().getAttribute("listaClientes");
                for (Cliente clien : listaClientes) {
                %>
                    <tr>
                        <% String nombre = clien.getNombre(); %>
                        <td> 
                            <%=nombre%> 
                        </td>
                        <% String apellido = clien.getApellido(); %>
                        <td> 
                            <%=apellido %> 
                        </td>
                        <% String direccion = clien.getDireccion(); %>
                        <td> 
                            <%=direccion %> 
                        </td>
                        <% int dni = clien.getDni(); %>
                        <td> 
                            <%=dni %> 
                        </td>
                        <% String fecha = clien.getFecha_nac(); %>
                        <td> 
                            <%=fecha %> 
                        </td>
                        <% String nacion = clien.getNacionalidad(); %>
                        <td> 
                            <%=nacion %> 
                        </td>
                        <% String celular = clien.getCelular(); %>
                        <td> 
                            <%=celular %> 
                        </td>
                        <% String email = clien.getEmail(); %>
                        <td> 
                            <%=email %> 
                        </td>
                        <% String hab = clien.getHabilitado(); %>
                        <td> 
                            <%=hab %> 
                        </td>
                        
                        <% int idClien = clien.getId_cliente(); %>
                        
                        
                        <td><form name="formModificarCliente" action="SvClienteMod" method="POST">
                                <input type="hidden" name="idClien" value="<%=idClien%>">
                                <button type="submit">Modificar</button>
                            </form>
                        </td>
                    </tr>
                <%}%>
                
            </tbody>
        </table>
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>



<%@page import="logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios Turisticos</title>
    </head>
    <body>
        <h1>Lista de Servicios Turisticos</h1>
        
        <table class="default">
            <thead>

                <tr>
                    <th>Codigo ||</th>
                    <th>Nombre ||</th>
                    <th>Descripcion ||</th>
                    <th>Destino ||</th>
                    <th>Costo ||</th>
                    <th>Fecha ||</th>
                    <th>Habilitado ||</th>

                </tr>
                
            </thead>
            <tbody>
                <% HttpSession misession = request.getSession();
                
                List <ServicioTuristico> listaServicios = (List) request.getSession().getAttribute("listaServicios");
                for (ServicioTuristico serv : listaServicios) {
                %>
                    <tr>
                        <% int codServ = serv.getCodigo_servicio(); %>
                        <td> 
                            <%=codServ %> 
                        </td>
                        <% String nombreServ = serv.getNombre(); %>
                        <td> 
                            <%=nombreServ %> 
                        </td>
                        <% String descrip = serv.getDescripcion(); %>
                        <td> 
                            <%=descrip %> 
                        </td>
                        <% String destino = serv.getDestino_servicio(); %>
                        <td> 
                            <%=destino %> 
                        </td>
                        <% double costo = serv.getCosto_servicio(); %>
                        <td> 
                            <%=costo %> 
                        </td>
                        <% String fecha = serv.getFecha_servicio(); %>
                        <td> 
                            <%=fecha %> 
                        </td>
                        <% String hab = serv.getHabilitado(); %>
                        <td> 
                            <%=hab %> 
                        </td>
                        
                        
                        <td><form name="formModificarServicio" action="SvServicioMod" method="POST">
                                <input type="hidden" name="codServ" value="<%=codServ%>">
                                <button type="submit">Modificar</button>
                            </form>
                        </td>
                    </tr>
                <%}%>
                
            </tbody>
        </table>
        <br>
        <form action="SvVentaDirec" method="GET">
                <button href="SvVentaDirec" type="submit">Crear Venta de Servicio</button>
        </form>
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>

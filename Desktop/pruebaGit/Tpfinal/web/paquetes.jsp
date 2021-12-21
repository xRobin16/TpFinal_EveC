

<%@page import="java.util.ArrayList"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paquetes Turisticos</title>
    </head>
    <body>
        <h1>Alta de paquetes</h1>
        
        <h2>Seleccione al menos dos servicios para armar un paquete</h2>
        
        <form action="SvPaqueteAlta" method="POST">       
            
            <table class="default">
                <thead>

                    <tr>
                        <th>Nombre ||</th>
                        <th>Descripcion ||</th>
                        <th>Destino ||</th>
                        <th>Costo ||</th>
                        <th>Fecha ||</th>
                        <th>Habilitado ||</th>
                        <th>Agregar ||</th>

                    </tr>

                </thead>

                <tbody>

                    <% HttpSession misession = request.getSession();

                    //List <ServicioTuristico> listaServInc = new ArrayList <ServicioTuristico>();
                    //List <Integer> listaServInc = new ArrayList <>();

                    List <ServicioTuristico> listaServicios = (List) request.getSession().getAttribute("listaServicios");
                    for (ServicioTuristico serv : listaServicios) {

                        String hab = serv.getHabilitado();
                        if("SI".equals(hab)) {
                    %>
                            <tr>
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
                                <td> 
                                    <%=hab %> 
                                </td>

                                <% int codServ = serv.getCodigo_servicio(); %>

                                <td> 

                                    <input type=checkbox name="servSelec" value="<%=codServ%>">

                                </td>

                            </tr>
                        <%}%>
                    <%}%>

                </tbody>
            </table>
                
                <button type="submit">Crear Paquete</button><br>       
        </form>
            
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>

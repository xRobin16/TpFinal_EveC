

<%@page import="logica.Venta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Ventas</title>
    </head>
    <body>
        <h1>Lista de Ventas</h1>
        <br>
        <form action="SvVentaDirec" method="GET">
                <button href="SvVentaDirec" type="submit">Crear Venta de Servicio</button>
        </form>
        <h2>Lista de Ventas de Servicios</h2>
        
        <table class="default">
            <thead>
                <tr>                    
                    <th>Numero de Venta ||</th>
                    <th>Medio de Pago ||</th>
                    <th>Fecha ||</th>
                    <th>Id Empleado ||</th>
                    <th>Id Cliente ||</th>
                    <th>Codigo de Servicio ||</th>
                    <th>Eliminar ||</th>
                    <th>Modificar</th>
            </thead>
            <tbody>
                <% HttpSession misession = request.getSession();
                
                List <Venta> listaVentas = (List) request.getSession().getAttribute("listaVentas");
                for (Venta ven : listaVentas) {
                    if (ven.getServicioRel()!=null) {
                %>
                        <tr>
                            <% int numVen = ven.getNum_venta();%>
                            <td> 
                                <%=numVen%> 
                            </td>
                            <% String medPago = ven.getMedio_pago(); %>
                            <td> 
                                <%=medPago %> 
                            </td>
                            <% String fecha = ven.getFecha_venta(); %>
                            <td> 
                                <%=fecha %> 
                            </td>
                            <% int idEmple = ven.getEmpleadoRel().getId_empleado(); %>
                            <td> 
                                <%=idEmple %> 
                            </td>
                            <% int idClien = ven.getClienteRel().getId_cliente(); %>
                            <td> 
                                <%=idClien %> 
                            </td>
                            <% int codServ = ven.getServicioRel().getCodigo_servicio(); %>
                            <td> 
                                <%=codServ %> 
                            </td>

                            <td><form name="formDelVentaS" action="SvVentaDelServ" method="POST">
                                    <input type="hidden" name="numVen" value="<%=numVen%>">
                                    <button type="submit">Eliminar</button>
                                </form>
                            </td>

                            <td><form name="formModVentaS" action="SvVentaModServ" method="POST">
                                    <input type="hidden" name="numVen" value="<%=numVen%>">
                                    <button type="submit">Modificar</button>
                                </form>
                            </td>
                        </tr>
                    <%}%>
                <%}%>
            </tbody>
        </table>
        <br>
        <h2>Lista de Ventas de Paquetes</h2>
        
        <table class="default">
            <thead>
                <tr>                    
                    <th>Numero de Venta ||</th>
                    <th>Medio de Pago ||</th>
                    <th>Fecha ||</th>
                    <th>Id Empleado ||</th>
                    <th>Id Cliente ||</th>
                    <th>Codigo de Paquete ||</th>
                    <th>Eliminar ||</th>
                    <th>Modificar</th>
            </thead>
            <tbody>
                <% 
                for (Venta ven : listaVentas) {
                    if (ven.getPaqueteRel()!=null) {
                %>
                        <tr>
                            <% int numVen = ven.getNum_venta();%>
                            <td> 
                                <%=numVen%> 
                            </td>
                            <% String medPago = ven.getMedio_pago(); %>
                            <td> 
                                <%=medPago %> 
                            </td>
                            <% String fecha = ven.getFecha_venta(); %>
                            <td> 
                                <%=fecha %> 
                            </td>
                            <% int idEmple = ven.getEmpleadoRel().getId_empleado(); %>
                            <td> 
                                <%=idEmple %> 
                            </td>
                            <% int idClien = ven.getClienteRel().getId_cliente(); %>
                            <td> 
                                <%=idClien %> 
                            </td>
                            <%int codPaq = ven.getPaqueteRel().getCodigo_paquete(); %>
                            <td> 
                                <%=codPaq %> 
                            </td> 

                            <td><form name="formDelVentaP" action="SvVentaDelPaq" method="POST">
                                    <input type="hidden" name="numVen" value="<%=numVen%>">
                                    <button type="submit">Eliminar</button>
                                </form>
                            </td>

                            <td><form name="formModVentaP" action="SvVentaModPaq" method="POST">
                                    <input type="hidden" name="numVen" value="<%=numVen%>">
                                    <button type="submit">Modificar</button>
                                </form>
                            </td>
                        </tr>
                    <%}%>
                <%}%>
                
            </tbody>
        </table>
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>

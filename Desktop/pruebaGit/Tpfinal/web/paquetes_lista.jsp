

<%@page import="java.util.ArrayList"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="logica.PaqueteTuristico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Paquetes</title>
    </head>
    <body>
        
        <form action="SvServicioConsultaP" method="GET">
                <button href="SvServicioConsultaP" type="submit">Crear Paquete</button>
        </form>
        
        <h1>Lista de paquetes</h1>
        
        <table class="default">
            <thead>
                <tr>
                    <th>Codigo ||</th>
                    <th>Costo  ||</th>
                    <th>Habilitado  ||</th>
                    <th>Servicios Incluidos  ||</th>
                    <th>Editar Estado  ||</th>
                    <th>Editar Servicios Incluidos</th>
                    
                </tr>              
            </thead>
            <tbody>
                <% HttpSession misession = request.getSession();
                
                List <PaqueteTuristico> listaPaquetes = (List) request.getSession().getAttribute("listaPaquetes");
                for (PaqueteTuristico paq : listaPaquetes) {
                %>
                    <tr>
                        <% int codPaq = paq.getCodigo_paquete(); %>
                        <td> 
                            <%=codPaq%> 
                        </td>
                        
                        <% double costo = paq.getCosto_paquete(); %>
                        <td> 
                            <%=costo%> 
                        </td>
                        <% String hab = paq.getHabilitado(); %>
                        <td> 
                            <%=hab %> 
                        </td>
                        <td>
                        <% List <ServicioTuristico> listaServiciosInc = new ArrayList<>();
                            listaServiciosInc = paq.getLista_servicios_incluidos();
                           for (ServicioTuristico serv : listaServiciosInc) {
                               
                               int codServ = serv.getCodigo_servicio();
                                String nombreServ = serv.getNombre(); %>
                                
                                <label>-</label><%=nombreServ %><br>   

                            <%}%>
                        </td>   
                        
                        
                        
                        <td><form name="formPaqueteMod" action="SvPaqueteMod" method="POST">
                                <input type="hidden" name="codPaq" value="<%=codPaq%>">
                                <button type="submit">Modificar</button>
                            </form>
                        </td>
                        
                        <td><form name="formPaqueteMod" action="SvPaqueteModServ" method="POST">
                                <input type="hidden" name="codPaq" value="<%=codPaq%>">
                                <button type="submit">Modificar</button>
                            </form>
                        </td>
                    </tr>
                <%}%>
                
            </tbody>
        </table>
        <br>
        
        <form action="SvVentaDirecP" method="GET">
                <button href="SvVentaDirecP" type="submit">Crear Venta de Paquete</button>
        </form>
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>

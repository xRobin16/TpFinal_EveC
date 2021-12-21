

<%@page import="java.util.ArrayList"%>
<%@page import="logica.PaqueteTuristico"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de paquetes</title>
    </head>
    <body>
        <h1>Edicion de paquete</h1>
        
        <h2>Paquete seleccionado:</h2>
        
        <form action="SvPaqueteMod" method="get">
            <% HttpSession misession = request.getSession();

            PaqueteTuristico paq = (PaqueteTuristico) misession.getAttribute("paquete"); 
                    
            int codPaq = paq.getCodigo_paquete();
            double costo = paq.getCosto_paquete();
            %>
        
                   
            <p><label>Codigo de paquete: </label> <%=codPaq%> </p>
            <p><label>Costo: </label> <%=costo%> </p>
            <p><label>Habilitado: </label>
                                <select name="select">
                                    <option value="SI" selected>SI</option>
                                    <option value="NO">NO</option>
                                </select> 
            </p>               
            <p><label>Servicios Incluidos: </label> </p>
                            <% List <ServicioTuristico> listaServiciosInc = new ArrayList<>();
                                listaServiciosInc = paq.getLista_servicios_incluidos();
                               for (ServicioTuristico serv : listaServiciosInc) {

                                   int codServ = serv.getCodigo_servicio();
                                    String nombreServ = serv.getNombre(); %>

                                    <label>-</label><%=nombreServ %><br>   

                                <%}%>
                                
                                <br>
                                <input type="hidden" name="codPaq" value="<%=codPaq%>">
            
                                <button type="submit"> Guardar </button>
                    </form>
       
    </body>
</html>

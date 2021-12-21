

<%@page import="logica.ServicioTuristico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Servicios</title>
    </head>
    <body>
        <h1>Edicion de Servicios</h1>
        <h2>Datos del Servicio</h2>
        
        <% HttpSession misession = request.getSession();
                
                ServicioTuristico serv = (ServicioTuristico) misession.getAttribute("servicio"); 
                
                String nombreServ = serv.getNombre();
                String descrip = serv.getDescripcion();
                String destino = serv.getDestino_servicio();
                double costo = serv.getCosto_servicio();
                String fecha = serv.getFecha_servicio();
                
                int codServ = serv.getCodigo_servicio();
        %>
        <form action="SvServicioMod" method="get">
            
            <p><label>Nombre del servicio: </label><input type="text" name="nombreServ" value="<%=nombreServ%>"></p>
            <p><label>Descripcion: </label><input type="text" name="descripcion" value="<%=descrip%>"></p>
            <p><label>Destino: </label><input type="text" name="destino" value="<%=destino%>"></p>
            <p><label>Costo: </label><input type="text" name="costo" value="<%=costo%>"></p>
            <p><label>Fecha: </label><input type="text" name="fecha"value="<%=fecha%>"></p>
            <p><label>Habilitado: </label>
                <select name="select">
                    <option value="SI" selected>SI</option>
                    <option value="NO">NO</option>
                </select>
            </p>
            
            <p><input type="hidden" name="codServ" value="<%=codServ%>"</p>
            
            <button type="submit"> Guardar </button>
        </form>
        
    </body>
</html>

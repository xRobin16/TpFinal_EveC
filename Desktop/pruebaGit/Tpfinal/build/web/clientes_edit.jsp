

<%@page import="logica.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Clientes</title>
    </head>
    <body>
        <h1>Edicion de Clientes</h1>
        <h2>Datos del Cliente</h2>
        
        <% HttpSession misession = request.getSession();
                
                Cliente clien = (Cliente) misession.getAttribute("cliente"); 
                
                String nombreCompleto = clien.getNombre();
                String apellido = clien.getApellido();
                String direccion = clien.getDireccion();
                int dni = clien.getDni();
                String fecha = clien.getFecha_nac();
                String nacion = clien.getNacionalidad();
                String celular = clien.getCelular();
                String email = clien.getEmail();
                String hab = clien.getHabilitado();
                
                int idClien = clien.getId_cliente();
        %>
        
        <form action="SvClienteMod" method="get">

            <p><label>Nombre: </label><input type="text" name="nombre" value="<%=nombreCompleto%>"></p>
            <p><label>Apellido </label><input type="text" name="apellido" value="<%=apellido%> "></p>
            <p><label>Direccion: </label><input type="text" name="direccion" value="<%=direccion %>"></p>
            <p><label>DNI: </label><input type="text" name="dni" value="<%=dni %>"></p>
            <p><label>Fecha Nac: </label><input type="text" name="fecha_nac" value="<%=fecha %>"></p>
            <p><label>Nacionalidad: </label><input type="text" name="nacionalidad" value="<%=nacion %>"></p>
            <p><label>Celular: </label><input type="text" name="celular" value="<%=celular %>"></p>
            <p><label>Email: </label><input type="text" name="email" value="<%=email %>"></p>
            <p><label>Habilitado: </label>
                <select name="select">
                    <option value="SI" selected>SI</option>
                    <option value="NO">NO</option>
                </select>
            </p>
            
            <p><input type="hidden" name="idClien" value="<%=idClien%>"</p>
            
            <button type="submit"> Guardar </button>
        </form>
        
    </body>
</html>

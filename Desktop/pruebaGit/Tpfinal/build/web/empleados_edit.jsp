

<%@page import="logica.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Empleados</title>
    </head>
    <body>
        <h1>Edicion de Empleado</h1>
        <h2>Datos del Empleado</h2>
        
        <% HttpSession misession = request.getSession();
                
                Empleado emple = (Empleado) misession.getAttribute("empleado"); 
                
                String nombreCompleto = emple.getNombre();
                String apellido = emple.getApellido();
                String direccion = emple.getDireccion();
                int dni = emple.getDni();
                String fecha = emple.getFecha_nac();
                String nacion = emple.getNacionalidad();
                String celular = emple.getCelular();
                String email = emple.getEmail();
                String cargo = emple.getCargo();
                double sueldo = emple.getSueldo();
                String hab = emple.getHabilitado();
                
                int idEmple = emple.getId_empleado();
        %>
        
        <form action="SvEmpleadoMod" method="get">

            <p><label>Nombre: </label><input type="text" name="nombre" value="<%=nombreCompleto%>"></p>
            <p><label>Apellido </label><input type="text" name="apellido" value="<%=apellido%> "></p>
            <p><label>Direccion: </label><input type="text" name="direccion" value="<%=direccion %>"></p>
            <p><label>DNI: </label><input type="text" name="dni" value="<%=dni %>"></p>
            <p><label>Fecha Nac: </label><input type="text" name="fecha_nac" value="<%=fecha %>"></p>
            <p><label>Nacionalidad: </label><input type="text" name="nacionalidad" value="<%=nacion %>"></p>
            <p><label>Celular: </label><input type="text" name="celular" value="<%=celular %>"></p>
            <p><label>Email: </label><input type="text" name="email" value="<%=email %>"></p>
            <p><label>Cargo: </label><input type="text" name="cargo" value="<%=cargo %>"></p>
            <p><label>Sueldo: </label><input type="text" name="sueldo" value="<%=sueldo %>"></p>
            <p><label>Habilitado: </label>
                <select name="select">
                    <option value="SI" selected>SI</option>
                    <option value="NO">NO</option>
                </select>
            </p>
            
            <p><input type="hidden" name="idEmple" value="<%=idEmple%>"</p>
            
            <button type="submit"> Guardar </button>
        </form>
    </body>
</html>

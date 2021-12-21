

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion de Empleados</title>
    </head>
    <body>
        <h1>Alta Empleados</h1>
        
        <p>Ingrese los datos del empleado</p>
        
        <form action="SvEmpleado" method="POST">
        <p><label>Nombre: </label><input type="text" name="nombre"></p>
        <p><label>Apellido </label><input type="text" name="apellido"></p>
        <p><label>Direccion: </label><input type="text" name="direccion"></p>
        <p><label>DNI: </label><input type="text" name="dni"></p>
        <p><label>Fecha Nac: </label><input type="text" name="fecha_nac"></p>
        <p><label>Nacionalidad: </label><input type="text" name="nacionalidad"></p>
        <p><label>Celular: </label><input type="text" name="celular"></p>
        <p><label>Email: </label><input type="text" name="email"></p>
        <p><label>Cargo: </label><input type="text" name="cargo"></p>
        <p><label>Sueldo: </label><input type="text" name="sueldo"></p>
        <p><label>Nombre de Usuario: </label><input type="text" name="nombre_usuario"></p>
        <p><label>Contrasenia: </label><input type="password" name="contrasenia"></p>
        
        <button type="submit"> Crear </button>
        </form>
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>

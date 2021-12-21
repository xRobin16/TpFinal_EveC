
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de servicios</title>
    </head>
    <body>
        <h1>Ingresar datos de servicio</h1>
        
        <form action="SvServicioAlta" method="POST">
        <p><label>Nombre del servicio: </label><input type="text" name="nombreServ"></p>
        <p><label>Descripcion: </label><input type="text" name="descripcion"></p>
        <p><label>Destino: </label><input type="text" name="destino"></p>
        <p><label>Costo: </label><input type="text" name="costo"></p>
        <p><label>Fecha: </label><input type="text" name="fecha"></p>
        
        <button type="submit"> Crear </button>
        </form>
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO</title>
    </head>
    <body>
        <h1>MENU PRINCIPAL</h1>
 
            <button onclick=location.href="empleados.jsp">Crear Empleado</button>
            <form action="SvEmpleadoConsulta" method="GET">
                <button href="SvEmpleadoConsulta" type="submit">Ver Empleados</button>
            </form>
  
        <br>
 
            <form action="SvUsuarioConsulta" method="GET">
                <button href="SvUsuario" type="submit">Ver Usuarios</button>
            </form>

  
        <br>
      
            <button onclick=location.href="servicios.jsp">Crear Servicio</button>
            <form action="SvServicioConsulta" method="GET">
                <button href="SvServicioConsulta" type="submit">Ver Servicios</button>
            </form>
     
        <br>
            <form action="SvServicioConsultaP" method="GET">
                <button href="SvServicioConsultaP" type="submit">Crear Paquete</button>
            </form>
            <form action="SvPaqueteConsulta" method="GET">
                <button href="SvPaqueteConsulta" type="submit">Ver Paquetes</button>
            </form>
        <br>
 
            <button onclick=location.href="clientes.jsp">Crear Cliente</button>
            <form action="SvClienteConsulta" method="GET">
                <button href="SvClienteConsulta" type="submit">Ver Clientes</button>
            </form>
     
        <br>
            <form action="SvVentaDirec" method="GET">
                <button href="SvVentaDirec" type="submit">Crear Venta de Servicio</button>
            </form>
            <form action="SvVentaDirecP" method="GET">
                <button href="SvVentaDirecP" type="submit">Crear Venta de Paquete</button>
            </form>
            <form action="SvVentaConsulta" method="GET">
                <button href="SvVentaConsulta" type="submit">Ver Ventas</button>
            </form>

    </body>
</html>

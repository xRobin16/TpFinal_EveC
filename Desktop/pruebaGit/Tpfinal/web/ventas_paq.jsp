

<%@page import="logica.PaqueteTuristico"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de Venta</title>
    </head>
    <body>
        <h1>Alta de Venta de Paquete</h1>
        <h2>Datos de Venta</h2>
        
        <form action="SvVentaPaqAlta" method="POST"> 
            <p><label>Empleado:</label>
                <select id="empleadoSelect" name="empleadoSelect">
                    <% List <Empleado> listaEmpleados = (List) request.getSession().getAttribute("listaEmpleados");
                    //if(listaEmpleados!=null)
                    for (Empleado emple : listaEmpleados){
                        String hab = emple.getHabilitado();
                        if("SI".equals(hab)) {
                    %>
                            <option value="<%=emple.getId_empleado()%>"><%=emple.getNombre()%></option>
                        <%} %>>
                    <%} %>>
                </select>
            </p>
            
            <p><label>Cliente:</label>
                <select id="clienteSelect" name="clienteSelect">
                    <% List <Cliente> listaClientes = (List) request.getSession().getAttribute("listaClientes");
                    if(listaClientes!=null)
                    for (Cliente clien : listaClientes){
                        String hab = clien.getHabilitado();
                        if("SI".equals(hab)) {
                    %>
                            <option value="<%=clien.getId_cliente()%>"><%=clien.getNombre()%></option>
                        <%} %>>
                    <%} %>
                </select>
            </p>
            
            <p><label>Paquete:</label>
                <select id="paqueteSelect" name="paqueteSelect">
                    <% List <PaqueteTuristico> listaPaquetes = (List) request.getSession().getAttribute("listaPaquetes");
                    if(listaPaquetes!=null)
                    for (PaqueteTuristico paq : listaPaquetes){
                    int codPaq = paq.getCodigo_paquete();
                    
                    String hab = paq.getHabilitado();
                        if("SI".equals(hab)) {
                    %>
                            <option value="<%=paq.getCodigo_paquete()%>"><%=codPaq%></option>
                        <%} %>
                    <%} %>
                </select>
            </p> 
            <a href="SvPaqueteConsulta" class="SUBMIT">Ver Paquetes</a><br>
            <br>
            
            <p><label>Medio de pago: </label><input type="text" name="medPago"></p>
            <p><label>Fecha: </label><input type="text" name="fechaVen"></p>
            
            <button type="submit"> Crear </button>
        </form>
        <br>
        <button onclick=location.href="index.jsp">Volver al Menu</button>
    </body>
</html>
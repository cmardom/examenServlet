<%@ page import="com.example.examenud2.model.Partido"%>
<%@ page import="java.util.Optional" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="estilos.css" />
</head>
<body class="bg-light">
<%
    Partido partido = (Partido) request.getAttribute("partido");
%>
<div class="container bg-white">
    <div class="row border-bottom">
        <%
            String action;
            if(partido != null){
                action = "EditarPartidosServlet";
        %>
        <div class="col-12 h2">Edite los datos del partido <%=partido.getId()%></div>
        <%
        } else {
            action = "GrabarPartidosServlet";
        %>
        <div class="col-12 h2">Introduzca los datos del nuevo partido</div>
        <% } %>
    </div>
</div>

<div class="container bg-light">
    <form method="post" action="<%=action%>">
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Fecha</div>
            <div class="col-md-6 align-self-center"><input type="date" name="fecha" value="<%= partido != null ? partido.getFecha() : "" %>" /></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Equipo 1</div>
            <div class="col-md-6 align-self-center"><input type="text" name="equipo1" value="<%= partido != null ? partido.getEquipo1() : "" %>" /></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Puntos equipo 1</div>
            <div class="col-md-6 align-self-center"><input type="number" name="puntos_equipo1" value="<%= partido != null ? partido.getPuntos_equipo1() : "" %>" /></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Equipo 2</div>
            <div class="col-md-6 align-self-center"><input type="text" name="equipo2" value="<%= partido != null ? partido.getEquipo2() : "" %>" /></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Puntos equipo 2</div>
            <div class="col-md-6 align-self-center"><input type="number" name="puntos_equipo2" value="<%= partido != null ? partido.getPuntos_equipo2() : "" %>" /></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Tipo de partido (amistoso/oficial) 2</div>
            <div class="col-md-6 align-self-center"><input type="text" name="tipo_partido" value="<%= partido != null ? partido.getTipo_partido() : "" %>" /></div>
        </div>
        <div class="row mt-2">
            <div class="col-md-6">
                &nbsp;
            </div>
            <div class="col-md-6 align-self-center">
                <input class="btn btn-primary" type="submit" value="Aceptar">
            </div>
        </div>
        <%
            if(partido != null){
        %>
        <input type="hidden" name="partidoID" value="<%=partido.getId()%>">
        <% } %>
    </form>
    <%
        //                                                 v---- RECOGER MENSAJE DE ERROR DEL ÁMBITO request
        String error = (String) request.getAttribute("error");
//            v---- SI ESTÁ PRESENTE INFORMAR DEL ERROR
        if (error != null) {
    %>
    <div class="row mt-2">
        <div class="col-6">
            <div class="alert alert-danger alert-dismissible fade show">
                <strong>Error!</strong> <%=error%>
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>
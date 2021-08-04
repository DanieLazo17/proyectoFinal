<%@page import="modeloDAO.JugadorDAO"%>
<%@page import="modelo.Jugador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Bootstrap CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
	
	<title>Cambio</title>
	<script src="vistas/editar.js"></script>
</head>
<body>

	<%
    	String id = request.getParameter("id");
        int _id;
        _id = Integer.parseInt(id);
        Jugador resultado=null;
        JugadorDAO jugadorDao = new JugadorDAO(); 
        resultado =  jugadorDao.buscar(_id);
   
    %>

	<div class="container">
		<h1>Formulario para Editar</h1>
		<form action="http://localhost:8080/ProyectoFinal/JugadorControlador?accion=actualizar" method="POST">
			<input type="hidden" name="numId" id="numId" value="<%=resultado.getId()%>" class="form-control">
			<br>
			<label for="txtNombre">Nombre:</label>
			<input type="text" name="txtNombre" id="txtNombre" value="<%=resultado.getNombre()%>" autofocus class="form-control"> 
			<br>
			<label for="txtApellido">Apellido:</label>
			<input type="text" name="txtApellido" id="txtApellido" value="<%=resultado.getApellido()%>" class="form-control">
			<br>
			<label for="numPosicion">Posición:</label>
			<input type="number" name="numPosicion" id="numPosicion" value="<%=resultado.getPosicion()%>" class="form-control"> 
			<br>
			<label for="txtClub">Club:</label>
			<input type="text" name="txtClub" id="txtClub" value="<%=resultado.getClub()%>" class="form-control"> <br>
			<br>
			<button type="submit" id="btnCambiar" class="btn btn-primary" disabled>Cambiar</button>
			<br>
		</form>
		<a href="http://localhost:8080/ProyectoFinal/JugadorControlador?accion=formar">Regresar</a>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
<%@page import="conexion.Conexion"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="modeloDAO.JugadorDAO"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
	integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
	crossorigin="anonymous">


<title>Selección Argentina</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<a class="btn btn-primary col-4 m-4" href="vistas/agregar.jsp">Agregar Jugador</a>
			<table class="table table-primary">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Posición</th>
						<th>Club</th>
						<th>Modificar</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Jugador> resultado = null;
					
					JugadorDAO jugador = new JugadorDAO();
					
					resultado = jugador.formar();
					
					%>
					<%
					for (int i = 0; i < resultado.size(); i++) {
						String rutaEditar = "JugadorControlador?accion=editar&id=" + resultado.get(i).getId();
						String rutaEliminar = "JugadorControlador?accion=eliminar&id=" + resultado.get(i).getId();
					%>
					<tr>
						<td><%=resultado.get(i).getId()%></td>
						<td><%=resultado.get(i).getNombre()%></td>
						<td><%=resultado.get(i).getApellido()%></td>
						<td><%=resultado.get(i).getPosicion()%></td>
						<td><%=resultado.get(i).getClub()%></td>
						<td><a class="text-success" href=<%=rutaEditar%>><i class="fas fa-pencil-alt"></i></a></td>
						<td><a class="text-danger" href=<%=rutaEliminar%>><i class="fas fa-trash-alt"></i></a></td>
					</tr>
				</tbody>
				<%
				}
				%>
			</table>
		</div>
	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
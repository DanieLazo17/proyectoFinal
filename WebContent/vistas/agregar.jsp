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
	
	<title>Convocado</title>
	<script src="agregar.js"></script>
</head>
<body>

	<div class="container">
		<h1>Formulario para dar de Alta</h1>
		<form action="../JugadorControlador?accion=agregar" method="POST">
				<label for="txtNombre">Nombre:</label>
				<input type="text" name="txtNombre" id="txtNombre" autofocus class="form-control"> <br>
				<label for="txtApellido">Apellido:</label>
				<input type="text" name="txtApellido" id="txtApellido" class="form-control"> <br>
				<label for="numPosicion">Posicion:</label>
				<input type="number" name="numPosicion" id="numPosicion" class="form-control"> <br>
				<label for="txtClub">Club:</label>
				<input type="text" name="txtClub" id="txtClub" class="form-control"> <br>
				<br> 
				<button type="submit" id="btnAgregar" class="btn btn-primary" disabled>Agregar</button> <br>
		</form>
		<a href="../JugadorControlador?accion=formar">Regresar</a>
	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
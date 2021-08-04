/**
 * 
 */
addEventListener("load", load);

function $(demo){
    return document.getElementById(demo);
}

function load(){
    document.getElementById('txtNombre').addEventListener("keyup", validar);
    document.getElementById('txtApellido').addEventListener("keyup", validar);
	document.getElementById('numPosicion').addEventListener("keyup", validar);
	document.getElementById('txtClub').addEventListener("keyup", validar);
}

function validar(){

    var txtNombre = document.getElementById('txtNombre').value.length;
    var txtApellido = document.getElementById('txtApellido').value.length;
	var numPosicion = document.getElementById('numPosicion').value;
	var txtClub = document.getElementById('txtClub').value.length;

    if( txtNombre >=2 && txtApellido >=2 && txtClub >=2 && numPosicion >0){
        $('btnAgregar').disabled = false;
    }else{
        $('btnAgregar').disabled = true;
    }
}
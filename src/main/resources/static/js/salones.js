function traerInformacionSalones(){
	$.ajax({    
    url : 'http://150.136.174.195/Partyroom/all',
	data: "{}",
    type : 'GET',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",
  
    success : function(respuesta) {
		console.log(respuesta);
		$("#resultadoSalones").empty();
        let miTabla = '<table>';
		for (i=0; i<respuesta.items.length; i++){
			miTabla += '<tr>';
	        miTabla += '<td>'+ respuesta.items[i].id+ '</td>'; 		
	        miTabla += '<td>'+ respuesta.items[i].owner+ '</td>'; 		
	        miTabla += '<td>'+ respuesta.items[i].capacity+ '</td>'; 		
	        miTabla += '<td>'+ respuesta.items[i].category_id+ '</td>'; 		
	        miTabla += '<td>'+ respuesta.items[i].name+ '</td>';
			miTabla += '<td><button onclick="editarRegistroSalones('+respuesta.items[i].id+' )">Editar</button>' 		
			miTabla += '</tr>';
		}
        miTabla += '</table>';
	    $("#resultadoSalones").append(miTabla);    

	},
    error : function(xhr, status) {
        alert('ha sucedido un problema:'+ status);
    }
});
}

function guardarInformacionSalones(){
	let misDatos = {
		id: $("#idSalones").val(),
        category_id: $("#category_id").val(),
        owner: $("#owner").val(),
        capacity: $("#capacity").val(),
        name: $("#nameSalones").val()
	};
	let datosJson = JSON.stringify(misDatos); 
	$.ajax(    
    'http://150.136.174.195/Partyroom/save',
	{data: datosJson,
    type : 'POST',
    dataType : 'json',
    contentType: "application/json; charset=utf-8",
  
    statusCode : {
		201 :  function() {
			alert("guardado!");
			$("#idSalones").val("");
			$("#category_id").val("");
			$("#owner").val("");
			$("#capacity").val("");
			$("#nameSalones").val("");
        	traerInformacionSalones();	
			}
		}
	});
}

function editarRegistroSalones (id){
	$.ajax({    
	url : 'https://g73664e6c770cfe-partyroom.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/partyroom/partyroom/'+id,
	data: "{}",
	type : 'GET',
	dataType : 'json',
	contentType: "application/json; charset=utf-8",

	success : function(respuesta) {
		console.log(respuesta);
		let miTabla = '<table>';
		for (i=0; i<respuesta.items.length; i++){
			$("#idSalones").val(respuesta.items[i].id);
			$("#category_id").val(respuesta.items[i].category_id);
			$("#owner").val(respuesta.items[i].owner);
			$("#capacity").val(respuesta.items[i].capacity);
			$("#nameSalones").val(respuesta.items[i].name);
		}
	},
	error : function(xhr, status) {
		alert('ha sucedido un problema:' +status + json);
	}
});
}

function actualizarInformacionSalones(){
	let misDatos = {
		id: $("#idSalones").val(),
        category_id: $("#category_id").val(),
        owner: $("#owner").val(),
        capacity: $("#capacity").val(),
        name: $("#nameSalones").val()
	};
	let datosJson = JSON.stringify(misDatos);
	$.ajax(    
	'https://g73664e6c770cfe-partyroom.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/partyroom/partyroom',
	{data: datosJson,
	type : 'PUT',
	dataType : 'json',
	contentType: "application/json; charset=utf-8",

	statusCode : {
		201 : function() {
			alert("guardado!");
			$("#idSalones").val("")
			$("#category_id").val("");
			$("#owner").val("");
			$("#capacity").val("");
			$("#nameSalones").val("");
			traerInformacionSalones();
		}
	}
});
}

function borrarInformacionSalones(){
	let misDatos ={
		id: $("#idSalones").val()
	};
	let datosJson = JSON.stringify(misDatos)
	$.ajax({    
		url : 'https://g73664e6c770cfe-partyroom.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/partyroom/partyroom',
		data: datosJson,
		type : 'DELETE',
		dataType : 'json',
		contentType: "application/json; charset=utf-8",
		statusCode : {
			204 : function() {
				alert("borrado!");
				$("#idSalones").val("")
				$("#category_id").val("");
				$("#owner").val("");
				$("#capacity").val("");
				$("#nameSalones").val("");
				traerInformacionSalones();
			}
		}
	});
}




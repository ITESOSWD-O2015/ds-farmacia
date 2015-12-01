
var app = angular.module('myApp', []);

//Este es el controlador que muestra todos los productos de la Base de Datos
var sara = [];

app.controller('Receta', function($scope,$http){
	
	$scope.go = function(x){
		
		console.log(x)
	$http.post("http://localhost:8080/FarmaciaJava/api/recetas/",x)
	.success(function(response) {
		$scope.products = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
		window.close();
		
	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});
	}
}); // Se cierra el controlador de BuscarProductos


app.controller('BuscarProductos2', function($scope,$http){
	
	
	$http.get("http://localhost:8080/FarmaciaJava/api/products/")
	.success(function(response) {
		$scope.products = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
		
	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});
	
});

app.controller('BuscarProductos', function($scope,$http){
	
	$scope.all = function(){
	$http.get("http://localhost:8080/FarmaciaJava/api/products/")
	.success(function(response) {
		$scope.products = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
		
	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});
	}
}); // Se cierra el controlador de BuscarProductos




app.controller('BuscarProveedor', function($scope,$http){

	$http.get("http://localhost:8080/FarmaciaJava/api/proveedores/")
	.success(function(response) {$scope.proveedor = response; //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla

	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});

}); // Se cierra el controlador de BuscarProveedor


app.controller('BuscarPago', function($scope, $http){
	
	$http.get("http://localhost:8080/FarmaciaJava/api/pagos/")
	.success(function(response) {$scope.pay = response;
	
	})
	.error(function(){
		alert("Error"); //En caso de que fallara algo, muestra mensaje de error.
	});		
});


app.controller('BuscarUnidadMedida', function($scope,$http){

	$http.get("http://localhost:8080/FarmaciaJava/api/unidadmedidas/")
	.success(function(response) {$scope.unidadmedida = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});

}); // Se cierra el controlador de BuscarMarca


app.controller('BuscarCategoria', function($scope,$http){

	$http.get("http://localhost:8080/FarmaciaJava/api/categorias/")
	.success(function(response) {$scope.categoria = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});

}); // Se cierra el controlador de BuscarCategoria


//Este es el controlador que buscar un producto en especifico de la Base de Datos
var array = [];
app.controller('BuscarIDController', function($scope, $http){
	$scope.resultado = [];
	$scope.dinerito = {subtotal: 0, iva: 0, total: 0, cantidad:0};
	$scope.monto = {cambio : 0, monto : 0};
	$scope.array = [];
	$scope.temp = {precio:0, iva:0};
	
	
	
	
	console.log($scope.dinerito.subtotal)
	
	

	
	
	$http.get("http://localhost:8080/FarmaciaJava/api/facturas/")
	.success(function(response) {$scope.factura = response; //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
			console.log($scope.factura);
	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});
	
	
	$scope.buscar = function(){
		console.log('Si entre a buscar el id');  //Verificar que se haya ejecutando el click de buscar
		

		$http.get("http://localhost:8080/FarmaciaJava/api/products/"+$scope.product)
		.success(function(response) {
			if(response){
				
				
				if(response.categoriaNombre == "Antibiotico"){
					window.open('http://localhost:8080/FarmaciaJava/FormReceta.html','Receta','width=600,height=600', 'scrollbars=NO');
					}
				
					$scope.array.push(response);
					$scope.resultado.push(response);
					
					$scope.dinerito.subtotal += response.precioVenta;
					$scope.temp.precio += response.precioVenta 
					$scope.dinerito.iva += response.iva;
					$scope.temp.iva += response.iva;
					$scope.dinerito.total = $scope.dinerito.subtotal + $scope.dinerito.iva;
					
					console.log(JSON.stringify($scope.resultado));
					
					
					$scope.monto.cambio = $scope.dinerito.total - $scope.monto.total 
					
					console.log($scope.temp.precio);
					
				
	
				
			}
			else{
				if(!($scope.resultado))
					alert("No se encontro el producto"); 
			}


		})
		.error(function(){
			alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
		});

	}//Se cierra la funcion buscar
	
	
	
	$scope.pagar = function(){
		
		
		$scope.monto.cambio =  Math.abs($scope.dinerito.total - $scope.monto.total );
	}
	
	$scope.delet = function(id){
		 var person_to_delete = $scope.resultado[id];
		 $scope.dinerito.subtotal = $scope.dinerito.subtotal - person_to_delete.precioVenta;
		 $scope.dinerito.iva = $scope.dinerito.iva - person_to_delete.iva;
		 $scope.dinerito.total = $scope.dinerito.total - (person_to_delete.iva + person_to_delete.precioVenta);
		  $scope.resultado.splice(id, 1);	
		  
		
	}

}); // Se cierra el controlador de Buscar ID

//Este el controlador que agregar productos a la Base de Datos

app.controller('AgregarProducto', function($scope, $http){
	console.log('No entre'); 

	$scope.calculate = function(){
		
		console.log('Entre al boton calcular'); 
		
		$scope.data.iva = $scope.data.precioVenta * 0.15;
	}
	
	
	$scope.add = function(){
		console.log('Si entre a agregar el producto');  //Verificar que se haya ejecutando el click de agregar

		$http.post("http://localhost:8080/FarmaciaJava/api/products", $scope.data)
		.success(function() {
			alert("El producto se ha agregado correctamente"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
			$scope.data=null;})

			.error(function(){
				alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
			});
	} // Se cierra la funcion de add

}); // Se cierra el controlador de agregar



app.controller('Mensajes', function($scope, $http){
	console.log('No entre'); 

//	$scope.look = function(){
		console.log('Si entre a buscar la cantidad menores o iguales a 4');  //Verificar que se haya ejecutando el click de agregar

		$http.get("http://localhost:8080/FarmaciaJava/api/mensaje")
		.success(function(response) {$scope.product = response;
		})

		.error(function(){
			alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
		});
	//} // Se cierra la funcion de add

});

app.controller('Factura', function($scope, $http){
	
		
		$scope.cash = function(t,x,id){
			
			console.log(t);
			
//			$http.post("http://localhost:8080/FarmaciaJava/api/facturas/", t)
//			.success(function() {
//				alert("Se actualizo el producto"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
//			})
//			.error(function(){
//				alert("Se elimino el producto exitosamente"); //En caso de que fallara algo, muestra mensaje de error.
//			});	

			$http({
		        url: "http://localhost:8080/FarmaciaJava/api/facturas",
		        method: "POST",
		        data:  t
		    })
		    .then(function(response) {
		            // success
		    }, 
		    function(response) { // optional
		            // failed
		    });
			
		
		
	
    
		console.log('Si entre a Factura Detalle');  //Verificar que se haya ejecutando el click de agregar
			
		
			console.log(x);
			console.log(x.length);
			console.log(id);
			id = id +1;
			var fact = [{factID: 0, producto:0, precio:0, cantidad:0, total:0}];
			
			
			var json = {factura: []};
			
			for(var i=0;i<x.length;i++){
			
				  json.factura.push({ 
				        "ticketId" : id,
				        "productId"  : x[i].productId,
				        "precioventa": x[i].precioVenta ,
				        "cantidad" : 1,
				        "total" : x[i].precioVenta 
				    });
			}
			
			for(var i=0;i<x.length;i++){
				
				console.log(json.factura[i]);
			}
			
	
			for(var i=0;i<x.length;i++){
				
		
				 $http({
				        url: "http://localhost:8080/FarmaciaJava/api/facturad",
				        method: "POST",
				        contentType: "application/json",
				        data: json.factura[i]
				    })
				    .then(function(response) {
				    	
				          	
				    }, 
				    function(response) { // optional
				            // failed
				    });
			}
			
			$scope.resultado = null;
			$scope.dinerito = null;
			
			alert("Se registro la venta"); //En caso de que fallara algo, muestra mensaje de error.
		
			console.log('Sali');
			 
			 
	} // Se cierra la funcion de test

});




//Este el controlador que elimina un producto de la base de datos

app.controller('EliminarController', function($scope, $http){

	$scope.eliminar = function(){
		console.log('Si entre a eliminar el producto'); //Verificar que se haya ejecutando el click de eliminar


//		Preguntar porque no se ejecutan los mensajes del delete y el .delete porque marca error
		$http['delete']("http://localhost:8080/FarmaciaJava/api/products/"+$scope.data.productId)
		.success(function() {
			
			alert("Se elimino el producto exitosamente"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
		})
		.error(function(){
			alert("Se elimino el producto exitosamente"); //En caso de que fallara algo, muestra mensaje de error.
		});


	} //Se cierra la funcion eliminar


}); // Se cierra el controlador Eliminar


//Este el controlador que actualiza productos de la base de datos	

app.controller('ActualizarController', function($scope, $http){

	$scope.agregar = function(){
		console.log('Si entre a actualizar');  //Verificar que se haya ejecutando el click de actualizar

		$http.put("http://localhost:8080/FarmaciaJava/api/products/"+$scope.data.productId, $scope.data)
		.success(function() {
			alert("Se actualizo el producto"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
			$scope.data=null //Se limpian los campos de input para ejecutar una nueva actualizacion.
		})
		.error(function(){
			alert("Se elimino el producto exitosamente"); //En caso de que fallara algo, muestra mensaje de error.
		});	

	} //Se cierra la funcion agregar

}); //Se cierra el controlador ActualizarController



app.controller('BuscarID', function($scope, $http){

		
	$scope.look = function(){
		console.log('Si entre a buscar');  //Verificar que se haya ejecutando el click de actualizar

		$http.get("http://localhost:8080/FarmaciaJava/api/products/"+$scope.product)
		.success(function(response) {
			$scope.products=null;	
			$scope.data = response;
			alert("Encontre el producto"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
		
		})
		.error(function(){
			alert("Error"); //En caso de que fallara algo, muestra mensaje de error.
		});	

	} //Se cierra la funcion agregar
	
	$scope.all = function(){
		$http.get("http://localhost:8080/FarmaciaJava/api/products/")
		.success(function(response) {
			$scope.data = null;
			$scope.products = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
			
		})
		.error(function(){
			alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
		});
		}

}); //Se cierra el controlador ActualizarController


app.controller('BuscarAct', function($scope, $http){
	
	$scope.calculate = function(){
	
	console.log('Entre al boton calcular'); 
	
	$scope.data.iva = $scope.data.precioVenta * 0.15;
}
	
$scope.look = function(){
	console.log('Si entre a buscar');  //Verificar que se haya ejecutando el click de actualizar

	$http.get("http://localhost:8080/FarmaciaJava/api/products/"+$scope.producto)
	.success(function(response) {
		$scope.data = response;
		alert("Encontre el producto"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
	
	})
	.error(function(){
		alert("Error"); //En caso de que fallara algo, muestra mensaje de error.
	});	

} //Se cierra la funcion agregar



}); //Se cierra el controlador ActualizarController

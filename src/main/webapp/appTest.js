

var app2 = angular.module('myApp2', []);


var array= [];

app2.controller('BuscarIDController', function($scope, $http){
	$scope.resultado = [];
	$scope.array = [];
	$scope.dinerito = {subtotal: 0, iva: 0, total: 0};
	$scope.monto = {cambio : 0, monto : 0};
	var msgForIn = '';
	var msgForNormal = '';
	var test = [];
	
	
	
	$scope.buscar = function(){
		console.log('Si entre a buscar el id');  //Verificar que se haya ejecutando el click de buscar

		$http.get("http://localhost:8080/FarmaciaJava/api/products/"+$scope.product)
		.success(function(response) {
			if(response){
				
				
				if(response.categoriaNombre == "Antibiotico"){
					window.open('http://localhost:8080/FarmaciaJava/CategoriaDetalle.html','Receta','width=600,height=600', 'scrollbars=NO');
					}
					
					array.push(response);
					$scope.resultado.push(response);		
					$scope.dinerito.subtotal += response.precioVenta;
					$scope.dinerito.iva += response.iva;
					$scope.dinerito.total += response.precioVenta + response.iva;
					$scope.monto.cambio = $scope.dinerito.total - $scope.monto.total;

					}
					
				

			else{
				if(!($scope.resultado))
					alert("No se encontro el producto"); 
			}
			
			$scope.test = function(){
				console.log('CAmbies');  //Verificar que se haya ejecutando el click de agregar

			
				$http.post("http://localhost:8080/FarmaciaJava/api/factura")
				.success(function(response) {$scope.product = response;
				})

				.error(function(){
					alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
				});
			} // Se cierra la funcion de test
		

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
		  $scope.resultado.splice(id, 1);	
		  
		
	}

}); // Se cierra el controlador de Buscar ID


app2.controller('Mensajes', function($scope, $http){
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
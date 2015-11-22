var app = angular.module('myApp', []);

//	Este es el controlador que muestra todos los productos de la Base de Datos

	app.controller('BuscarProductos', function($scope,$http){
    
    $http.get("http://localhost:9080/ChoriStore/api/products/")
    .success(function(response) {$scope.products = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
    })
    .error(function(){
    	 alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
    });
    
	}); // Se cierra el controlador de BuscarProductos
	
	
	app.controller('BuscarProveedor', function($scope,$http){
	    
	    $http.get("http://localhost:9080/ChoriStore/api/proveedores/")
	    .success(function(response) {$scope.proveedor = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
	    })
	    .error(function(){
	    	 alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	    });
	    
		}); // Se cierra el controlador de BuscarProveedor

	
	app.controller('BuscarMarca', function($scope,$http){
	    
	    $http.get("http://localhost:9080/ChoriStore/api/marcas/")
	    .success(function(response) {$scope.marca = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
	    })
	    .error(function(){
	    	 alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	    });
	    
		}); // Se cierra el controlador de BuscarMarca
	
	
		app.controller('BuscarCategoria', function($scope,$http){
	    
	    $http.get("http://localhost:9080/ChoriStore/api/categorias/")
	    .success(function(response) {$scope.categoria = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
	    })
	    .error(function(){
	    	 alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	    });
	    
		}); // Se cierra el controlador de BuscarProductos
	
	
//	Este es el controlador que buscar un producto en especifico de la Base de Datos
	
	app.controller('BuscarIDController', function($scope, $http){

		 $scope.buscar = function(){
			 console.log('Si entre a buscar el id');  //Verificar que se haya ejecutando el click de buscar
		    	
		    	 $http.get("http://localhost:9080/ChoriStore/api/products/"+$scope.product)
				    .success(function(response) {$scope.resultado = response; //En caso de que sea exitosa la ejeccucion, los datos se muestran.
				    
				    
				    
				    if(!($scope.resultado))
				    	alert("No se encontro el producto"); 
				  
				    
		    
				    })
				    .error(function(){
		    		 alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
		    	 });
		    	
		    }//Se cierra la funcion buscar
		
	}); // Se cierra el controlador de Buscar ID

//	Este el controlador que agregar productos a la Base de Datos
	
	app.controller('AgregarProducto', function($scope, $http){
		console.log('No entre'); 

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
	

//	Este el controlador que elimina un producto de la base de datos
	
		app.controller('EliminarController', function($scope, $http){

		 $scope.eliminar = function(){
			 console.log('Si entre a eliminar el producto'); //Verificar que se haya ejecutando el click de eliminar
			 
			 
//			 	Preguntar porque no se ejecutan los mensajes del delete y el .delete porque marca error
		    	 $http['delete']("http://localhost:9080/ChoriStore/api/products/"+$scope.resultado.productId)
				    .success(function() {
				    		alert("Se elimino el producto exitosamente"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
				    					})
				    .error(function(){
				    		alert("Se elimino el producto exitosamente"); //En caso de que fallara algo, muestra mensaje de error.
				    				 });
		    	 
		    	
		    } //Se cierra la funcion eliminar
		
		
	}); // Se cierra el controlador Eliminar
		
	
//	Este el controlador que actualiza productos de la base de datos	
		
		app.controller('ActualizarController', function($scope, $http){
		
			 $scope.agregar = function(){
			 console.log('Si entre a actualizar');  //Verificar que se haya ejecutando el click de actualizar
		    	
		    	 $http.put("http://localhost:9080/ChoriStore/api/products/"+$scope.resultado.productId, $scope.resultado)
				    .success(function() {
				    	alert("Se actualizo el producto"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
				    	$scope.resultado=null //Se limpian los campos de input para ejecutar una nueva actualizacion.
				    					})
				   .error(function(){
					   alert("Se elimino el producto exitosamente"); //En caso de que fallara algo, muestra mensaje de error.
				   						});	
	 
		    } //Se cierra la funcion agregar
		
	}); //Se cierra el controlador ActualizarController

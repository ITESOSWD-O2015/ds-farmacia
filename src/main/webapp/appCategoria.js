/**
 * 
 */

var app = angular.module('myApp', []);

app.controller('BuscarCategorias', function($scope,$http){
	
	$scope.all = function(){
	$http.get("http://localhost:8080/FarmaciaJava/api/categorias/")
	.success(function(response) {
		$scope.data= null;
		$scope.products = response;  //En caso de que sea exitosa la ejeccucion, los datos se muestran en una tabla
		
	})
	.error(function(){
		alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
	});
	}
}); // Se cierra el controlador de BuscarProductos


app.controller('BuscarCategoriaID', function($scope, $http){

	
$scope.look = function(x){
	console.log(x);  //Verificar que se haya ejecutando el click de actualizar
		
	$http.get("http://localhost:8080/FarmaciaJava/api/categorias/" +x)
	.success(function(response) {
		$scope.products= null;
		$scope.data = response;
		
		console.log($scope.data)
		
		alert("Encontre el producto"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
	
	})
	.error(function(){
		alert("Error"); //En caso de que fallara algo, muestra mensaje de error.
	});	

} //Se cierra la funcion agregar

}); //Se cierra el controlador BuscarCategoriaID

app.controller('AgregarCategoria', function($scope, $http){
	console.log('No entre'); 


	$scope.add = function(){
		console.log('Si entre a agregar la categoria');  //Verificar que se haya ejecutando el click de agregar

		$http.post("http://localhost:8080/FarmaciaJava/api/categorias", $scope.data)
		.success(function() {
			alert("El producto se ha agregado correctamente"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
			$scope.data=null;})

			.error(function(){
				alert("Surgio un error"); //En caso de que fallara algo, muestra mensaje de error.
			});
	} // Se cierra la funcion de add

}); // Se cierra el controlador de agregar




app.controller('ActualizarController', function($scope, $http){

	$scope.actualizar = function(x){
		console.log('Si entre a actualizar');  //Verificar que se haya ejecutando el click de actualizar
		
		console.log(x);

		$http.put("http://localhost:8080/FarmaciaJava/api/categorias/"+$scope.data.categoriaId, $scope.data)
		.success(function() {
			alert("Se actualizo el producto"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
			$scope.cate=null //Se limpian los campos de input para ejecutar una nueva actualizacion.
		})
		.error(function(){
			alert("Se elimino el producto exitosamente"); //En caso de que fallara algo, muestra mensaje de error.
		});	

	} //Se cierra la funcion agregar

}); //Se cierra el controlador ActualizarController


app.controller('EliminarCategoria', function($scope, $http){

	$scope.eliminar = function(){
		console.log('Si entre a eliminar el producto'); //Verificar que se haya ejecutando el click de eliminar


//		Preguntar porque no se ejecutan los mensajes del delete y el .delete porque marca error
		$http['delete']("http://localhost:8080/FarmaciaJava/api/categorias/"+$scope.data.categoriaId)
		.success(function() {
			
			$scope.data = null;
			
			alert("Se elimino el producto exitosamente"); //En caso de que sea exitosa la ejeccucion, muestra mensaje de exito.
		})
		.error(function(){
			alert("Se elimino el producto exitosamente"); //En caso de que fallara algo, muestra mensaje de error.
		});


	} //Se cierra la funcion eliminar


}); // Se cierra el controlador Eliminar



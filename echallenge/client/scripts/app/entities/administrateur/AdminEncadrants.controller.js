'use strict';

app
.controller('AdminEncadrantsController', function ($scope, $state,$stateParams,$filter , Encadrant ) {

	console.log("admin encadrant");

	$scope.modif = [];
	$scope.newencadrant = {};
	$scope.encadrants = Encadrant.query();
	

	Encadrant.get({id:161},function  (result) {

		console.log(result);
	})

	$scope.initModif=function (i)
	{	
		$scope.encadrants.forEach(function  (encadrant) {
			encadrant.motDePasse = "";

		})

		$scope.modif[i] =true;
	}

	$scope.modifier = function  (i,encadrant) {

		$scope.modif[i] =false;
		Encadrant.update({id:encadrant.id},encadrant);


	}


	$scope.initsupprimer = function  (encadrant) {

		$scope.encadrantsup = encadrant;
		$('#suppressionModal').modal('show');  

	}


	$scope.supprimer=function  () {
		Encadrant.delete({id:$scope.encadrantsup.id} , $scope.encadrantsup);
		$('#suppressionModal').modal('hide');                                         
		$scope.encadrants = Encadrant.query();
	}


	$scope.ajouter = function  () {

		
		Encadrant.save($scope.newencadrant)
		$('#addModal').modal('hide');                                         

	}

	$scope.initajouter = function  () {
		
		$('#addModal').modal('show');                                         

	}

});





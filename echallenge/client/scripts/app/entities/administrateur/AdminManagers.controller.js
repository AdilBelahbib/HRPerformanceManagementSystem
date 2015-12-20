'use strict';

app
.controller('AdminManagersController', function ($scope, $state,$stateParams,$filter , Manager ) {

	console.log("admin manager");

	$scope.modif = [];
	$scope.newmanager = {};
	$scope.managers = Manager.query();
	

	

	$scope.initModif=function (i)
	{	
		$scope.managers.forEach(function  (manager) {
			manager.motDePasse = "";

		})

		$scope.modif[i] =true;
	}

	$scope.modifier = function  (i,manager) {

		$scope.modif[i] =false;
		Manager.update({id:manager.id},manager);


	}


	$scope.initsupprimer = function  (manager) {

		$scope.managersup = manager;
		$('#suppressionModal').modal('show');                                         
	}


	$scope.supprimer=function  () {
		Manager.delete({id:$scope.managersup.id} , $scope.managersup);
		$('#suppressionModal').modal('hide');                                         
		$scope.managers = Manager.query();
	}


	
	$scope.ajouter = function  () { 
		
		Manager.save($scope.newmanager ) ;
		$('#addModal').modal('hide');                                         
		

	}

	$scope.initajouter = function  () {
		
		$('#addModal').modal('show');                                         

	}



});





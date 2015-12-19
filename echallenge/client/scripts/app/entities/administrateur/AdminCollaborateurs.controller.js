'use strict';

app
.controller('AdminCollaborateursController', function ($scope, $state,$stateParams,$filter , Collaborateur ) {

	console.log("admin collaborateur");

	$scope.modif = [];

	$scope.collaborateurs = Collaborateur.query();
	

	Collaborateur.get({id:154},function  (result) {

		console.log(result);
	})

	$scope.initModif=function (i)
	{	
		console.log("initModif"+i)

		$scope.collaborateurs.forEach(function  (collaborateur) {
		collaborateur.motDePasse = "";
	})

		$scope.modif[i] =true;
	}

	$scope.modifier = function  (i,collaborateur) {

		$scope.modif[i] =false;
		console.log(collaborateur) ;


	}






});





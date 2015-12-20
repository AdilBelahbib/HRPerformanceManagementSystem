'use strict';

app
.controller('AdminCollaborateursController', function ($scope, $state,$stateParams,$filter ,$cookieStore , Collaborateur , Manager , connect ) {

	console.log("admin collaborateur");
	
  $scope.user = $cookieStore.get('connectedUser');
	 if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'A')
	{
		$state.go('login');
	}
	else
	{
		$scope.id = $scope.user.utilisateur.id ;
	}

	$scope.managerupdt = {};
	$scope.modif = [];
	$scope.newcollaborateur = {};
	$scope.collaborateurs = Collaborateur.query();
	

	

	$scope.initModif=function (i)
	{	
		$scope.collaborateurs.forEach(function  (collaborateur) {
			collaborateur.motDePasse = "";

		})

		$scope.modif[i] =true;
	}

	$scope.modifier = function  (i,collaborateur) {

		$scope.modif[i] =false;
		Collaborateur.update({id:collaborateur.id},collaborateur);


	}


	$scope.initsupprimer = function  (collaborateur) {

		$scope.collaborateursup = collaborateur;
		$('#suppressionModal').modal('show');                                         
	}


	$scope.supprimer=function  () {
		Collaborateur.delete({id:$scope.collaborateursup.id} , $scope.collaborateursup);
		$('#suppressionModal').modal('hide');                                         
		$scope.collaborateurs = Collaborateur.query();
	}

	
	$scope.ajouter = function  () {
	
		console.log("id manager "+$scope.managerupdt.id+"collaborateur");
		console.log($scope.newcollaborateur);
		 Collaborateur.new({idmanager : $scope.managerupdt.id} ,$scope.newcollaborateur ) ;
		$('#addModal').modal('hide');                                         

	}

	$scope.initajouter = function  () {
		$scope.managers = Manager.query();
		$('#addModal').modal('show');                                         

	}

});





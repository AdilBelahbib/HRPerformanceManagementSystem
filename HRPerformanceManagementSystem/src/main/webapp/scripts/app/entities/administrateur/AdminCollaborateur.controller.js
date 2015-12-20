'use strict';

app
.controller('AdminCollaborateurController', function ($scope, $state,$stateParams,$filter , $cookieStore, Collaborateur) {

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
console.log("admin");
Collaborateur.get({id:$stateParams.id}, function  (result) {
	
	$scope.collaborateur = result;

})


});





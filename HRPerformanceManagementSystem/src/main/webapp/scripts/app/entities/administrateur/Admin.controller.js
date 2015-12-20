'use strict';

app
.controller('AdminController', function ($scope, $state, $cookieStore,$stateParams,$filter ) {

	console.log("admin");


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
});





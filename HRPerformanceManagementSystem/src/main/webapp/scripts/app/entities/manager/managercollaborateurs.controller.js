'use strict';

app
.controller('ManagerCollaborateursController', function ($scope, $stateParams,$filter , Manager ,$cookieStore,$state) {

	
  $scope.user = $cookieStore.get('connectedUser');
  if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'M')
   {
     $state.go('login');
 }
 else
 {
    $scope.id = $scope.user.utilisateur.id ;
}

Manager.get({id : $scope.id}, function  (result) {
$scope.collaborateurs = result.collaborateurs;
    
});


});


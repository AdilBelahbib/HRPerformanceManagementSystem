'use strict';

app
.controller('ManagerController', function ($scope,$stateParams,$filter , Manager ,$cookieStore,$state, Bap , Collaborateur) {

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




       Manager.get({id: $scope.id}, function(result) {
            $scope.manager = result;
            //collaborateurs du managerRH avec un BAp statut en cours
            $scope.collaborateurs = $scope.manager.collaborateurs;        
            });
    
        $scope.class = function  (bap) {
            if(bap.statut=="EN_COURS") return  "info";
            if(bap.statut=="EN_ATTENTE") return "warning";
            if(bap.statut=="VALIDE") return "primary";
            if(bap.statut=="REJETE") return "danger";
        }

    });


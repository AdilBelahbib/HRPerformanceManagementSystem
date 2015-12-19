'use strict';

app
.controller('ManagerBipController', function ($scope, $stateParams,$filter , Collaborateur , Objectif , Bip ) {

  
  Collaborateur.get({id:$stateParams.id},function  (result) {

    $scope.collaborateur=result;
    
    Objectif.currentfiche({id:$scope.collaborateur.id},function  (result2) {
      
      $scope.ficheCourant = result2;
      console.log($scope.ficheCourant);
    })

  });

   });


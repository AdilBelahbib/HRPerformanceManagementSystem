'use strict';

app
.controller('ManagerBipController', function ($scope, $stateParams,$filter , Collaborateur , Bip ) {

  
  Collaborateur.get({id:$stateParams.id},function  (result) {

    $scope.collaborateur=result;
    console.log(result);

  });

   });


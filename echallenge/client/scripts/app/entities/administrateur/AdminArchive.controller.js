'use strict';

app
.controller('AdminArchiveController', function ($scope, $state,$stateParams,$filter, $cookieStore , Collaborateur ) {

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
    Collaborateur.get({id : $stateParams.id} , function  (result) {

       $scope.collaborateur = result; 


   });  

    $scope.showObjectifs = function (id) {

        $scope.hideobjectifs=false;

        var fichesobjectif= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.id==id;});

        $scope.fichesobjectif=fichesobjectif[0];

        if($scope.fichesobjectif.objectifs.length==0)$scope.hideobjectifs=true;

        $('#objectifsModal').modal('show');
    };

    $scope.showEvaluations = function (id) {

        $scope.hideevaluations=false;

        var fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.id==id;});

        $scope.fichesevaluation=fichesevaluations[0];

        if($scope.fichesevaluation.evaluations.length==0)$scope.hideevaluations=true;

        $('#evaluationModal').modal('show');
    };


});





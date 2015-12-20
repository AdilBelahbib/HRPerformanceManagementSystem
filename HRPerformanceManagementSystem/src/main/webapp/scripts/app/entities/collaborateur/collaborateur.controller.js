'use strict';

app
.controller('CollaborateurController', function ($scope, $stateParams,$filter, Collaborateur , $cookieStore,$state ,Objectif, Utilisateur , Bap) {
    console.log("Testing the rest API");

    $scope.user = $cookieStore.get('connectedUser');
     if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'C')
    {
       $state.go('login');
   }
   else
   {
    $scope.id = $scope.user.utilisateur.id ;
   }
   Collaborateur.get({id: $scope.id}, function(result) {
    $scope.collaborateur = result;
    $scope.collaborateur.fichesobjectifs= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.autorisationAcces==1;});
    $scope.collaborateur.fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.autorisationAcces==1;});

});  

   $scope.currentfiche =Objectif.currentfiche({id:$scope.id});

   Bap.bapByStatut({id:$scope.id, statut : "A_VALIDER"},function(result)
   {
    $scope.bap =result;
    $scope.ficheEnAttente = result.ficheObjectifsRediges;        
});


   $scope.loadAll=function  () {
    $scope.collaborateurs = Collaborateur.query();

}
$scope.valider =function ()
{

    console.log($scope.bap);
    Bap.valider($scope.bap);
}

$scope.rejeter =function ()
{
   
    console.log($scope.bap);
    Bap.rejeter($scope.bap);
}
$scope.showObjectifs = function (id) {
    $scope.hideobjectifs=false;
    var fichesobjectif= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.id==id;});
    $scope.fichesobjectif=fichesobjectif[0];
    if($scope.fichesobjectif.objectifs.length==0)$scope.hideobjectifs=true;
    $('#objectifsModal').modal('show');
};
$scope.showEvaluations = function (id) {
    $scope.hidevaluations=false;
    var fichesevaluation= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.id==id;});
    $scope.fichesevaluation=fichesevaluation[0];
    if($scope.fichesevaluation.evaluations.length==0)$scope.hidevaluations=true;
    $('#evaluationModal').modal('show');
};

});

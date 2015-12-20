'use strict';

app
.controller('ManagerBipController', function ($scope, $stateParams,$filter , Collaborateur , $cookieStore,$state,Objectif , Bip ) {


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

$scope.modif = [];
$scope.modif2 = [];
$scope.modif3 = [];
$scope.Actions =[]  ;
$scope.objectifsFormation ={};
$scope.objectifsFormation.objectifs =[];
$scope.objectifsFormation.autoformation=false;
$scope.Formations = [];

$scope.newobjectifnewobjectifFormation ={};
Collaborateur.get({id:$stateParams.id},function  (result) {

  $scope.collaborateur=result;
  
  Objectif.ficheEnCours({id:$scope.collaborateur.id},function  (result2) {

    $scope.ficheCourant = result2;
    console.log($scope.ficheCourant);
  })

});


$scope.addObjectif=function  () {
  $scope.ficheCourant.objectifs.push($scope.newobjectif);
  $scope.newobjectif={};
}

$scope.addObjectifFormation=function  () {
  $scope.newobjectifnewobjectifFormation.avancementObjectif = 0 ;
  $scope.objectifsFormation.objectifs.push( $scope.newobjectifnewobjectifFormation);
  
  console.log($scope.objectifsFormation);
  $scope.newobjectifnewobjectifFormation={};
}
$scope.addAction=function  () {
  $scope.Actions.push( $scope.newaction);
  $scope.newaction={};
}

$scope.supprimerAction=function  (i) {
  $scope.Actions.splice(i,1);

}
$scope.supprimerObjectif=function  (i) {
  $scope.ficheCourant.objectifs.splice(i,1);

}
$scope.supprimerObjectifFormation=function  (i) {
  $scope.objectifsFormation.splice(i,1);

}
$scope.initModif=function (i)
{

  $scope.modif[i] =true;
}

$scope.Modif = function  (i) {
 $scope.modif[i] =false; 
}

$scope.initModif2=function (i)
{

  $scope.modif2[i] =true;
}

$scope.Modif2 = function  (i) {
 $scope.modif2[i] =false; 
}

$scope.initModif3=function (i)
{

  $scope.modif3[i] =true;
}

$scope.Modif3 = function  (i) {
 $scope.modif3[i] =false; 
}


$scope.initFormation = function  () {
 $('#FormationModal').modal('show');
}

$scope.initAction = function  () {
 $('#ActionModal').modal('show'); 
}

$scope.MAJFormation = function  () {

  $scope.Formations.push($scope.objectifsFormation);
  $scope.objectifsFormation = {} ;
  $scope.objectifsFormation.objectifs =[];
  $scope.objectifsFormation.autoformation=false;
  $('#FormationModal').modal('hide');    


}
$scope.MAJAction = function  () {

  $('#ActionModal').modal('hide');    
}

$scope.saveBip = function  () {
  
  var bip = {};
  bip.ficheObjectifsTraites = $scope.ficheCourant ; 
  bip.collaborateur = $scope.collaborateur ; 
  bip.actions = $scope.Actions  ;
  bip.formations = $scope.Formations ;
  bip.dateBilan = new Date();
  console.log(bip);

  Bip.save(bip);
  
}


});



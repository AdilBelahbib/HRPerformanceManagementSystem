'use strict';

app
.controller('AdminCollaborateurController', function ($scope, $state,$stateParams,$filter , Collaborateur) {

console.log("admin");
Collaborateur.get({id:$stateParams.id}, function  (result) {
	
	$scope.collaborateur = result;

})


});





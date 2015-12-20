'use strict';

app
.controller('demandeBipsController', function ($scope, $stateParams,$filter , Manager , DemandeBip ) {

	
Manager.get({id : 160}, function  (result) {
$scope.collaborateurs = result.collaborateurs;
    
});

DemandeBip.collaborateur({id : 163}, function  (result) {
	$scope.demandes = result;
	console.log(result);
})


});


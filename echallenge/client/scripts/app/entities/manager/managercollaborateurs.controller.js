'use strict';

app
.controller('ManagerCollaborateursController', function ($scope, $stateParams,$filter , Manager ) {

	
Manager.get({id : 160}, function  (result) {
$scope.collaborateurs = result.collaborateurs;
    
});


});


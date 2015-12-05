'use strict';

app
    .controller('CollaborateurController', function ($scope, $stateParams, Collaborateur) {
        console.log("Testing the rest API");
        
        $scope.collaborateurs = Collaborateur.query();

        console.log($scope.collaborateurs);

        $scope.loadAll=function  () {
        	$scope.collaborateurs = Collaborateur.query();

        }

        $scope.addCollaborateur=function() {
        
                $('#addModal').modal('show');
        }

        $scope.showEditCollaborateur = function(user) {
        	console.log("edit modal...");
        	Collaborateur.get({id:user.id}, function(result) {
                $scope.currentCollaborateur = result;
                
                $('#editModal').modal('show');
            });
        };

        $scope.EditCollaborateur = function() {
        	console.log("edit modal2...");
        	
        	 Collaborateur.update({id: $scope.currentCollaborateur.id},$scope.currentCollaborateur , function(){
        	 $scope.loadAll();
        	$('#editModal').modal('hide'); 	
        	 });
        	
            
        };

        $scope.deleteCollaborateur=function  (user) {
        	  Collaborateur.delete({id: user.id},
                function () {
                    $scope.loadAll();
                });
        }
        
        
         
    });

'use strict';

app
    .controller('UtilisateurController', function ($scope, $stateParams, Utilisateur) {
        console.log("Testing the rest API");
        
        $scope.collaborateurs = Utilisateur.query();

        console.log($scope.collaborateurs);

        $scope.loadAll=function  () {
        	$scope.collaborateurs = Utilisateur.query();

        }

        $scope.create = function () {
            var entity = $scope.collaborateur;
            console.log("test")
            if(entity.id) {
                console.log("update")
                Utilisateur.update({id: entity.id}, entity, saveCalback);
            }
            else {
                console.log("create")
              var  managerh=[];
                managerh.nom="test";
                managerh.id=154;
                managerh.email="t";
                entity.manager=managerh;
                Utilisateur.save(entity, saveCalback);
            }
        };
        function saveCalback() {
            $('#editModal').modal('hide');
        }
        $scope.update = function (id) {
            Utilisateur.get({id: id}, function(result) {
                $scope.collaborateur = result;
                $('#editModal').modal('show');
            });
        };

        $scope.addUtilisateur=function() {
        
        console.log("show modal");
        $('#editModal').modal('show');
        }

        $scope.showEditUtilisateur = function(user) {
        	console.log("edit modal...");
        	Utilisateur.get({id:user.id}, function(result) {
                $scope.currentUtilisateur = result;
                
                $('#editModal').modal('show');
            });
        };

        $scope.EditUtilisateur = function() {
        	console.log("edit modal2...");
        	
        	 Utilisateur.update({id: $scope.currentUtilisateur.id},$scope.currentUtilisateur , function(){
        	 $scope.loadAll();
        	$('#editModal').modal('hide'); 	
        	 });
        	
            
        };

        $scope.deleteUtilisateur=function  (user) {
        	  Utilisateur.delete({id: user.id},
                function () {
                    $scope.loadAll();
                });
        }
        
        
         
    });

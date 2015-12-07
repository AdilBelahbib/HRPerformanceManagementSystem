'use strict';

app
    .controller('CollaborateurController', function ($scope, $stateParams,$filter, Collaborateur) {
        console.log("Testing the rest API");
        
        $scope.collaborateurs = Collaborateur.query();
        // id récupérer à partir de la session ouverte 

          Collaborateur.get({id: 154}, function(result) {
                $scope.collaborateur = result;

                $scope.collaborateur.fichesobjectifs.forEach(function (entity) {
                entity.dateFicheObjectifs = $filter('date')(entity.dateFicheObjectifs, 'yyyy-MM-dd');    
                });
                $scope.collaborateur.fichesevaluations.forEach(function (entity) {
                entity.dateEvaluation = $filter('date')(entity.dateEvaluation, 'yyyy-MM-dd');    
                });
                //filter provisoir 
                $scope.collaborateur.fichesobjectifs= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.autorisationAcces==1;});
                $scope.collaborateur.fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.autorisationAcces==1;});
                
                
            });  
        console.log($scope.collaborateurs);

        $scope.loadAll=function  () {
        	$scope.collaborateurs = Collaborateur.query();

        }

        $scope.showObjectifs = function (id) {
                $scope.hideobjectifs=false;
                var fichesobjectif= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.id==id;});
                $scope.fichesobjectif=fichesobjectif[0];
                if($scope.fichesobjectif.objectifs.length==0)$scope.hideobjectifs=true;
                $('#objectifsModal').modal('show');
        };
        $scope.create = function () {
            var entity = $scope.collaborateur;
            console.log("test")
            if(entity.id) {
                console.log("update")
                Collaborateur.update({id: entity.id}, entity, saveCalback);
            }
            else {
                console.log("create")
              var  managerh=[];
                managerh.nom="test";
                managerh.id=154;
                managerh.email="t";
                entity.manager=managerh;
                Collaborateur.save(entity, saveCalback);
            }
        };
        function saveCalback() {
            $('#editModal').modal('hide');
        }
        $scope.update = function (id) {
            Collaborateur.get({id: id}, function(result) {
                $scope.collaborateur = result;
                $('#editModal').modal('show');
            });
        };

        $scope.addCollaborateur=function() {
        
        console.log("show modal");
        $('#editModal').modal('show');
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

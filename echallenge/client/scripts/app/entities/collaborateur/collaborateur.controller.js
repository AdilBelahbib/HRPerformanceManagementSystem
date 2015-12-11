'use strict';

app
    .controller('CollaborateurController', function ($scope, $stateParams,$filter, Collaborateur , Objectif, Utilisateur) {
        console.log("Testing the rest API");
        
        $scope.collaborateurs = Collaborateur.query();
        // id récupérer à partir de la session ouverte 
          Utilisateur.Auth({email:"belahbib@mail.com",mdp:"1829bca2a2e6210239ce329dabf70722a71d8873"},function(result){
            $scope.role = "c";
          });
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
        $scope.currentfiche =Objectif.currentfiche({id:154});

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
         
    });

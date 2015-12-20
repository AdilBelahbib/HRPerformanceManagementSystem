'use strict';

app
    .controller('CollaborateurController', function ($scope, $stateParams,$filter, Collaborateur , Objectif, Utilisateur , Bap) {
        console.log("Testing the rest API");
        
        
          Collaborateur.get({id: 154}, function(result) {
                $scope.collaborateur = result;
                $scope.collaborateur.fichesobjectifs= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.autorisationAcces==1;});
                $scope.collaborateur.fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.autorisationAcces==1;});
                
            });  

        $scope.currentfiche =Objectif.currentfiche({id:154});

        Bap.bapCourant({id:154},function(result)
            {
                $scope.bap =result;
                $scope.ficheEnAttente = result.ficheObjectifsRediges;        
            });
        
        
        $scope.loadAll=function  () {
            $scope.collaborateurs = Collaborateur.query();

        }
        $scope.valider =function ()
        {
            $scope.bap.statut = "VALIDE";
            console.log($scope.bap);
            Bap.update({id:154},$scope.bap);
        }
        
        $scope.rejeter =function ()
        {
            $scope.bap.statut = "REJETE";
            console.log($scope.bap);
            Bap.update({id:154},$scope.bap);
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

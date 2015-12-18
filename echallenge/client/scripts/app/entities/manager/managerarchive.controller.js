'use strict';

app
.controller('ManagerArchiveController', function ($scope, $stateParams,$filter  , Collaborateur) {


        //recupérer les fiches du  collaborateur selectionné

        Collaborateur.get({id: $stateParams.id}, function(result) {

            $scope.collaborateur = result;
            
            console.log(result);

            $scope.collaborateur.fichesobjectifs.forEach(function (entity) {

                entity.dateFicheObjectifs = $filter('date')(entity.dateFicheObjectifs, 'yyyy-MM-dd');    

            });
            
            $scope.collaborateur.fichesevaluations.forEach(function (entity) {

                entity.dateEvaluation = $filter('date')(entity.dateEvaluation, 'yyyy-MM-dd');    

            });

        });  

        $scope.showObjectifs = function (id) {

            $scope.hideobjectifs=false;

            var fichesobjectif= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.id==id;});

            $scope.fichesobjectif=fichesobjectif[0];

            if($scope.fichesobjectif.objectifs.length==0)$scope.hideobjectifs=true;

            $('#objectifsModal').modal('show');
        };

        $scope.showEvaluations = function (id) {

            $scope.hideevaluations=false;

            var fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.id==id;});

            $scope.fichesevaluation=fichesevaluations[0];

            if($scope.fichesevaluation.evaluations.length==0)$scope.hideevaluations=true;

            $('#evaluationModal').modal('show');
        };



    });


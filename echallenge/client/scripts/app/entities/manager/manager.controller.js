'use strict';

app
.controller('ManagerController', function ($scope, $state,$stateParams,$filter , Manager , Bap , Collaborateur) {


        //recupérer les collaborateurs du manager




       Manager.get({id: 160}, function(result) {
            $scope.manager = result;
            //collaborateurs du managerRH avec un BAp statut en cours
            $scope.collaborateurs = $scope.manager.collaborateurs;        
            });
    
        $scope.class = function  (bap) {
            if(bap.statut=="EN_COURS") return  "info";
            if(bap.statut=="EN_ATTENTE") return "warning";
            if(bap.statut=="VALIDE") return "primary";
            if(bap.statut=="REJETE") return "danger";
        }

    });


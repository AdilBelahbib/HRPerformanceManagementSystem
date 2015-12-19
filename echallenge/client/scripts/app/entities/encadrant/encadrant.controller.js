'use strict';

app
.controller('EncadrantController', function ($scope, $state,$stateParams,$filter , Manager , Encadrant,Bap , Collaborateur , DemandeBip) {





        $scope.encadrant = Encadrant.get({id:161});

        Collaborateur.encadrant({id:162},function  (result) {
            
           $scope.collaborateurs=result;
        })        
        
        $scope.initdemandeBip = function  (collaborateur) {
            // afficher modal
            $scope.collaborateurdemande = collaborateur ; 

            $('#demandeBipModal').modal('show');

        }

        $scope.demandeBip = function  (collaborateur) {
            // save demandeBip
            console.log("demande bip confirmé ...");
            var demandeBip = {};
            demandeBip.collaborateur= collaborateur ;
            demandeBip.dateDemande = new Date();
            demandeBip.encadrant = $scope.encadrant;

            DemandeBip.save(demandeBip)   ;
            $('#demandeBipModal').modal('hide');             
        }

        $scope.evaluer= function  (collaborateur) {
        // lancer l'evaluation 
        // 1 selectionner l'objectif  à evaluer du collaborateur encadré
        // 2 evaluer => resultat


    }

    $scope.class = function  (bap) {
        if(bap.statut=="EN_COURS") return  "info";
        if(bap.statut=="EN_ATTENTE") return "warning";
        if(bap.statut=="VALIDE") return "primary";
        if(bap.statut=="REJETE") return "danger";
    }

});





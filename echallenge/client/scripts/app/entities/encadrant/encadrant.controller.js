'use strict';

app
.controller('EncadrantController', function ($scope, $state,$stateParams,$filter , Manager , Encadrant,Bap , Collaborateur , DemandeBip) {


        //recupérer les collaborateurs de l'encadrant !!!


        $scope.encadrant = Encadrant.get({id:161});

        Manager.get({id: 160}, function(result) {
            $scope.manager = result;
            //collaborateur du managerRH avec un BAp statut en cours
            $scope.collaborateurs = $scope.manager.collaborateurs;        
            // get Bap foreach collaborator
            $scope.CollaborateursBaps=[];
            $scope.collaborateurs.forEach(function (entity) {

                Bap.collaborateur({id:entity.id},function  (result) {


                    $scope.CollaborateursBaps[entity.id]=result;

                });
                
                
            });

        });
        
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





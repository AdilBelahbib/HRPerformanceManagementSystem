'use strict';

app
.controller('EncadrantCollaborateurController', function ($scope, $state,$stateParams,$filter , Bap ,DemandeBip ,Feedback , Collaborateur , Encadrant ) {

    $scope.modif = [];
    $scope.feedback = {};
    $scope.feedback.qualificationstheme =[];
    $scope.newqualification={};
    $scope.encadrant = Encadrant.get({id:161});
    Bap.bapCourant({id:$stateParams.id},function  (result) {

        $scope.bap=result;
        console.log($scope.encadrant);

    });




    
    $scope.initdemandeBip = function  (collaborateur) {
            // afficher modal
            $scope.collaborateurdemande = collaborateur ; 
            console.log(collaborateur);
            $('#demandeBipModal').modal('show');
            console.log($scope.encadrant);
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

            Bap.update({id:$scope.bap.id} , $scope.bap);


        }
        $scope.initEvaluation = function  () {


            $('#evaluationModal').modal('show');             

        }
        $scope.initFeedBack =function  () {
            $('#feedbackModal').modal('show');                                         
        }

        $scope.feedBack= function  () {
            console.log($scope.feedback);

        }

        $scope.addqualification=function  () {
            $scope.feedback.qualificationstheme.push( $scope.newqualification);
            $scope.newqualification={};
        }

        $scope.supprimerQualification=function  (i) {
            $scope.feedback.qualificationstheme.splice(i,1);

        }
        
        $scope.initModif=function (i)
        {

            $scope.modif[i] =true;
        }

        $scope.Modif = function  (i) {
         $scope.modif[i] =false; 
     }


 });


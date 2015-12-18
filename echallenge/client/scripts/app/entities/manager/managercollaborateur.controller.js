'use strict';

app
.controller('ManagerCollaborateurController', function ($scope, $stateParams,$filter , Bap , Encadrant ,Collaborateur) {

	$scope.ev = [];
	Bap.collaborateur({id:$stateParams.id},function  (result) {
		console.log(result);
		$scope.baps=result;

	});





	$scope.initValiderBap = function  (bap) {

		$scope.bapToValidate = bap;
		
		$scope.current = 1;
		$('#step1_1').show();	
		$('#step1_2').hide();	
		$('#step1_3').hide();	
		$('#BapModal').modal('show');

	}


	$scope.valider=function  (o,i) {
        // $('#objectif'+o.id).hide();

        $scope.bapToValidate.ficheObjectifsRediges.objectifs.splice(i,1);

        $scope.bapToValidate.ficheObjectifsTraites.objectifs.push(o);

        $('#objectif'+o.id).html("objectif Validé");

    }

    $scope.reporter=function  (o) {
    	
    	$('#objectif'+o.id).html("objectif Reporté");
    }

    $scope.nextStep=function()
    {

    	$('#step1_'+$scope.current).hide();
    	$scope.current++;
    	$('#step1_'+$scope.current).show();
        	// if($scope.current==3)$('#nextbtn').hide();	
        }



        $scope.addObjectif=function  () {
        	$scope.bapToValidate.ficheObjectifsRediges.objectifs.push($scope.newobjectif);
        	$scope.newobjectif={};
        }


        $scope.supprimerObjectif=function  (i) {
        	$scope.bapToValidate.ficheObjectifsRediges.objectifs.splice(i,1);
        }

        $scope.ValiderBap=function()
        {
			
			console.log("Creation d'un nouveau Bap et mise à jour de l'ancien");
        	
        }




        $scope.initPreparerBap = function  (bap) {

        	$scope.bapToPrepare = bap;
        	$scope.encadrants = Encadrant.query();
        	$scope.current = 1;
        	$('#step2_2').hide();   
        	$('#step2_3').hide();   
        	$('#step2_1').show();   
        	$('#BapModal2').modal('show');


        }
        $scope.MAJBap = function  () {
        	var total = 0
        	$scope.bapToPrepare.ficheObjectifsRediges.objectifs.forEach(function (obje) {
        		total+=parseInt($scope.ev.poids[obje.id]); 
        	});
        	if(total>100)
        	{
        		$scope.error=true;
        	}
        	else
        	{
            //exec next function 
        }
    }

//helpers 
$scope.actions = function  (bap) {
	if(bap.statut=="EN_COURS") return  "Valider Bap";
	if(bap.statut=="EN_ATTENTE") return "Préparer Bap";
	if(bap.statut=="VALIDE") return "Imprimer Bap";
	if(bap.statut=="REJETE") return "Valider Bap";
}
$scope.class = function  (bap) {
	if(bap.statut=="EN_COURS") return  "info";
	if(bap.statut=="EN_ATTENTE") return "warning";
	if(bap.statut=="VALIDE") return "primary";
	if(bap.statut=="REJETE") return "danger";
}
$scope.exec = function  (bap) {

	if(bap.statut=="EN_COURS") $scope.initValiderBap(bap);
	if(bap.statut=="EN_ATTENTE") $scope.initPreparerBap(bap);
}
});


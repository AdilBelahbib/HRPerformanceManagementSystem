'use strict';

app
.controller('ManagerCollaborateurController', function ($scope, $stateParams,$filter , Bap  ,Feedback , Collaborateur) {

  $scope.modif = [];
    Bap.bapCourant({id:$stateParams.id},function  (result) {

      $scope.bap=result;
      console.log(result);

  });




    $scope.initModif=function (i)
    {
     
      $scope.modif[i] =true;
    }

    $scope.Modif = function  (i) {
     $scope.modif[i] =false; 
    }
    $scope.initValiderBap = function  (bap) {

      $scope.bapToValidate = bap;
      
      $scope.totalaValider = 0
      $scope.bapToValidate.ficheEvaluations.evaluations.forEach(function (obje) {

        if(obje.poids != '' )$scope.totalaValider+=parseInt(obje.poids); 
    });

      $scope.current = 1;
      $('#step1_1').show();	
      $('#step1_2').hide();	
      $('#step1_3').hide();	
      $('#step1_4').hide(); 
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
        if($scope.current==2)
        {
            //valider bap 
            $scope.ValiderBap();
            console.log($scope.bapToValidate);
        }
        if($scope.current==3)console.log($scope.bapToValidate);
        
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
            $scope.totalaValider = 0
            $scope.bapToValidate.ficheEvaluations.evaluations.forEach(function (obje) {
              $scope.totalaValider+=parseInt(obje.poids); 
          });
            if($scope.totalaValider!=100)
            {
              $scope.error2=true;
          }
          else
          {

            Bap.valider($scope.bapToValidate,function  (result) {
                console.log(result);
                $scope.bapToValidate = result;
            });

        }

        

    }




    $scope.initPreparerBap = function  (bap) {

     $scope.bapToPrepare = bap;

     $scope.current = 1;
     $('#step2_2').hide();   
     $('#step2_3').hide();   
     $('#step2_1').show();   
     $('#BapModal2').modal('show');

     $scope.total = 0
     $scope.bapToPrepare.ficheEvaluations.evaluations.forEach(function (obje) {

      $scope.total+=parseInt(obje.poids); 
  });


 }
 $scope.majPoid = function  () {
     $scope.total = 0
     $scope.bapToPrepare.ficheEvaluations.evaluations.forEach(function (obje) {

        if(obje.poids != '' )$scope.total+=parseInt(obje.poids); 
    });
 }
 $scope.majPoidaValider = function  () {
     $scope.totalaValider = 0
     $scope.bapToValidate.ficheEvaluations.evaluations.forEach(function (obje) {

        if(obje.poids != '' )$scope.totalaValider+=parseInt(obje.poids); 
    });
 }

 $scope.MAJBap = function  () {
    $scope.total = 0
    $scope.bapToPrepare.ficheEvaluations.evaluations.forEach(function (obje) {
      $scope.total+=parseInt(obje.poids); 
  });
    if($scope.total!=100)
    {
      $scope.error=true;
  }
  else
  {

    Bap.update({id :$scope.bapToPrepare } , $scope.bapToPrepare);
    $('#BapModal2').modal('hide');
}
}


$scope.SaveBap = function  () {
  console.log($scope.bapToValidate);
  Bap.save($scope.bapToValidate);
}


});


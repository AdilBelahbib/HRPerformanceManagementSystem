'use strict';

app
    .controller('TestController', function ($scope, $stateParams,$filter ,Encadrant) {
        console.log("Testing the rest API");
         
         // Put/Post errors
                //collaborateur+encadrant+feedback+manager put,Post :Unrecognized field "autoformation" (Class com.echallenge.model.PlanAmelioration), not marked as ignorable
                //Bap Validé 
                //put,Post action {
                                // idcollaborateur cannot be null ?!
                                // }

                   // put , Post Bip :
                    // Unrecognized field "collaborateur" (Class com.echallenge.model.BIP),
                     // not marked as ignorable

        //Post , put Evaluation :idEncadrant cannot be null        
        //Post , put Formation : idCollaborateur cannot be null        
                
                

                Encadrant.get({id:149},function (result) {
                    
                   
                    console.log(result);
                    
                    result.evaluations[0].poids=-1;
                    Encadrant.update({id:149},result);


                    

                    // Formation.save(result);



                });
                
    
         
    });

'use strict';

app
.controller('ManagerController', function ($scope, $stateParams,$filter, Manager ) {


   $scope.managers = Manager.query();
        // id récupérer à partir de la session ouverte 

        Manager.get({id: 151}, function(result) {
            $scope.manager = result;

            $scope.collaborateurs = $scope.manager.collaborateurs;        
            console.log($scope.collaborateurs);



        });  
        

        



    });

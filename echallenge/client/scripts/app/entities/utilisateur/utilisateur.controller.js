'use strict';

app
.controller('UtilisateurController', function ($scope, $stateParams, Utilisateur , $rootScope ,$cookieStore , $state) {
    $scope.user = {};
    $scope.login = function  () {
        Utilisateur.auth({email : $scope.user.email , mdp : $scope.user.motDePasse} ,function  (result) {

            if(result.token) 
            {
             
                 $cookieStore.put('connectedUser', result);
                 $cookieStore.put('logged', true);
                 $scope.user = $cookieStore.get('connectedUser');
                if($scope.user.utilisateur.type == 'A')
                {
                 $state.go('administrateur');
                 }
                 if($scope.user.utilisateur.type == 'C')
                {
                 $state.go('collaborateur');
                 }
                 if($scope.user.utilisateur.type == 'E')
                {
                 $state.go('encadrant');
                 }
                 if($scope.user.utilisateur.type == 'M')
                {
                 $state.go('manager');
                 }
           }
           else
           {
            $cookieStore.put('logged', false);
        }

        $scope.$on('handleBroadcast', function() {
        $scope.message = sharedService.message;
    });

    });
    }        

});

'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('login', {
                url: '/login',
                views: {
                    'login@': {
                        templateUrl: 'scripts/app/entities/utilisateur/utilisateur.html',
                        controller: 'UtilisateurController'
                    }
                
                },
                data: {
                    logged : false 
                },
            });
            
    });

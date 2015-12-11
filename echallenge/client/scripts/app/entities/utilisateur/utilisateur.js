'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('utilisateur', {
                url: '/utilisateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/utilisateur/utilisateur.html',
                        controller: 'UtilisateurController'
                    }
                }
            });
            
    });

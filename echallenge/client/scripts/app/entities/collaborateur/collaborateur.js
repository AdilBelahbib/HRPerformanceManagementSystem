'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('collaborateur', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/collaborateur.html',
                        controller: 'CollaborateurController'
                    }
                }
            });
            
    });

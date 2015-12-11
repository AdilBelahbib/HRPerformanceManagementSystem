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
            })
            .state('collaborateur.fichesobjectifs', {
                url: '/collaborateurs/fichesobjectifs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/fichesobjectifs.html',
                        controller: 'CollaborateurController'
                    }
                }
            })
            .state('collaborateur.fichesevaluation', {
                url: '/collaborateurs/fichesevaluation',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/fichesevaluation.html',
                        controller: 'CollaborateurController'
                    }
                }
            });
            
    });

'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('test', {
                url: '/tests',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/test.html',
                        controller: 'TestController'
                    }
                }
            })
            .state('collaborateur', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/collaborateur.html',
                        controller: 'CollaborateurController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-c.partial.html'
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

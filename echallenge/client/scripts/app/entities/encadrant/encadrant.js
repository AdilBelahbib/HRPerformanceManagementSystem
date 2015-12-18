'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('encadrant', {
                url: '/encadrants',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/encadrant.html',
                        controller: 'EncadrantController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-m.partial.html'
                    }
                    
                    }

                
            })
            .state('encadrant.fiches', {
                url: '/fiches/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/fiches.html',
                        controller: 'EncadrantArchiveController'
                    }
                }
            })
            .state('encadrant.collaborateur', {
                url: '/collaborateur/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/detailcollaborateur.html',
                        controller: 'EncadrantCollaborateurController'
                    }
                }
            })
            .state('encadrant.collaborateurs', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/listcollaborateurs.html',
                        controller: 'EncadrantCollaborateursController'
                    }
                }
            });
            
    });

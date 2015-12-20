'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('administrateur', {
                url: '/admin',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listcollaborateurs.html',
                        controller: 'AdminCollaborateursController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-a.partial.html'
                    }
                    
                    },
                    
            })
            .state('administrateur.fiches', {
                url: '/fiches/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/fiches.html',
                        controller: 'AdminArchiveController'
                    }
                }
            })
            .state('administrateur.collaborateur', {
                url: '/collaborateur/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/detailcollaborateur.html',
                        controller: 'AdminCollaborateurController'
                    }
                }
            })
            .state('administrateur.collaborateurs', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listcollaborateurs.html',
                        controller: 'AdminCollaborateursController'
                    }
                }
            })
            .state('administrateur.Encadrants', {
                url: '/Encadrants',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listEncadrants.html',
                        controller: 'AdminEncadrantsController'
                    }
                }
            })
            .state('administrateur.Managers', {
                url: '/Managers',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listManagers.html',
                        controller: 'AdminManagersController'
                    }
                }
            });
            
    });

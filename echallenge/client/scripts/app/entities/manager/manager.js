'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('manager', {
                url: '/managers',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/listcollaborateurs.html',
                        controller: 'ManagerCollaborateursController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-m.partial.html'
                    }
                    
                    }

                
            })
            .state('manager.fiches', {
                url: '/fiches/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/fiches.html',
                        controller: 'ManagerArchiveController'
                    }
                }
            })
            .state('manager.collaborateur', {
                url: '/collaborateur/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/detailcollaborateur.html',
                        controller: 'ManagerCollaborateurController'
                    }
                }
            })
            .state('manager.collaborateurs', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/listcollaborateurs.html',
                        controller: 'ManagerCollaborateursController'
                    }
                }
            });
            
    });

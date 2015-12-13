'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('manager', {
                url: '/managers',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/manager.html',
                        controller: 'ManagerController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-c.partial.html'
                    }
                    
                    }

                
            })
            .state('manager.fichesobjectifs', {
                url: '/managers/fichesobjectifs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/fichesobjectifs.html',
                        controller: 'ManagerController'
                    }
                }
            })
            .state('manager.fichesevaluation', {
                url: '/managers/fichesevaluation',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/fichesevaluation.html',
                        controller: 'ManagerController'
                    }
                }
            });
            
    });

'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('user', {
                url: '/',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/user/user.html',
                        controller: 'UserController'
                    }
                }
            });
            
    });

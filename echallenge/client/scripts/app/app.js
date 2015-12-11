var app=angular.module('hrPerformanceApp',['ui.router','ngResource']);
app.config(['$locationProvider', function($scope,$locationProvider, Utilisateur) {
     // 

  }]);
app.config(function ($stateProvider, $urlRouterProvider, $httpProvider, $locationProvider) {

        //enable CSRF
        

        
        $stateProvider.state('site', {
            'abstract': true,
            views: {
                'navbar@': {
                    templateUrl: 'scripts/components/navbar/navbar.html',
                    controller: 'NavbarController'
                }
            },
            resolve: {
                // authorize: ['Auth',
                //     function (Auth) {
                //         return Auth.authorize();
                //     }
                // ]
            }
        });

    });




console.log('after-config');



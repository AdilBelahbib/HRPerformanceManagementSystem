var app=angular.module('hrPerformanceApp',['ui.router','ngResource','ngCookies']);
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

app.controller('mainController', function ($scope, $state, $cookieStore,$stateParams,$filter ) {


    $scope.logOut = function  () {

        $cookieStore.remove('connectedUser');
        $cookieStore.remove('logged');    
        $state.go('login');
    }

    
});







console.log('after-config');



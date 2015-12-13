'use strict';

app
    .factory('Utilisateur', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/utilisateurs/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'auth' : { 
                        method: 'GET',
                        isArray: false,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/utilisateurs/auth/:email/:mdp'
                      },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

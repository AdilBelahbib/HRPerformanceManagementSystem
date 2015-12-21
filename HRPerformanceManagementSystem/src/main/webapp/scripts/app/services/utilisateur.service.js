'use strict';

app
    .factory('Utilisateur', function ($resource, $filter) {
        
        return $resource('/HRPerformanceManagementSystem/resources/utilisateurs/:id', {}, {
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
                        url: '/HRPerformanceManagementSystem/resources/utilisateurs/auth/:email/:mdp'
                      },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

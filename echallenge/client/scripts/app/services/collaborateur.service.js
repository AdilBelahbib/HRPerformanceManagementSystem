'use strict';

app
    .factory('Collaborateur', function ($resource, $filter) {
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'encadrant' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/encadrant/:id'
                      },
            'manager' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/managerrh/:id'
                      },
            'bap' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/bapstatut/:idencadrant/:statut'
                      },
            'update': { method:'PUT' },
            
            'save': { method:'POST' }
        });
    });

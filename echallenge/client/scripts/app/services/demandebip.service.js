    'use strict';

app
    .factory('DemandeBip', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/demandebips/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray : true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/demandebips/collaborateur/:id'
                      },
            'encadrant' :
            {
                     method: 'GET',
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/demandebips/encadrant/:id'
            },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

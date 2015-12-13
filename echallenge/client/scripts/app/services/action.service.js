'use strict';

app
    .factory('Action', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/actions/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/actions/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

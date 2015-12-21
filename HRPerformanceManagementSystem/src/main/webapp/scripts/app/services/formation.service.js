'use strict';

app
    .factory('Formation', function ($resource, $filter) {
        
        return $resource('/HRPerformanceManagementSystem/resources/formations/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/HRPerformanceManagementSystem/resources/formations/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

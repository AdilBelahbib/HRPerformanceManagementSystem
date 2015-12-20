'use strict';

app
    .factory('Formation', function ($resource, $filter) {
        
        return $resource('/resources/formations/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/resources/formations/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

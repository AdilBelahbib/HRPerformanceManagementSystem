'use strict';

app
    .factory('Action', function ($resource, $filter) {
        
        return $resource('/resources/actions/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: '/resources/actions/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

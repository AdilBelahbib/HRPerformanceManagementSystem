'use strict';

app
    .factory('Projet', function ($resource, $filter) {
        
        return $resource('/resources/<projets></projets>/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'code':
                    {  
                        method:'GET',
                        url:'/resources/profils/bycode/:code'

                    },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

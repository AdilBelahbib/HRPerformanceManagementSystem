'use strict';

app
    .factory('Entete', function ($resource, $filter) {
        
        return $resource('/resources/entetes/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'feedback':{method : 'GET',url:'/resources/entetes/feedback/:id'},
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

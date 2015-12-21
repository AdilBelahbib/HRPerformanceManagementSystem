'use strict';

app
    .factory('Entete', function ($resource, $filter) {
        
        return $resource('/HRPerformanceManagementSystem/resources/entetes/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'feedback':{method : 'GET',url:'/HRPerformanceManagementSystem/resources/entetes/feedback/:id'},
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

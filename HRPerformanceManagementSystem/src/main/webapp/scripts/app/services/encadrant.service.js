'use strict';

app
    .factory('Encadrant', function ($resource, $filter) {
        
        return $resource('/HRPerformanceManagementSystem/resources/encadrants/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

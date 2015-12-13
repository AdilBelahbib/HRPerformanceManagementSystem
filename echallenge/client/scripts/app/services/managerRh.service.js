'use strict';

app
    .factory('Manager', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/managersrh/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

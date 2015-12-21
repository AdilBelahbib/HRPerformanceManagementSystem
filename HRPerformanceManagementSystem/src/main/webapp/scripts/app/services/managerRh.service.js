'use strict';

app
    .factory('Manager', function ($resource, $filter) {
        
        return $resource('/HRPerformanceManagementSystem/resources/managersrh/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });

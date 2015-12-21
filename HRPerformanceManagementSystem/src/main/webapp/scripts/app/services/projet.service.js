'use strict';

app
    .factory('Projet', function ($resource, $filter) {
        
        return $resource('/HRPerformanceManagementSystem/resources/<projets></projets>/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'code':
                    {  
                        method:'GET',
                        url:'/HRPerformanceManagementSystem/resources/profils/bycode/:code'

                    },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
